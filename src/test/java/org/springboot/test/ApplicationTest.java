package org.springboot.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.ho.yaml.Yaml;
import org.springboot.statement.objectstore.MinioObjectClient;
import org.springboot.statement.util.FileUtils;

public class ApplicationTest {
	public static void main(String[] args) {
		File file = new File(System.getProperty("user.dir")+"/src/main/resources/"+"application_config.yaml");
		try {
			Map map =Yaml.loadType(file, HashMap.class);
			System.out.println(map.get("file_directory"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*File file = new File(System.getProperty("user.dir")+"/src/main/resources/"+"object_store_config.properties");
		System.out.println(file.getPath());
		String uuid = UUID.randomUUID().toString();
		String objectName = FileUtils.getPrefixPath2(uuid)+uuid+"/"+file.getName();
		MinioObjectClient.getInstance().saveFile(objectName, file.getPath());
		System.out.println(objectName);*/
	}
}
