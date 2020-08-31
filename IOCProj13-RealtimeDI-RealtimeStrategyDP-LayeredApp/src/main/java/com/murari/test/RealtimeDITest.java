package com.murari.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.stereotype.Controller;

import com.murari.controller.MainController;
import com.murari.vo.CustomerVO;

public class RealtimeDITest {

	public static void main(String[] args) {
		
		Scanner sc=null;
		String name,cadd,pamt,rate,time;
		CustomerVO vo=null;
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		MainController controller=null;
		String result=null;
		
		//read inputs
		sc=new Scanner(System.in);
		System.out.println("Enter Customer Name");
		name=sc.next();
		System.out.println("Enter Customer Address");
		cadd=sc.next();
		System.out.println("Enter Principle Amount");
		pamt=sc.next();
		System.out.println("Enter rate");
		rate=sc.next();
		System.out.println("Enter time ");
		time=sc.next();
		
		//store inputs in vo class object
		vo=new CustomerVO();
		vo.setCname(name);vo.setCadd(cadd);vo.setPamt(pamt);vo.setRate(rate);vo.setTime(time);
		
		//create beanFactory IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/murari/cfgs/applicationContext.xml");
		
		//get Controller bean class obj
		controller=factory.getBean("controller",MainController.class);
		
		//invoke the method
		try {
			result=controller.processCustomer(vo);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Internal problem");
		}
		
	}//main
}//class
