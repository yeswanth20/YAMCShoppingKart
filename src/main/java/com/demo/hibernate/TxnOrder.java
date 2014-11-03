package com.demo.hibernate;

import com.shopping.daoimpl.TransactionOrderDaoimpl;
import com.shopping.to.TransactionOrderAddressTo;
import com.shopping.to.TransactionOrderTo;

public class TxnOrder {
	
	public static void main(String[] args) {
		
	
		
		TransactionOrderTo transactionOrderTo = new TransactionOrderTo();
//		transactionOrderTo.setTxnOrderID("Aliiiiiiiiii");
		transactionOrderTo.setPriceAfterDiscount(12.35);
		
//		TransactionOrderAddressTo transactionOrderAddressTo = new TransactionOrderAddressTo();
//		transactionOrderAddressTo.setName("name");
//		transactionOrderTo.setAddress(transactionOrderAddressTo);
		
		TransactionOrderDaoimpl daoimpl = new TransactionOrderDaoimpl();
		daoimpl.insert(transactionOrderTo,12);
	
	}

}


