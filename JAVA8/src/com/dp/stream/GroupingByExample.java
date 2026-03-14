package com.dp.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingByExample {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(
				new Employee("Alice", "HR"),
				new Employee("Alice1", "HR"),
				new Employee("Alice3", "HR"),
				new Employee("Bob", "IT"), 
				new Employee("Charlie", "IT"), 
				new Employee("David", "Finance"));
		List<Salary> sal = Arrays.asList(
				new Salary("Alice", 123.00), 
				new Salary("Alice1", 1233.00),
				new Salary("Alice3", 1231.00),
				new Salary("Bob", 1231.00), 
				new Salary("Charlie", 1238.00), 
				new Salary("David", 1023.00));
		
		
		//find the second highest salary from hr
		
		Map<String,Salary> salMa = sal.stream().collect(Collectors.toMap(s->s.getName(),Function.identity()));
		Map<String, Optional<Salary>> salz= list.stream().collect(Collectors.
				groupingBy(e->e.getDepartment(),Collectors.mapping(e->salMa.get(e.getName()), 
			Collectors.maxBy(Comparator.comparingDouble(Salary::getSal)))));
		
		Map<String, Optional<Employee>> ss=	list.stream().filter(e->e.getDepartment().equals("IT"))
				.collect(Collectors.groupingBy(e->e.getDepartment(),
				Collectors.collectingAndThen(Collectors.toList(), el->el.stream()
						.sorted(Comparator.comparingDouble(emp->salMa.get(((Employee) emp).getName()).getSal()).reversed()).skip(1).findFirst())));
		//System.out.println(ss.get("HR").get().getName());
		/*
		 * 1
		 */
		List<Salary> lxl = list.stream()
				.flatMap(emp -> sal.stream()
						.filter(sal1 -> sal1.getName().equals(emp.getName()) && emp.getDepartment().equals("HR"))
						.map(s -> s))
				.collect(Collectors.toList());
		System.out.println(lxl);
		System.out.println("*********");
		Optional<Salary> sxl = list.stream()
		.flatMap(emp -> sal.stream()
				.filter(sal1 -> sal1.getName().equals(emp.getName()) && emp.getDepartment().equals("HR"))
				).sorted(Comparator.comparingDouble(Salary::getSal).reversed()).skip(1).findFirst();
		System.out.println(sxl.get().getSal()+"sxl");
		System.out.println("*********");
 
		/*
		 * 2get()
		 */
		Map<String, Optional<Employee>> result = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.maxBy(Comparator.comparingInt(emp -> emp.getName().length()))));
		System.out.println(result);

		Map<String, Salary> salaryMap = sal.stream().collect(Collectors.toMap(Salary::getName, s -> s));

		System.out.println("Salary Map:" + salaryMap);

		Map<String, Optional<Employee>> result1 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.maxBy(Comparator.comparing(i -> i.getName().compareTo(i.getName())))));
		System.out.println(result1);
		/*
		 * find maximum salary by Dept
		 */
		Map<String, Optional<Salary>> maxSalaryByDept = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.mapping(dept -> salaryMap.get(dept.getName()),
								Collectors.maxBy(Comparator.comparingDouble(Salary::getSal)))));
		

		System.out.println(maxSalaryByDept.get("HR").get().getName());

		Map<String, List<String>> mn = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.mapping(Employee::getName, Collectors.toList())));

		List<String> ll = list.stream().filter(emp -> emp.getDepartment().equalsIgnoreCase("HR"))
				.collect(Collectors.mapping(Employee::getName, Collectors.toList()));
		Map<String, Employee> mp = list.stream().collect(Collectors.toMap(Employee::getName, Function.identity()));

		System.out.println(ll);
		mp.entrySet().stream()
				.forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue().getDepartment()));
		Map<String, List<Employee>> m = list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(m);
		
		List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
		Map<String, Long> countMap = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(">>>" + countMap);
		
		List<Product> products = Arrays.asList(new Product("Electronics", 1000), new Product("Electronics", 1500),
				new Product("Clothing", 500), new Product("Clothing", 700));

		Map<String, Optional<Product>> md = products.stream().collect(Collectors.groupingBy(Product::getCategory,
				Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));

		System.out.println(md.get("Electronics").get().getPrice());
		List<Student> students = Arrays.asList(new Student(1, "Alice", "CS", 85.5), new Student(2, "Bob", "Math", 90.0),
				new Student(12, "Charlie", "CS", 78.2), new Student(3, "Charlie", "CS", 78.2),
				new Student(4, "David", "Math", 92.3), new Student(5, "Eva", "Physics", 88.8),
				new Student(6, "Frank", "CS", 92.0), new Student(7, "Grace", "Physics", 91.5), null // Simulating
																									// a
																									// null
																									// entry
		);
		List l = students.stream().filter(Objects::nonNull)
				.sorted(Comparator.comparingDouble(Student::getMarks).reversed()).skip(1).collect(Collectors.toList());
		System.out.println(l);
		List k = students.stream().filter(Objects::nonNull).filter(item -> item.getDepartment().equalsIgnoreCase("CS"))
				.sorted(Comparator.comparingDouble(Student::getMarks).reversed())
				.collect(Collectors.mapping(Student::getName, Collectors.toList()));

		System.out.println(k);
		Optional kc = students.stream().filter(Objects::nonNull)
				.filter(item -> item.getDepartment().equalsIgnoreCase("CS"))
				.sorted(Comparator.comparingDouble(Student::getMarks).reversed()).findFirst();
		System.out.println(kc.get());
		// 1️⃣ Map: ID -> Student (handling nulls & duplicates)
		Map<Integer, Student> idToStudent = students.stream().filter(Objects::nonNull)
				.collect(Collectors.toMap(Student::getId, s -> s, (existing, replacement) -> existing, // Keep
																										// first
																										// if
																										// duplicate
																										// ID
						LinkedHashMap::new));

		// 2️ Map: Department -> List of Students
		Map<String, List<Student>> deptToStudents = students.stream().filter(Objects::nonNull)
				.collect(Collectors.groupingBy(Student::getDepartment));

		// 3️ Map: Department -> List of Names
		Map<String, List<String>> deptToNames = students.stream().filter(Objects::nonNull).collect(Collectors
				.groupingBy(Student::getDepartment, Collectors.mapping(Student::getName, Collectors.toList())));

		// 4️ Map: Department -> Top Scorer
		Map<String, Optional<Student>> deptToTopScorer = students.stream().filter(Objects::nonNull).collect(Collectors
				.groupingBy(Student::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Student::getMarks))));

		// Output
		System.out.println("1️⃣ ID -> Student:");
		idToStudent.forEach((id, student) -> System.out.println(id + " => " + student));

		System.out.println("\n2️⃣ Department -> Students:");
		deptToStudents.forEach((dept, listx) -> System.out.println(dept + " => " + listx));

		System.out.println("\n3️⃣ Department -> Names:");
		deptToNames.forEach((dept, names) -> System.out.println(dept + " => " + names));

		System.out.println("\n4️⃣ Department -> Top Scorer:");
		deptToTopScorer.forEach((dept, studentOpt) -> System.out.println(dept + " => " + studentOpt.orElse(null)));
		
		List<String> words = Arrays.asList("Java", "Stream", "API", "Development");
        String sl = words.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println("max:"+sl);
        String input = "success";
        char mostFrequent = input.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .get();
        System.out.println(mostFrequent);
        input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
        .stream()
        .max(Comparator.comparingInt(e->e.getKey()))
        .map(e->e.getValue())
        .get();

	}

}

class Salary {
	private String name;
	private double sal;

	public Salary(String name, double sal) {
		super();
		this.name = name;
		this.sal = sal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

}

class Student {
	private int id;
	private String name;
	private String department;
	private double marks;

	public Student(int id, String name, String department, double marks) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.marks = marks;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public double getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return String.format("Student{id=%d, name='%s', dept='%s', marks=%.1f}", id, name, department, marks);
	}
}

class Product {
	String category;
	double price;

	Product(String category, double price) {
		this.category = category;
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

class Employee {
	String name;
	String department;

	Employee(String name, String department) {
		this.name = name;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}