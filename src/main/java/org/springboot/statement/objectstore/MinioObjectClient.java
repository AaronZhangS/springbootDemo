package org.springboot.statement.objectstore;

import java.io.InputStream;
import java.util.Properties;
import io.minio.MinioClient;

public class MinioObjectClient {
	private static MinioObjectClient client = null;
	private static Object sycObj = new Object();
	private MinioClient conn = null;
	private String bucket = null;

	private MinioObjectClient(String propFile) {
		init(propFile);
	}

	public static MinioObjectClient getInstance() {
		synchronized (sycObj) {
			if (client == null) {
				client = new MinioObjectClient("/object_store_config.properties");
			}

			return client;
		}
	}

	public static MinioObjectClient getInstance(String propFile) {
		synchronized (sycObj) {
			if (client == null) {
				client = new MinioObjectClient(propFile);
			}

			return client;
		}
	}

	private void init(String propFile) {
		Properties prop = new Properties();
		try {
			InputStream in = getClass().getResourceAsStream(propFile);
			prop.load(in);

			String accessKey = prop.getProperty("object_store_access_key");
			String secretKey = prop.getProperty("object_store_secret_key");
			String endpoint = prop.getProperty("object_store_endpoint");
			bucket = prop.getProperty("object_store_bucket");

			String[] strs = endpoint.split(":");
			if (strs.length >= 2) {
				conn = new MinioClient(strs[0], Integer.parseInt(strs[1]), accessKey, secretKey, false);
			} else {
				conn = new MinioClient(endpoint, accessKey, secretKey, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	public void saveFile(String objectName, String fileName) {
		try {
			conn.putObject(bucket, objectName, fileName, "application/octet-stream");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
