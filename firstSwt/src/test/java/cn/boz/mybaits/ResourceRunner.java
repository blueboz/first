package cn.boz.mybaits;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

public class ResourceRunner {

	@SuppressWarnings("resource")
	@Test
	public void test() {
		try {

			System.out.println(System.getProperty("user.dir"));
			File file = new File("context.xml");
			FileInputStream fileInputStream = new FileInputStream(file);
			
			var str=new String(fileInputStream.readAllBytes(),"UTF-8");
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
