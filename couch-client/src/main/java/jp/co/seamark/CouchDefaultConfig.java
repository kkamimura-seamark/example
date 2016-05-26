package jp.co.seamark;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.support.IndexManager;

@Configuration
@EnableCouchbaseRepositories
public class CouchDefaultConfig extends AbstractCouchbaseConfiguration {

	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList("192.168.0.190");
	}

	@Override
	protected String getBucketName() {
		return "default";
	}

	@Override
	protected String getBucketPassword() {
		return "";
	}

	@Override
	public IndexManager indexManager() {
		return new IndexManager(true, false, false);
	}

}
