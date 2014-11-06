package com.demo.hibernate;

import com.shopping.daoimpl.TransactionStatusDaoimpl;
import com.shopping.to.TransactionStatusTo;

public class TxnStatus {
	
	public static void main(String[] args) {
		TransactionStatusTo txnStatusTo = new TransactionStatusTo();
		txnStatusTo.setStatusName("Status 2");
		TransactionStatusDaoimpl txnStatusDaoimpl = new TransactionStatusDaoimpl();
		txnStatusDaoimpl.insert(txnStatusTo,1);
		txnStatusDaoimpl.getAll();
		System.out.println("");
		
	}

}


