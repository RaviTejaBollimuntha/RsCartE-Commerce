package com.rscart.util;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.rscart.validator.PasswordMatches;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter

@Setter

@ToString

@NoArgsConstructor

@PasswordMatches
public class PasswordResetDTO {

	@NotNull

	@NotEmpty
	private String oldPassword;

	@NotNull

	@NotEmpty
	private String newPassword;

	@NotNull

	@NotEmpty
	private String newPasswordConfirm;

}
