package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Link : https://javabypatel.blogspot.com/2018/06/java-8-stream-practice-problems.html
// https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---micro-katas

class TempStudent {
	public String name;
	public int age;
	public String address;
	public List<String> mobileNumbers;

	public TempStudent(String name, int age, String address, List<String> mobileNumbers) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNumbers = mobileNumbers;
	}

	@Override
	public String toString() {
		return "TempStudent [name=" + name + ", age=" + age + ", address=" + address + ", mobileNumbers="
				+ mobileNumbers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((mobileNumbers == null) ? 0 : mobileNumbers.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempStudent other = (TempStudent) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (mobileNumbers == null) {
			if (other.mobileNumbers != null)
				return false;
		} else if (!mobileNumbers.equals(other.mobileNumbers))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}


class Student{
	private String name;
	private int age;
	private String address;
	private List<String> phone;																							

	public Student(String name, int age, String address, List<String> phone) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public List<String> getPhone() {
		return phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setStrings(List<String> phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				", address=" + address +
				", phone=" + phone +
				'}';
	}
}

public class Java8Stream {

	public static void main(String[] args) {

		Student student1 = new Student(
				"Jayesh",
				20,
				new String("1234"),
				Arrays.asList(new String("1233"), new String("1234")));

		Student student2 = new Student(
				"Khyati",
				20,
				new String("1235"),
				Arrays.asList(new String("1111"), new String("3333"), new String("1233")));

		Student student3 = new Student(
				"Jason",
				20,
				new String("1236"),
				Arrays.asList(new String("3333"), new String("4444")));

		List<Student> students = Arrays.asList(student1, student2, student3);

		// Get student with exact match name "jayesh"
		Optional<Student> jayeshStud = students.stream()
				.filter(stud -> stud.getName().equals("Jayesh"))
				.findFirst();

		System.out.println(jayeshStud.isPresent() ? jayeshStud.get().getName() : "No student found");

		// Get student with matching address "1235"
		Optional<Student> addrStud = students.stream()
				.filter(stud -> stud.getAddress().equals("1235"))
				.findFirst();
		System.out.println(addrStud.isPresent() ? addrStud.get().getName() : "No student found");

		// Get all student having mobile numbers 3333.
		List<String> mobileStudents = students.stream()
				.filter(stud -> stud.getPhone().contains("3333"))
				.map(stud -> stud.getName())
				.collect(Collectors.toList());
		System.out.println(mobileStudents);

		// Get all student having mobile number 1233 and 1234
		List<String> studM2 = students.stream()
				.filter(stud -> stud.getPhone().containsAll(new ArrayList<String>(Arrays.asList("1233", "1234"))))
				.map(stud -> stud.getName())
				.collect(Collectors.toList());
		System.out.println(studM2);

		// Create a List<TempStudent> from List<Student>
		List<TempStudent> tempStudents = students.stream()
				.map(stud -> new TempStudent(stud.getName(), stud.getAge(), stud.getAddress(), stud.getPhone()))
				.collect(Collectors.toList());
		System.out.println(tempStudents);

		// Convert List<Student> to List<String> of student name
		List<String> names = students.stream()
				.map(stud -> stud.getName())
				.collect(Collectors.toList());
		System.out.println(names);

		// Convert List<students> to String
		String name = students.stream()
				.map(stud -> stud.getName())
				.collect(Collectors.joining(","));
		System.out.println(name);

		//Change the case of List<String>
		List<String> upperCaseNames = students.stream()
				.map(stud -> stud.getName().toUpperCase())
				.collect(Collectors.toList());
		System.out.println(upperCaseNames);

		// Sort List<String>
		List<String> sortedNames = names.stream()
				.sorted()
				.collect(Collectors.toList());
		System.out.println(sortedNames);

		// Conditionally apply Filter condition, (starts with "J")say if flag is enabled then.
		boolean sortConditionFlag = true;

		Stream<Student> conditionalFilterResult = students.stream()
				.filter(std -> std.getName().startsWith("J"));

		if (sortConditionFlag) {
			List<String> conditionalNames = conditionalFilterResult
					.sorted(Comparator.comparing(stud -> ((Student)stud).getName()))
					// (OR) .sorted(Comparator.comparing(Student::getName))
					.map(stud -> stud.getName())
					.collect(Collectors.toList());
			System.out.println(conditionalNames);
		}

		String input = "name=Megha&company=Azuga Telematics Pvt Ltd.&phone=9566&city=Blr";
		Map<String, String> ans = Arrays.stream(input.split("&"))
				.map(i -> i.split("=")).collect(Collectors.toMap(i->i[0], i->i[1]));

		System.out.println(ans);

		// starting again from a list of names, find total number of letters in all the names with more than 5 letters
		String[] ar = new String[] {"fdghhk", "fghvjkk", "cgk"};
		System.out.println(Arrays.stream(ar).filter(n -> n.length() > 5).mapToInt(str -> str.length()).sum());

		// similarly for student object
		System.out.println(students.stream()
				.filter(s -> s.getName().length() > 5)
				.mapToInt(str -> str.getName().length())
				.sum());
	}
}