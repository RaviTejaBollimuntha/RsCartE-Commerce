package com.rscart.listener;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import com.rscart.model.Customer;

@SuppressWarnings("serial")
@Getter
@Setter
public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private Customer user;
	private String appUrl;

	public OnRegistrationCompleteEvent(Object obj,Customer user, String appUrl) {		
		super(obj);
		System.out.println("test "+appUrl);
		this.user = user;
		this.appUrl = appUrl;
	}

}
