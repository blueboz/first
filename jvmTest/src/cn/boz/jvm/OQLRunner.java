package cn.boz.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

import cn.boz.jvm.pojo.UserInfo;

public class OQLRunner {

	public static String[] FIRST_NAME = { "Bleboz", "Jay", "John", "Jack", "Angla", "King", "Rube" };
	public static String[] LAST_NAME = { "Chen", "Li", "Wang", "Gao", "Lin", "Yao", "Zhou", "Cai" };
	public static String[] GENDERS = { "male", "female" };

	public static void main(String[] args) throws Exception {
		List<UserInfo> users = new ArrayList<UserInfo>();
		Random random = new Random();
		IntStream intRange = IntStream.range(0, 1000);
		intRange.forEach(it -> {
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(UUID.randomUUID().toString());
			userInfo.setAge(it);
			userInfo.setName(
					FIRST_NAME[random.nextInt(FIRST_NAME.length)] + "." + LAST_NAME[random.nextInt(LAST_NAME.length)]);
			userInfo.setGender(GENDERS[random.nextInt(2)]);
			userInfo.setSalary(it+random.nextDouble());
			users.add(userInfo);
		});
		Thread.sleep(1000 * 3600 * 24);

	}
	
	

}