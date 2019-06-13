package com.gzg.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author guozengguang
 * @date 2019-06-12 16:35
 */
public interface CategoryDao {
	@Select("select * from category")
	List<Map<String, String>> query();
}
