package com.imranmadbar.vsTs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "opManager", propOrder = { "version", "service", "method", "param", "numberofparam", "userid",
		"password", "failclause" })
public class OpManager {
	protected String version;
	protected String service;
	protected String method;
	protected List<String> param;
	protected int numberofparam;
	protected String userid;
	protected String password;
	protected String failclause;

	public OpManager() {
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String value) {
		this.version = value;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String value) {
		this.service = value;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String value) {
		this.method = value;
	}

	public List<String> getParam() {
		if (this.param == null) {
			this.param = new ArrayList();
		}

		return this.param;
	}

	public int getNumberofparam() {
		return this.numberofparam;
	}

	public void setNumberofparam(int value) {
		this.numberofparam = value;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String value) {
		this.userid = value;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String value) {
		this.password = value;
	}

	public String getFailclause() {
		return this.failclause;
	}

	public void setFailclause(String value) {
		this.failclause = value;
	}

	@Override
	public String toString() {
		return "OpManager [version=" + version + ", service=" + service + ", method=" + method + ", param=" + param
				+ ", numberofparam=" + numberofparam + ", userid=" + userid + ", password=" + password + ", failclause="
				+ failclause + "]";
	}

}
