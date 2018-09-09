package cn.boz.miner.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class HttpRequester {

	private static HttpRequester requester;

	//private HttpClientBuilder builder = HttpClientBuilder.create();

	private CookieStore cookieStore;

	private HttpClient httpClient;

	private HttpRequester() {
		cookieStore = new BasicCookieStore();
		//builder.setDefaultCookieStore(cookieStore);
		httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
	}

	public static HttpRequester getInstance() {
		if (requester == null)
			requester = new HttpRequester();
		return requester;
	}

	public String getRequest(String url) {
		return getRequest(url, "UTF-8");
	}

	@SuppressWarnings("deprecation")
	public String getRequest(String url, String encode) {
		URI uri = URI.create(url);
		HttpGet request = new HttpGet(uri);

		HttpResponse response;
		try {
			response = httpClient.execute(request);
			Header[] hs = response.getAllHeaders();
			System.out.println();
			System.out.println("-----------------------");
			System.out.println(request.getURI());
			StatusLine statusLine = response.getStatusLine();
			System.out.println(statusLine);
			for (Header header : hs) {
				System.out.println(header.getName() + ":" + header.getValue());
			}
			Header[] cks = response.getHeaders("Set-Cookie");
			for (Header header : cks) {
				String value = header.getValue();
				String[] metas = value.split(";");
				for (String meta : metas) {
					System.out.println(meta);
					String[] kv = meta.split("=");
					if (kv.length == 2) {
						String k = kv[0];
						String v = kv[1];
					}
				}

				//BasicClientCookie basicClientCookie = new BasicClientCookie(, header.getValue());

				//cookieStore.addCookie(basicClientCookie);
			}
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			String str = new String(content.readAllBytes(), encode);
			return str;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeHttpClient();
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
