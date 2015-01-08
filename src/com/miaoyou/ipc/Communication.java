package com.miaoyou.ipc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * UDP Communication
 *
 * @author 305027939
 * @param <T>
 */
public class Communication<T> {
    private static final Log logger = LogFactory.getLog(Communication.class);
	DatagramSocket clientsocket;
	DatagramSocket clientReciveSocket;

	public Communication() {
	}

	public DatagramSocket getReciveSocket() {
		return clientReciveSocket;
	}
//
	public void close() {
		if (clientsocket != null) {
			try {
				clientsocket.close();
				clientsocket = null;
				logger.info("close socket of client datagram .");
			} catch (Exception e) {
				logger.error(e);
			}

		}
		if (clientReciveSocket != null) {
			logger.info("close socket of client recive datagram .");
			clientReciveSocket.close();
			clientReciveSocket = null;
		}
	}

	public void startReciveThread(final String ip, final int port) throws Exception {

		if (clientReciveSocket != null) {
			clientReciveSocket.close();
		}
		clientReciveSocket = null;
			clientReciveSocket = new DatagramSocket(port,
					InetAddress.getByName(ip));
			logger.info("---start to recive from " +ip+"/"+ port + "---");
		
	}

	public void send(String remoteIP, int port, UrpPkg urpPkg,
			boolean broadcast) {
		 send(remoteIP, port, urpPkg, broadcast, 3000);
	}

