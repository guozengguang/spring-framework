package com.gzg.test;

import com.gzg.config.AppConfig;
import com.gzg.service.CategoryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author guozengguang
 * @date 2019-06-12 16:44
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		CategoryService categoryService = annotationConfigApplicationContext.getBean(CategoryService.class);
		categoryService.query();
	}
}
