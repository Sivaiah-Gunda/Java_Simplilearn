package com.simplilearn.firstspringdemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App 
{
    public static void main( String[] args )
    {
//       Resource resource= new ClassPathResource("beans.xml");
//       BeanFactory factory = new XmlBeanFactory(resource);
//    	 HelloWorld h =(HelloWorld) factory.getBean("obj");
    	ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
    	HelloWorld h =(HelloWorld) context.getBean("obj");
    	h.print();
    }
}
