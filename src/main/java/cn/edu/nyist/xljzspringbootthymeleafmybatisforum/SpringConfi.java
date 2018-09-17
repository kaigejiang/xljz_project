package cn.edu.nyist.xljzspringbootthymeleafmybatisforum;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class SpringConfi {
	@Autowired
	private Environment env;
	@Bean(name="dataSource")
    public DataSource getDataSource() {
		DruidDataSource dSource = new DruidDataSource();
		dSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name").trim());
		dSource.setUrl(env.getProperty("spring.datasource.url").trim());
		dSource.setPassword(env.getProperty("spring.datasource.password").trim());
		dSource.setUsername(env.getProperty("spring.datasource.username").trim());
		return dSource;
	}
}
