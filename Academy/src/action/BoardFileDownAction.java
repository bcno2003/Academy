package action;

import java.io.*;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;

public class BoardFileDownAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String fileName = request.getParameter("downFile");
		System.out.println();
		String savePath = "boardUpload";
		ServletContext context = request.getServletContext();
		//서버 상의 실제 경로를 가져오는 부분
		String sDownloadPath = context.getRealPath(savePath);
		//다운로드 할 파일의 전체 경로값을 지정하는 부분
		String sFilePath = sDownloadPath+"\\"+fileName;
		//한번에 읽고 출혁할 사이즈를 지정
		byte b[]= new byte [4096];
		FileInputStream in = new FileInputStream(sFilePath);
		String sMimeType = request.getServletContext().getMimeType(sFilePath);
		if(sMimeType==null) {
			sMimeType="appplication/octet-stream";}
	         response.setContentType(sMimeType);
	         String agent=request.getHeader("User-Agent");
	         
	      //브라우저의 종류가 explorer인지 판단하는 부분
	      boolean ieBrowser=(agent.indexOf("MSIE")>-1)||(agent.indexOf("Trident")>-1);
	      
	      if(ieBrowser){
	         fileName=URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+","%20");
	      
	         
	      }else{
	         fileName=new String(fileName.getBytes("UTF-8"),"iso-8859-1");
	      }
	      response.setHeader("Content-Disposition","attachment; filename="+fileName);
	      ServletOutputStream out2=response.getOutputStream();
	      int numRead;
	      while((numRead=in.read(b,0,b.length))!=-1){
	         out2.write(b,0,numRead);
	         
	         
	      }
	      out2.flush();
	      out2.close();
	      in.close();
	         
	      
	      return null;
		
			}

}
