package com.gzg.test;

import com.gzg.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author guozengguang
 * @date 2019-06-12 16:44
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//		CategoryService categoryService = annotationConfigApplicationContext.getBean(CategoryService.class);
//		categoryService.query();
//		C2 c2 = annotationConfigApplicationContext.getBean(C2.class);
//		System.out.println(c2);
		System.out.println("C1:" + annotationConfigApplicationContext.getBean("myFactoryBean"));
		System.out.println("myFactoryBean:" + annotationConfigApplicationContext.getBean("&myFactoryBean"));
		System.out.println("categoryDao:" + annotationConfigApplicationContext.getBean("myFactoryBean"));


//		Class[] interfaces = new Class[]{CategoryDao.class};
//		CategoryDao categoryDao = (CategoryDao) Proxy.newProxyInstance(Test.class.getClassLoader(), interfaces, new CategoryDaoInvocationHandler());
//		categoryDao.query();
		/**
		 * 自己产生的对象如何交给spring容器管理
		 * 1、@Bean
		 * 2、annotationConfigApplicationContext.getBeanFactory().registerSingleton("categoryDao", categoryDao);
		 * 3、FactoryBean
		 */
//		annotationConfigApplicationContext.getBeanFactory().registerSingleton("categoryDao", categoryDao);
	}
}
