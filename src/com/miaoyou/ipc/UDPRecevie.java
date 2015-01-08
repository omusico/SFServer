package com.miaoyou.ipc;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class UDPRecevie implements Runnable {
	private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(UDPRecevie.class);
	private static int sequence = 0;

	public static long currentCallLong;
	private static Date hangupDate;
	private static Date hangdownDate;

	public UDPRecevie() {
		currentCallLong = 0;
	}

	public static void recive() {
		logger.debug("start to run a thread for listen message server :ip["
				+ Command.localhostIp + "],port[" + Command.webMessagePort
				+ "]");
		Thread t = new Thread(new UDPRecevie());
		t.setDaemon(true);
		t.start();
	}

	public static void main(String[] args) throws Exception {
		org.apache.log4j.varia.LevelRangeFilter filter = new org.apache.log4j.varia.LevelRangeFilter();
		filter.setLevelMin(Level.DEBUG);
		final Logger loggers = Logger.getRootLogger();

		org.apache.log4j.ConsoleAppender consoleAppender = new org.apache.log4j.ConsoleAppender(
				new org.apache.log4j.PatternLayout(
						PatternLayout.TTCC_CONVERSION_PATTERN));
		consoleAppender.setName("console log");
		consoleAppender.addFilter(filter);
		loggers.addAppender(consoleAppender);
		System.out.println("start tel simulator...");
		new Thread() {
			@Override
			public void run() {
				recive();
			}
		}.start();
	}

	@Override
	public void run() {
		logger.info("----create receiving thread for udp package ----");

		// 接收端
		try {
			Command command = Command.getInstance(Command.localhostIp,
					Command.webMessagePort);
			DatagramSocket socket = command.getReciveSocket();
			// 接收数据的buf数组并指定大小
			byte[] buf = new byte[1024];
			// 创建接收数据包，存储在buf中
			DatagramPacket packet = new DatagramPacket(buf, buf.length);

			while (true) {
				// 接收操作
				logger.info("--------------waitting for tel data--------------");
				socket.receive(packet);
				logger.info("--------------received data--------------");

				byte data[] = packet.getData();// 接收的数据
				InetAddress address = packet.getAddress();// 接收的地址

				UrpPkg replyPkg = Communication
						.decodeFromData(data, data.length,
								address.getHostAddress(), packet.getPort());
				UrpCmd replycmd = replyPkg.getCmd();
				String result = new String(replycmd.getData());
				switch (replycmd.getCmdID()) {
				case Command.COMMAND_SystemStartup:

					break;
				case Command.COMMAND_SystemClose:

					break;
				case Command.COMMAND_Phone_start_dial:

					break;
				case Command.COMMAND_Phone_end_dial:

					logger.info("result:" + result);

					break;
				case Command.COMMAND_Phone_start_earphone:

					break;
				case Command.COMMAND_Phone_end_endphone:

					break;
				case Command.COMMAND_Phone_start_talking:

					break;
				case Command.COMMAND_Phone_start_webserver:
					Communication<UrpPkg> _UDPCommunication = new Communication<UrpPkg>();
					UrpPkg pkg = new UrpPkg();
					UrpCmd cmd = new UrpCmd();
					cmd.setCmdID(Command.COMMAND_Phone_start_webserver);
					cmd.setdLen(0);
					cmd.setData("ok");
					pkg.setCmdFlag(Command.NOWAIT_FLAG);
					pkg.setCmd(cmd);
					pkg.setSeqID(++Command.sequence);
					_UDPCommunication.send(Command.broadcastIp,
							Command.systemPort, pkg, true);

					break;
				case Command.COMMAND_Phone_stop_webserver:
					Communication<UrpPkg> _UDPCommunication2 = new Communication<UrpPkg>();
					UrpPkg pkg2 = new UrpPkg();
					UrpCmd cmd2 = new UrpCmd();
					cmd2.setCmdID(Command.COMMAND_Phone_stop_webserver);
					cmd2.setdLen(0);
					cmd2.setData("ok");
					pkg2.setCmdFlag(Command.NOWAIT_FLAG);
					pkg2.setCmd(cmd2);
					pkg2.setSeqID(++Command.sequence);
					_UDPCommunication2.send(Command.broadcastIp,
							Command.systemPort, pkg2, true);
					break;
				}

			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

}
