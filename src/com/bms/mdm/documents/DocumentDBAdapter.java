package com.bms.mdm.documents;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;
import com.bms.mdm.documents.DocumentActionForm;


/**
 * DocumentDBAdapter manages the Document table in the database. Responsible for 
 * all CRUD operations on the Document table.
 * @author Jemis Dhameliya
 *
 */


public class DocumentDBAdapter extends RestoserverDBAdapter{
	
	private final String TAG = "com.scm.documents.DocumentDBAdapter";
	
	private final Logger log = Logger.getLogger(TAG);
	
	public static final String DOCUMENTS_TABLE_NAME="mdm_documents";
	
	public static final String COLUMN_DOCUMENTS_ID="documentId";
	public static final String COLUMN_DOCUMENTS_FILE_NAME="fileName";
	public static final String COLUMN_DOCUMENTS_FILE_EXT="fileExt";
	public static final String COLUMN_DOCUMENTS_FILE_PATH="filePath";
	public static final String COLUMN_DOCUMENTS_FILE_SIZE="fileSize";
	public static final String COLUMN_DOCUMENTS_CRETED_BY="createdBy";
	public static final String COLUMN_DOCUMENTS_CRETED_DTTM="createdDate";
	public static final String COLUMN_DOCUMENTS_MODIFIED_BY="modifiedBy";
	public static final String COLUMN_DOCUMENTS_MODIFIED_DATE="modifiedDate";
	
	 public DocumentDBAdapter() {
		 super();
	}

	 
	 /**
		 * Insert Document will insert data in to Document table 
         *
		 * @param documetBean 
		 * @return cVAlue object if succes 
		 */
    
		public int insertDocument(DocumentActionForm documetBean)
	     	
		{
			
			ContentValues cValues = new ContentValues();
			cValues.put(COLUMN_DOCUMENTS_ID, documetBean.getDocumentId());
			cValues.put(COLUMN_DOCUMENTS_FILE_NAME, documetBean.getDocumentFileName());
			cValues.put(COLUMN_DOCUMENTS_FILE_EXT, documetBean.getDocumentFileExt());
			cValues.put(COLUMN_DOCUMENTS_FILE_PATH, documetBean.getDocumentFilePath());
			cValues.put(COLUMN_DOCUMENTS_FILE_SIZE, documetBean.getDocumentFileSize());
			cValues.put(COLUMN_DOCUMENTS_CRETED_BY, documetBean.getCreatedBy());
			cValues.put(COLUMN_DOCUMENTS_CRETED_DTTM, documetBean.getCreatedDate());
			cValues.put(COLUMN_DOCUMENTS_MODIFIED_BY, documetBean.getModifiedBy());
			cValues.put(COLUMN_DOCUMENTS_MODIFIED_DATE, documetBean.getModifiedDate());
			
			
			return (int)insert(DOCUMENTS_TABLE_NAME, null, cValues);
			
		}
	 
		/**
		 * get All Method will return all record of Document table
		 * 
		 * 
		 */
		
		public ResultSet getAll()
		{
			return query(DOCUMENTS_TABLE_NAME, new String[] {COLUMN_DOCUMENTS_ID, COLUMN_DOCUMENTS_FILE_NAME, COLUMN_DOCUMENTS_FILE_EXT, COLUMN_DOCUMENTS_FILE_PATH, COLUMN_DOCUMENTS_FILE_SIZE,COLUMN_DOCUMENTS_CRETED_BY, COLUMN_DOCUMENTS_CRETED_DTTM, COLUMN_DOCUMENTS_MODIFIED_BY, COLUMN_DOCUMENTS_MODIFIED_DATE}, null, null, null, null, null);		
		}
		
		
		/**
		 * getByDocumentId  will return single record of Document table
		 * 
		 * @param documentId
		 * @return resultset
		 * 
		 */
		
		public ResultSet getBydocumentId(int documentId)
		{
			return query(DOCUMENTS_TABLE_NAME, new String[] {COLUMN_DOCUMENTS_ID, COLUMN_DOCUMENTS_FILE_NAME, COLUMN_DOCUMENTS_FILE_EXT, COLUMN_DOCUMENTS_FILE_PATH, COLUMN_DOCUMENTS_FILE_SIZE,COLUMN_DOCUMENTS_CRETED_BY, COLUMN_DOCUMENTS_CRETED_DTTM, COLUMN_DOCUMENTS_MODIFIED_BY, COLUMN_DOCUMENTS_MODIFIED_DATE}, COLUMN_DOCUMENTS_ID+ "=" + documentId, null, null, null, null);
		}
		
	
		/**
		 * DeactivateDocument  will unset particular of Document table
		 * 
		 * @param documentId
		 * @return true/false
		 * 
		 */
			
	
		public boolean deactiavteDocument(long documentId) {

			return delete(DOCUMENTS_TABLE_NAME, COLUMN_DOCUMENTS_ID+ "=" + documentId, null) > 0;
		}

		
		/**
		 * Update will update Document of Document table
		 * 
		 * @param documetBean
		 * @return resultset
		 * 
		 */
			
		
		public int update(DocumentActionForm documetBean){

			int result = 0;
			ContentValues cv=new ContentValues();
			cv.put(COLUMN_DOCUMENTS_FILE_NAME, documetBean.getDocumentFileName());
			cv.put(COLUMN_DOCUMENTS_FILE_EXT, documetBean.getDocumentFileExt());
			cv.put(COLUMN_DOCUMENTS_FILE_PATH, documetBean.getDocumentFilePath());
			cv.put(COLUMN_DOCUMENTS_FILE_SIZE , documetBean.getDocumentFileSize());
			
			cv.put(COLUMN_DOCUMENTS_CRETED_BY, documetBean.getCreatedBy());
			cv.put(COLUMN_DOCUMENTS_CRETED_DTTM, documetBean.getCreatedDate());
			cv.put(COLUMN_DOCUMENTS_MODIFIED_BY , documetBean.getModifiedBy());
			cv.put(COLUMN_DOCUMENTS_MODIFIED_DATE , documetBean.getModifiedDate());
			
			result = update(DOCUMENTS_TABLE_NAME, cv, COLUMN_DOCUMENTS_ID + "='" + documetBean.getDocumentId() +"'", null);
			return result;
		}

}
