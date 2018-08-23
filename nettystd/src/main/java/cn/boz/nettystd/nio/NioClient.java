package cn.boz.nettystd.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NioClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException {
		
		SocketChannel sc = SocketChannel.open();
		sc.connect(new InetSocketAddress("localhost", 9026));
		sc.configureBlocking(true);
		FileChannel fc = new FileInputStream("C:\\Users\\Administrator\\git\\firstSwt\\nettystd\\build.gradle").getChannel();
		long size = fc.size();
		int pos=0;
		int offset=218;
		long curnset=0;
		long counts=0;
		while(pos<size) {
			curnset = fc.transferTo(pos, 218, sc);
			pos+=offset;
			counts+=curnset;
		}
		fc.close();
		sc.close();
		System.out.println(counts);
		System.out.println("bytes send-- "+	counts);
		
		
	}
}
