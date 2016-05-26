package com.dp.java.core;




/**
 * In java, a method can only be written in Subclass, not in same class.
 * The argument list should be exactly the same as that of the overridden method.
 * The return type should be the same or a subtype of the return type declared 
 * in the original overridden method in the super class
 * private final and static method can not be overriden
 * Static methods can't be overriden as it is part of a class rather than an object. But one can overload static method. 
 * 
 * @author dhiraj
 *
 */
public class MethodOverriding {

	/*
	 *simple overriding example  
	 */
	public static void testOverriding(){
		Company company=new Company();
		company.address();
		company=new Flipkart();
		company.address();
		/*
		 * testing overriding in the case of static this will call super class audit method even though its reffering 
		 * subclass object
		 */
		company.audit();
		
	}
	
	
}

class Company{
	
	int empstrength=0;
	
	 void address(){
		System.out.println("please give address detail");
	}
	 /*
	  * if you try to override a method in the same class it will give compile time error
	  *  "Duplicate method address() in type Company"
	  */
//	 void address(){
//		 
//	 }
	public Number getEmployeeNo(){
		return 0;
	}
	/*
	 * static method can not be overridden
	 */
	public static void audit(){
		System.out.println("super class audit method");
	}
}

class Flipkart extends Company{
	@Override
	void address() {
		System.out.println("flipkart address");
	}
	/*
	 * this method is not overriding the super class address method instead its overloading the address method of Flipkart class 
	 * you can not call this method with the super class reference 
	 */
	void address(String add){
		System.out.println(add);
	}
	/*
	 * this method is overriding the super class mehtod with differen reurn type i.e covarient return type sub class method can
	 * return the subclass 
	 * (non-Javadoc)
	 * @see com.dp.java.core.Company#getEmployeeNo()
	 */
	@Override
	public Integer getEmployeeNo() {
		Integer n=9; //auto unboxing 
		return  n;
	}
	/*
	 * this will give compile time error "This instance method cannot override the static method from Company" 
	 * as we can not override static method but if we add static key word then it will not give compile time error as JVM will
	 * treat it as method of sub class
	 */
//	 public void  audit(){
//		
//	}
	
	static public void audit(){
		System.out.println("sub class audit method");
	}
}