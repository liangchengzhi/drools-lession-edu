package com.xjc.drools.lession.chapter01;

import org.junit.Test;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;

import com.xjc.drools.lession.BaseTest;

/**
 * drools jdk测试
 * @author  liangcz
 * @Date    2018年10月26日 上午10:16:43
 * @version 1.0
 */
public class JdkVersionTest extends BaseTest{
	/**
	 * jdk 版本测试
	 * @author liangcz
	 * @date   2018年10月26日 上午10:25:04
	 * @return void
	 */
	@Test
	public void testJdkVersion(){
		KieSession kieSession = getKieSession();
		int count = kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println("Fire " + count + " rules!");
	}
}
