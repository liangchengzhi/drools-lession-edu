package com.xjc.drools.lession.chapter02;

import java.util.Collection;

import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import com.xjc.drools.lession.BaseTest;
import com.xjc.drools.lession.model.Goods;

/**
 * drools 5 api测试
 * 
 * @author liangcz
 * @Date 2018年10月26日 上午10:37:50
 * @version 1.0
 */
public class Drools5ApiTest extends BaseTest {
	@Test
	public void test() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource(
				"com/rules/goods.drl", this.getClass()), ResourceType.DRL);
		if (kbuilder.hasErrors()) {
			System.out.println(kbuilder.getErrors());
		}
		KnowledgeBase kbase = kbuilder.newKnowledgeBase();
		Collection<KnowledgePackage> pks = kbuilder.getKnowledgePackages();
		kbase.addKnowledgePackages(pks);
		StatefulKnowledgeSession statefulKnowledgeSession = kbase.newStatefulKnowledgeSession();

		Goods goods = new Goods();
		statefulKnowledgeSession.insert(goods);
		int count = statefulKnowledgeSession.fireAllRules();
		statefulKnowledgeSession.dispose();
		System.out.println("Fire " + count + " rule(s)!");
		System.out.println("The new discount is " + goods.getDiscount() + "%");
	}
}
