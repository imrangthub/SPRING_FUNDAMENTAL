package com.imran.appshared;

import com.imran.appcore.CoreCommonFunction;

public interface SharedFunctions extends CoreCommonFunction{
	
	default String getSimpleSharedMsg() {
		return "This Message from app Shared Module | "+getSimpleMsg();
	}

}
