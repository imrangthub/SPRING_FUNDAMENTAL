package com.imranmadbar;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imranmadbar.home.HomeController;

@RestController
public class MemconsumeController {
	
    
    List<Object> memoryLeakList = new ArrayList();
    byte[] memoryArray;
	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	// Show total uses memory in this service
	@GetMapping("/currentinfo")
	public String memtest() {
        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println();
        System.out.println("CurrentHeapSizeInMB: "+bytesToMegabytes(runtime.totalMemory())+",  AppsAllocatedHeapInMB: "+ bytesToMegabytes(memory));
		return "CurrentHeapSizeInMB: "+bytesToMegabytes(runtime.totalMemory())+",  AppsAllocatedHeapInMB: "+ bytesToMegabytes(memory);
	}
	

	
	// Show total uses memory in this service
	@GetMapping("/callgc")
	public String gc() {
		
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        long beforGcHeap = runtime.totalMemory();
        System.out.println();
        System.out.println("BeforeGCHeapSizeInMB: "+bytesToMegabytes(beforGcHeap)+", BeforeGCAppsSizeInMB: "+ bytesToMegabytes(memory));
        System.out.println();
        memoryLeakList = new ArrayList();
        runtime.gc();
        
        long memory2 = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("AfterGCHeapSizeInMB: "+bytesToMegabytes(runtime.totalMemory())+", AfterGCAppsSizeInMB: "+ bytesToMegabytes(memory2));
		return "BeforeGCHeapSizeInMB: "+bytesToMegabytes(beforGcHeap)+", AfterGCHeapSizeInMB: "+bytesToMegabytes(runtime.totalMemory())+", BeforeGCAppsSizeInMB: "+ bytesToMegabytes(memory)+", AfterGCAppsSizeInMB: "+ bytesToMegabytes(memory2);
	}
	
	
	
	
	@GetMapping(value = "/allocate100mb")
	public String getEmpEnfoxn(@RequestParam(value = "mb", required = false) Integer mb) {
        int memoryToAllocateMB = 100;
         if(mb !=null && mb>0){
        	 if(mb>1001) {
        		 return  "Requested memory too much, max permited: 1000 MB";
        	 }
        	 memoryToAllocateMB=mb;
         }
        long bytesToAllocate = memoryToAllocateMB * 1024L * 1024L;
        memoryArray = new byte[(int) bytesToAllocate];
        memoryLeakList.add(memoryArray);
	    Runtime runtime = Runtime.getRuntime();
        long appAllocationHeapSize = runtime.totalMemory() - runtime.freeMemory();
        System.out.println();
        System.out.println("CurrentHeapSizeInMB: "+bytesToMegabytes(runtime.totalMemory())+", AfterAllocated "+memoryToAllocateMB+"mb NowAppsHeapSizeInMB: "+ bytesToMegabytes(appAllocationHeapSize));
        
		return "CurrentHeapSizeInMB: "+bytesToMegabytes(runtime.totalMemory())+", AfterAllocated "+memoryToAllocateMB+"mb NowAppsHeapSizeInMB: "+ bytesToMegabytes(appAllocationHeapSize);
	}
	
	
	
	

//	
//	@GetMapping("/memtest0")
//	public void memtest0() {
//		 String s;
//		  try {
//		        Process ps = Runtime.getRuntime().exec("Pc.bat");
//		        BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
//		        while((s = br.readLine()) != null) {
//		            System.out.println(s);
//		        }
//		    }
//		    catch( Exception ex ) {
//		        System.out.println(ex.toString());
//		    }
//		
//	}

}
