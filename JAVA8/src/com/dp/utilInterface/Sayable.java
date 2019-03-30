package com.dp.utilInterface;

public interface Sayable {
	void say(String s);  
    default void dontSay(){
    	System.out.println("<<<dont say any thing>> ");
    }
    default void sayLoud(){
    	System.out.println("<<<dont say any thing >>");
    }
}
