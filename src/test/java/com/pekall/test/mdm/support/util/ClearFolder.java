package com.pekall.test.mdm.support.util;

import java.io.File;

public class ClearFolder {
	public static void clear(String path){
		File dir = new File(path);
		if(dir.exists()){	
			File[] files = dir.listFiles();
			System.out.println(files);
			if(files!=null){
				for(File file:files){
					file.delete();
				}
			}
		}
		
	}
}
