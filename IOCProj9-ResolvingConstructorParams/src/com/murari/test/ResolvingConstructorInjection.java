package com.murari.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.murari.beans.Marks;

public class ResolvingConstructorInjection {

	public static void main(String[] args) {
	
		BeanFactory factory=null;
		Marks mk =null;
		//create BeanFactory container
		factory=new XmlBeanFactory(new ClassPathResource("com/murari/cfgs/applicationContext.xml"));
		
		//get Bean obj
		mk=factory.getBean("mk", Marks.class);	
		System.out.println(mk);
		
	}
}
