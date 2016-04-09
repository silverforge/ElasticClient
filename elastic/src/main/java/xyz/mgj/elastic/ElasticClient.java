package xyz.mgj.elastic;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import xyz.mgj.elastic.contracts.IElasticClient;
import xyz.mgj.elastic.contracts.IElasticType;
import xyz.mgj.elastic.model.ClientSettings;

/**
 * Created by janosmurvaigaal on 14/03/16.
 */
public class ElasticClient implements IElasticClient {
	private ClientSettings settings;

	public ElasticClient(ClientSettings settings) {
		this.settings = settings;
	}

	public static Builder builder() {
		return new Builder();
	}

	public boolean createIndex(String indexName, AnnotatedElement types) {

		types.getClass().getFields();

		return true;
	}



	public static class Builder {
		private ClientSettings settings;

		public Builder url(String url) {
			settings.setUrl(url);
			return this;
		}

		public Builder userName(String userName) {
			settings.setUserName(userName);
			return this;
		}

		public Builder password(String password) {
			settings.setPassword(password);
			return this;
		}

		public ElasticClient build() {
			return new ElasticClient(settings);
		}
	}
}
