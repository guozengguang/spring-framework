package com.gzg.spring;

import com.gzg.service.MybatisMapperFactoryBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author guozengguang
 * @date 2019-06-14 16:29
 */
public class SpringImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MybatisMapperFactoryBean.class);
		AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
		System.out.println(beanDefinition.getAutowireMode());
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.gzg.dao.CategoryDao");
		registry.registerBeanDefinition("categoryDao", beanDefinition);
	}
}
