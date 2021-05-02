package com.ma2rix.music.service.interfaces;

import com.ma2rix.music.model.domain.Payment;

public interface PaymentService {
	public int getPaymentCount();
	public Payment getPaymentByPayNo(int payNo);
	public void insertPayment(Payment payment);
	public void updatePayment(Payment payment);
	public void deletePayment(int payNo);
}
