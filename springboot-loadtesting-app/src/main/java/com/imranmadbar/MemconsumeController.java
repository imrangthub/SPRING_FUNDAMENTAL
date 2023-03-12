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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imranmadbar.home.HomeController;

@RestController
public class MemconsumeController {
	
	@GetMapping("/memtest3")
	public String memtest3() {
		
        List<Person> list = new ArrayList<Person>();
        for (int i = 0; i <= 900; i++) {
            list.add(new Person("MD IMRAN HOSSAIN", "Male"));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Step: "+i);
        }
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total memory is megabytes: "
                + bytesToMegabytes(runtime.totalMemory()));
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "
                + bytesToMegabytes(memory));
        
        
        
		return "Used memory is megabytes: "+ bytesToMegabytes(memory);
	}
	
	


	
	@GetMapping("/memtest2")
	public String memtest2(@RequestParam(name="name") String name) {
		
        List<Person> list = new ArrayList<Person>();
        List<Person> list2 = new ArrayList<Person>();
        for (int i = 0; i <= 9900000; i++) {
            list.add(new Person(name, "Male"));
            list2.add(new Person(name, "Female"));
        }
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total memory is megabytes: "
                + bytesToMegabytes(runtime.totalMemory()));
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "
                + bytesToMegabytes(memory));
        
        
        
		return "Used memory is megabytes: "+ bytesToMegabytes(memory);
	}

	@GetMapping("/memtest1")
	public String memtest1() {
		
        List<Person> list = new ArrayList<Person>();
        List<Person> list2 = new ArrayList<Person>();
        for (int i = 0; i <= 9900000; i++) {
            list.add(new Person("MD IMRAN HOSSAIN", "Male"));
            list2.add(new Person("Methila  HOSSAIN", "Female"));
        }
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total memory is megabytes: "
                + bytesToMegabytes(runtime.totalMemory()));
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "
                + bytesToMegabytes(memory));
        
        
        
		return "Used memory is megabytes: "+ bytesToMegabytes(memory);
	}
	
	
	@GetMapping("/memtest")
	public String memtest() {
		
  
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total memory is megabytes: "
                + bytesToMegabytes(runtime.totalMemory()));
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "
                + bytesToMegabytes(memory));
        
        
        
		return "Used memory is megabytes: "+ bytesToMegabytes(memory);
	}
	
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);

	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}
	
	
	@GetMapping("/memtest0")
	public void memtest0() {
		 String s;
		  try {
		        Process ps = Runtime.getRuntime().exec("Pc.bat");
		        BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
		        while((s = br.readLine()) != null) {
		            System.out.println(s);
		        }
		    }
		    catch( Exception ex ) {
		        System.out.println(ex.toString());
		    }
		
	}

}
