package com.rscart.util;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.rscart.validator.CustomEmail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmailResetDTO {

	@CustomEmail
	@NotNull
	@NotEmpty
	private String newEmail;

	@CustomEmail
	@NotNull
	@NotEmpty
	private String newEmailConfirm;

	@NotNull
	@NotEmpty
	private String password;

}
