package com.pekall.test.mdm.support.util;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pekall.test.mdm.support.service.MyDriver;
import com.pekall.test.mdm.support.service.Service;

public class WaitForElement {
	private static WaitForElement instance;
	private  WebDriver driver = Service.getInstance(MyDriver.USE);
	
	public static WaitForElement getInstance(){
		if(instance == null){
			instance = new WaitForElement();
		}
		return instance;
	}
	public WebElement wait(By by){
	
		long start = System.currentTimeMillis();
		
		while (true) {

			try {

				return driver.findElement(by);

			} catch(NoSuchElementException nse) {
				System.out.println("no such element");
				System.out.println("System.currentTimeMillis()- start"+(System.currentTimeMillis()- start));
				if (System.currentTimeMillis()- start >= WebInfos.waitTimeout) {
					nse.printStackTrace();
					CaptureScreenshot.screenShot(by.toString());
					return null;
				} 
				else {
					try {
						synchronized(this) {
							wait(WebInfos.waitInterval);
						}
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			catch(WebDriverException wde) {
				System.out.println("no such emlement");
				System.out.println("System.currentTimeMillis()- start"+(System.currentTimeMillis()- start));
				if (System.currentTimeMillis()- start >= WebInfos.waitTimeout) {
					wde.printStackTrace();
					CaptureScreenshot.screenShot(by.toString());
					return null;
				} 
				else {
					try {
						synchronized(this) {
							wait(WebInfos.waitInterval);
						}
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void waitAndClick(By by){
	
		long start = System.currentTimeMillis();
		WebElement el = null;

		while (true) {
			System.out.println(by.toString());
			try {
				driver.findElement(by).click();
				break;

			} catch(NoSuchElementException nse) {
				System.out.println("no such emlement");
				System.out.println("System.currentTimeMillis()- start"+(System.currentTimeMillis()- start));
				if (System.currentTimeMillis()- start >= WebInfos.waitTimeout) {
					nse.printStackTrace();
					CaptureScreenshot.screenShot(by.toString());
					return;
				} 
				else {
					
					try {
						synchronized(this) {
							wait(WebInfos.waitInterval);
						}
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			catch(WebDriverException wde) {
				System.out.println("no such emlement");
				System.out.println("System.currentTimeMillis()- start"+(System.currentTimeMillis()- start));
				if (System.currentTimeMillis()- start >= WebInfos.waitTimeout) {
					wde.printStackTrace();
					CaptureScreenshot.screenShot(by.toString());
					return;
				} 
				else {
					System.out.println("wait");
					try {
						synchronized(this) {
							wait(WebInfos.waitInterval);
						}
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
			}
			//ElementNotVisibleException
			
		}
	}
	
	public void waitAndSwitchToFrame(String id){
		long start = System.currentTimeMillis();
		driver.switchTo().defaultContent();
		WebElement webElement = null;
		while (true) {
		
			try {
				webElement = driver.findElement(By.id(id));
				if(webElement!=null){
					driver.switchTo().frame(id);
					return;
				}
			
			} catch(NoSuchElementException nse) {
				System.out.println("no such element");
				System.out.println("System.currentTimeMillis()- start"+(System.currentTimeMillis()- start));
				if (System.currentTimeMillis()- start >= WebInfos.waitTimeout) {
					nse.printStackTrace();
					CaptureScreenshot.screenShot(id);
					return;
				} 
				else {
				
					try {
					
						synchronized(this) {
							
							wait(WebInfos.waitInterval);
						}
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
		
	}
	
	
	public void waitAndSwitchToFrame(By by){
		long start = System.currentTimeMillis();
		driver.switchTo().defaultContent();
		WebElement webElement = null;
		while (true) {
			System.out.println(by.toString());
			try {

				webElement = driver.findElement(by);
				if(webElement != null){
					driver.switchTo().frame(driver.findElement(by).getAttribute("id"));
					return;
				}
				
			} catch(NoSuchElementException nse) {
				System.out.println("no such element");
				System.out.println("System.currentTimeMillis()- start"+(System.currentTimeMillis()- start));
				
				if (System.currentTimeMillis()- start >= WebInfos.waitTimeout) {
					nse.printStackTrace();
					CaptureScreenshot.screenShot(by.toString());
					return;
				} 
				else {
				
					try {
						synchronized(this) {
							wait(WebInfos.waitInterval);
						}
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	
	public boolean wait(String str){
		return wait(str,WebInfos.waitTimeout);
	}
	
	public boolean wait(String str,long timeout){
		
		long start = System.currentTimeMillis();
		boolean r = false;

		while (true) {
			
			 r = driver.getPageSource().contains(str); 
		
			if(r){
				return r;
			}
			else{
				System.out.println("System.currentTimeMillis()- start"+(System.currentTimeMillis()- start));
				
				if (System.currentTimeMillis()- start >= timeout) {
					CaptureScreenshot.screenShot(str);
					return false;
				} 
				else {
					
					try {
						synchronized(this) {
							wait(WebInfos.waitInterval);
						}
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
}
