package com.jaeseong.kakao.util;

import org.springframework.stereotype.Service;

@Service
public class GlobalVar {
	public static String CONTEXT_PATH = "";
	public static String RESOURCES_PATH = "";
	public static String IMG_PATH = "/kakao/resources/image/";
	
	public void afterPropertiesSet() throws Exception {		
		String classPath = this.getClass().getResource("/").getPath(); 
		System.out.println("classPath : " + classPath);
		CONTEXT_PATH = classPath.substring(0, classPath.lastIndexOf("WEB-INF"));
		System.out.println("context_path : " + CONTEXT_PATH);
		
		RESOURCES_PATH = CONTEXT_PATH + "resources/";
		
	}
}
