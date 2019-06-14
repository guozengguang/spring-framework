package com.gzg.annotation;

import com.gzg.spring.SpringImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author guozengguang
 * @date 2019-06-14 17:01
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(SpringImportBeanDefinitionRegistrar.class)
public @interface CustomizeMapperScan {
}
