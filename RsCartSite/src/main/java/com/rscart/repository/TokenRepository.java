package com.rscart.repository;

import com.rscart.model.Customer;
import com.rscart.util.EmailResetToken;
import com.rscart.util.VerificationToken;

public interface TokenRepository {

	public Customer findByEmail(String email);

	public void saveVCToken(VerificationToken verificationToken);

	public void deleteVerToken(VerificationToken verificationToken);

	public int updatePwdWithID(Long customerid, String password);

	public VerificationToken findByVerToken(String token);

	public boolean updatecustomerActive(Long Id);

	public EmailResetToken findByEmailToken(String token);

	public void deleteEmailToken(EmailResetToken emailToken);

	public void saveEmailToken(EmailResetToken resettoken);

	public int updateNewEmail(String email, Long customerid);
	

}
