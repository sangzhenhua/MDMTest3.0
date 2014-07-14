package com.pekall.test.mdm.support.util;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.pekall.test.mdm.RunCukesTest;


public class CmdExcute {
	
	public static void run(long waitTime,String modulName,String methodName) throws InterruptedException{
		Thread.sleep(waitTime);
		excute("cmd\\runTest.cmd",modulName,methodName);
	}
	
	public static void pushJarToPhone(String uitestDir ) throws InterruptedException{
		System.out.println("push jar ");
		excute("cmd\\pushJarToPhone.cmd",uitestDir,null);
	}
	
	public static void mkMdmdir() throws InterruptedException{
		excute("cmd\\mkMdmdir.cmd",null,null);
	}
	
	public static void clearMdmdir() throws InterruptedException{
		excute("cmd\\clearMdmdir.cmd",null,null);
	}
	
	public static void buildJar(String uitestDir,String folderPath) throws InterruptedException{
		excute("cmd\\buildjar.cmd",uitestDir,folderPath);
	}
	
	public static void pullScreenshot(String folderPath)throws InterruptedException{
		excute("cmd\\pullScreenshot.cmd",folderPath,null);
	}
	
	public static Process logcat(String savePath,String methodName)throws InterruptedException{
		return excuteLogcat("cmd\\logcat.cmd",methodName);
	}
	
	private static void tasklist(String folderPath)throws InterruptedException{
		excute("cmd\\tasklist.cmd",folderPath,null);
	}
	
	public static void killAdbProcess()throws InterruptedException, IOException{
		excute("cmd\\killProcess.cmd","adb.exe",null);
	}
	
	public static void killDriverProcess()throws InterruptedException, IOException{
		excute("cmd\\killProcess.cmd","chromedriver.exe",null);
	}

	private static String  getAdbtaskPid() throws IOException, InterruptedException{
		tasklist(RunCukesTest.phoneUiTestLogPath);
		File file = new File(RunCukesTest.phoneUiTestLogPath+"\\tasklist.txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line=null;
		String[] trimedStr = new String[10];
		int i = 0;
        while((line=br.readLine())!=null) {
        	String[] strs = line.split(" ");
        	if(strs[0].contains("adb.exe")){
        		for(String str:strs){
        			if(!str.trim().isEmpty()){
        				trimedStr[i] = str.trim();
        				i++;
        			}
        		}
        		return trimedStr[1];
        	}
        	
        
        }
       
        return null;
	}
	
	public static boolean  analyzeResult(String methodName) throws IOException{
		boolean result = false;
		File file = new File(RunCukesTest.phoneUiTestLogPath+"\\"+methodName+".txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line=null;
        while((line=br.readLine())!=null) {
        	if(line.contains("Found ANR and click ok")){
    			return false;
    		}
        	if(line.startsWith("OK") || line.startsWith("BUILD SUCCESSFUL")){
        		
        		result = true;
        	}
        }
       
        return result;
	}
	private static Process excute(String cmdPath,String modulName,String methodName) throws InterruptedException{
		Process p =null;
		try {
			StringBuffer str = new StringBuffer();
			//str.append("cmd /c start ").append(path);
			str.append("cmd /c start ").append(cmdPath);
			if(modulName!=null){
				str.append(" ").append(modulName);	
			}
			if(methodName!=null){
				str.append(" ").append(methodName);
			}
			else{
				
			}
			
			str.append(" ").append(RunCukesTest.phoneUiTestLogPath);
		
			System.out.println(str.toString());
			p = Runtime.getRuntime().exec(str.toString());
		
			
	            //取得命令结果的输出流
	            InputStream fis=p.getInputStream();
	            //用一个读输出流类去读
	            InputStreamReader isr=new InputStreamReader(fis);
	            //用缓冲器读行
	            BufferedReader br=new BufferedReader(isr);
	            String line=null;
	            //直到读完为止
	            while((line=br.readLine())!=null) {
	                System.out.println(line);
	            }
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
		
	}
	
	private static Process excuteLogcat(String cmdPath,String methodName) throws InterruptedException{
		Process p =null;
		try {
			StringBuffer str = new StringBuffer();
			//str.append("cmd /c start ").append(path);
			str.append("cmd /c start ").append(cmdPath);
			str.append(" "+RunCukesTest.phoneSystemLogPath);
			if(methodName!=null){
				str.append(" ").append(methodName);	
			}
			
			else{
				
			}
			
			System.out.println(str.toString());
			p = Runtime.getRuntime().exec(str.toString());
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
		
	}
	
}
