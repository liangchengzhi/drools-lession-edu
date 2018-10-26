package com.xjc.drools.lession.model;
/**
 * 车
 * @author liangcz
 * @Date   2018年10月26日 下午2:01:46
 * @version 1.0
 */
public class Car {
	/**
	 * 折扣
	 */
	private int discount = 100;
	/**
	 * 归属人
	 */
	private Person person;
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
