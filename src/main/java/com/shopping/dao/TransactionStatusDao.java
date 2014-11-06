package com.shopping.dao;

import java.util.Collection;

import com.shopping.orm.TransactionStatusOrm;
import com.shopping.to.TransactionStatusTo;

public interface TransactionStatusDao {
	public TransactionStatusTo insert(TransactionStatusTo transactionStatusTo, int userId);
	public TransactionStatusTo update(int id, TransactionStatusTo transactionStatusTo, int userId);
	public TransactionStatusTo searchById(int id);
	public Collection<TransactionStatusTo> getAll();
	public TransactionStatusOrm getTransactionStatusById(int id);
	public boolean delete(int id);

}
