package com.huijiasoft.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUploads<M extends BaseUploads<M>> extends Model<M> implements IBean {

	public void setUploadId(java.lang.Integer uploadId) {
		set("upload_id", uploadId);
	}

	public java.lang.Integer getUploadId() {
		return get("upload_id");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}

	public java.lang.String getType() {
		return get("type");
	}

	public void setAdd(java.lang.String add) {
		set("add", add);
	}

	public java.lang.String getAdd() {
		return get("add");
	}

}
