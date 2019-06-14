package com.gzg.service;

import com.gzg.handler.CategoryDaoInvocationHandler;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * 模拟mybatis的MapperFactoryBean
 * 不能写bean标签 这个FactoryBean没有被容器管理
 * 所以你必须让MapperFactoryBean给spring容器
 * <p>
 * 1、bean标签不行 多个dao需要写多个@Bean
 * 2、注解@Component不行，没法传参数mapperInterface
 * 3、只能使用BeanDefinition ---spring提供的扩展点
 *
 * @author guozengguang
 * @date 2019-06-14 15:55
 */
public class MybatisMapperFactoryBean implements FactoryBean {

	public MybatisMapperFactoryBean() {
	}

	public MybatisMapperFactoryBean(Class mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	Class mapperInterface;

	@Override
	public Object getObject() throws Exception {
		Class[] interfaces = new Class[]{mapperInterface};
		Object object = Proxy.newProxyInstance(MybatisMapperFactoryBean.class.getClassLoader(), interfaces, new CategoryDaoInvocationHandler());
		return object;
	}

	@Override
	public Class<?> getObjectType() {
		return Object.class;
	}

	public void setMapperInterface(Class mapperInterface) {
		this.mapperInterface = mapperInterface;
	}
}
