package com.pizza.domain;

import java.util.Arrays;
import java.util.List;

public enum PaymentType {
	支付宝,
	微信,
	借记卡;
	public static List<PaymentType> asList(){
		PaymentType[] all = PaymentType.values();
		return Arrays.asList(all);
	}
}
