package cn.boz.nettystd.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NioServer {

	private static Logger logger = LoggerFactory.getLogger(NioServer.class);

	public static void main(String[] args) throws IOException {
		var ssc = ServerSocketChannel.open();
		var ss = ssc.socket();
		ss.setReuseAddress(true);
		ss.bind(new InetSocketAddress("localhost", 9026));
		var ba = ByteBuffer.allocate(4096);
		logger.info("Listen in :" + ss.getInetAddress() + " : " + ss.getLocalPort());
		int count=0;
		while (true) {
			var channel = ssc.accept();
			logger.info("Accepted :" + channel);
			channel.configureBlocking(true);
			int nread = 0;
			while (nread != -1) {
				try {
					nread = channel.read(ba);
					byte[] array = ba.array();
					String str = new String(array, 0, ba.position());
					System.out.println(str);
					ba.clear();
				} catch (IOException e) {
					e.printStackTrace();
					nread = -1;
				}
			}

		}

	}

}
