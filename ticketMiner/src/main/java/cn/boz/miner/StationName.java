package cn.boz.miner;

import java.util.HashMap;
import java.util.Map;

import cn.boz.miner.network.HttpRequester;

public class StationName {

	public static StationName stationName;
	private Map<String,Object> mapper=new HashMap<String,Object>();

	private StationName () {
		String raw = HttpRequester.getInstance().getRequest("https://kyfw.12306.cn/otn/resources/js/framework/station_name.js?station_version=1.8964");
		String stations = raw.substring(raw.indexOf('\'')+1, raw.lastIndexOf("\'"));
		String[] stats = stations.split("@");
		for (String stat : stats) {
			if(stat.length()>0) {
				String[] sa = stat.split("\\|");
				mapper.put(sa[2], sa[1]);
			}
		}
	}
	
	public static StationName getInstance() {
		if(stationName==null)
			stationName=new StationName();
		return stationName;
	}
	
	public static void main(String[] args) {
		StationName instance = StationName.getInstance();
	}
	
	public String translate(String name){
		return (String) mapper.get(name.trim());
	}
	
}

