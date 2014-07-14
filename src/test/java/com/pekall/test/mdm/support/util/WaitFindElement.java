package com.pekall.test.mdm.support.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pekall.test.mdm.support.service.MyDriver;
import com.pekall.test.mdm.support.service.Service;

public class WaitFindElement {
	private WebDriver driver = Service.getInstance(MyDriver.USE);
	public WebElement waitFindElement(By by,long timeout,long interval){
	
		long start = System.currentTimeMillis();

		while (true) {

			try {

				return driver.findElement(by);

			} catch(NoSuchElementException nse) {

				if (System.currentTimeMillis()- start >= timeout) {

				//	throw newError("Timeout reached and element[" + by + "]not found");

				} else {

					try {

						synchronized(this) {

							wait(interval);

						}

					} catch(InterruptedException e) {

						e.printStackTrace();

					}

				}

			}
		
	}
}
}
