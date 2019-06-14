package com.gzg.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author guozengguang
 * @date 2019-06-12 16:35
 */
public interface CategoryDao {
	/**
	 * mybatis是为mapper或者dao产生了一个代理对象
	 * 代理对象实现了这个dao或者mapper,从而去实现里面的方法
	 * 主要是查询了数据库
	 *
	 * @return
	 */
	@Select("select * from course_pre")
	List<Map<String, String>> query();
}
