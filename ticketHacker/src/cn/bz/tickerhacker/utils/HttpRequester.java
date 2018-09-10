package cn.bz.tickerhacker.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpRequester {

	// 采用单例设计模式进行设计
	private static HttpRequester requester;

	// Cookie容器
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
	
	public Map jsonPost(String url,Map<String,Object> params) {
		String rst = HttpRequester.getInstance().postRequest(url, params);
		if(rst!=null&&rst.length()>0) {
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				Map rm = objectMapper.readValue(rst,Map.class);
				return rm;
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public String postRequest(String url,Map<String,Object> params)   {
		InputStream stream = postsStream(url, params);
		if(stream!=null) {
			try {
				byte[] bs = stream.readAllBytes();
				String content = new String(bs,"UTF-8");
				return content;
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public InputStream postsStream(String url,Map<String,Object> params) {
		var formparams=new ArrayList<NameValuePair>();
		params.forEach((k,v)->{
			formparams.add(new BasicNameValuePair(k, (String) v));
		});
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams,Consts.UTF_8);
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(entity);
		try {
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity rEntity = response.getEntity();
			InputStream content = rEntity.getContent();
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public InputStream getStream(String url) {
		URI uri = URI.create(url);
		HttpGet request = new HttpGet(uri);
		try {
			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getRequest(String url, String encode) {
		InputStream content = null;
		try {
			content = getStream(url);
			String str = new String(content.readAllBytes(), encode);
			return str;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				content.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
