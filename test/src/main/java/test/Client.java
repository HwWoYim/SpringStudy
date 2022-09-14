package test;

import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		// Spring �����̳ʸ� ���۽�ų���ֵ��� �ڵ��ۼ�
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		TestBean tb=(TestBean)factory.getBean("tb");
		Set<String> datas=tb.getDatas();
		for(String v:datas) {
			System.out.println(v);
		}
		factory.close();
		
		// Spring �����̳ʾ�, �� �� ��ü�� ������;�!
		// == Lookup == ��ü��û: �����̳ʾ�, �������ִ� ��ü�߿��� �̸��� "phone"�� ��ü�� ��!
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
