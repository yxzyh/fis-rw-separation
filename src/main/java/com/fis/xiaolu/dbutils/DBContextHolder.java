package com.fis.xiaolu.dbutils;

import com.fis.xiaolu.eum.DBTypeEnum;

/**
 * @Desc   描述。。。
 * @author XiaoLu.Su
 * @date   2019年12月9日下午2:31:14 
 */
public class DBContextHolder {

	private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

	public static void set(DBTypeEnum dBTypeEnum) {
		contextHolder.set(dBTypeEnum);
	}
	
	public static DBTypeEnum get() {
		return contextHolder.get();
	}
	
	public static void master() {
		set(DBTypeEnum.MASTER);
		System.out.println("切换到主机");
	}
	
	public static void slave() {
		set(DBTypeEnum.SLAVE);
		System.out.println("切换到从机");
	}
	
	
	
}
