package com.ma2rix.music.dao.mapper;

import com.ma2rix.music.model.domain.Payment;

public interface PaymentMapper {
	public int getPaymentCount();
	public Payment getPaymentByPayNo(int payNo);
	public void insertPayment(Payment payment);
	public void updatePayment(Payment payment);
	public void deletePayment(int payNo);
}
