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
                <form method="POST" action="Login">
                    <h2>Log In</h2>
                    <div class="row">
                        <div class="twelve columns">
                            <input name="id" type="text" class="u-full-width" placeholder="Your User ID or Matriculation Number" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="twelve columns">
                            <input name="password" type="password" class="u-full-width" placeholder="Your Password" />
                        </div>
                    </div>
                    <div class="row">
                        <input class="button" type="submit" value="Log In">
                    </div>
                </form>
            </div>
            
            <div class="six columns">
                <form method="POST" action="Register">
                    <h2>Register</h2>
                    <div class="row">
                        <div class="twelve columns">
                            <input name="userid" type="text" class="u-full-width" placeholder="Your User ID or Matriculation Number" />
                        </div>
                    </div> 
                    <div class="row">
                        <div class="twelve columns">
                            <input name="displayName" type="text" class="u-full-width" placeholder="Display Name" />
                        </div>
                    </div>    
                    <div class="row">
                        <div class="twelve columns">
                            <input name="email" type="text" class="u-full-width" placeholder="Email Address" />
                        </div>
                    </div>     
                    <div class="row">
                        <div class="twelve columns">
                            <input name="password" type="password" class="u-full-width" placeholder="Choose Your Password" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="twelve columns">
                            <input name="passwordConfirm" type="password" class="u-full-width" placeholder="Confirm Your Password" />
                        </div>
                    </div>   
                    <div class="row">
                        <div class="three columns row-center">
                            Position
                        </div>
                        <div class="nine columns">
                            <select name="position" class="u-full-width">
                                <option value="student">Student</option>
                                <option value="staff">Staff</option>
                            </select>
                        </div>
                    </div>  
                    <div class="row">
                        <input class="button" type="submit" value="Create An Account">
                    </div>    
                </form>
            </div>
        </div>
        
        
    </jsp:body>
</t:wrapper>