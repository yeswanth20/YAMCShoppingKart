package com.demo.hibernate;

import com.shopping.daoimpl.TransactionOrderDaoimpl;
import com.shopping.orm.TransactionOrderProductListOrm;
import com.shopping.to.TransactionOrderAddressTo;
import com.shopping.to.TransactionOrderProductListTo;
import com.shopping.to.TransactionOrderTo;

public class TxnOrder {
	
	public static void main(String[] args) {
		
	
		
		TransactionOrderTo transactionOrderTo = new TransactionOrderTo();
		transactionOrderTo.setTxnOrderID("Aliiiiiiiiii");
//		transactionOrderTo.setPriceAfterDiscount(12.35);
		
		TransactionOrderAddressTo transactionOrderAddressTo = new TransactionOrderAddressTo();
		transactionOrderAddressTo.setName("name");
		transactionOrderTo.setAddress(transactionOrderAddressTo);
		
		TransactionOrderProductListTo productListTo = new TransactionOrderProductListTo();
		productListTo.setPrice(12.35);
		transactionOrderTo.getProductList().add(productListTo);
		
		
		TransactionOrderDaoimpl daoimpl = new TransactionOrderDaoimpl();
		daoimpl.insert(transactionOrderTo,12);
	
	}

}


