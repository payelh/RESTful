package com.pocopay.springmvc.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pocopay.springmvc.dbutil.MyBatisUtil;
import com.pocopay.springmvc.model.Payment;

public class PaymentMapperImpl implements PaymentMapper {

	@Override
	public Payment getPaymentById(Long id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			PaymentMapper paymentMapper = sqlSession
					.getMapper(PaymentMapper.class);
			return paymentMapper.getPaymentById(id);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void createPayment(Payment payment) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			PaymentMapper paymentMapper = sqlSession.getMapper(PaymentMapper.class);
			paymentMapper.createPayment(payment);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}		
	}

	@Override
	public List<Payment> getAllPayemtnsBySourceAccountID(Long srcAccountID) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  PaymentMapper paymentMapper = sqlSession.getMapper(PaymentMapper.class);
		  return paymentMapper.getAllPayemtnsBySourceAccountID(srcAccountID);
		  }finally{
		   sqlSession.close();
		  }
	}

}
