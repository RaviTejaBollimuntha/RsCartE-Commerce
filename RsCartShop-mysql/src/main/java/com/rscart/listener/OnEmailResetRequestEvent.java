
package com.rscart.listener;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import com.rscart.model.Customer;

@SuppressWarnings("serial")
@Getter
@Setter
public class OnEmailResetRequestEvent extends ApplicationEvent {

	private Customer customer;
	private String appUrl;
	private String newEmail;

	public OnEmailResetRequestEvent(Object obj, Customer customer,String appUrl, String newEmail) {
		super(obj);
		this.customer = customer;
		this.appUrl = appUrl;
		this.newEmail = newEmail;
	}
}
