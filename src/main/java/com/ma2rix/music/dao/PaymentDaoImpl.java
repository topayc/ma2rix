package com.ma2rix.music.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.PaymentDao;
import com.ma2rix.music.dao.mapper.PaymentMapper;
import com.ma2rix.music.model.domain.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {
	
	@Autowired PaymentMapper paymentMapper;
	
	@Override
	public int getPaymentCount() {
		return paymentMapper.getPaymentCount();
	}

	@Override
	public Payment getPaymentByPayNo(int payNo) {
		return paymentMapper.getPaymentByPayNo(payNo);
	}

	@Override
	public void insertPayment(Payment payment) {
		paymentMapper.insertPayment(payment);
	}

	@Override
	public void updatePayment(Payment payment) {
		paymentMapper.updatePayment(payment);
	}

	@Override
	public void deletePayment(int payNo) {
		paymentMapper.deletePayment(payNo);
	}
}
