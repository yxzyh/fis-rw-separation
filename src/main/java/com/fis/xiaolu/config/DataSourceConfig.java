package com.fis.xiaolu.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fis.xiaolu.dbutils.MyRoutingDataSource;
import com.fis.xiaolu.eum.DBTypeEnum;

/**
 * @Desc   描述。。。
 * @author XiaoLu.Su
 * @date   2019年12月9日下午2:56:40 
 */
@Configuration
public class DataSourceConfig {

	/**
	 * 主库数据源
	 * @return
	 */
	@Bean
	@ConfigurationProperties("spring.datasource.master")
	public DataSource masterDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	/**
	 * 从库数据源
	 * @return
	 */
	@Bean
	@ConfigurationProperties("spring.datasource.slave1")
	public DataSource slaveDataSource() {
		return DataSourceBuilder.create().build();
	}
	

	@Bean
	public DataSource myRoutingDataSource(@Qualifier("masterDataSource")DataSource masterDataSource,
			@Qualifier("slaveDataSource")DataSource slaveDataSource) {
		 Map<Object, Object> targetDataSources = new HashMap<>();
	        targetDataSources.put(DBTypeEnum.MASTER,masterDataSource);
	        targetDataSources.put(DBTypeEnum.SLAVE,slaveDataSource);
	        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
	        myRoutingDataSource.setTargetDataSources(targetDataSources);
	        /*当执行的方法没有被Aop拦截时，缺省使用的数据源*/
	        myRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
	        return myRoutingDataSource;
	}
	
	
	
	
	
}
