package cn.boz.miner.network;

import java.io.InputStream;
import java.util.Map;


public final class NetworkUtils {

	public static NetworkUtils networkUtils;

	private NetworkUtils() { }

	public static NetworkUtils getInstance() {
		if (networkUtils == null) {
			synchronized (NetworkUtils.class) {
				if (networkUtils == null) {
					networkUtils = new NetworkUtils();
				}
			}
		}
		return networkUtils;
	}

	public InputStream getVCode() {
		InputStream stream = HttpRequester.getInstance().getStream(
				"https://kyfw.12306.cn/passport/captcha/captcha-image?login_site=E&module=login&rand=sjrand&0.6523714968109542");
		return stream;
	}
	
	public Map vCodeVerify(Map<String,Object> map) {
		String url="https://kyfw.12306.cn/passport/captcha/captcha-check";
		return HttpRequester.getInstance().jsonPost(url, map);
	}
	
	public Map login(Map<String,Object> map) {
		String url="https://kyfw.12306.cn/passport/web/login";
		return HttpRequester.getInstance().jsonPost(url, map);
	}
	
	/**
	 *  queryType: 2
	 *	queryStartDate: 2018-09-29
	 *	queryEndDate: 2018-09-30
	 *	come_from_flag: my_order
	 *	pageSize: 8
	 *	pageIndex: 0
	 *	query_where: G
	 *	sequeue_train_name: 
	 * @param map
	 * @return
	 */
	public Map queryMyTicket(Map<String,Object> map) {
		String url="https://kyfw.12306.cn/otn/queryOrder/queryMyOrder";
		return HttpRequester.getInstance().jsonPost(url, map);
	}
	
	/**
	 * 登录良辰云
	 * email
	 * password
	 * code
	 * @param params
	 */
	public Map loginLiangChengyun(Map<String,Object> params) {
		String url="https://xn--9kq677j3ki.app/auth/login";
		Map rst = HttpRequester.getInstance().jsonPost(url, params);
		return rst;
	}
}
