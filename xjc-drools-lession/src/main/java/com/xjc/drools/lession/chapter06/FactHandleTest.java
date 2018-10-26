package com.xjc.drools.lession.chapter06;

import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.xjc.drools.lession.BaseTest;
import com.xjc.drools.lession.model.Person;

/**
 * 事实句柄
 * @author liangcz
 * @Date   2018年10月26日 下午6:33:14
 * @version 1.0
 */
public class FactHandleTest extends BaseTest{
	@Test
	public void test(){
		KieSession kieSession = this.getKieSession("fact-handle-group");
		Person person = new Person();
		person.setAge(81);
		FactHandle factHandle = kieSession.insert(person);
		System.out.println(factHandle.toExternalForm());
		int cn = kieSession.fireAllRules();
		System.out.println("fire rule : " + cn);
		
		kieSession.getAgenda().getAgendaGroup("fact-handle-group").setFocus();
		person.setAge(90);
		kieSession.update(factHandle, person);
		cn = kieSession.fireAllRules();
		System.out.println("fire rule : " + cn);
		kieSession.dispose();

	}
}
