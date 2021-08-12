package eBIS.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.IOUtils;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class FtpConfiguration {
    
	@Value("${uat.ftp.username}")
    private String UATUserName;
 
    @Value("${uat.ftp.password}")
    private String UATPassWord;
 
    @Value("${uat.ftp.host}")
    private String UATIP;
 
    @Value("${uat.ftp.port}")
    private int UATPort;
    
    @Value("${uat.ftp.filepath}")
    private String UATFilePath;
    
    @Value("${production.ftp.username}")
    private String ProductionUserName;
 
    @Value("${production.ftp.password}")
    private String ProductionPassWord;
 
    @Value("${production.ftp.host}")
    private String ProductionIP;
 
    @Value("${production.ftp.port}")
    private int ProductionPort;
    
    @Value("${production.ftp.filepath}")
    private String ProductionFilePath;
    
    @Value("${local.ftp.username}")
    private String LocalUserName;
 
    @Value("${local.ftp.password}")
    private String LocalPassWord;
 
    @Value("${local.ftp.host}")
    private String LocalIP;
 
    @Value("${local.ftp.port}")
    private int LocalPort;
    
    @Value("${uat.ftp.filepath}")
    private String LocalFilePath;
    
    private FTPClient ftpClient = new FTPClient();
    public String uploadToFtp(MultipartFile upload_file,String FilePath)
            throws FTPConnectionClosedException, IOException, Exception {
    	InputStream inputstream = upload_file.getInputStream();
    	FTPClient ftpclient = connectToServer();
    	setFileType(FTP.BINARY_FILE_TYPE);
    	String checksum = GenerateCheckSum(inputstream);
    	ftpclient = uploadPathCreator(FilePath, ftpclient);
    	String[] FileExtensionTemp = upload_file.getOriginalFilename().split("\\.");
		String FileExtension = FileExtensionTemp[FileExtensionTemp.length-1];
		boolean upload = ftpclient.storeFile(checksum+"."+FileExtension, upload_file.getInputStream());
		closeConnect();
		if(upload!=true) {
			checksum="0";
		}
		return checksum;
    }
    public void closeConnect() {
        try {
            if (ftpClient != null) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (Exception e) {
        	System.out.println("Failed to close FTP connection!"+ e);
        }
    }
    private void setFileType(int fileType) {
        try {
            ftpClient.setFileType(fileType);
        } catch (Exception e) {
        	System.out.println("Failed to set the type of file transfer by FTP!"+e);
        }
    }
    private FTPClient connectToServer() throws FTPConnectionClosedException, Exception {
        if (!ftpClient.isConnected()) {
            int reply;
            String IP="";
            try {
                ftpClient = new FTPClient();
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.enterLocalPassiveMode();
                InetAddress ip;
        		String hostname="";
        		try {
        			ip = InetAddress.getLocalHost();
        			hostname = ip.getHostAddress();
        		} catch (UnknownHostException e) {
        			e.printStackTrace();
        		}

                int Port=0;
                String UserName="";
                String Passward="";
        		if(hostname.contains("10.10.38.4")||hostname.contains("10.10.38.11")||hostname.contains("10.10.38.15")||hostname.contains("10.10.38.16"))
        	      {
        			IP=ProductionIP;
        			Port=ProductionPort;
        			UserName=ProductionUserName;
        			Passward=ProductionPassWord;
        	      }else {
        	    	  if(hostname.contains("10.10.10.109")||hostname.contains("10.10.10.215")) {
        	    		IP=UATIP;
              			Port=UATPort;
              			UserName=UATUserName;
              			Passward=UATPassWord;
        	    	  }else {
        	    		IP=LocalIP;
              			Port=LocalPort;
              			UserName=LocalUserName;
              			Passward=LocalPassWord;
        	    	  }
        	      }
                ftpClient.connect(IP, Port);
                boolean loginflag = ftpClient.login(UserName, Passward);
                reply = ftpClient.getReplyCode();
                System.out.println(loginflag);
                if (!FTPReply.isPositiveCompletion(reply)) {
                    ftpClient.disconnect();
                    System.out.println("connectToServer FTP server refused connection.");
                }
 
            } catch (FTPConnectionClosedException ex) {
            	System.out.println("Server:IP:" + IP + "No connection! There are too many connected users, please try later"+ ex);
                throw ex;
            } catch (Exception e) {
            	System.out.println("Login to ftp server [" + IP + "] failed"+ e);
                throw e;
            }
        }
        return ftpClient;
    }

    private String GenerateCheckSum(InputStream inputstream) throws NoSuchAlgorithmException, IOException {
    	String stChecksum = "";
		byte[] content = IOUtils.toByteArray(inputstream);
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] digest = md5.digest(content);
		stChecksum = new BigInteger(1, digest).toString(16);
		return stChecksum;
    }
    public FTPClient uploadPathCreator(String stFilePath, FTPClient ftpclient) {
		String[] pathElements = stFilePath.split("/");
		try {
			ftpclient.setFileType(FTP.BINARY_FILE_TYPE);
			InetAddress ip;
    		String hostname="";
    		try {
    			ip = InetAddress.getLocalHost();
    			hostname = ip.getHostAddress();
    		} catch (UnknownHostException e) {
    			e.printStackTrace();
    		}
			String FilePath="";
			if(hostname.contains("10.10.38.4")||hostname.contains("10.10.38.11")||hostname.contains("10.10.38.15")||hostname.contains("10.10.38.16")){
				FilePath=ProductionFilePath;
			}else {
  	    	  if(hostname.contains("10.10.10.109")||hostname.contains("10.10.10.215")) {
  	    		FilePath=UATFilePath;
  	    	  }else {
  	    		FilePath=LocalFilePath;
  	    	  }
  	      }
			ftpclient.changeWorkingDirectory(FilePath);
			if (pathElements != null && pathElements.length > 0) {
				for (int i = 0; i < pathElements.length; i++) {
					ftpclient.changeWorkingDirectory(pathElements[i]);
					int returnCode = ftpclient.getReplyCode();
					if (returnCode == 550) {
						ftpclient.makeDirectory(pathElements[i]);
						ftpclient.changeWorkingDirectory(pathElements[i]);
					}
				}
			} else {
				System.out.println("Invalid Path: " + stFilePath);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return ftpclient;
	}
    public InputStream downloadfromFtp(String FilePath)
            throws FTPConnectionClosedException, IOException, Exception {
    	FTPClient ftpclient = connectToServer();
    	setFileType(FTP.BINARY_FILE_TYPE);
    	ftpclient = uploadPathCreator(FilePath, ftpclient);
    	InputStream inputStream = ftpclient.retrieveFileStream(FilePath);
		return inputStream;
    }
    
}
