import java.io.File;

import com.jacques.Blissproject.InfoMachine;

public class Main {

	public static void main(String[] args) {
		
		while(true){
			try {
				Thread.sleep(10000000);
				InfoMachine machine = new InfoMachine();
				machine.getMemoryUsage();
				machine.getRamFree();
				machine.getRamTotal();
				System.out.println("cpu machine\n" + machine.getMemoryUsage());
				// TODO Auto-generated method stub
				    /* Total number of processors or cores available to the JVM */
				  System.out.println("Available processors (cores): " + 
				  Runtime.getRuntime().availableProcessors());

			
				   
				    /* Get a list of all filesystem roots on this system */
				    File[] roots = File.listRoots();

				    /* For each filesystem root, print some info */
				    for (File root : roots) {
				      System.out.println("File system root: " + root.getAbsolutePath());
				      System.out.println("Total space (bytes): " + root.getTotalSpace());
				      System.out.println("Free space (bytes): " + root.getFreeSpace());
				      System.out.println("Usable space (bytes): " + root.getUsableSpace());
				    
				    }
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		
		
		}
	}

}
