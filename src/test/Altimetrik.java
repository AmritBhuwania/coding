package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Altimetrik {

	public static void main(String[] args) {

		List<Employee> emps = new ArrayList<Employee>();

		emps.add(new Employee(1, "Amrit", 25l));
		emps.add(new Employee(1, "Amrit", 26l));
		emps.add(new Employee(1, "Jatin", 20l));
		emps.add(new Employee(1, "Amrit", 20l));
		emps.add(new Employee(1, "Ujjawal", 21l));
		emps.add(new Employee(1, "Jatin", 29l));

		Set<String> set = new HashSet<>();
		Set<String> ans = emps.stream()
				.filter(emp->!set.add(emp.getName())).map(emp->emp.getName()).collect(Collectors.toSet());
		System.out.println(ans);
	}
}

class Employee {

	long id;
	String name;
	long age;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}

	public Employee(long id, String name, long age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}