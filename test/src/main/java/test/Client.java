package test;

import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		// Spring 컨테이너를 동작시킬수있도록 코드작성
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		TestBean tb=(TestBean)factory.getBean("tb");
		Set<String> datas=tb.getDatas();
		for(String v:datas) {
			System.out.println(v);
		}
		factory.close();
		
		// Spring 컨테이너야, 나 폰 객체를 가지고싶어!
		// == Lookup == 객체요청: 컨테이너야, 가지고있는 객체중에서 이름이 "phone"인 객체를 줘!
		/*
		Phone phone=(Phone)factory.getBean("gp");
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		factory.close();
		*/
		
		/*
		BeanFactory bf=new BeanFactory();
		Phone phone=(Phone)bf.getBean(args[0]);
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		*/
	}
}
