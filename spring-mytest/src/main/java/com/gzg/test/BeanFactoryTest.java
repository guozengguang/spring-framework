package com.gzg.test;

import com.gzg.bean.MyTestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author guozengguang
 * @date 2019-06-17 18:19
 */
public class BeanFactoryTest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
		MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
		System.out.println("testStr".equals(myTestBean.getTestStr()));
	}
}
