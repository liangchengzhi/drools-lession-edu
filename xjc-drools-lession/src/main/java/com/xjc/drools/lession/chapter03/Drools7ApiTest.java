package com.xjc.drools.lession.chapter03;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.xjc.drools.lession.BaseTest;
import com.xjc.drools.lession.model.Car;
import com.xjc.drools.lession.model.Person;

/**
 * drools 5 api测试
 * 
 * @author liangcz
 * @Date 2018年10月26日 上午10:37:50
 * @version 1.0
 */
public class Drools7ApiTest extends BaseTest {
	@Test
	public void test() {
		KieSession kieSession = getKieSession("drools7-api");
		Person p1 = new Person();
		p1.setAge(70);
		Car car1 = new Car();
		car1.setPerson(p1);
		
		Person p2 = new Person();
		p2.setAge(20);
		Car car2 = new Car();
		car2.setPerson(p2);
		
		kieSession.insert(car1);
		kieSession.insert(car2);
		int count = kieSession.fireAllRules();
		System.out.println("Fire " + count + " rule(s)!");
		System.out.println("The car1 discount is " + car1.getDiscount() + "%");
		System.out.println("The car2 discount is " + car2.getDiscount() + "%");
		
		kieSession.dispose();
	}
}
