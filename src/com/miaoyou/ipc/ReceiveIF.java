package com.miaoyou.ipc;

import java.net.DatagramSocket;

public interface ReceiveIF {

	public void run(final Communication communication,final DatagramSocket reciveSocket);
	
}
