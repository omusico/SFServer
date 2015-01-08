package com.miaoyou.ipc;

import java.net.DatagramSocket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Communication Command Class
 *
 * @author 305027939
 */
public class Command {
    private static final Log logger = LogFactory.getLog(Command.class);
	public static int sequence;
	public static String telServerIp = "127.0.0.1";
	public static short telPort = 8100;
	public static String localhostIp = "127.0.0.1";
	public static short systemPort = 4567;
	public static String broadcastIp = "127.0.0.255";
	public static short  webMessagePort = 4568;
	final Communication<UrpPkg> _UDPCommunication;

	public final static int WAIT_FLAG = 0;
	public final static int ACK_FLAG = 1;
	public final static int NOWAIT_FLAG = 2;

	public final static int COMMAND_SystemStartup = 0x00000001;
	public final static int COMMAND_SystemClose = 0x00000002;
	public final static int COMMAND_Phone_start_dial = 0x00000003;
	public final static int COMMAND_Phone_end_dial = 0x00000004;
	public final static int COMMAND_Phone_start_earphone = 0x00000005;
	public final static int COMMAND_Phone_end_endphone = 0x00000006;
	public final static int COMMAND_Phone_start_talking = 0x00000007;
	public final static int COMMAND_Phone_start_webserver = 0x00000008;
	public final static int COMMAND_Phone_stop_webserver = 0x00000009;

	private static Command commandHandle;

	// static{
	// try {
	// InetAddress adress = InetAddress.getLocalHost();
	// Command.localhostIp = adress.getHostAddress();
	// Command.broadcastIp = Command.localhostIp.substring(0,
	// Command.localhostIp.lastIndexOf(".")) + ".255";
	// } catch (Exception e) {
	// logger.error(e);
	// }
	// }

	public static Command getInstance() {
		return getInstance(localhostIp, systemPort);
	}

	public static Command getInstance(String localhostIp, int systemPort) {
		if (commandHandle == null) {
			commandHandle = new Command(localhostIp, systemPort);
		}
		return commandHandle;
	}

	private Command() {
		this(localhostIp, systemPort);
	}

	private Command(String localhostIp, int systemPort) {
		_UDPCommunication = new Communication<UrpPkg>();
		try {
			_UDPCommunication.startReciveThread(localhostIp, systemPort);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	public void close() {
		if (_UDPCommunication != null)
			_UDPCommunication.close();

		commandHandle = null;
	}

	public DatagramSocket getReciveSocket() {
		return _UDPCommunication.getReciveSocket();
	}

	public UrpPkg continueReciveInfo(int timeout) {
		return _UDPCommunication.continueReciveInfoByte(timeout);
	}

	public void commandreplyAckToTel(int seqnum) {
		UrpPkg pkg = new UrpPkg();
		pkg.setSeqID(seqnum);
		pkg.setCmdFlag(ACK_FLAG);
		_UDPCommunication.send(broadcastIp, telPort, pkg, false);
	}

	public void commandreplyAckToHost(int seqnum) {
		UrpPkg pkg = new UrpPkg();
		pkg.setSeqID(seqnum);
		pkg.setCmdFlag(ACK_FLAG);
		_UDPCommunication.send(localhostIp, systemPort, pkg, false);
	}

	/**
	 * End of Upload
	 */
	public void commandShakehand() {
		UrpPkg pkg = new UrpPkg();
		UrpCmd cmd = new UrpCmd();
		cmd.setCmdID(COMMAND_SystemStartup);
		cmd.setdLen(0);
		cmd.setData("shake hand");
		pkg.setCmdFlag(WAIT_FLAG);
		pkg.setCmd(cmd);
		pkg.setSeqID(++sequence);
		_UDPCommunication.send(telServerIp, telPort, pkg, false);

	}

	public void commandShutdown() {
		UrpPkg pkg = new UrpPkg();
		UrpCmd cmd = new UrpCmd();
		cmd.setCmdID(COMMAND_SystemClose);
		cmd.setdLen(0);
		cmd.setData("shutdown");
		pkg.setCmdFlag(WAIT_FLAG);
		pkg.setCmd(cmd);
		pkg.setSeqID(++sequence);
		_UDPCommunication.send(telServerIp, telPort, pkg, false);
	}


	public void commandDial(String number) {
		UrpPkg pkg = new UrpPkg();
		UrpCmd cmd = new UrpCmd();
		cmd.setCmdID(COMMAND_Phone_start_dial);
		cmd.setdLen(0);
		cmd.setData(number);
		pkg.setCmdFlag(WAIT_FLAG);
		pkg.setCmd(cmd);
		pkg.setSeqID(++sequence);
		 _UDPCommunication.send(telServerIp, telPort, pkg, false);
	
	}

	public void commandHangup() {
		UrpPkg pkg = new UrpPkg();
		UrpCmd cmd = new UrpCmd();
		cmd.setCmdID(COMMAND_Phone_end_dial);
		cmd.setdLen(0);
		cmd.setData("");
		pkg.setCmdFlag(NOWAIT_FLAG);
		pkg.setCmd(cmd);
		pkg.setSeqID(++sequence);
		 _UDPCommunication.send(telServerIp, telPort, pkg, false);
		
	}

	public void commandSend(int commandid, String number) {
		commandSend(commandid,number,false);
	}
	
	public void commandSend(int commandid, String number,boolean broadcast) {
		UrpPkg pkg = new UrpPkg();
		UrpCmd cmd = new UrpCmd();
		cmd.setCmdID(commandid);
		cmd.setdLen(0);
		cmd.setData(number);
		pkg.setCmdFlag(NOWAIT_FLAG);
		pkg.setCmd(cmd);
		pkg.setSeqID(++sequence);
		_UDPCommunication.send(localhostIp, systemPort, pkg, broadcast);
	}

}
