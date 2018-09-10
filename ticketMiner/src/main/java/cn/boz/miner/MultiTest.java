package cn.boz.miner;

import java.util.ArrayList;

import cn.boz.miner.network.HttpRequester;

/**
 * 测试多线程问题
 * @author Administrator
 *
 */
public class MultiTest {

	public static void main(String[] args) {

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
