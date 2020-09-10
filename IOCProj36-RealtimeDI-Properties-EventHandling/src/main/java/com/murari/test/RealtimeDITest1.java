package com.murari.test;

import java.io.Closeable;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.murari.controller.MainController;
import com.murari.vo.CustomerVO;

public class RealtimeDITest1 {

	public static void main(String[] args) {
		Scanner sc = null;
		String name = null, cadd = null, pamt = null, rate = null, time = null;
		CustomerVO vo = null;
		ApplicationContext ctx=null;
		MainController controller = null;
		String result = null;
		 Environment  env=null;
		// read inputs
		sc = new Scanner(System.in);
		System.out.println("enter Customername :: ");
		name = sc.next();
		System.out.println("Enter customer Addrs::");
		cadd = sc.next();
		System.out.println("Enter Principle  amount::");
		pamt = sc.next();
		System.out.println("Enter rate of intrest::");
		rate = sc.next();
		System.out.println("Enter time   ::");
		time = sc.next();
		// Store inputs in VO class object
		vo = new CustomerVO();
		vo.setCname(name);
		vo.setCadd(cadd);
		vo.setpAmt(pamt);
		vo.setRate(rate);
		vo.setTime(time);
		// create ApplicationContext IOC container
		ctx=new ClassPathXmlApplicationContext("com/murari/cfgs/applicationContext.xml");
		
		// get Controller Bean class object..
		controller = ctx.getBean("controller", MainController.class);
		// invoke the method
		try {
			result = controller.processCustomer(vo);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal Problem");
			e.printStackTrace();
		}
		
	
		((AbstractApplicationContext) ctx).close();
	}// main
}// class
