package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ImmutableClass {

	// MV as private and final
	private String name;

	private List<String> department;

	public String getName() {
		return name;
	}
	
	public List<String> getDepartment() {
		
		// Deep copy
		List<String> tempDepartment = new ArrayList<String>();

		for (int i = 0; i < department.size(); ++i) {
			tempDepartment.add(department.get(i));
		}

		return tempDepartment;

	}

	public ImmutableClass() {}

	public ImmutableClass(String name, List<String> department) {
		super();
		this.name = name;

		this.department = new ArrayList<String>();

		// deep copy
		//System.out.println(department.size() + ", items: " + department);
		for (int i = 0; i < department.size(); ++i) {


			this.department.add(department.get(i));
		}

	}

	@Override
	public String toString() {
		return "Test1 [name=" + name + ", department=" + department + "]";
	}

	public static void main(String[] args) {

		
		try {
			ImmutableClass test1 = new ImmutableClass("abc", new ArrayList<>(Arrays.asList("1", "2", "3")));

			System.out.println(test1);

			test1.getDepartment().add("4");

			System.out.println(test1);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		
		
		List<String> txnList = new ArrayList<>();
		txnList.stream().filter(line -> line.startsWith("#TXN")).collect(Collectors.toList());

	}

}
