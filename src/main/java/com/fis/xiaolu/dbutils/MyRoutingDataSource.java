package com.fis.xiaolu.dbutils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Desc   描述。。。
 * @author XiaoLu.Su
 * @date   2019年12月9日下午2:40:52 
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DBContextHolder.get();
	}

}
