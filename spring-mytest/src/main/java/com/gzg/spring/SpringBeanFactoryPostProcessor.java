package com.gzg.spring;

import com.gzg.service.C2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author guozengguang
 * 自定义一个类实现BeanFactoryPostProcessor接口可以改变BeanDefinition 从而在spring实例化的时候实例化另外一个bean
 * 只能修改不能增加
 * @date 2019-06-14 15:33
 */
//@Component
public class SpringBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition c1 = (GenericBeanDefinition) beanFactory.getBeanDefinition("c1");
		c1.setBeanClass(C2.class);

	}
}
