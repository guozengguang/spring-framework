package com.gzg.handler;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author guozengguang
 * @date 2019-06-14 14:34
 */
public class CategoryDaoInvocationHandler implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.isAnnotationPresent(Select.class)) {
			System.out.println(method.getAnnotation(Select.class).value()[0]);
		}
		return null;
	}
}
