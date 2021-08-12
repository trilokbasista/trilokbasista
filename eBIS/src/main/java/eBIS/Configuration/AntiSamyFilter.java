package eBIS.Configuration;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.stereotype.Component;

//
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import org.apache.commons.codec.binary.Base64;
//import org.apache.commons.lang3.StringEscapeUtils;
//import org.apache.commons.lang3.StringUtils;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.Cookie;
//import org.owasp.validator.html.AntiSamy;
//import org.owasp.validator.html.CleanResults;
//import org.owasp.validator.html.Policy;
//import org.owasp.validator.html.PolicyException;
//import org.springframework.stereotype.Component;
//
@Component
public class AntiSamyFilter implements Filter {

	@Override
	   public void destroy() {}

	   @Override
	   public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain) 
	      throws IOException, ServletException {
	      
	      System.out.println("Remote Host:"+request.getRemoteHost());
	      System.out.println("Remote Address:"+request);
	      filterchain.doFilter(request, response);
	   }

	   @Override
	   public void init(FilterConfig filterconfig) throws ServletException {}
	
}
//
//	private final AntiSamy antiSamy ;
//	 public AntiSamyFilter() {
//	        try {
//	            URL url = this.getClass().getClassLoader().getResource("antisamy-default.xml");
//	            System.out.println("url: "+url);
//	            Policy policy = Policy.getInstance(url.getFile());
//	            antiSamy = new AntiSamy(policy);
//	        } catch (PolicyException e) {
//	            throw new IllegalStateException(e.getMessage(), e);
//	        }
//	    }
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		String method = ((HttpServletRequest) request).getMethod();	
//		HttpServletRequest req=((HttpServletRequest) request);   
//		HttpServletResponse res=((HttpServletResponse) response); 			
//		String url = req.getRequestURI();
//		System.out.println(req.getRequestURL().toString());
//		if(shouldExclude(request)||url.equals("/eBIS/logout")||method.equalsIgnoreCase("GET") && url.equals("/eBIS/login") || url.equals("/eBIS/getCaptcha")||url.equals("/eBIS/AHCFeeResponse") || url.equals("/eBIS/AHCListForWebsite")||url.equals("/eBIS/getDistrictAjax")||url.contains("/eBIS/sendRecognitionAndAccountMappingMailToAHC")||url.contains("/eBIS/ahcLogo")|| url.equals("/eBIS/EsignResponse")||url.equals("/eBIS/EsignResponsePC")||url.equals("/eBIS/PaymentDetailsInitiateFeeResponse")||url.equals("/eBIS/FeePCApplicantApplicationResponse"))
//		{
//		  chain.doFilter(request, response);	
//		}
//		else {
//
//			Cookie jSessionCookie = null;
//			Cookie[] cookies = req.getCookies();
//			String originalUserId = "";
//			String sessionId = "";
//			//String decodedSessionId = "";
//			String originalSessionId = "";
//			if (cookies != null) {
//				for(int i=0;i<cookies.length;i++){
//					Cookie cookie = cookies[i];
//					if(cookie.getName().equals("window_count_save")){
//						originalUserId= cookie.getValue();
//					}else if(cookie.getName().equals("hit_count_save")){
//						sessionId = cookie.getValue();
//						byte[] decodedSessionByte = Base64.decodeBase64(cookie.getValue().getBytes());
//						String decodedSessionId = new String(decodedSessionByte);
//						System.out.println("decodedSessionId: "+decodedSessionId);
//					} else if(cookie.getName().equals("JSESSIONID") || cookie.getName().equalsIgnoreCase("eBISId")){
//						jSessionCookie= cookie;
//						originalSessionId =  cookie.getValue();
//						//System.out.println("JSESSIONID cookie !! \t"+ jSessionCookie.getValue());
//					}             	
//				}
//			}else {
//				System.out.println("Cookies are null");
//			}
//			String browserInfo = req.getHeader("User-Agent");
//
//			HttpSession session = req.getSession(false);
//			
//			/*String loggedInCheck="";
//			try{
//				loggedInCheck=session.getAttribute("logged-in").toString();
//			System.out.println("loggedInCheck is"+loggedInCheck);
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//			*/
//			if (null != session) 
//			{
//				Session usrInfo = (Session) session.getAttribute("SessInfo");
//
//				if (null != usrInfo) {
//					// System.out.println("User Info detail exist");
//					int newUserId = usrInfo.getUserid();
//					//System.out.println("newuserid"+newUserId);
//					String encUserId = usrInfo.getEncUserId();
//					//System.out.println("encUserId"+encUserId);
//					String encSessionId = usrInfo.getEncSessionId();
//					//System.out.println("encSessionId"+encSessionId);
//		            String tomcatSessId = usrInfo.getTomcatSessionId();
//		            //System.out.println("tomcat sess id "+tomcatSessId );
//		            //System.out.println("url is "+url);
//					if (StringUtils.isNotBlank(originalUserId) && StringUtils.isNotBlank(sessionId)) {
//						if ((!originalUserId.equals(encUserId)) || (!sessionId.equals(encSessionId))
//								|| (!browserInfo.equals(usrInfo.getBrowserInfo())) || (!originalSessionId.equals(tomcatSessId))) {
//							 System.out.println("Some value not Matcched Cookie Updated");
//							Cookie userIdCookie = new Cookie("window_count_save", originalUserId);
//							Cookie sessionCookie = new Cookie("hit_count_save", sessionId);
//							// System.out.println("decoded SessionId \t "+ decodedSessionId);
//							if (jSessionCookie == null)
//								System.out.println("jsessioncookie is null");
//
//							jSessionCookie.setValue(sessionId);
//
//							jSessionCookie.setVersion(jSessionCookie.getVersion() + 1);
//
//							// Cookie cookie = new Cookie("JSESSIONID", decodedSessionId);
//							// Cookie userIdCookie= new Cookie("usiddata",new
//							// Base64Encoder(""+registration.getNumUserId()));
//							res.addCookie(userIdCookie);
//							res.addCookie(sessionCookie);
//							// res.addCookie(jSessionCookie);
//
//							res.sendRedirect("./logout");
//							
//							Thread.currentThread().interrupt();
//						} 
//					}
//					else
//					{
//						if(null != session){
//							if(StringUtils.isBlank(originalUserId) && StringUtils.isBlank(sessionId))
//							{
//								System.out.println("in this vivek check");
//								res.sendRedirect("./logout");
//							}
//						     }
//						
//					}
//				}
//			}
//			
//
//
//
//		//end of sessionhijacking code
//
//
//
//
//
//
//
//
//
//		//start of antisamy code
//
//
//		        if (request instanceof HttpServletRequest && !url.equals("/eBIS/getCaptcha") && !url.equals("/eBIS/login") && !url.equals("/eBIS/GlobalTextEditorForHM") && !url.equals("/eBIS/GlobalTextEditor")) {
//		    		//HttpServletRequest req=((HttpServletRequest) request);
//		        	  // String url = req.getRequestURI();
//		        	   
//		        	 // Vivek Thandle on 28/5/2019, try-catch block to restrict Directory Traversal in Spring Framework: STH
//		               try {
//		          		   String[] arrurl = url.split("/");          		   
//		          		   String chkval = arrurl[arrurl.length-1];
//
//		          		   if ( url.indexOf( "%01" )!=-1  || url.indexOf( "%25" )!=-1   || url.indexOf( "%10" )!=-1 ){          			
//		   			    	    ((HttpServletResponse) response).sendRedirect("../eBIS/ErrorHandlerController");        		            	
//		   		        	    Thread.currentThread().interrupt();
//		     			     }
//		          		   else{
//		          			  // System.out.println("%01 or %25 or %10 check leakage");
//		          		   }
//		          		   
//		          		   if(chkval!=null && !chkval.equals("")){
//		          			     if (chkval.indexOf( ";" )!=-1 || chkval.indexOf( "%01" )!=-1  || chkval.indexOf( "%25" )!=-1   || chkval.indexOf( "%10" )!=-1 ||  chkval.indexOf( ";;9711'():;9274" )!=-1 ||  chkval.indexOf( "(" )!=-1||  chkval.indexOf( ")" )!=-1 ||  chkval.indexOf( "'" )!=-1 ||  chkval.indexOf( ":" )!=-1 ){
//		          			 
//		          			    	    ((HttpServletResponse) response).sendRedirect("../eBIS/ErrorHandlerController");        		            	
//		          		        	    Thread.currentThread().interrupt();
//		          			     }
//		          			      
//		          		   }
//
//		   		   } catch (Exception e) {
//		   				// : handle exception
//		   		   }
//
//		    		   /*String[] arrurl = url.split("/");
//		    		   String chkval = arrurl[arrurl.length-1];
//		        	   
//		    		   if(chkval!=null && !chkval.equals("")){
//		    			     if (chkval.indexOf( ";" )!=-1  ||  chkval.indexOf( ":" )!=-1 ){
//		 			    	    ((HttpServletResponse) response).sendRedirect("../MSIPS/ErrorHandler");       		            	
//		    		        	    Thread.currentThread().interrupt();
//		    			     }
//		    		   }*///commented on 21/5/2018 Nishtha
//		            CleanServletRequest cleanRequest = new CleanServletRequest((HttpServletRequest) request, antiSamy);
//		            chain.doFilter(cleanRequest, response);    
//		            
//		        } else {
//		            chain.doFilter(request, response);
//		        }
//		    }
//	}
//	public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    public void destroy() {
//    }
//    public static class CleanServletRequest extends HttpServletRequestWrapper {
//
//        private final AntiSamy antiSamy;
//
//        private CleanServletRequest(HttpServletRequest request, AntiSamy antiSamy) {
//            super(request);
//            this.antiSamy = antiSamy;
//        }
//
//        /**
//         * overriding getParameter functions in {@link ServletRequestWrapper}
//         */
//        @Override
//        public String[] getParameterValues(String name) {
//            String[] originalValues = super.getParameterValues(name);
//            if (originalValues == null) {
//                return null;
//            }
//            List<String> newValues = new ArrayList<String>(originalValues.length);
//            for (String value : originalValues) {
//                newValues.add(filterString(value));
//            }
//            return newValues.toArray(new String[newValues.size()]);
//        }
//
//        @Override
//        public Map getParameterMap() {
//            Map<String, String[]> originalMap = super.getParameterMap();
//            Map<String, String[]> filteredMap = new ConcurrentHashMap<String, String[]>(originalMap.size());
//            for (String name : originalMap.keySet()) {
//                filteredMap.put(name, getParameterValues(name));
//            }
//            return Collections.unmodifiableMap(filteredMap);
//        }
//
//        @Override
//        public String getParameter(String name) {
//            String potentiallyDirtyParameter = super.getParameter(name);
//            return filterString(potentiallyDirtyParameter);
//        }
//
//        /**
//         * This is only here so we can see what the original parameters were, you should delete this method!
//         *
//         * @return original unwrapped request
//         */
//        @Deprecated
//        public HttpServletRequest getOriginalRequest() {
//            return (HttpServletRequest) super.getRequest();
//        }
//
//        /**
//         * @param potentiallyDirtyParameter string to be cleaned
//         * @return a clean version of the same string
//         */
//        private String filterString(String potentiallyDirtyParameter) {
//            if (potentiallyDirtyParameter == null) {
//                return null;
//            }
//
//            try {
//                CleanResults cr = antiSamy.scan(potentiallyDirtyParameter, AntiSamy.DOM);
//                if (cr.getNumberOfErrors() > 0) {
//                	System.out.println("antisamy encountered problem with input: " + cr.getErrorMessages());
//                }
//                return StringEscapeUtils.unescapeHtml4(cr.getCleanHTML());
//            } catch (Exception e) {
//                throw new IllegalStateException(e.getMessage(), e);
//            }
//        }
//    }
//    private boolean shouldExclude(ServletRequest req) {
//        if(req instanceof HttpServletRequest) {
//            HttpServletRequest hreq = (HttpServletRequest) req;
//            return (hreq.getRequestURI().endsWith(".css") ||
//                    hreq.getRequestURI().endsWith(".js")|| hreq.getRequestURI().endsWith(".png")|| hreq.getRequestURI().endsWith(".json") ||hreq.getRequestURI().endsWith(".jpg"));
//        }
//        return false;
//   }
//}
