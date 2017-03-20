package com.simon.Metting;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Java反射机制的学习
 * @author Wang
 *
 */
public class Reflect {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//验证无参对象的反射
		Demo1();
		
		//验证有参构造函数的反射
		Demo2();
	}
	
	
	/**
	 * Demo1:通过Java反射机制创建对象，无参构造
	 */
	public static void Demo1() throws  ClassNotFoundException, InstantiationException, IllegalAccessException  {
		Class class1 = null;
		class1 = Class.forName("com.simon.Metting.Person");
		//反射得到对象
		Person person = (Person)class1.newInstance();
		person.setId("Simon");
		System.out.println(person.getId());
	}
	
	/**
	 * Demo2:通过反射机制创建带参构造对象
	 */
	public static void Demo2() throws ClassNotFoundException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException{
		Class<?> class2 = null;
		class2 = Class.forName("com.simon.Metting.Person");
		
		//构造函数的集合
		Constructor<?>[] constructor = class2.getConstructors();

		//constructor代表构造函数的数组
		//其中【1】就是代表第二个构造函数
		Person person = (Person)constructor[1].newInstance("Simon","001");
		System.out.println(person.toString());
		
	}
}







//反射的内部内
class Person{
	//无参构造函数
	public Person(){
		
	}
	//有参构造函数
	public Person(String name,String id){
		this.name = name;
		this.id = id;
	}
	
	//对象属性
	public String name;
	public String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}
}
