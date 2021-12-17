package com.bms.transaction;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;


/**
 * TransactionDBAdapter manages the Transaction table in the database. Responsible for 
 * all CRUD operations on the Transaction table.
 * @author Mehul Markana
 *
 */

public class TransactionDBAdapter extends RestoserverDBAdapter{

private final String TAG = "com.scm.transaction.TansactionDBAdapter";
	
	private final Logger log = Logger.getLogger(TAG);
	
	public static final String TRANSACTION_TABLE_NAME="transaction_transactiontable";
	
	public static final String COLUMN_TRANSACTION_ID="transactionId";
	public static final String COLUMN_TRANSACTION_DATE="transactionDate";
	public static final String COLUMN_TRANSACTION_FLOW="transactionFlow";
	public static final String COLUMN_TRANSACTION_AMOUNT="transactionAmount";
	public static final String COLUMN_TRANSACTION_CREATED_BY="createdBy";
	public static final String COLUMN_TRANSACTION_CREATED_DATE="createdDate";
	public static final String COLUMN_TRANSACTION_MODIFIED_BY="modifiedBy";
	public static final String COLUMN_TRANSACTION_MODIFIED_DATE="modifiedDate";
	public static final String COLUMN_TRANSACTION_VOUCHER_NO="voucherNo";
	public static final String COLUMN_TRANSACTION_VOUCHER_DATE="voucherDate";
	
	
	public TransactionDBAdapter()
	{
		super();
	}
	
	
	public int insertTransactionTable(TransactionActionForm transactionActionForm)
	{
		ContentValues cValues=new ContentValues();
		cValues.put(COLUMN_TRANSACTION_DATE, transactionActionForm.getTransactionDate());
		cValues.put(COLUMN_TRANSACTION_FLOW,transactionActionForm.getTransactionFlow());
		cValues.put(COLUMN_TRANSACTION_AMOUNT,transactionActionForm.getTransactionAmount());
		cValues.put(COLUMN_TRANSACTION_CREATED_BY,transactionActionForm.getCreatedBy());
		cValues.put(COLUMN_TRANSACTION_CREATED_DATE,transactionActionForm.getCreatedDate());
		cValues.put(COLUMN_TRANSACTION_MODIFIED_BY,transactionActionForm.getModifiedBy());
		cValues.put( COLUMN_TRANSACTION_MODIFIED_DATE,transactionActionForm.getModifiedDate());
		cValues.put(COLUMN_TRANSACTION_VOUCHER_NO,transactionActionForm.getVoucherNumber());
		cValues.put( COLUMN_TRANSACTION_VOUCHER_DATE,transactionActionForm.getVoucherDate());
		
		return (int)insert(TRANSACTION_TABLE_NAME, null, cValues); 
	}
	
	/**
	 * get All Method will return all record of Transaction table
	 * 
	 * 
	 */
	
	public ResultSet getAll()
	{
		return query(TRANSACTION_TABLE_NAME, null, null, null, null, null, null);
	}
	
	/**
	 * getByTransactionId  will return single record of Transaction table
	 * 
	 * @param transactionId
	 * @return resultset
	 * 
	 */
	
	public ResultSet getByTransactionId(int transactionId)
	{
		return query(TRANSACTION_TABLE_NAME, null, COLUMN_TRANSACTION_ID+ "=" + transactionId, null, null, null, null);
	}
	
	
	/**
	 * DeactivateTransactionEntry  will unset particular Transaction of TransactionEntry table
	 * 
	 * @param transactionId
	 * @return true/false
	 * 
	 */
		

	public boolean deactiavteTransactionEntry(long transactionId) {

		return delete(TRANSACTION_TABLE_NAME, COLUMN_TRANSACTION_ID+ "=" + transactionId, null) > 0;
	}
	
	
	/**
	 *update will update TransactionEntry of TransactionEntry table
	 * 
	 * @param TransactionEntryBean
	 * @return resultset
	 * 
	 */
		
	
	public int update(TransactionActionForm transactionActionForm ){

		int result = 0;
		ContentValues cValues=new ContentValues();
		
		cValues.put(COLUMN_TRANSACTION_ID, transactionActionForm.getTransactionId());
		cValues.put(COLUMN_TRANSACTION_DATE, transactionActionForm.getTransactionDate());
		cValues.put(COLUMN_TRANSACTION_FLOW,transactionActionForm.getTransactionFlow());
		cValues.put(COLUMN_TRANSACTION_AMOUNT,transactionActionForm.getTransactionAmount());
		cValues.put(COLUMN_TRANSACTION_CREATED_BY,transactionActionForm.getCreatedBy());
		cValues.put(COLUMN_TRANSACTION_CREATED_DATE,transactionActionForm.getCreatedDate());
		cValues.put(COLUMN_TRANSACTION_MODIFIED_BY,transactionActionForm.getModifiedBy());
		cValues.put( COLUMN_TRANSACTION_MODIFIED_DATE,transactionActionForm.getModifiedDate());
		cValues.put(COLUMN_TRANSACTION_VOUCHER_NO,transactionActionForm.getVoucherNumber());
		cValues.put( COLUMN_TRANSACTION_VOUCHER_DATE,transactionActionForm.getVoucherDate());
		
	
		result = update(TRANSACTION_TABLE_NAME, cValues, COLUMN_TRANSACTION_ID + "='" + transactionActionForm.getTransactionId() +"'", null);
		return result;
	}
	
	
	
}
