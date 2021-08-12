package eBIS.Configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"eBIS.*"})
public class EBisConfiguration {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(EBisConfiguration.class, args);
		for(int i=0;i< applicationContext.getBeanDefinitionNames().length;i++) {
			//System.out.println("Bean Class Name["+i+"]: "+applicationContext.getBeanDefinitionNames()[i]);
		}
	}
}
