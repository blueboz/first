package cn.boz.miner.network;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpRequester {

	private static HttpRequester requester;

	HttpClientBuilder builder = HttpClientBuilder.create();

	private HttpRequester() {
	}

	public static HttpRequester getInstance() {
		if(requester==null)
			requester=new HttpRequester();
		return requester;
	}
	
	public String getRequest(String url) {
		return getRequest(url,"UTF-8");
	}

	public String getRequest(String url,String encode) {
		CloseableHttpClient httpClient = builder.build();
		HttpGet request = new HttpGet(url);
		HttpResponse response;
		try {
			response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			String str = new String(content.readAllBytes(), encode);
			return str;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
