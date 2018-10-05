package cn.boz.miner;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.boz.miner.network.HttpRequester;
import cn.boz.miner.network.NetworkUtils;

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
		LoginLiangChenyun yun = new LoginLiangChenyun();
		Runtime.getRuntime().addShutdownHook(yun);
		String r1 = yun.checkIn("1173626291@qq.com", "1173626291");
		System.out.println(r1);
		String r2 = yun.checkIn("blueboz.chen@bstek.com", "1173626291");
		System.out.println(r2);
	}
	
	public String checkIn(String email,String psw) {
		StringBuilder infomation = new StringBuilder();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("email", email);
		map.put("passwd", psw);
		map.put("code", "");
		Map rst = NetworkUtils.getInstance().loginLiangChengyun(map);
		if(rst!=null) {
			int ret=(int) rst.get("ret");
			if(ret==1) {
				infomation.append(rst.get("msg")+":"+map.get("email"));
				infomation.append(System.getProperty("line.separator"));
				Map info = NetworkUtils.getInstance().checkInLiangChenyun();
				infomation.append(info.get("msg"));
				infomation.append(System.getProperty("line.separator"));
			}else {
				infomation.append(rst.get("msg"));
				infomation.append(System.getProperty("line.separator"));
			}
			String logout = NetworkUtils.getInstance().logoutLiangChenYun();
			Optional.of(logout).ifPresent(it->{
				infomation.append("登出成功!");
				infomation.append(System.getProperty("line.separator"));
			});
		}
		return infomation.toString();
	}
	
	
}

