package eBIS.nswsAPI.Controller;

import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import eBIS.nswsAPI.Services.NSWSFileUploadService;

@RestController
@RequestMapping("API/NSWS")
public class NSWSDownloadFileController {
//	@Autowired
//	NSWSFileUploadService uploadservice;
	
	@Value("${ftp.seperator}")
	private String FileSeparator; // do not make static
	
	@Value("${upload.hm.documents.path}")
	private String uploadHMDocumentsPath; // do not make static
	
	@GetMapping(value="/DownloadNSWSFile")
	public void downloadNSWSFile(HttpServletRequest  request,HttpServletResponse response) throws Exception {
//		String FilePath=uploadHMDocumentsPath+FileSeparator+"97"+FileSeparator+"979000409_97"+FileSeparator+"87e287a1f02f65497653c88fdcabb3aa.jpg";
//		InputStream inputStream=uploadservice.downloadFile(FilePath);
//		if (inputStream != null) {
//			response.setHeader("Content-Transfer-Encoding", "binary");
//			response.setHeader("Content-Disposition", "inline; filename=\"" + "downloadFile");
//			}
//		ServletOutputStream out = response.getOutputStream();
//		int i;
//		while ((i = inputStream.read()) != -1) {
//		out.write(i);
//		}
//		inputStream.close();
//		out.close();
//		uploadservice.closeConnect();
	}
	
}
