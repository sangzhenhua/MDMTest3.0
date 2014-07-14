package com.pekall.test.mdm.support.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	public class DocManager {
		private static DocManager instance;
		private WebDriver driver = Service.getInstance(MyDriver.USE);
		
		public static DocManager getInstance(){
			if(instance == null){
				instance = new DocManager();
			}
			return instance;
		}
		
		public void gotoDocList() throws InterruptedException{
			driver.findElement(By.id("doc")).click();
			Thread.sleep(2000);
			driver.switchTo().frame("face-content");
		}
		
		public void addDoc(String name,String desc,String path) throws InterruptedException{
			driver.findElement(By.id("doc-name")).sendKeys(name);
			driver.findElement(By.id("doc-tag")).sendKeys(desc);
			driver.findElement(By.id("doc_file")).sendKeys(path);
			Thread.sleep(2000);
			driver.findElement(By.id("confirm")).click();
			Thread.sleep(6000);
		}
		
		public void selectDoc(List<String> docList){
			if(docList!=null){
				for(String doc_name:docList)
				{
					if(!doc_name.equals("文档名称")){
						WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr/td[2]/a[text()='"+doc_name+"']/parent::td/parent::tr/td/input[@type='checkbox']"));
						System.out.println(element.getAttribute("id"));
						if (!element.isSelected()){
							element.click();
						}
					}
				}
			}
		}
		
}
