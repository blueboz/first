package cn.boz.miner.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

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

	/**
	 * 返回时json串的POST请求
	 * 
	 * @param url    请求URL
	 * @param params 请求参数
	 * @return
	 */
	public Map jsonPost(String url, Map<String, Object> params) {
		String rst = requester.postRequest(url, params);
		return string2JsonMap(rst);
	}

	
	public Map jsonGet(String url) {
		return jsonGet(url, new HashMap());
	}
	/**
	 * 返回时json串的其你去
	 * 
	 * @param url    请求url
	 * @param params 请求参数
	 * @return
	 */
	public Map jsonGet(String url, Map<String, Object> params) {
		String rst = requester.getRequest(url, params);
		return string2JsonMap(rst);
	}

	public String postRequest(String url, Map<String, Object> params, Map<String, String> header) {
		InputStream inputStream = postStream(url, params, header);
		return stream2String(inputStream, null);
	}

	/**
	 * @param url    URL
	 * @param encode 编码类型
	 * @return
	 */
	public String postRequest(String url, String encode) {
		return postRequest(url, encode, null);
	}

	/**
	 * 默认UTF-8编码
	 * 
	 * @param url    目标URL
	 * @param params 参数列表
	 * @return
	 */
	public String postRequest(String url, Map<String, Object> params) {
		return postRequest(url, null, params);
	}

	/**
	 * @param url    目标url
	 * @param encode 编码类型
	 * @param params 参数map
	 * @return
	 */
	public String postRequest(String url, String encode, Map<String, Object> params) {
		return postRequest(url, encode, params, null);
	}

	/**
	 * 最完整的方法，其他都是这个方法衍生出去的。
	 * 
	 * @param url     目标url
	 * @param encode  编码类型
	 * @param params  请求参数
	 * @param headers 请求头
	 * @return
	 */
	public String postRequest(String url, String encode, Map<String, Object> params, Map<String, String> headers) {
		InputStream inputStream = postStream(url, params, headers);
		return stream2String(inputStream, encode);
	}

	public InputStream postStream(String url, Map<String, Object> params, Map<String, String> header) {
		var formparams = new ArrayList<NameValuePair>();
		if (params != null) {
			params.forEach((k, v) -> {
				formparams.add(new BasicNameValuePair(k, (String) v));
			});
		}

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
		if (header != null) {
			header.forEach((k, v) -> {
				httpPost.addHeader(k, v);
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

	public InputStream postStream(String url, Map<String, Object> params) {
		return postStream(url, params, null);
	}

	public InputStream postStream(String url) {
		return postStream(url, null);
	}

	public InputStream getStream(String url, Map<String, Object> params, Map<String, String> headers) {
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		if (params != null)
			params.forEach((k, v) -> {
				formparams.add(new BasicNameValuePair(k, (String) v));
			});
		String urlSuffix = "";
		try {
			urlSuffix = EntityUtils.toString(new UrlEncodedFormEntity(formparams, Consts.UTF_8));
		} catch (ParseException | IOException e1) {
			e1.printStackTrace();
		}
		if (urlSuffix != null && urlSuffix.length() > 0) {
			if (url.contains("?")) {
				url += "&" + urlSuffix;
			} else {
				url += "?" + urlSuffix;
			}
		}
		URI uri = URI.create(url);
		HttpGet httpGet = new HttpGet(uri);
		httpGet.addHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
		try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getRequest(String url, String encode, Map<String, Object> params, Map<String, String> headers) {
		InputStream inputStream = getStream(url, params, headers);
		return stream2String(inputStream, encode);
	}

	public String getRequest(String url, String encode, Map<String, Object> params) {
		return getRequest(url, encode, params, null);
	}

	public String getRequest(String url, String encode) {
		return getRequest(url, encode, null);
	}

	public String getRequest(String url, Map<String, Object> params) {
		return getRequest(url, null, params);
	}

	public String getRequest(String url) {
		return getRequest(url, "");
	}

	public InputStream getStream(String url, Map<String, Object> params) {
		return getStream(url, params, null);
	}

	public InputStream getStream(String url) {
		return getStream(url, null);
	}

	public void closeHttpClient() {
		try {
			if (httpClient != null)
				((CloseableHttpClient) httpClient).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * stream 流转字符串 注意，此方法会关流
	 * 
	 * @param inputStream 输入流
	 * @param encode      编码
	 * @return
	 */
	private String stream2String(InputStream inputStream, String encode) {
		String rst = null;
		if (inputStream != null) {
			try {
				byte[] bs = inputStream.readAllBytes();
				if (encode == null || encode.length() == 0) {
					encode = "UTF-8";
				}
				rst = new String(bs, encode);
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

	/**
	 * 将JSON 字符串转成Map对象
	 * 
	 * @param str 字符串
	 * @return
	 */
	private Map string2JsonMap(String str) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			if (str != null && str.length() > 0) {
				Map rm = objectMapper.readValue(str, Map.class);
				return rm;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
