package com.bms.mdm.documents;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bms.mdm.documents.DocumentActionForm;
import com.bms.mdm.documents.DocumentDBAdapter;


/**
 * DocumentDBHelper manages the DocumentDBAdapter Responsible for 
 * all business operations on the Document table.
 * @author Jemis Dhameliya
 *
 */

public class DocumentDBHelper {
	
	private static final String TAG= "com.scm.documents.DocumentDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	
	private DocumentDBAdapter documentDBAdapter;
	public DocumentDBHelper() {
		documentDBAdapter=new DocumentDBAdapter();
	}
	
	
	public ArrayList<DocumentActionForm> fetchAllRecords(){
		documentDBAdapter.open();
		ResultSet cursor=documentDBAdapter.getAll();
		ArrayList<DocumentActionForm> documentBeanList = new ArrayList<DocumentActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					documentBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		documentDBAdapter.close();
		return documentBeanList; 
	}
	
	
	
	public DocumentActionForm getByDocumentId(int documentId){
		documentDBAdapter.open();
		ResultSet cursor=documentDBAdapter.getBydocumentId(documentId);
		DocumentActionForm documentBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					documentBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		documentDBAdapter.close();
		return documentBean;
	}
	
	
	
	public int addDocument(DocumentActionForm documentBean)
	{   
		documentDBAdapter.open();
		int status = documentDBAdapter.insertDocument(documentBean);
		documentDBAdapter.close();
		
		return status;
	}
	
	
	public boolean deleteByDocumentId(int documentId)
	{
         documentDBAdapter.open();
		 boolean status = documentDBAdapter.deactiavteDocument(documentId);
		documentDBAdapter.close();
		return status;
	}
	
	
	
	
	public int updateDocument(DocumentActionForm documentBean){
		documentDBAdapter.open();
		int result = documentDBAdapter.update(documentBean);
		documentDBAdapter.close();
		return result;
	}
	
	
	private DocumentActionForm fetchDataFromResultSet(ResultSet cursor){ 
		DocumentActionForm documentBean=new DocumentActionForm();
		try
		{
			documentBean.setDocumentId(cursor.getInt(DocumentDBAdapter.COLUMN_DOCUMENTS_ID));
			documentBean.setDocumentFileName(cursor.getString(DocumentDBAdapter.COLUMN_DOCUMENTS_FILE_NAME));
			documentBean.setDocumentFileExt(cursor.getString(DocumentDBAdapter.COLUMN_DOCUMENTS_FILE_EXT));
			documentBean.setDocumentFilePath(cursor.getString(DocumentDBAdapter.COLUMN_DOCUMENTS_FILE_PATH));
			documentBean.setDocumentFileSize(cursor.getFloat(DocumentDBAdapter.COLUMN_DOCUMENTS_FILE_SIZE));
			documentBean.setCreatedBy(cursor.getString(DocumentDBAdapter.COLUMN_DOCUMENTS_CRETED_BY));
			documentBean.setCreatedDate(cursor.getString(DocumentDBAdapter.COLUMN_DOCUMENTS_CRETED_DTTM));
			documentBean.setModifiedBy(cursor.getString(DocumentDBAdapter.COLUMN_DOCUMENTS_MODIFIED_BY));
			documentBean.setModifiedDate(cursor.getString(DocumentDBAdapter.COLUMN_DOCUMENTS_MODIFIED_DATE));
			
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return documentBean;
	}
	

}
