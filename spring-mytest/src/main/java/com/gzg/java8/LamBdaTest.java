package com.gzg.java8;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author guozengguang
 * @date 2019-06-25 12:29
 */
public class LamBdaTest {

	/**
	 * 原来的匿名内部类
	 */
	@Test
	public void test1() {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//实际上只有这一行有用
				return Integer.compare(o1, o2);
			}
		};
		TreeSet<Integer> treeSet = new TreeSet<>(comparator);
	}

	/**
	 * Lambda表达式
	 */
	@Test
	public void test2() {
//		Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
		Comparator<Integer> comparator = Integer::compare;
		TreeSet<Integer> treeSet = new TreeSet<>(comparator);
	}

	private List<Employee> employees = Lists.newArrayList(
			new Employee("张三", 18, 9999.99),
			new Employee("李四", 38, 5555.55),
			new Employee("王五", 50, 6666.66),
			new Employee("赵六", 16, 3333.33),
			new Employee("田七", 8, 7777.77)
	);

	@Test
	public void test3() {
		List<Employee> list = filterEmployees(employees);
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	/**
	 * 需求:获取当前公司中员工年龄大于等于35的员工信息
	 */
	public List<Employee> filterEmployees(List<Employee> employees) {
		List<Employee> emps = new ArrayList<>();
		for (Employee employee : employees) {
			if (employee.getAge() >= 35) {
				emps.add(employee);
			}
		}
		return emps;
	}

	/**
	 * 需求:获取当前公司中员工工资大于等于5000的员工信息
	 */
	public List<Employee> filterEmployees2(List<Employee> employees) {
		List<Employee> emps = new ArrayList<>();
		for (Employee employee : employees) {
			//跟上面年龄判断只有if判断不一样，造成大量冗余代码
			if (employee.getSalary() >= 5000) {
				emps.add(employee);
			}
		}
		return emps;
	}

	public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> myPredicate) {
		List<Employee> emps = new ArrayList<>();
		for (Employee employee : list) {
			if (myPredicate.compare(employee)) {
				emps.add(employee);
			}
		}
		return emps;
	}

	/**
	 * 优化方式一：策略设计模式
	 */
	@Test
	public void test4() {
		List<Employee> emps = filterEmployee(this.employees, new FilterEmployeeByAge());
		for (Employee emp : emps) {
			System.out.println(emp);
		}

		System.out.println("--------------------------------------------------------");

		List<Employee> employees = filterEmployee(this.employees, new FilterEmployeeBySalary());
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	/**
	 * 优化方式二:匿名内部类
	 */
	@Test
	public void test5() {
		List<Employee> list = filterEmployee(this.employees, new MyPredicate<Employee>() {
			@Override
			public boolean compare(Employee employee) {
				return employee.getSalary() >= 5000;
			}
		});

		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	/**
	 * 优化方式三:Lambda表达式
	 */
	@Test
	public void test6() {
		List<Employee> list = filterEmployee(this.employees, (employee) -> employee.getSalary() <= 5000);
		list.forEach(System.out::println);
	}

	/**
	 * 优化方式四:Stream API
	 */
	@Test
	public void test7() {
		this.employees.stream()
				.filter((e) -> e.getSalary() >= 5000)
				.limit(2)
				.forEach(System.out::println);
		System.out.println("--------------------------------------------------------");
		this.employees.stream()
				.map(Employee::getName)
				.forEach(System.out::println);
	}
}
