package eBIS.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "readonlyEntityManager")
public class ReadonlyDataSourceConfiguration {

	@Value("${readonly.show-sql}")
    private String showsql;
	@Value("${package.scan}")
    private String packageScanner;
	
	@Value("${production.readonly.datasource.jdbcurl}")
    private String ProductionDatasourceJdbcurl;
    
    @Value("${production.readonly.datasource.username}")
    private String ProductionDatasourceUsername;
    
    @Value("${production.readonly.datasource.password}")
    private String ProductionDatasourcePassword;
    
    @Value("${uat.readonly.datasource.jdbcurl}")
    private String UATDatasourceJdbcurl;
    
    @Value("${uat.readonly.datasource.username}")
    private String UATDatasourceUsername;
    
    @Value("${uat.readonly.datasource.password}")
    private String UATDatasourcePassword;
    
    @Value("${local.readonly.datasource.jdbcurl}")
    private String LocalDatasourceJdbcurl;
    
    @Value("${local.readonly.datasource.username}")
    private String LocalDatasourceUsername;
    
    @Value("${local.readonly.datasource.password}")
    private String LocalDatasourcePassword;
    
    @Value("${datasource.poolsize}")
    private String DatasourcePoolsize;
    
    @Value("${readonly.datasource.minimumidle}")
    private String MinimumIdle;
    
    @Value("${datasource.maxlifetime}")
    private String MaxlifeTime;
    
    @Value("${datasource.idletimeout}")
    private String IdletimeOut;
    
    @Value("${datasource.leakdetectionthreshold}")
    private String LeakdetectionThreshold;
    
    @Value("${datasource.keepalivetime}")
    private String keepalivetime;
    
    @Value("${datasource.connectiontimeout}")
    private String ConnectionTimeout;
    
	@Bean(name="readonly",destroyMethod = "close")
    @Qualifier("readonlyEntityManager")
	public DataSource readonlydataSource() {
		InetAddress ip;
		String hostname="";
		try {
			ip = InetAddress.getLocalHost();
			hostname = ip.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("org.postgresql.Driver");
		String DatasourceJdbcurl="";
		String DatasourceUsername="";
		String DatasourcePassword="";
		if(hostname.contains("10.10.38.4")||hostname.contains("10.10.38.11")||hostname.contains("10.10.38.15")||hostname.contains("10.10.38.16"))
	      {
			DatasourceJdbcurl=ProductionDatasourceJdbcurl;
			DatasourceUsername=ProductionDatasourceUsername;
			DatasourcePassword=ProductionDatasourcePassword;
	      }else {
	    	  if(hostname.contains("10.10.10.109")||hostname.contains("10.10.10.215")) {
	    		  DatasourceJdbcurl=UATDatasourceJdbcurl;
	    		  DatasourceUsername=UATDatasourceUsername;
	    		  DatasourcePassword=UATDatasourcePassword;
	    	  }else {
	    		DatasourceJdbcurl=LocalDatasourceJdbcurl;
	  			DatasourceUsername=LocalDatasourceUsername;
	  			DatasourcePassword=LocalDatasourcePassword;
	    	  }
	      }
		System.out.println("Primary DatasourceJdbcurl: "+DatasourceJdbcurl);
		System.out.println("Primary DatasourceUsername: "+DatasourceUsername);
		System.out.println("Primary DatasourcePassword: "+DatasourcePassword);
	    hikariConfig.setJdbcUrl(DatasourceJdbcurl); 
	    hikariConfig.setUsername(DatasourceUsername);
	    hikariConfig.setPassword(DatasourcePassword);
//	    hikariConfig.setConnectionTestQuery("SELECT 1");
	    hikariConfig.setPoolName("ReadonlyHikari");
	    hikariConfig.setConnectionTimeout(Long.parseLong(ConnectionTimeout));
	    hikariConfig.setMinimumIdle(Integer.parseInt(MinimumIdle));
	    hikariConfig.setMaximumPoolSize( Integer.parseInt(DatasourcePoolsize));
	    hikariConfig.setAutoCommit(true);
	    hikariConfig.setReadOnly(true);
	    hikariConfig.setMaxLifetime(Long.parseLong(MaxlifeTime));
	    hikariConfig.setIdleTimeout(Long.parseLong(IdletimeOut));
	    hikariConfig.setLeakDetectionThreshold(Long.parseLong(LeakdetectionThreshold));
	    hikariConfig.setKeepaliveTime(Long.parseLong(keepalivetime));
	    hikariConfig.setAllowPoolSuspension(true);
	    hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
	    hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);
	    return dataSource;
	}
	Properties readonlyJpaProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.show_sql", showsql);
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.use_sql_comments", "false");
        properties.setProperty("hibernate.generate_statistics", "false");
        properties.setProperty("hibernate.archive.autodetection", "class");
        properties.setProperty("hibernate.id.new_generator_mappings", "false");
        return properties;
    }
	@Bean(name = "readonlyEntityManager")
    public LocalContainerEntityManagerFactoryBean readonlyEntityManager(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(readonlydataSource());
        String[] packageScannerArray = packageScanner.replace(" ", "").split(",");
        em.setPackagesToScan(packageScannerArray);
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(readonlyJpaProperties());
        em.setPersistenceUnitName("readonlyPersistence");
        return em;
    }
	@Bean(name="readonlydaohelper")
	ReadonlyDaoHelper readonlyDaoHelper(){
		ReadonlyDaoHelper readonlydaohelper = new eBIS.Configuration.ReadonlyDaoHelper();
    	return readonlydaohelper;
    }
	@Bean(name = "readonlyjdbcTemplate")
    public synchronized JdbcTemplate readonlyjdbcTemplate(@Qualifier("readonlyEntityManager") DataSource ds) {
     return new JdbcTemplate(ds);
    }
}
