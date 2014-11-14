package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.TransactionOrderOrm;
import com.shopping.to.TransactionOrderTo;

public interface TransactionOrderDao {
	public TransactionOrderTo insert(TransactionOrderTo transactionOrderTo, int userId);
	public TransactionOrderTo update(int id, TransactionOrderTo transactionOrderTo, int userId);
	public TransactionOrderTo searchById(int id);
	public TransactionOrderTo searchByTxnOrderId(String txnOrderID);
	public Collection<TransactionOrderTo> getAll();
	public TransactionOrderOrm getTransactionOrderById(int id);
	
	public boolean delete(int id);
}
