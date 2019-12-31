package org.springboot.test;

import java.io.File;
import java.util.UUID;

import org.springboot.statement.objectstore.MinioObjectClient;
import org.springboot.statement.util.FileUtils;

public class ApplicationTest {
	public static void main(String[] args) {
		File file = new File("D:\\kuangye-workspace\\springbootDemo\\src\\main\\resources\\object_store_config.properties");
		String uuid = UUID.randomUUID().toString();
		String objectName = FileUtils.getPrefixPath2(uuid)+uuid+"/"+file.getName();
		MinioObjectClient.getInstance().saveFile(objectName, file.getPath());
		System.out.println(objectName);
	}
}
