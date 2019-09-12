<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.mom.model.*,com.mom.DAO.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/dashb.css">
<link href="css/style2.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  color:white;
  text-align: center;
}

#customers td, #customers th {
  
  padding: 8px;
}

#customers tr:{background-color: #394264;}

#customers tr:hover {background-color: #394264;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #394264;
  color: white;
}
.button2 {background-color: #11a8ab;;} 

#tableHolder
 {
 height: 250px;
 overflow: auto;
  direction: ltl;
}

.card {
        top: 25%;
		left:40%;
		
		
		display: block;
		position: absolute;

}

body{
	max-height: 550px;
  background-color: #02081f;

}

a {
    color: #f3f8fd;
    text-decoration: none;
}

.col1
{
  background-color: #394264;
}
</style>
</head>
<title>Admin Dashboard</title>   
   <body>
<% 
   int empid=(Integer)session.getAttribute("Emp_id");
    List<Action> al=new ArrayList<Action>();
   try{
=ActionDetailsDAO.getEmpAssignedAct(empid);
   }catch(Exception e){
    System.out.println(e);
   }
   %>






    
 <div class="container-fixed">
        <div class="main-container">

            <!-- HEADER -->
            <header class="block">
                <ul class="header-menu horizontal-list">
                    <li>
                        <a class="header-menu-tab" href="AdminDashboard.jsp"><span class="icon entypo-cog scnd-font-color"></span>Home</a>
                    </li>
                    <li>
                        <a class="header-menu-tab" href="LogoutServlet"><span class="icon fontawesome-user scnd-font-color"></span>Logout</a>
                    </li>
                    
                </ul>
                <div class="profile-menu">
                    <p><a href="#26"><span class="entypo-down-open scnd-font-color"></span></a></p>
                
                        <img width="30px" height="30px" alt="Anne Hathaway picture" src="images/user.png" style="border-radius:50%;">
                    
                </div>
            </header>
            <!-- LEFT-CONTAINER -->
            <div class="container-fixed">


            <div class="row">
               <div class="left-container container col-md-4">
                <div class="menu-box block"> <!-- MENU BOX (LEFT-CONTAINER) -->
                    <h4 class="titular" style="color: white">ADMIN MENU</h4>
                    <ul class="menu-box-menu">
                        <li>
                            <a class="menu-box-tab" href="Registration_form.html"><span class="icon fontawesome-envelope scnd-font-color "></span>Employee Registration<div class="menu-box-number"></div></a>                           
                        </li>
                        <li>
                            <a class="menu-box-tab" href="view.jsp"><span class="icon entypo-paper-plane scnd-font-color"></span>Employee Details<div class="menu-box-number"></div></a>                            
                        </li> <br>
                        <li>
                            <a class="menu-box-tab" href="Export.html"><span class="icon entypo-calendar scnd-font-color"></span>Export<div class="menu-box-number"></div></a>                            
                        </li>
                                            
                      </ul>
                  </div>
                </div>



                <div class="col-md-4">
                	<center><h1 style="color: white"> WELCOME </h1></center>
					<center><img width="100px" height="100px" alt="" src="images/adicon.jpg" style="border-radius:50%;"></center>
					<br> <br> <br> <br> <br> 
                </div>
                


  <div class="container col-md-4 data-spy="scroll"">
      <div class="menu-box block" id="tableHolder"> <!-- MENU BOX (LEFT-CONTAINER) -->
          <h4 class="titular" style="color: white">ACTION TO ACCEPT</h4> 
					
               
			       <table class="table table-bordered table-responsive-md table-striped text-center" id="customers">
			         <thead>
                <tr class="col2">
                  <th class="text-center"><center>Name</center></th>
                  <th class="text-center"><center>MoM ID</center></th>
                  <th class="text-center"><center>Status</center></th>
            
                </tr>
                </thead>
       
        <tbody>
          <tr lass="col1">
            <td class="pt-3-half" >Aurelia Vega</td>
            <td class="pt-3-half">30</td>
            
			       <td>
              <span class="table-remove">
			  <button type="button"
                  class="button2" data-toggle="modal" data-target="#elegantModalForm"  >Accept</button></span>
				  </td>
				
           
              		  
				  </tr>
				  
        </tbody>
      </table>
          
      </div>
      </div>
                
		</div>


		
			<div class="row">


			<div class="left-container container col-md-4 ">
                <div class="menu-box block"> <!-- MENU BOX (LEFT-CONTAINER) -->
                    <h4 class="titular" style="color: white">EMPLOYEE MENU</h4>
                    <ul class="menu-box-menu">
                        <li>
                            <a class="menu-box-tab" href="createMom.jsp"><span class="icon fontawesome-envelope scnd-font-color"></span>Create MoM<div class="menu-box-number"></div></a>                            
                        </li><br>
                        <li>
                            <a class="menu-box-tab" href="#"><span class="icon entypo-paper-plane scnd-font-color"></span>View MoM<div class="menu-box-number"></div></a>                            
                        </li>
                        
                                            
                    </ul>
                </div>
			</div>
			
			
               
                

            <!-- MIDDLE-CONTAINER -->
            <div class="container col-md-4">
               <!-- <div class="profile block"> <!--PROFILE (MIDDLE-CONTAINER)-
                    <a class="add-button" href="#28"></a>
                   
                      
                    
                   
                </div>-->
				 
				  <div class="midcon block"> 
				  <p class= "center1">Number of MoM created: 12</p>
				</div>
					
					 <div class="midcon block"> 
					 <p class= "center1">Number of MoM created: 12</p>
				</div>
					
						 
						 <div class="midcon block"> 
						 <p class= "center1">Number of MoM created: 12</p>
				</div>
						
						
							
				 <div class="midcon block"> 
				 <p class= "center1">Number of MoM created: 12</p>
				</div>
				
            </div>

           	
			<div class="container col-md-4">
                <div class="menu-box block" id="tableHolder"> <!-- MENU BOX (LEFT-CONTAINER) -->
                    <h4 class="titular">ACTION IN PROGRESS</h4> 
                    <table class="table table-bordered table-responsive-md table-striped text-center" id="customers">
        <thead>
          <tr class="col2">
            <th class="text-center "><center>Name</center></th>
            <th class="text-center "><center>MoM ID</center></th>
            
			<th class="text-center "><center>Status</center></th>
            
          </tr>
        </thead>
        <tbody>
          <tr class="col1">
            <td class="pt-3-half" >Aurelia Vega</td>
            <td class="pt-3-half">30</td>
            
			   <td>
              <span class="table-remove">
			  <button type="button"
                  class="button2" data-toggle="modal" data-target="#elegantModalForm"  >Ready</button></span>
				  </td>
				
           
              		  
				  </tr>
				  
			
          
          <!-- This is our clonable table line -->
            <tr class="col1">
            <td class="pt-3-half" >Aurelia Vega</td>
            <td class="pt-3-half">30</td>
            
			   <td>
              <span class="table-remove">
			  <button type="button"  class="button2"
                  class="btn  btn-rounded btn-sm my-0 font btn btn-info" data-toggle="modal" data-target="#elegantModalForm"  >Ready</button></span>
				  </td>
				
           
              		  
				  </tr>
          <!-- This is our clonable table line -->
            <tr class="col1">
            <td class="pt-3-half" >Aurelia Vega</td>
            <td class="pt-3-half">30</td>
            
			   <td>
              <span class="table-remove">
			  <button type="button"  class="button2"
                  class="btn  btn-rounded btn-sm my-0 font btn btn-info" data-toggle="modal" data-target="#elegantModalForm"  >Ready</button></span>
				  </td>  
				  </tr>
          <!-- This is our clonable table line -->
          <tr class="col1">
            <td class="pt-3-half" >Aurelia Vega</td>
            <td class="pt-3-half">30</td>
            
			   <td>
              <span class="table-remove">
			  <button type="button"  class="button2"
                  class="btn  btn-rounded btn-sm my-0 font btn btn-info" data-toggle="modal" data-target="#elegantModalForm"  >Ready</button></span>
				  </td>  
				  </tr>
				  <tr class="col1">
            <td class="pt-3-half" >Aurelia Vega</td>
            <td class="pt-3-half">30</td>
            
			   <td>
              <span class="table-remove">
			  <button type="button"  class="button2"
                  class="btn  btn-rounded btn-sm my-0 font btn btn-info" data-toggle="modal" data-target="#elegantModalForm"  >Ready</button></span>
				  </td>
				
           
              		  
				  </tr>
        </tbody>
      </table>
                        
                                            
                  
                </div>
			</div>
			</div>
			</div>
        </div> <!-- end main-container -->
        </div>
        
        <!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</body>
</html>