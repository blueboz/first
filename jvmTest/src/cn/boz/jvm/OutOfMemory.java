package cn.boz.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OutOfMemory {

	private List<String> list = new ArrayList<String>();

	private void add(String str) {
		list.add(str);
	}
	
	public void stackObject() {
		var list= new ArrayList<String>();
		for(int i=0;i<50000;i++) {
			list.add("JayChou"+i);
		}
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line;
		try {
			line = bufr.readLine();
			System.out.println(line);
			System.out.println("Leave");
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public static void main(String[] args) throws IOException {
		String str="jj";
		
		var oom = new OutOfMemory();
		oom.stackObject();
		for (int i = 0; i < 1000000; i++) {
			oom.add(UUID.randomUUID().toString());
		}
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = bufr.readLine();
		System.out.println(line);
		//虚拟机中
	}

}
