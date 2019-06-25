package com.gzg.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author guozengguang
 * @date 2019-06-18 10:44
 */
public class TestMethodReplacer implements MethodReplacer {
	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("我替换了原有的方法");
		return null;
	}
}
