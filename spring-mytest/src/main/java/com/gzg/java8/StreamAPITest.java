package com.gzg.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
public class StreamAPITest {
	@Test
	public void test1() {
		//1、可以通过Collection系列集合提供的stream()--- 串行流
		// parallelStream --并行流
		List<String> list = new ArrayList<>();
		Stream<String> stream1 = list.stream();
		//2、通过Arrays中的静态方法stream()获取数组流
		Employee[] employees = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(employees);
		//3、通过Stream类中的静态方法of()
		Stream<String> stream3 = Stream.of("aa", "bb", "cc");
		//4、创建无限流
		//迭代
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
//		stream4.forEach(System.out::println);
//		stream4.limit(10).forEach(System.out::println);

		//生成
//		Stream.generate(() -> Math.random()).forEach(System.out::println);
//		Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);
		Stream.generate(() -> (int) (Math.random() * 100)).limit(5).forEach(System.out::println);
	}
}
