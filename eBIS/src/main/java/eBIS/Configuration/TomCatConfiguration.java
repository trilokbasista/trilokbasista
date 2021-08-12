package eBIS.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomCatConfiguration {
	@Value("${uatserverport}")
    private String UATServerPort;
	
	@Value("${productionserverport}")
    private String ProductionServerPort;
	@Bean
	public TomcatServletWebServerFactory servletContainer() {
 	TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
       @Override
       protected void postProcessContext(Context context) {
         SecurityConstraint securityConstraint = new SecurityConstraint();
         securityConstraint.setUserConstraint("CONFIDENTIAL");
         SecurityCollection collection = new SecurityCollection();
         collection.addPattern("/*");
         securityConstraint.addCollection(collection);
         context.addConstraint(securityConstraint);
       }
     };
   tomcat.addAdditionalTomcatConnectors(redirectConnector());
   //System.out.println("TomCatConfiguration");
   return tomcat;
 }
	private Connector redirectConnector() {
		InetAddress ip;
		String hostname="";
		try {
			ip = InetAddress.getLocalHost();
			hostname = ip.getHostAddress();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	      Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	      connector.setScheme("http");
	      if(hostname.contains("10.10.38.4")||hostname.contains("10.10.38.11")||hostname.contains("10.10.38.15")||hostname.contains("10.10.38.16"))
	      {
	    	  connector.setPort(Integer.parseInt(ProductionServerPort));
	      }else {
	    	  connector.setPort(Integer.parseInt(UATServerPort));
	      }
	      connector.setSecure(false);
	      connector.setRedirectPort(8443);
	      return connector;
	    }
}
