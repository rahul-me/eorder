package com.bms.transaction;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;





/**
 * TransactionDBAdapter manages the TransactionEntry table in the database. Responsible for 
 * all CRUD operations on the TransactionEntry table.
 * @author Mehul Markana
 *
 */

public class TransactionDBHelper{
	
	private static final String TAG= "com.scm.transaction.TransactionDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	
	private TransactionDBAdapter transactionDBAdapter;
	public TransactionDBHelper() {
		transactionDBAdapter=new TransactionDBAdapter();
	}
	
	public ArrayList<TransactionActionForm> fetchAllRecords(){
		transactionDBAdapter.open();
		ResultSet cursor=transactionDBAdapter.getAll();
		ArrayList<TransactionActionForm> transactionActionFormsList = new ArrayList<TransactionActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					transactionActionFormsList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		transactionDBAdapter.close();
		return transactionActionFormsList; 
	}
	
	public TransactionActionForm getTransactionEntryById(int transactionEntryId){
		transactionDBAdapter.open();
		ResultSet cursor=transactionDBAdapter.getByTransactionId(transactionEntryId);
		TransactionActionForm transactionActionForm = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					transactionActionForm = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		transactionDBAdapter.close();
		return transactionActionForm;
	}
	
	
	
	public int addTransactionTable(TransactionActionForm transactionActionForm)
	{   
		transactionDBAdapter.open();
		int status = transactionDBAdapter.insertTransactionTable(transactionActionForm);
		transactionDBAdapter.close();
		
		return status;
	}
	
	
	public boolean deleteTransactionTableById(int transactionTableId)
	{
		transactionDBAdapter.open();
		boolean status = transactionDBAdapter.deactiavteTransactionEntry(transactionTableId);
		transactionDBAdapter.close();
		return status;
	}
	
	
	
	
	public int updateAccountEntry(TransactionActionForm transactionActionForm){
		transactionDBAdapter.open();
		int result = transactionDBAdapter.update(transactionActionForm);
		transactionDBAdapter.close();
		return result;
	}
	
	
	
	
	private TransactionActionForm fetchDataFromResultSet(ResultSet cursor){ 
		
		TransactionActionForm transactionActionForm=new TransactionActionForm();
		try
		{
			transactionActionForm.setTransactionId(cursor.getInt(TransactionDBAdapter.COLUMN_TRANSACTION_ID));
			transactionActionForm.setTransactionFlow(cursor.getString(TransactionDBAdapter.COLUMN_TRANSACTION_FLOW));
			transactionActionForm.setTransactionDate(cursor.getString(TransactionDBAdapter.COLUMN_TRANSACTION_DATE));
			transactionActionForm.setTransactionAmount(cursor.getFloat(TransactionDBAdapter.COLUMN_TRANSACTION_AMOUNT));
			transactionActionForm.setCreatedBy(cursor.getString(TransactionDBAdapter.COLUMN_TRANSACTION_CREATED_BY));
			transactionActionForm.setCreatedDate(cursor.getString(TransactionDBAdapter.COLUMN_TRANSACTION_CREATED_DATE));
			transactionActionForm.setModifiedBy(cursor.getString(TransactionDBAdapter.COLUMN_TRANSACTION_MODIFIED_BY));
			transactionActionForm.setModifiedDate(cursor.getString(TransactionDBAdapter.COLUMN_TRANSACTION_MODIFIED_DATE));
			transactionActionForm.setVoucherNumber(cursor.getInt(TransactionDBAdapter.COLUMN_TRANSACTION_VOUCHER_NO));
			transactionActionForm.setVoucherDate(cursor.getString(TransactionDBAdapter.COLUMN_TRANSACTION_VOUCHER_DATE));
		
			
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return transactionActionForm;
	}
	

	
	
	

}
