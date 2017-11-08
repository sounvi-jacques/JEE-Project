package com.jacques.Blissproject.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jacques.Blissproject.InfoMachine;

/**
 * Servlet implementation class InfoMachineServlet
 */
public class InfoMachineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoMachineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  // Set refresh, autoload time as 5 seconds
	      response.setIntHeader("Refresh", 10);
	      
	      // Get current time
	      Calendar calendar = new GregorianCalendar();
	      String am_pm;
	      int hour = calendar.get(Calendar.HOUR);
	      int minute = calendar.get(Calendar.MINUTE);
	      int second = calendar.get(Calendar.SECOND);
	         
	      if(calendar.get(Calendar.AM_PM) == 0)
	         am_pm = "AM";
	      else
	         am_pm = "PM";
	 
	      String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
	    
	      
	      
	      InfoMachine machine = new InfoMachine();
	      double cpuusage = machine.getCPUUsage();
	      double FreeRam = machine.getRamFree();
	      double RamTotale = machine.getRamTotal();
	      String EtatMachine = machine.getEtatmachine();
	      String Systeme = machine.getSystemName();
	      String etatRam = machine.getEtatRam();
	      double PourcentageRam = machine.getPourcentageRam();
	      double RamConsomme = machine.getRamConsomme();
	      //double TotalMemory = machine.getTotalMemory();
	      
	 
	      // Set response content type
	      response.setContentType("application/json");
	      response.setCharacterEncoding("utf-8");
	      PrintWriter out = response.getWriter();
	      JSONObject json = new JSONObject();
	      JSONArray jsonArray = new JSONArray();

	      
	      try {
			json.put("cpuusage",cpuusage);
			//json.put("Mémoire disponible", FreeMemory +" "+"mo");
			json.put("ramtotale", RamTotale);
			json.put("ramfree", FreeRam);
			json.put("Heurelocale", CT);
			json.put("etatmachine", EtatMachine);
			json.put("nomsysteme", Systeme);
			json.put("pourcentageRamconsommee", PourcentageRam +""+"%");
			json.put("Ramconsomme", RamConsomme);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	     
	      jsonArray.put(json);
	     // out.println(json);

	      
	      request.setAttribute("data", json);  
	      request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);

	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
