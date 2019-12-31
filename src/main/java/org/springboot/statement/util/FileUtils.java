package org.springboot.statement.util;


public class FileUtils {
	
	public static String getPrefixPath2(String name) {
		String filePath = null;
		if(name.length()>=2) {
			filePath = name.substring(0,1)+"/"+name.substring(1,2)+"/";
		}
		else {
			filePath = name.substring(0,1)+"/"+name.substring(0,1)+"/";
		}
        
		return filePath;
	}
}
