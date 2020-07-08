<%@page import="java.util.Calendar" %>    
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.css"></script>
<style type="text/css"><%@include file="/css/menuStyle.css" %></style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>


<%@ page import="java.text.*,java.util.*" session="true"%>

    <header class="mdl-layout__header demo-layout-transparent">
    	<div class="mdl-layout__header-row">
    	
    	<span class="mdl-layout-title"> Users Page </span>	
    	
    	<div class="mdl-layout-spacer"></div>
    	<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm"); %>
		<h5 class="date"><%= df.format(new java.util.Date()) %> </h5>
		
    
    		
    	<nav class="mdl-navigation mdl-layout--large-screen-only">
    	<a class= "mdl-navigation__link" href="newUser.jsp"> New User</a>
    	<a class= "mdl-navigation__link" href="ServletControl?op=list">List Users</a>
    	
    	</nav>	
    	</div>
        </header>
        <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">Users</span>
        <nav class= "mdl-navigation">
        <a class ="mdl-navigation__link" href="ServletControl?op=delete&opp=<c:out value='${product.id}' />">Add new user</a>
        <a class ="mdl-navigation__link" href="ServletControl?op=list">List all users</a>
        
        </nav>
        </div>