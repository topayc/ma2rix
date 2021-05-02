package com.ma2rix.music.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ma2rix.music.dao.interfaces.PaymentDao;
import com.ma2rix.music.model.domain.Payment;
import com.ma2rix.music.service.interfaces.PaymentService;

public class PaymentServiceImpl implements PaymentService {
	@Autowired PaymentDao paymentDao;
	
	@Override
	public int getPaymentCount() {
		return paymentDao.getPaymentCount();
	}

	@Override
	public Payment getPaymentByPayNo(int payNo) {
		return paymentDao.getPaymentByPayNo(payNo);
	}

	@Override
	public void insertPayment(Payment payment) {
		paymentDao.insertPayment(payment);
	}

	@Override
	public void updatePayment(Payment payment) {
		paymentDao.updatePayment(payment);
	}

	@Override
	public void deletePayment(int payNo) {
		paymentDao.deletePayment(payNo);
	}
}
