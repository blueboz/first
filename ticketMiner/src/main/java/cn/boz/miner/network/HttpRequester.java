package cn.boz.miner.network;

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

public final class HttpRequester {

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
	
	public String postRequestWithHeader(String url,Map<String,Object> params,Map<String,String> header) {
		InputStream inputStream = postStream(url, params, header);
		return stream2String(inputStream, null);
	}
	
	public String postRequest(String url,Map<String,Object> params,Map<String,String> header) {
		InputStream inputStream = postStream(url, params, header);
		return stream2String(inputStream, null);
	}
	
	/**
	 * stream 流转字符串
	 * 注意，此方法会关流
	 * @param inputStream 输入流
	 * @param encode 编码
	 * @return
	 */
	private String stream2String(InputStream inputStream,String encode) {
		String rst=null;
		if(inputStream!=null) {
			try {
				byte[] bs = inputStream.readAllBytes();
				if(encode==null||encode.length()>0) {
					rst=new String(bs,encode);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return rst;
	}
	
	public String postRequest(String url,Map<String,Object> params)   {
		InputStream inputStream = postStream(url, params,null);
		return stream2String(inputStream, null);
	}
	
	public InputStream postStream(String url,Map<String,Object> params,Map<String,String> header) {
		var formparams=new ArrayList<NameValuePair>();
		params.forEach((k,v)->{
			formparams.add(new BasicNameValuePair(k, (String) v));
		});
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams,Consts.UTF_8);
		HttpPost httpPost = new HttpPost(url);
		if(header!=null) {
			header.forEach((k,v)->{
				httpPost.addHeader(k,v);
			});
		}
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
		InputStream inputStream = getStream(url);
		return stream2String(inputStream, encode);
	}

	public void closeHttpClient() {
		try {
			((CloseableHttpClient) httpClient).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Demo
	 */
	public void demo() {
		HttpGet httpGet = new HttpGet("https://xn--9kq677j3ki.app/auth/login");
		httpGet.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
		try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			byte[] bs = is.readAllBytes();
			String raw = new String(bs,"UTF-8");
			System.out.println(raw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
