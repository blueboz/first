package cn.boz.utils;

import java.util.ArrayList;
import java.util.UUID;

public class Tester {

	public static void main(String[] args) {
		var list=new ArrayList<String>();
		while(true) {
			list.add(UUID.randomUUID().toString());
		}
	}
}
