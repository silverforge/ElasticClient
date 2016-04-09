package xyz.mgj.elastic.contracts;

import xyz.mgj.elastic.model.StringResult;

/**
 * Created by janosmurvaigaal on 14/03/16.
 */
public interface IElasticHttpClient {
	StringResult head(String path);
	StringResult get(String path);
	StringResult post(String path, String data);
	StringResult put(String path, String data);
	StringResult delete(String path, String data);
}
