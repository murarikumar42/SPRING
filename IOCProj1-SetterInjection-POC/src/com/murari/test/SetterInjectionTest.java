package com.murari.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.murari.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {

		System.out.println("SetterInjectionTest.main()");
		
		Resource res=null;
		BeanFactory factory=null;
		Object obj=null;
		WishMessageGenerator generator=null;
		String result=null;
		
		//hold name and location of spring bean cfg file
		res=new FileSystemResource("src/com/murari/cfgs/applicationContext.xml");
		
		//create beanFactory IOC container
		factory=new XmlBeanFactory(res);
		
		//get target bean class obj
		obj=factory.getBean("wmg");
		
		//typeCasting
		generator=(WishMessageGenerator)obj;
		
		//invoke the method
		result=generator.generateWishMessage("murari");
		
		System.out.println("Message::"+result);
		
		

	}

}
