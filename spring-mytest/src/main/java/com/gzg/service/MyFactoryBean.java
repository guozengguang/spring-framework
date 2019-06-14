package com.gzg.service;

import com.gzg.dao.CategoryDao;
import com.gzg.handler.CategoryDaoInvocationHandler;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * 验证FactoryBean的特殊性
 * System.out.println("C1:" + annotationConfigApplicationContext.getBean("myFactoryBean"));
 * System.out.println("myFactoryBean:" + annotationConfigApplicationContext.getBean("&myFactoryBean"));
 * 只有&myFactoryBean才可以拿到MyFactoryBean自己，否则拿到的是getObject()方法中返回的对象
 *
 * @author guozengguang
 * @date 2019-06-14 15:55
 */
@Component
public class MyFactoryBean implements FactoryBean {
	//	@Override
//	public Object getObject() throws Exception {
//		return new C1();
//	}
//
//	@Override
//	public Class<?> getObjectType() {
//		return C1.class;
//	}
	@Override
	public Object getObject() throws Exception {
		Class[] interfaces = new Class[]{CategoryDao.class};
		CategoryDao categoryDao = (CategoryDao) Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(), interfaces, new CategoryDaoInvocationHandler());
		return categoryDao;
	}

	@Override
	public Class<?> getObjectType() {
		return CategoryDao.class;
	}
}
