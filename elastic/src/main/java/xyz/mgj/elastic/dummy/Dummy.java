package xyz.mgj.elastic.dummy;

import java.util.List;

import xyz.mgj.elastic.contracts.IElasticType;

/**
 * Created by janosmurvaigaal on 20/03/16.
 */
@IElasticType
public class Dummy {
	private String name;
	private List<String> somethings;
}
