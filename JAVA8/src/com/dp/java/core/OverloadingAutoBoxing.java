package com.dp.java.core;

/**
 * 
 * @author dhiraj
 *According to (JLS 15.2.2), there are 3 phases used in overload resolution:
 *First phase performs overload resolution without permitting boxing or unboxing conversion,
 *Second phase performs overload resolution while allowing boxing and unboxing and
 *Third phase allows overloading to be combined with variable arity methods, boxing, and unboxing.
 *If no applicable method is found during these phases, then ambiguity occurs.
 */
public class OverloadingAutoBoxing {

	public void method(byte i){ 
        System.out.println("Primitive type int formal argument byte:" + i); 
    }
	public void method(short i){ 
        System.out.println("Primitive type int formal argument short:" + i); 
    }
    /*public void method(int i){ 
        System.out.println("Primitive type int formal argument int:" + i); 
    } */
      
    public void method(Integer i){ 
          
        System.out.println("Reference type Integer formal argument Integer:" + i); 
    } 
      
     
    public void method(long i){ 
          
        System.out.println("Primitive type long formal argument long:" + i); 
    } 
    public void method(double i){ 
        
        System.out.println("Primitive type long formal argument double:" + i); 
    } 
    public void method(float i){ 
        
        System.out.println("Primitive type long formal argument double:" + i); 
    } 
}
