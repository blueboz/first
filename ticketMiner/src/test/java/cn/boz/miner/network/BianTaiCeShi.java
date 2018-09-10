package cn.boz.miner.network;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class BianTaiCeShi {

	@Test
	public void testname() {
		System.out.println("Begin");
		var list = new ArrayList<Thread>();
		for (int i = 0; i < 100; i++) {
			Thread thread = new Thread(() -> {
				HttpRequester instance = HttpRequester.getInstance();
				System.out.println(instance);
			});
			thread.setDaemon(false);
			list.add(thread);
		}
		for (Thread thread : list) {
			thread.start();
		}
	}
}
