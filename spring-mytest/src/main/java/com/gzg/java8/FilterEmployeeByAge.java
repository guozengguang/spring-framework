package com.gzg.java8;

/**
 * @author guozengguang
 * @date 2019-06-25 13:06
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {
	@Override
	public boolean compare(Employee employee) {
		return employee.getAge() >= 35;
	}
}
