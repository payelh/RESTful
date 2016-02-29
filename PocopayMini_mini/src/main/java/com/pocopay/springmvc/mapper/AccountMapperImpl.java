package com.pocopay.springmvc.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pocopay.springmvc.dbutil.MyBatisUtil;
import com.pocopay.springmvc.model.Account;

public class AccountMapperImpl implements AccountMapper {

	@Override
	public void createAccount(Account account) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
			accountMapper.createAccount(account);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	@Override
	public Account getAccountByName(String name) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccountMapper accountMapper = sqlSession
					.getMapper(AccountMapper.class);
			return accountMapper.getAccountByName(name);
		} finally {
			sqlSession.close();
		}
	}
	
	
	@Override
	public void updateAccountBalance(Account account) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
			accountMapper.updateAccountBalance(account);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void deleteAccount(Integer userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
		  accountMapper.deleteAccount(userId);
		  sqlSession.commit();
		  }finally{
		   sqlSession.close();
		  }
	}

	@Override
	public List<Account> getAllAccounts() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
		  return accountMapper.getAllAccounts();
		  }finally{
		   sqlSession.close();
		  }
	}
	@Override
	public Account getAccountByID(Long id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccountMapper accountMapper = sqlSession
					.getMapper(AccountMapper.class);
			return accountMapper.getAccountByID(id);
		} finally {
			sqlSession.close();
		}
	}
	

}
