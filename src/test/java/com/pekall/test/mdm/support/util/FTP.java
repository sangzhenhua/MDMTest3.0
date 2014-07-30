package com.pekall.test.mdm.support.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTP {
	public  boolean downFile( 
				            String url, //FTP服务器hostname 
				         
				            String username, //FTP登录账号 
				            String password, //FTP登录密码 
				            String remotePath,//FTP服务器上的相对路径  
				            String fileName,//要下载的文件名 
				            String localPath//下载后保存到本地的路径 
				            ) {   
				        boolean success = false;   
				        FTPClient ftp = new FTPClient();   
				        try {   
				            int reply;   
				            ftp.connect(url);   
			            //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器    
				            ftp.login(username, password);//登录    
				            reply = ftp.getReplyCode();   
				            if (!FTPReply.isPositiveCompletion(reply)) {   
				                ftp.disconnect();   
				                return success;   
				            }   
				            ftp.setControlEncoding("GBK");

				            ftp.enterLocalPassiveMode();
				            ftp.setFileTransferMode(org.apache.commons.net.ftp.FTP.STREAM_TRANSFER_MODE);
				            ftp.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
				            ftp.changeWorkingDirectory(remotePath);//转移到FTP服务器目录    
				            FTPFile[] fs = ftp.listDirectories(); 
				            FTPFile newFile = fs[0];
				            for(FTPFile ff:fs){   
				            		if(ff.getTimestamp().after(newFile.getTimestamp())){
				            			newFile = ff;
				            		}
				                	
				                	
				              
				       
				            }   
				              
				           System.out.println("new File is :"+ newFile.getName());
				           ftp.changeWorkingDirectory(remotePath+"/"+newFile.getName());
				           FTPFile[] fs2 = ftp.listFiles();
				           for(FTPFile f:fs2){
				        	   if(f.getName().contains(fileName)){
				        		   File localFile = new File(localPath+"/"+f.getName());   
				                    OutputStream is = new FileOutputStream(localFile);    
				                    ftp.retrieveFile(f.getName(), is);   
				                    is.close();   
				        	   }
				           }
				          
				            ftp.logout();   
				            success = true;   
				        } catch (IOException e) {   
				            e.printStackTrace();   
				        } finally {   
				            if (ftp.isConnected()) {   
				                try {   
				                    ftp.disconnect();   
			                } catch (IOException ioe) {   
				                }   
				            }   
				        }   
				        return success;   
				    }
	    }
 
