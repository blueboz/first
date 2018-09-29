package cn.boz.jvm;

public class Runner implements Runnable {

	int a, b;

	public Runner(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			var t1=new Thread(new Runner(10, 8));
			t1.setName("T"+i+"A");
			var t2=new Thread(new Runner(8, 10));
			t2.setName("T"+i+"B");
			t1.start();
			t2.start();
		}
	}

	@Override
	public void run() {
		// 获取锁
		String name = Thread.currentThread().getName();
		System.out.println(name+" Enter");
		synchronized (Integer.valueOf(a)) {
			System.out.println(name+" got lock a:"+a);
			synchronized (Integer.valueOf(b)) {
				System.out.println(name+" got lock b:"+b);
				System.out.println(a + "==>" + b);
			}
		}
		System.out.println(name+" Leave");
	}
}
