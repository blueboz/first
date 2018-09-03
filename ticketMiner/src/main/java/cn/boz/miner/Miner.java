package cn.boz.miner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.boz.miner.network.HttpRequester;

public class Miner {
	private static Logger logger = LoggerFactory.getLogger(Miner.class);

	static long freq=1000*60;

	public static void main(String[] args) throws ClientProtocolException, IOException {
		for (String str : args) {
			String[] split = str.split("=");
			if(split.length==2) {
				if("freq".equals(split[0])) {
					 freq = Long.parseLong(split[1])*1000;
				}
			}
		}
		Miner miner = new Miner();
		Thread thread = new Thread(()-> {
			while(true) {
				try {
					miner.minerWork();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(freq);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread.setName("Miner T");
		thread.start();
	}

	public Miner() {
		// TODO Auto-generated constructor stub
	}

	public void minerWork() throws JsonParseException, JsonMappingException, IOException{
		HttpClientBuilder builder = HttpClientBuilder.create();
		String content = HttpRequester.getInstance().getRequest(
				"https://kyfw.12306.cn/otn/leftTicket/queryA?leftTicketDTO.train_date=2018-09-30&leftTicketDTO.from_station=IOQ&leftTicketDTO.to_station=CBQ&purpose_codes=ADULT");
		Map<String, Object> map = new ObjectMapper().readValue(content, Map.class);
		Map<String, Object> data = (Map<String, Object>) map.get("data");
		Map<String, Object> infos = (Map<String, Object>) data.get("map");
		List<String> result = (List<String>) data.get("result");
		StationName stationName = StationName.getInstance();
		StringBuilder logstr = new StringBuilder();
		result.forEach(it -> {
			try {
				String decode = URLDecoder.decode(it, "UTF-8");
				logstr.append(it);
				String[] ts = decode.split("\\|");
				if(ts[0]!=null&&ts[0].trim().length()>0) {
					StringBuilder sb = new StringBuilder();
					sb.append(ts[3]);
					sb.append("\t");
					sb.append(stationName.translate(ts[6]));
					sb.append("->");
					sb.append(stationName.translate(ts[7]));
					sb.append(" ");
					sb.append(ts[8]);
					sb.append(" ");
					sb.append(ts[9]);
					sb.append(" ");
					sb.append(ts[10]);
					sb.append("\t一：");
					sb.append(ts[31]);
					sb.append("\t二：");
					sb.append(ts[30]);
					sb.append("\t站：");
					sb.append(ts[26]);
					System.out.println(sb);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		});
		System.out.println();
		logger.info(logstr.toString());	
	}
}
