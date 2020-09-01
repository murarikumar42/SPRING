package com.murari.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.cglib.proxy.Factory;

import com.murari.controller.MainController;
import com.murari.vo.EmployeeVO;

public class RealTimeDITest {

	public static void main(String[] args) {

		Scanner sc=null;
		String ename=null;
		String edept=null;
		String eadd=null;
		String basicSal=null;
		EmployeeVO vo=null;
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		MainController controller=null;
		
		//read input from enduser using scanner
		sc=new Scanner(System.in);
		System.out.println("Enter Employee Name");
		ename=sc.next();
		System.out.println("Enter Employee deptno");
		edept=sc.next();
		System.out.println("Enter Employee Address");
		eadd=sc.next();
		System.out.println("Enter Employee basic salary");
		basicSal=sc.next();
		
		
		
		//store input into VO class object
		vo=new EmployeeVO();
		vo.setEname(ename);
		vo.setEdept(edept);
		vo.setEadd(eadd);
		vo.setBasicSal(basicSal);
		
		//create beanFactory container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/murari/cfgs/applicationContext.xml");
		
		
		//get controller class object
		 controller=factory.getBean("controller",MainController.class);
		
		//invoke methods
		try {
			String result=controller.processEmployee(vo);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal problem"+e.getMessage());
			e.printStackTrace();
		}
				
				
		
	}

}
