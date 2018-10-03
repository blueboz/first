package cn.boz.miner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.boz.miner.network.HttpRequester;

public class LoginLiangChenyun extends Thread{

	private static Logger logger = LoggerFactory.getLogger(Miner.class);

	@Override
	public void run() {
		logger.info("###################################");
		logger.info("#  Program is about to shutdown!  #");
		logger.info("###################################");
		HttpRequester.getInstance().closeHttpClient();
		super.run();
	}

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new LoginLiangChenyun());
		HttpRequester request = HttpRequester.getInstance();
		request.demo();

		/*Map<String,Object> map=new HashMap<String,Object>();
		map.put("email", "1173626291@qq.com");
		map.put("password", "1173626291");
		map.put("code", "");
		Map rst = NetworkUtils.getInstance().loginLiangChengyun(map);
		System.out.println(rst);*/

	}
}
