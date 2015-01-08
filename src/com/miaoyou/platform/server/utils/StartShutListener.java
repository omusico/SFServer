package com.miaoyou.platform.server.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.miaoyou.ipc.Command;
import com.miaoyou.ipc.Communication;
import com.miaoyou.ipc.UDPRecevie;
import com.miaoyou.ipc.UrpCmd;
import com.miaoyou.ipc.UrpPkg;
import com.miaoyou.platform.server.constants.Constants;

/**
 * 这里主要是发送广播消息给网内用户
 * @author 305027939
 *
 */
public class StartShutListener implements ServletContextListener {
	private static final Log log = LogFactory.getLog(StartShutListener.class);
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("############server shutdown#################");
		Communication<UrpPkg> _UDPCommunication = new Communication<UrpPkg>();
		UrpPkg pkg = new UrpPkg();
		UrpCmd cmd = new UrpCmd();
		cmd.setCmdID(Command.COMMAND_Phone_stop_webserver);
		cmd.setdLen(0);
		cmd.setData("ok");
		pkg.setCmdFlag(Command.NOWAIT_FLAG);
		pkg.setCmd(cmd);
		pkg.setSeqID(++Command.sequence);
		_UDPCommunication.send(Command.broadcastIp, Command.systemPort, pkg, true);
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		log.info("############server startup#################");
//		try {
//			InetAddress adress = InetAddress.getLocalHost();
//			Command.localhostIp = adress.getHostAddress();
//			
//			Command.broadcastIp = Command.localhostIp.substring(0,
//					Command.localhostIp.lastIndexOf(".")) + ".255";

//		} catch (Exception e) {
//			log.error(e);
//		}
		String localhostIp= ResourceReader.getString("localhostIp");
		String broadcastIp= ResourceReader.getString("broadcastIp");
		String clientPort= ResourceReader.getString("clientPort");
		String webmessagePort= ResourceReader.getString("messagePort");
		
		if(localhostIp!=null&&!localhostIp.trim().equals("")){
			Command.localhostIp = localhostIp;
		}
		if(broadcastIp!=null&&!broadcastIp.trim().equals("")){
			Command.broadcastIp = broadcastIp;
		}
		
		if(clientPort!=null&&!clientPort.trim().equals("")){
			try{
			Command.systemPort = Short.valueOf(clientPort);
			}catch(Exception e){
				log.error(e);
			}
			
		}
		if(webmessagePort!=null&&!webmessagePort.trim().equals("")){
			try{
			Command.webMessagePort = Short.valueOf(webmessagePort);
			}catch(Exception e){
				log.error(e);
			}
			
		}
		
		log.info("########:localip:"+Command.localhostIp);
		log.info("########:broadcastIp:"+Command.broadcastIp);
		log.info("########:clientPort:"+Command.systemPort);
		log.info("########:messagePort:"+Command.webMessagePort);
		Communication<UrpPkg> _UDPCommunication = new Communication<UrpPkg>();
		UrpPkg pkg = new UrpPkg();
		UrpCmd cmd = new UrpCmd();
		cmd.setCmdID(Command.COMMAND_Phone_start_webserver);
		cmd.setdLen(0);
		cmd.setData("ok");
		pkg.setCmdFlag(Command.NOWAIT_FLAG);
		pkg.setCmd(cmd);
		pkg.setSeqID(++Command.sequence);
		_UDPCommunication.send(Command.broadcastIp, Command.systemPort, pkg, true);
		
		
		UDPRecevie.recive();
		
	}

}
