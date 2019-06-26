package com.gzg.java8;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
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
public class StreamAPITest2 {
	/**
	 * 中间操作
	 * 映射
	 * map-接收Lambda表达式，将元素转换成其他形式或者提取信息，接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
	 * flatMap-接收一个函数作为参数，将流中的每个值都换成另外一个流，然后把所有的流连成一个流
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
		List<String> list = Lists.newArrayList("aaa", "bbb", "ccc", "ddd", "eee");
		list.stream()
				.map(String::toUpperCase)
				.forEach(System.out::println);
		System.out.println("==============================================================");
		employees.stream()
				.map(Employee::getName)
				.distinct()
				.forEach(System.out::println);
		System.out.println("==============================================================");
		Stream<Stream<Character>> stream = list.stream()
				.map(StreamAPITest2::filterCharacter);
		stream.forEach((sm) -> sm.forEach(System.out::println));
		System.out.println("==============================================================");
		Stream<Character> flatMapStream = list.stream()
				.flatMap(StreamAPITest2::filterCharacter);
		flatMapStream.forEach(System.out::println);
	}

	@Test
	public void test2() {
		List<String> list = Lists.newArrayList("aaa", "bbb", "ccc", "ddd", "eee");
		List list2 = Lists.newArrayList(111, 222);
		list2.add(list);
		//[111, 222, [aaa, bbb, ccc, ddd, eee]] 类似于map
		System.out.println(list2);
		list2.remove(list);
		list2.addAll(list);
		//[111, 222, aaa, bbb, ccc, ddd, eee] 类似于flatMap
		System.out.println(list2);

	}

	public static Stream<Character> filterCharacter(String str) {
		List<Character> list = new ArrayList<>();
		for (Character character : str.toCharArray()) {
			list.add(character);
		}
		return list.stream();
	}
}
