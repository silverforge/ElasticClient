package xyz.mgj.elastic;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import xyz.mgj.elastic.contracts.IHttpTest;
import xyz.mgj.elastic.model.StringResult;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by janosmurvaigaal on 14/03/16.
 */
@RunWith(JUnit4.class)
@Category(IHttpTest.class)
public class ElasticHttpClientGetTest {
	private ElasticHttpClient client = new ElasticHttpClient("http://www.szerencsejatek.hu");

	// region Happy path

	@Test
	public void WHEN_http_get_called_THEN_proper_data_received() {
		StringResult result = client.get("/xls/otos.csv");
		assertNotNull(result);
		assertTrue(result.isSuccess());
		assertThat(result.getResult().length(), greaterThan(0));
	}

	// endregion

	// region Sad path

	@Test
	public void WHEN_wrong_path_defined_THEN_exception_thrown() {
		StringResult result = client.get("almabarack");
		assertNotNull(result);
		assertFalse(result.isSuccess());
		assertThat(result.getStatusCode(), is(404));
	}

	@Test(expected = NullPointerException.class)
	public void WHEN_null_url_defined_THEN_exception_thrown() {
		new ElasticHttpClient(null);
	}

	// endregion
}