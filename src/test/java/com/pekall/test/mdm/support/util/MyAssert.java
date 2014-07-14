package com.pekall.test.mdm.support.util;

import org.junit.Assert;


public class MyAssert extends Assert {

	public static void assert_True(String failStr,boolean condition ){
		if(!condition){
			CaptureScreenshot.screenShot(failStr);
		}
		
		Assert.assertTrue(condition);
	}
	
	public static void assert_False(String failStr,boolean condition ){
		if(condition){
			CaptureScreenshot.screenShot(failStr);
		}
		Assert.assertTrue(condition);
	}
}
