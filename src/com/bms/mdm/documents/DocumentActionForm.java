package com.bms.mdm.documents;

import com.bms.struts.SCMActionForm;

public class DocumentActionForm extends SCMActionForm{

	private int documentId;
	private String documentFileName;
	private String documentFileExt;
	private String documentFilePath;
	private float documentFileSize;
	private String createdBy;
	private String createdDate;
	private String modifiedBy;
	private String modifiedDate;
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public String getDocumentFileName() {
		return documentFileName;
	}
	public void setDocumentFileName(String documentFileName) {
		this.documentFileName = documentFileName;
	}
	public String getDocumentFileExt() {
		return documentFileExt;
	}
	public void setDocumentFileExt(String documentFileExt) {
		this.documentFileExt = documentFileExt;
	}
	public String getDocumentFilePath() {
		return documentFilePath;
	}
	public void setDocumentFilePath(String documentFilePath) {
		this.documentFilePath = documentFilePath;
	}
	public float getDocumentFileSize() {
		return documentFileSize;
	}
	public void setDocumentFileSize(float documentFileSize) {
		this.documentFileSize = documentFileSize;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
}
