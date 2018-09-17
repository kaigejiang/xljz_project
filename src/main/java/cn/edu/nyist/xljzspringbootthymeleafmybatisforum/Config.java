package cn.edu.nyist.xljzspringbootthymeleafmybatisforum;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class Config {
	
	@Autowired
	private Environment env;//由该类自动读取配置文件application.properties
	@Bean(name="dateSource")//相当于配置文件里面的bean
	public DataSource getDateSource() {
		DruidDataSource dds=new DruidDataSource();
		dds.setUsername(env.getProperty("spring.datasource.name").trim());
		dds.setPassword(env.getProperty("spring.datasource.password").trim());
		dds.setUrl(env.getProperty("spring.datasource.url").trim());
		dds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name").trim());
		return dds;
	}

}
