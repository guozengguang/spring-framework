package com.gzg.test;

import com.gzg.bean.TestChangeMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guozengguang
 * @date 2019-06-18 10:17
 */
public class Main {
	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test/lookup/lookupTest.xml");
//		BeanTest beanTest = (BeanTest)applicationContext.getBean("beanTest");
//		beanTest.showMe();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test/replaceMethod/replaceMethodTest.xml");
		TestChangeMethod testChangeMethod = (TestChangeMethod) applicationContext.getBean("testChangeMethod");
		testChangeMethod.changeMe();
	}
}
