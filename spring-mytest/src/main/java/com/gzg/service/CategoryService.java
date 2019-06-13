package com.gzg.service;

import com.alibaba.fastjson.JSON;
import com.gzg.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author guozengguang
 * @date 2019-06-12 16:43
 */
@Component
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	public void query() {
		List<Map<String, String>> list = categoryDao.query();
		System.out.println(JSON.toJSONString(list));
	}
}
