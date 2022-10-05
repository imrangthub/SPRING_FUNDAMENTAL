package com.imranmadbar.shared;

import com.imranmadbar.core.CoreCommonFunction;

public interface SharedTestClas extends CoreCommonFunction{
	
	
	default String getSharedMsg() {
		return "This Message from Shared Module";
	}
	
	
	default String getBothMsg() {
		return getSimpleMsg()+"With from Shared module";
	}

}
