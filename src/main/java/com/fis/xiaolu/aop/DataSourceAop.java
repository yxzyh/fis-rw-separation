package com.fis.xiaolu.aop;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.fis.xiaolu.dbutils.DBContextHolder;


/**
 * @Desc   描述。。。
 * @author XiaoLu.Su
 * @date   2019年12月9日下午3:12:30 
 */
public class DataSourceAop {
	 /*从库的切点,没有标注Master注解，并且方法名为select和get开头的方法，走从库*/
    @Pointcut("!@annotation(com.fis.xiaolu.anno.Master) " +
            "&& (execution(* com.fis.xiaolu.service..*.select*(..)) " +
            "|| execution(* com.fis.xiaolu.service..*.get*(..))" +
            "|| execution(* com.fis.xiaolu.service..*.find*(..))" +
            "|| execution(* com.fis.xiaolu.service..*.query*(..)))")
    public void slavePointcut() {

    }

    /*主库的切点,或者标注了Master注解或者方法名为insert、update等开头的方法，走主库*/
    @Pointcut("@annotation(com.fis.xiaolu.anno.Master) " +
            "|| execution(* com.fis.xiaolu.service..*.insert*(..)) " +
            "|| execution(* com.fis.xiaolu.service..*.add*(..)) " +
            "|| execution(* com.fis.xiaolu.service..*.update*(..)) " +
            "|| execution(* com.fis.xiaolu.service..*.edit*(..)) " +
            "|| execution(* com.fis.xiaolu.service..*.delete*(..)) " +
            "|| execution(* com.fis.xiaolu.service..*.remove*(..))")
    public void masterPointcut() {
    }

    @Before("slavePointcut()")
    public void slave() {
        DBContextHolder.slave();
    }

    @Before("masterPointcut()")
    public void master() {
        DBContextHolder.master();
    }
}
