
package com.jacques.Blissproject;

import java.lang.management.ManagementFactory; 
import java.lang.management.OperatingSystemMXBean;
import java.text.DecimalFormat;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/info")
public class InfoMachine {
	
	
	 Logger logger = Logger.getLogger(InfoMachine.class); 

	
	 @GET
	 @Path("/cpu")
	 @Produces(MediaType.APPLICATION_JSON)
	 public double getMemoryUsage(){ 
	  double total = (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024); 
	  double currentMemory =total- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024)); 
	  logger.info("Current memory " +currentMemory +" Mo  on " +total +" Mo" ); 
	  return currentMemory; 
	 } 
	  
	 /**
	  * @return Returns the system load average for the last minute. 
	  *  The system load average is the sum of the number of runnable entities queued to the available processors and the number of runnable entities running on the available processors averaged over a period of time. The way in which the load average is calculated is 
	  *  operating system specific but is typically a damped time-dependent average. 
	  */
	
	 public double getCPUUsage() { 
	  // Using the JMX bean 
	  OperatingSystemMXBean threadBean = ManagementFactory.getOperatingSystemMXBean(); 
		OperatingSystemMXBean ibmMxBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	  double load =  ((com.sun.management.OperatingSystemMXBean) ibmMxBean).getSystemCpuLoad(); 
	  logger.info("CPU usage this last minute:  " +load  ); 
	  return  load; 
	 } 
	 
	 public long getRamTotal(){
		 OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean(); 
		 com.sun.management.OperatingSystemMXBean privateOsMxBean = (com.sun.management.OperatingSystemMXBean) osMxBean; 
		 long memoireTotale =  privateOsMxBean.getTotalPhysicalMemorySize()/1000000000; 
		 
		 return memoireTotale;
	 }
	 
	 public double getRamFree(){
		 OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean(); 
		 com.sun.management.OperatingSystemMXBean privateOsMxBean = (com.sun.management.OperatingSystemMXBean) osMxBean; 
		 //double memoireLibre = privateOsMxBean.getFreePhysicalMemorySize()/(1024*1024);
		 double memoireLibre = (double) privateOsMxBean.getFreePhysicalMemorySize()/100000000;

		 
		 return memoireLibre;
	 }
	 
	 /*
	 public double getMemoryused(){
		 
		 double memoryused = (Runtime.getRuntime().totalMemory()  - Runtime.getRuntime().freeMemory())/1000d;
		 
		return memoryused;
		 
	 }
	 */
	 public String getEtatmachine(){
		 
		 InfoMachine machine = new InfoMachine();
		 JSONObject json = new JSONObject();
		 if(machine.getEtatRam().equals("memoire RAM full")){
			 try {
				json.put("etat machine","memoire RAM full");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		 }
		 else if(machine.getEtatRam().equals("Attention Taux utilisation de la RAM est superieur a 70%")){
			 
			 try {
					json.put("etatmachine","Attention Taux utilisation de la RAM est superieur a 70%");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 
		 else if(machine.getEtatRam().equals("taux utilisation de la RAM est compris entre 50% et 70%")){
			 
			 try {
					json.put("etatmachine","taux utilisation de la RAM est compris entre 50% et 70%");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 else if(machine.getEtatRam().equals("taux utilisation de la RAM est correct")){
			 
			 try {
					json.put("etatmachine","taux utilisation de la RAM est correct");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 
		 return machine.getEtatRam();
		 
	 }
	 
	 public String getEtatRam(){
		 InfoMachine machine = new InfoMachine();
		 double RamTotal = machine.getRamTotal();
		 double RamFree = machine.getRamFree();
		 double pourcent = ((RamTotal-RamFree)/RamTotal)*100 ;
		 //String Pourcentage = Long.toString(pourcent);
		 String result = "";
		 
		 if(pourcent == 100){
			 result = "memoire RAM full";
		 }
		 
		 else if(pourcent < 100 && pourcent >70 ){
			 
			 result = "Attention Taux utilisation de la RAM est superieur a 70%";
		 }
		 else if(pourcent == 70 && pourcent>50){
			 
			 result = "taux utilisation de la RAM est compris entre 50% et 70%";
		 }
		 else if(pourcent==50 && pourcent>0){
			 result = "taux utilisation de la RAM est correct";
		 }
		 
		 return result;
		 
	 }
	 
	 public double getRamConsomme(){
		 
		 InfoMachine machine = new InfoMachine();
		 double RamTotal = machine.getRamTotal();
		 double RamFree = machine.getRamFree();
		 
		 double diff = (RamTotal-RamFree)/100000000;
		 
		 return diff;
		 
	 }
	 
	 public double getPourcentageRam(){
		 InfoMachine machine = new InfoMachine();
		 double RamTotal = machine.getRamTotal();
		 double RamFree = machine.getRamFree();
		 
		 double pourcent = ((RamTotal-RamFree)/RamTotal)*100 ;
		 //double pourcent = (RamFree/RamTotal)*100;

		 //String Pourcentage = Long.toString(pourcent);
		 String result = "";
		 
		 
		 if(pourcent > 50){
			 
			 result = "Taux utilisation normal";
		 }
		 else if(pourcent < 50){
			 
			 result = "Attention ! taux utilisation inferieur a 50%";
		 }
		 else if(pourcent<20){
			 result = "Etat critique taux utilisation inferieur a 20%";
		 }
			
		 else{
			 result = "systeme ko";
			 
		 }
		 
		 return pourcent;
		 
	 }

	 public String getSystemName(){
		 
		 String SystemName = System.getProperty("os.name");
		 
		 return SystemName;
	 }
}
