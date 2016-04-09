package xyz.mgj.elastic;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import xyz.mgj.elastic.contracts.IElasticHttpClient;
import xyz.mgj.elastic.model.HttpMethod;
import xyz.mgj.elastic.model.HttpMethodConstants;
import xyz.mgj.elastic.model.StringResult;

/**
 * Created by janosmurvaigaal on 14/03/16.
 */
public class ElasticHttpClient implements IElasticHttpClient {
	public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
	private final OkHttpClient client = new OkHttpClient();
	private HttpUrl parsedUrl;

	public ElasticHttpClient(String url) {
		parsedUrl = HttpUrl.parse(url);
	}

	public StringResult head(String path) {
		return invokeEndpoint(HttpMethod.HEAD, path);
	}

	public StringResult get(String path) {
		return invokeEndpoint(HttpMethod.GET, path);
	}

	public StringResult post(String path, String queryText) {
		return invokeEndpoint(HttpMethod.POST, path, queryText);
	}

	public StringResult put(String path, String queryText) {
		return invokeEndpoint(HttpMethod.PUT, path, queryText);
	}

	public StringResult delete(String path, String queryText) {
		return invokeEndpoint(HttpMethod.DELETE, path, queryText);
	}

	@NonNull
	private HttpUrl getHttpUrl(String path) {
		return new HttpUrl.Builder()
			.scheme(parsedUrl.scheme())
			.host(parsedUrl.host())
			.addPathSegments(path)
			.build();
	}

	private StringResult invokeEndpoint(HttpMethod method, String path) {
		return invokeEndpoint(method, path, null);
	}

	private StringResult invokeEndpoint(HttpMethod method, String path, String queryText) {
		StringResult result = new StringResult();

		try {
			Request request = getRequest(method, path, queryText);

			Response response = client.newCall(request).execute();
			result.setSuccess(response.isSuccessful());
			result.setStatusCode(response.code());
			result.setResult(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.addExceptionToResult(e);
		}

		return result;
	}

	private Request getRequest(HttpMethod method, String path, String queryText) {
		Request request;
		String methodName = method.getName();
		switch (methodName) {
			case HttpMethodConstants.HEAD:
				request = new Request.Builder()
					.url(getHttpUrl(path))
					.head()
					.build();
				break;
			case HttpMethodConstants.POST:
				request = new Request.Builder()
					.url(getHttpUrl(path))
					.post(RequestBody.create(MEDIA_TYPE_JSON, queryText))
					.build();
				break;
			case HttpMethodConstants.PUT:
				request = new Request.Builder()
					.url(getHttpUrl(path))
					.put(RequestBody.create(MEDIA_TYPE_JSON, queryText))
					.build();
				break;
			case HttpMethodConstants.DELETE:
				request = new Request.Builder()
					.url(getHttpUrl(path))
					.delete(RequestBody.create(MEDIA_TYPE_JSON, queryText))
					.build();
				break;
			default:
				request = new Request.Builder()
					.url(getHttpUrl(path))
					.get()
					.build();
				break;
		}
		return request;
	}
}
