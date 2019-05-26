package com.rscart.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class VerificationToken {
	
	private Long customerid;	
	private String token;
	private Date expiryDate;
	
	public Date calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Timestamp(cal.getTime().getTime()));
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

}
