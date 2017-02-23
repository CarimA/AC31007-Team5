<%-- 
    Document   : index
    Created on : 22-Feb-2017, 12:18:09
    Author     : carimakeju
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <jsp:attribute name="header">
        
    </jsp:attribute>
    <jsp:attribute name="footer">
        
    </jsp:attribute>
    
    <jsp:body>
        <div class="row">
            <div class="six columns">
                <h2>Log In</h2>
                <div class="row">
                    <div class="twelve columns">
                        <input type="text" class="u-full-width" placeholder="Your User ID or Matriculation Number" />
                    </div>
                </div>
                <div class="row">
                    <div class="twelve columns">
                        <input type="text" class="u-full-width" placeholder="Your Password" />
                    </div>
                </div>
                <div class="row">
                    <a href="#" class="button">Submit</a>
                </div>
            </div>
            
            <div class="six columns">
                <h2>Register</h2>
                <div class="row">
                    <div class="twelve columns">
                        <input type="text" class="u-full-width" placeholder="Your User ID or Matriculation Number" />
                    </div>
                </div>
                <div class="row">
                    <div class="twelve columns">
                        <input type="text" class="u-full-width" placeholder="Email Address" />
                    </div>
                </div>     
                <div class="row">
                    <div class="twelve columns">
                        <input type="text" class="u-full-width" placeholder="Choose Your Password" />
                    </div>
                </div>
                <div class="row">
                    <div class="twelve columns">
                        <input type="text" class="u-full-width" placeholder="Confirm Your Password" />
                    </div>
                </div>   
                <div class="row">
                    <div class="three columns row-center">
                        Position
                    </div>
                    <div class="nine columns">
                        <select class="u-full-width">
                            <option value="student">Student</option>
                            <option value="staff">Staff</option>
                        </select>
                    </div>
                </div>  
                <div class="row">
                    <a href="#" class="button">Submit</a>
                </div>                
            </div>
        </div>
        
        
    </jsp:body>
</t:wrapper>