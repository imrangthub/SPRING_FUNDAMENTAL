package com.imranmadbar;


import org.springframework.stereotype.Service;

@Service
public class SimpleService {
	
	public String getEmpEnfo() {
		return "Hellow From IntegrationSvcApplication";
	}
	
	
	public String getEmpEnfo1() {
		
		 try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return "Hellow From IntegrationSvcApplication Thread.sleep(200)";
	}

	
	public String getEmpEnfo2() {
		
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return "Hellow From IntegrationSvcApplication Thread.sleep(2000)";
	}
	
	
	public String getEmpEnfo3() {
		
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return "Hellow From IntegrationSvcApplication Thread.sleep(3000)";
	}
	
	
	public String getEmpEnfo4() {
		
		 try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return "Hellow From IntegrationSvcApplication Thread.sleep(4000)";
	}
	
	
	public String getEmpEnfo5() {
		
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return "Hellow From IntegrationSvcApplication Thread.sleep(5000)";
	}
	
	public String getEmpEnfox(int sleepData) {
		
		int sleeptime = 100;
		
		if (sleepData>0) {
			sleeptime = sleepData;
		}
		
		 try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return "Hellow From IntegrationSvcApplication sleep: "+sleeptime;
	}


	
}
