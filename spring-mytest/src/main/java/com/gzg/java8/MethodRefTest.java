package com.gzg.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 一、方法引用:若Lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
 * (可以理解为方法引用是Lambda表达式的另外一种表现形式)
 * 主要有三种语法格式:
 * <p>
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 * 注意:
 * 1、Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的参数列表和返回值类型保持一致!
 * 2、若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
 * <p>
 * 二、构造器引用
 * 格式:
 * ClassName::new
 * 注意:需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
 * <p>
 * 三、数组引用
 * Type::new
 *
 * @author guozengguang
 * @date 2019-06-26 08:52
 */
public class MethodRefTest {
	@Test
	public void test7() {
		Function<Integer, String[]> function = (x) -> new String[x];
		String[] strs = function.apply(10);
		System.out.println(strs.length);

		Function<Integer, String[]> function1 = String[]::new;
		String[] strs2 = function1.apply(20);
		System.out.println(strs2.length);
	}

	/**
	 * 构造器引用 调用一个参数构造器
	 */
	@Test
	public void test6() {
		Function<Integer, Employee> function = (id) -> new Employee(id);
		Function<Integer, Employee> function1 = Employee::new;
		Employee employee = function1.apply(101);
		System.out.println(employee);

		BiFunction<Integer, Integer, Employee> biFunction = Employee::new;
	}

	/**
	 * 构造器引用 调用无参构造器
	 */
	@Test
	public void test5() {
		Supplier<Employee> supplier = () -> new Employee();
		Employee employee = supplier.get();

		Supplier<Employee> supplier1 = Employee::new;
		Employee employee1 = supplier1.get();
		System.out.println(employee1);
	}

	/**
	 * 类::实例方法名
	 */
	@Test
	public void test4() {
		BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
		BiPredicate<String, String> biPredicate1 = String::equals;
		BiPredicate<Employee, Employee> biPredicate2 = Employee::equals;
	}

	@Test
	public void test1() {
		PrintStream ps1 = System.out;
		Consumer<String> consumer = (str) -> ps1.println(str);
		PrintStream ps = System.out;
		Consumer<String> consumer1 = ps::println;
		Consumer<String> consumer2 = System.out::println;
		consumer2.accept("hello method ref...");
	}

	@Test
	public void test2() {
		Employee employee = new Employee();
		Supplier<String> supplier = () -> employee.getName();
		String name = supplier.get();
		System.out.println(name);
		System.out.println("===============================");
		Supplier<Integer> supplier1 = employee::getAge;
		Integer age = supplier1.get();
		System.out.println(age);
	}

	/**
	 * 类::静态方法名
	 */
	@Test
	public void test3() {
		Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
		Comparator<Integer> comparator1 = Integer::compare;
	}
}
