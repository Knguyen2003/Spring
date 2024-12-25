package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Employee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       
       Employee e = context.getBean("e1", Employee.class);
       String kq = e.toString();
       System.out.println(kq);
	}

}
