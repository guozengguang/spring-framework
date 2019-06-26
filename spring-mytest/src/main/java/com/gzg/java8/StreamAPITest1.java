package com.gzg.java8;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream的三个步骤：
 * 1、创建Stream
 * 2、中间操作
 * 3、终止操作（终端操作）
 *
 * @author guozengguang
 * @date 2019-06-26 10:42
 */
public class StreamAPITest1 {
	/**
	 * 中间操作
	 * 筛选与切片
	 * filter-接收Lambda，从流中排除某些元素
	 * limit-截断流，使其元素不超过给定数量
	 * skip-跳过元素，返回一个扔掉了前n个元素的流，若其中元素不足n个，则返回一个空流，与limit(n)互补
	 * distinct-筛选，<通过流所生成元素的hashCode()和equals()去除重复元素>
	 */
	private List<Employee> employees = Lists.newArrayList(
			new Employee("张三", 18, 9999.99),
			new Employee("李四", 38, 5555.55),
			new Employee("王五", 50, 6666.66),
			new Employee("赵六", 16, 3333.33),
			new Employee("田七", 8, 7777.77),
			new Employee("田七", 8, 7777.77),
			new Employee("田七", 8, 7777.77)
	);

	/**
	 * 内部迭代：迭代操作由Stream API完成 filter
	 */
	@Test
	public void test1() {
		//中间操作：不会执行任何操作
		Stream<Employee> stream = employees.stream()
				.filter(employee -> {
					System.out.println("Stream API的中间操作...");
					return employee.getAge() >= 35;
				});
		//终止操作：一次性执行全部内容，即"惰性求值或者延迟执行"
		stream.forEach(System.out::println);
	}

	/**
	 * 外部迭代
	 */
	@Test
	public void test2() {
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	/**
	 * limit
	 */
	@Test
	public void test3() {
		employees.stream()
				.filter((employee -> {
					//&& || 找到匹配的数据后短路 提高效率
					System.out.println("短路");
					return employee.getAge() >= 10;
				}))
				.limit(2)
				.forEach(System.out::println);
	}

	/**
	 * skip
	 */
	@Test
	public void test4() {
		employees.stream()
				.filter((employee -> employee.getSalary() > 5000))
				.skip(2)
				.forEach(System.out::println);
	}

	/**
	 * distinct
	 */
	@Test
	public void test5() {
		employees.stream()
				.filter((employee -> employee.getSalary() > 5000))
				.skip(2)
				.distinct()
				.forEach(System.out::println);
	}
}
