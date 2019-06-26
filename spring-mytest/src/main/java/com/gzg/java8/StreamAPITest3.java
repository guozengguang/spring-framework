package com.gzg.java8;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * 一、Stream的三个步骤：
 * 1、创建Stream
 * 2、中间操作
 * 3、终止操作（终端操作）
 *
 * @author guozengguang
 * @date 2019-06-26 10:42
 */
public class StreamAPITest3 {
	/**
	 * 中间操作
	 * 排序
	 * sorted()--自然排序(Comparable)
	 * sorted(Comparator com) -- 定制排序(Comparator)
	 */
	private List<Employee> employees = Lists.newArrayList(
			new Employee("张三", 18, 9999.99),
			new Employee("李四", 38, 5555.55),
			new Employee("王五", 50, 6666.66),
			new Employee("赵六", 16, 3333.33),
			new Employee("田七", 8, 7777.77),
			new Employee("田七", 10, 7777.77),
			new Employee("田七", 9, 7777.77)
	);

	/**
	 * 自然排序
	 */
	@Test
	public void test1() {
		List<String> list = Lists.newArrayList("ddd", "eee", "aaa", "bbb", "ccc");
		list.stream()
				.sorted()
				.forEach(System.out::println);
		System.out.println("==============================================================");
		employees.stream()
				.sorted((e1, e2) -> {
					if (e1.getAge().equals(e2.getAge())) {
						return e1.getName().compareTo(e2.getName());
					} else {
						return e1.getAge().compareTo(e2.getAge());
					}
				}).forEach(System.out::println);
	}
}
