package cn.boz.miner.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpRequester {

	// 采用单例设计模式进行设计
	private static HttpRequester requester;

	//Cookie容器
	private CookieStore cookieStore;

	private HttpClient httpClient;

	private HttpRequester() {
		cookieStore = new BasicCookieStore();
		httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
	}

	/**
	 * 采用的是饿汉式 没有做好线程同步，可能会导致问题
	 */
	public static HttpRequester getInstance() {
		if (requester == null) {
			synchronized (HttpRequester.class) {
				if (requester == null) {
					requester = new HttpRequester();
				}
			}
		}
		return requester;
	}

	public String getRequest(String url) {
		return getRequest(url, "UTF-8");
	}

	public String getRequest(String url, String encode) {
		URI uri = URI.create(url);
		HttpGet request = new HttpGet(uri);
		try {
			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			String str = new String(content.readAllBytes(), encode);
			return str;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeHttpClient() {
		try {
			((CloseableHttpClient) httpClient).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
