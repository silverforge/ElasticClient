package xyz.mgj.elastic.model;

/**
 * Created by janosmurvaigaal on 14/03/16.
 */
public enum HttpMethod {
	HEAD(HttpMethodConstants.HEAD) {
		public String getName() {
			return HttpMethodConstants.HEAD;
		}
	},
	GET(HttpMethodConstants.GET) {
		@Override
		public String getName() {
			return HttpMethodConstants.GET;
		}
	},
	POST(HttpMethodConstants.POST) {
		@Override
		public String getName() {
			return HttpMethodConstants.POST;
		}
	},
	PUT(HttpMethodConstants.PUT) {
		@Override
		public String getName() {
			return HttpMethodConstants.PUT;
		}
	},
	DELETE(HttpMethodConstants.DELETE) {
		@Override
		public String getName() {
			return HttpMethodConstants.DELETE;
		}
	};

	private String method;

	HttpMethod(String method) {
		this.method = method;
	}

	public abstract String getName();

	@Override
	public String toString() {
		return method;
	}
}