	public void send(String remoteIP, int port, UrpPkg urpPkg,
			boolean broadcast, int timeout) {
		logger.debug("send to " + remoteIP + ",port:" + port);
		try {

			if (clientsocket == null) {
				logger.info("create datagram socket.");
				// clientsocket = new DatagramSocket();
				clientsocket = new DatagramSocket();
			}

			clientsocket.setBroadcast(broadcast);

			try (ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream(
					1024);
					ObjectOutputStream objectStream = new ObjectOutputStream(
							byteArrayStream)) {
				objectStream.writeObject(urpPkg);
				byte[] buf = byteArrayStream.toByteArray();

				// send packet
				DatagramPacket packet = new DatagramPacket(buf, buf.length,
						InetAddress.getByName(remoteIP), port);

				StringBuilder message = new StringBuilder("");
				UrpCmd cmd = urpPkg.getCmd();

				message.append("seq:").append(urpPkg.getSeqID())
						.append(",command:")
						.append(cmd == null ? "" : cmd.getCmdID())
						.append(",type:")
						.append(cmd == null ? "" : urpPkg.getCmdFlag())
						.append(",data:")
						.append(cmd == null ? "" : cmd.getData());

				// send packet
				// DatagramPacket packet = new DatagramPacket(pkgBuff1.array(),
				// pkgBuff1.array().length,
				// InetAddress.getByName(remoteIP), port);
				logger.info("[UDP "
						+ (urpPkg.getCmdFlag() == 1 ? "ACK" : urpPkg
								.getCmdFlag() == 2 ? "NOWAIT" : "WAIT")
						+ "]-->:" + message + " to detector:" + remoteIP + "/"
						+ port);

				clientsocket.send(packet);
				logger.debug("sent successfully.");

			}
//
//			if (clientReciveSocket == null) {
//				try {
//					clientReciveSocket = new DatagramSocket(Command.systemPort,
//							InetAddress.getByName(Command.localhostIp));
//					logger.info("---start to recive from " + port + "---");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			// recive
//			return displayReciveInfoByte(clientReciveSocket, urpPkg, timeout);

		} catch (SocketException e) {
			logger.error(e);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static UrpPkg decodeFromData(byte data[], int datalength, String ip,
			int port) {
		UrpPkg urpPkg = new UrpPkg();
		StringBuilder message = new StringBuilder("");
		if (data.length > 7) {

			try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
					ObjectInputStream ois = new ObjectInputStream(bais)) {
				urpPkg = (UrpPkg) ois.readObject();

				UrpCmd cmd = urpPkg.getCmd();
				message.append("seq:").append(urpPkg.getSeqID());
				if (cmd != null) {
					message.append(",command:").append(cmd.getCmdID())
							.append(",data:").append(cmd.getData());
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
			}

		} else {
			logger.debug("the length of data is less than " + 8
					+ ",not set the any data. data length:" + data.length);
		}
		logger.info("[UDP "
				+ (urpPkg.getCmdFlag() == 1 ? "ACK"
						: urpPkg.getCmdFlag() == 2 ? "NOWAIT" : "WAIT")
				+ "]<--:" + message.toString() + " from " + ip + "/" + port
				+ ",size:" + datalength);
		return urpPkg;
	}

	/**
	 * print remote replied data.
	 *
	 * @param socket
	 */
	public UrpPkg displayReciveInfoByte(final DatagramSocket socket,
			UrpPkg sendPkg, int timeout) {

		if (sendPkg.getCmdFlag() == Command.ACK_FLAG
				|| sendPkg.getCmdFlag() == Command.NOWAIT_FLAG) {// ACK message
																	// need not
			// to wait feedback from
			// detector
			return null;
		}

		byte[] buffer = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		logger.debug("waiting to receive data...");
		int urpRetry = timeout > 100000 ? 1 : 2;
		boolean found = true;
		boolean ack = false;
		while (urpRetry > 0) {
			try {
				socket.setSoTimeout(timeout);
				socket.receive(packet);
			} catch (Exception ex) {
				urpRetry--;
				logger.warn("no data received \n" + ex
						+ ", retry receive:" + urpRetry);
				// ex.printStackTrace();
				continue;
			}

			byte data[] = packet.getData();
			InetAddress address = packet.getAddress();
			UrpPkg replyPkg = decodeFromData(data, data.length,
					address.getHostAddress(), packet.getPort());

//			if (sendPkg.getSeqID() != replyPkg.getSeqID()) {
//				logger.warn("sequence id is not same, repeat receive.");
//				urpRetry--;
//				continue;
//			}

			// if (replyPkg.getCmdFlag() == 1) {// ack flag
			// found = false;
			// ack = true;
			// logger.debug("got ACK Packet data, re-receive...");
			// if (sendPkg.getSeqID() == replyPkg.getSeqID()) {
			// found = true;
			// }
			// continue;
			// }
			// if (!found) {
			// continue;
			// }
			//
			// if (ack && found) { // got data and need ack reply
			// UrpPkg ackpkg = new UrpPkg();
			// ackpkg.setSeqID(replyPkg.getSeqID());
			// ackpkg.setCmdFlag(Command.ACK_FLAG);
			// // sent ack message => hi,detector,i got the data.
			// send(address.getHostAddress(), packet.getPort(), ackpkg, false);
			// }

			return replyPkg;
		}
		return null;

	}

	/**
	 * print remote replied data.
	 *
	 * @param socket
	 */
	public UrpPkg continueReciveInfoByte(int timeout) {
		byte[] buffer = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		logger.info("waiting to receive data...");
		int urpRetry = timeout > 100000 ? 1 : 5;
		while (urpRetry > 0) {
			try {
				clientReciveSocket.setSoTimeout(timeout);
				clientReciveSocket.receive(packet);
			} catch (IOException ex) {
				urpRetry--;
				logger.error("no data received \n" + ex + ", retry receive:"
						+ urpRetry);
				// ex.printStackTrace();
				continue;
			}

			byte data[] = packet.getData();
			InetAddress address = packet.getAddress();
			UrpPkg replyPkg = decodeFromData(data, data.length,
					address.getHostAddress(), packet.getPort());
			return replyPkg;
		}
		return null;

	}

	public static String toRadix(int data, int radix) {
		char[] digits = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };
		char buf[] = new char[33];
		int charPos = 32;

		while (data > radix) {
			buf[charPos--] = digits[data % radix];
			data = data / radix;
		}
		buf[charPos] = digits[data];
		return new String(buf, charPos, (33 - charPos));
	}

	public static void main(String args[]) {

		String detectorIp = Command.telServerIp;
		String localhostIp = Command.localhostIp;
		short systemPort = Command.systemPort;
		String broadcastIp = Command.broadcastIp;

		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-d")) {
				if ((i + 1) < args.length) {
					detectorIp = args[i + 1];
				}
			} else if (args[i].equals("-l")) {
				if ((i + 1) < args.length) {
					localhostIp = args[i + 1];
				}
			} else if (args[i].equals("-p")) {
				if ((i + 1) < args.length) {
					systemPort = Short.parseShort(args[i + 1]);
				}
			} else if (args[i].equals("-b")) {
				if ((i + 1) < args.length) {
					broadcastIp = args[i + 1];
				}
			}
		}

		logger.info("######## detector IP:" + detectorIp + " ########");
		logger.info("######## local IP:" + localhostIp + " ########");
		logger.info("######## system port:" + systemPort + " ########");
		logger.info("######## broadcast IP:" + broadcastIp + " ########");

		// org.apache.log4j.varia.LevelRangeFilter filter = new
		// org.apache.log4j.varia.LevelRangeFilter();
		// filter.setLevelMin(Level.DEBUG);
		// final Logger loggers = Logger.getRootLogger();
		//
		// org.apache.log4j.ConsoleAppender consoleAppender = new
		// org.apache.log4j.ConsoleAppender(
		// new org.apache.log4j.PatternLayout(
		// PatternLayout.TTCC_CONVERSION_PATTERN));
		// consoleAppender.setName("console log");
		// consoleAppender.addFilter(filter);
		// loggers.addAppender(consoleAppender);

//		Command command = Command.getInstance();
//		command.commandShakehand();
//
//		command.close();
//
//		Command command2 = Command.getInstance();
//		command2.commandShakehand();
//		command2.close();
//
//		Command command3 = Command.getInstance();
//		command3.commandShakehand();
//
//		command3.close();
	}

}
