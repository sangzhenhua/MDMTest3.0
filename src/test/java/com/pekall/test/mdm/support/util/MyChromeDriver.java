package com.pekall.test.mdm.support.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyChromeDriver extends ChromeDriver {

	@Override
	public void get(String url) {
		// TODO Auto-generated method stub
		super.get(url);
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		List<WebElement> list = null;
		try{
		 list = super.findElements(by);
		
		}catch(NoSuchElementException e2){
			System.out.println(by.toString()+"没有找到");
			CaptureScreenshot.screenShot("元素没有找到");
		}
		 
		 return list;
	}

	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		WebElement el = null;
		try{
			el = super.findElement(by);
		
		}catch(NoSuchElementException e2){
			System.out.println("\n");
			System.out.println(by.toString()+"没有找到");
			System.out.println("\n");
			CaptureScreenshot.screenShot("元素没有找到");
		}
		
		return el;
	}

}
