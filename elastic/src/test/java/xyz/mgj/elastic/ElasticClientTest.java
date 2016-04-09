package xyz.mgj.elastic;

import org.junit.Test;

import xyz.mgj.elastic.contracts.IElasticType;
import xyz.mgj.elastic.dummy.Dummy;

/**
 * Created by janosmurvaigaal on 20/03/16.
 */
public class ElasticClientTest {

	@Test
	public void Test1() {

		ElasticClient client = ElasticClient
			.builder()
			.url("aaaa")
			.userName("3424")
			.password("23werwerwe")
			.build();


		Dummy dummy = new Dummy();

//		client.createIndex("aaa", dummy);

	}
}
