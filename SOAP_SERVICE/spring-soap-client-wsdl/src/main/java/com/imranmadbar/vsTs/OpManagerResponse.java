package com.imranmadbar.vsTs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "opManagerResponse", propOrder = { "_return" })
public class OpManagerResponse {
	@XmlElement(name = "return")
	protected String _return;

	public OpManagerResponse() {
	}

	public String getReturn() {
		return this._return;
	}

	public void setReturn(String value) {
		this._return = value;
	}

	@Override
	public String toString() {
		return "OpManagerResponse [_return=" + _return + "]";
	}

}
