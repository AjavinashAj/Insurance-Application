
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insurance App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" 
    rel="stylesheet" 
    integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" 
    crossorigin="anonymous">
    <style>
        
        .brand-name {
            font-size: 30px;
            font-weight: bold;
        }
        nav span {
            font-size: 22px;
            margin-right: 20px;
        }
        header {
            display: flex;
            justify-content: space-between;
            background-color: black;
            color:white;
            padding: 10px;
            font-family: Arial;
        }
        section {
                height: 540px;
                
            }
            footer{
                background-color: Red;
                color:white;
                font-family:Segoe UI;
                font-size: 20px;
                padding: 14px;
                display: grid;
                grid-template-columns: 2.4fr 2.4fr 2.4fr 2.4fr 2.4fr;
            }
            .footer-brand {
                font-size: 30px;
                font-weight: bold;
                margin-bottom: 10px;
            }
            
            .footer-title {
                font-weight: bold;
                margin-bottom: 5px;
            }
            
            body{
                mi-height:100vh;
            }
            .sticky-footer{
                  position:sticky;
            
            }
        
    </style>
</head>
<body>
<header>
        <div>
           <span class="brand-name " align="center">Insurance Report Application</span>
        </div>
        
       
  </header>
  <section>
  <div class="container pb-3 pt-3">
  <!--  <h1 class="pb-3 pt-3">Insurance Report Application</h1>-->
   <form:form action="handle" modelAttribute="request" method="POST">
     <table class="table table-bordered table table-hover" align=center>
         <tr class="table-primary">
            <td>Plan Name:</td>
            <td><form:select path="planName">
                <form:option value="">-select-</form:option>
                <form:options items="${names}"/>
            </form:select></td>
         
            <td>Plan Status:</td>
            <td><form:select path="planStatus">
                <form:option value="">-select-</form:option>
                <form:options items="${status}"/>
                </form:select>
            </td>
            <td>Gender:</td>
            <td><form:select path="gender">
                <form:option value="">-select-</form:option>
                <form:option value="Male">Male</form:option>
                <form:option value="Female">Female</form:option>
                </form:select>
            </td>
         </tr>
         <tr class="table-secondary">
           <td>Start Date:</td>
           <td><form:input type="date" path="startDate"/></td>
           
           <td>End Date:</td>
           <td><form:input type="date" path="endDate"/></td>
           <td><a href="/" class="btn btn-danger" >Reset</a></td>
           <td><input type="submit" value="Search" class="btn btn-primary"/></td>
           
         </tr>
     </table>
   </form:form>
   <hr>
   <table class="table table-striped table-hover">
         <thead>
               <tr>
                  <th>S.No</th>
                  <th>Holder Name</th>
                  <th>Gender</th>
                  <th>Plan Name</th>
                  <th>Plan Status</th>
                  <th>Start Date</th>
                  <th>End Date</th>
                  <th>Benefit Amt</th>
               </tr>
               
         </thead>
         <tbody>
              <c:forEach items="${plans}" var="plan" varStatus="ind">
              
              <tr>
                  <td>${ind.count}</td>
                  <td>${plan.citizenName}</td>
                  <td>${plan.gender}</td>
                  <td>${plan.planName}</td>
                  <td>${plan.planStatus}</td>
                  <td>${plan.planStartDate}</td>
                  <td>${plan.planEndDate}</td>
                  <td>${plan.benefitAmt}</td>
              </tr> 
              
              </c:forEach>
              <tr>
                <c:if test="${empty plans}">
                <td colspan="8" style="text-align:center">No Record Found</td>
                </c:if>
              </tr>
         </tbody>
   </table>
   
   <hr>
   <table class="table table-bordered table table-hover" align=center>
      <tr class="table-danger">
       <td>Export:</td>
       <td><a href="excel">Excel</a></td>
       <td><a href="pdf">Pdf</a></td>
     </tr>
   </table>          
  </div>
  </section>
  <footer class="sticky-footer">
            <div>
                <div class="footer-title">AvinashIT</div>
                
               </div>            
            <div>
                <div class="footer-title">SUPPORT</div>
                
            </div>
            
            
            <div>
                <div class="footer-title">FAQs</div>
                
            </div>
            <div>
                <div class="footer-title">CONTACT</div>
                
            </div>
            <div>
                <div class="footer-title">HELP</div>
                
            </div>
        </footer>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" 
crossorigin="anonymous">
</script>
</body>
</html>