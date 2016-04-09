package xyz.mgj.elastic.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by janosmurvaigaal on 14/03/16.
 */
public class Result {

	@Getter
	@Setter
	private boolean isSuccess;

	@Getter
	@Setter
	private int statusCode;

	@Getter
	private List<Exception> aggregatedExceptions = new ArrayList<>();

	public void addExceptionToResult(Exception ex) {
		aggregatedExceptions.add(ex);
	}
}
