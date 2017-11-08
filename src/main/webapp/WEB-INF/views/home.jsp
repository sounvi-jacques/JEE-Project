<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="com.jacques.Blissproject.Servlet.InfoMachineServlet" %>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage Informations</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/form.css" />" />
		 <link href="<c:url value="/Bootstrap/bootstrap.min.css"/>" rel="stylesheet">
		    
    </head>
    <body>
     	<div class="container">
     		<form method="post" action="inscription">
            <fieldset >
                <legend>Informations Machines</legend>
                
					
						<label for="CpuUtilise">CPU utilise <span class="requis">:</span></label>
                		<label id='cpu'></label></br>
					
						
					
						<label for="FreeMemory"> memoire restant RAM <span class="requis">:</span></label>
		                <label id='FreeMemory'></label></br>
					
		                
                

		                <label for="PourcentageRam">Pourcentage Ram<span class="requis">:</span></label>
		                <label id='PourcentageRam'></label>
		                <br />
		                
		                 <label for="RamConsomme">Ram Consomme<span class="requis">:</span></label>
		                <label id='RamConsomme'></label>
		                <br />

		                <label for="EtatMachine">Etat Machine<span class="requis">:</span></label>
		     			<label id='EtatMachine'></label>
		                <br /><br>
		                
		                 <label for="RamTotal">Ram Total<span class="requis">:</span></label>
		     			<label id='RamTotal'></label>
		                <br />
                
		                 <label for="NomMachine">Nom Machine<span class="requis">:</span></label>
		     			<label id='NomMachine'></label>
		                <br />
		                
		                 <label for="HeureLocale">Heure Locale<span class="requis">:</span></label>
		     			<label id='HeureLocale'></label>
		                <br />

						
					
		                
                
            </fieldset>
        </form>
     
     
     	</div>
    	
        
         <script type="text/javascript">
        	var datajson = '<%=request.getAttribute("data") %>';
        	var json = eval('('+ datajson +')');
        	console.log(json.cpuusage);
        	
        	var labelCpu = document.getElementById('cpu');
        	labelCpu.innerHTML = json.cpuusage;
        	
        	var labelFreeMemory = document.getElementById('FreeMemory');
        	labelFreeMemory.innerHTML = json.ramfree;
        	
        	var labelPourcentageRam = document.getElementById('PourcentageRam');
        	labelPourcentageRam.innerHTML = json.pourcentageRamconsommee;
        	
        	var labelRamConsomme = document.getElementById('RamConsomme');
        	labelRamConsomme.innerHTML = json.Ramconsomme
        	
        	var labelEtatMachine = document.getElementById('EtatMachine');
            labelEtatMachine.innerHTML = json.etatmachine;
            
            var labelRamTotal = document.getElementById('RamTotal');
            labelRamTotal.innerHTML = json.ramtotale;
            
            var labelHeureLocale = document.getElementById('HeureLocale');
            labelHeureLocale.innerHTML = json.Heurelocale;
            
            var labelNomMachine = document.getElementById('NomMachine');
            labelNomMachine.innerHTML = json.nomsysteme;
            
        	
	
        
        </script>


    </body>
</html>