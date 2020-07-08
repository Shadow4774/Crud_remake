<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Editing</title>
</head>
<body>
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
     <%@include file="menu.jsp"%>
		<main class="mdl-layout__content">
		
			<div class="page-content">
				<div class="mdl-grid center-items">
					<div class="mdl-cell mdl-cell--4-col">
						<div class="mdl-card mdl-shadow--6dp">
						
							<div
								class="mdl-card__title demo-layout-transparent mdl-color-text--white">
								<h1 class="mdl-card__title-text">Edit User</h1>
								</div> 
<div>  
 <form class="mdl-card__supporting-text"
  name="myForm" action="/CRUD-remake/ServletControl?op=update" method="post"> 
 
 <div class="mdl-textfield mdl-js-textfield">
 	<input class=" mdl-textfield__input" type="hidden" name="id" value="${user.id }">
 									</div>
 	
 	<div class="mdl-textfield mdl-js-textfield">
 	<label class="MDL-textfield - floating-label" for="name">name:</label>
	<input class=" mdl-textfield__input" type="text" name="name" id="name" value="${user.name }"><br>
									</div>
	
	<div class="mdl-textfield mdl-js-textfield">
	<label class="MDL-textfield - floating-label" for="surname">surname:</label>
	<input class=" mdl-textfield__input" type="text" name="surname" id="surname" value="${user.surname }"><br>
									</div>
	
	<div class="mdl-textfield mdl-js-textfield">
	<label class="MDL-textfield - floating-label" for="date">date:</label>
	<input class=" mdl-textfield__input" type="date" name="birth" id="birth" value="${user.birthDate }"><br>
									</div>
	

	Type: 
	<div class="mdl-textfield mdl-js-textfield">
	<label class="mdl-textfield__label" for="owner">Owner</label>
	<input class=" mdl-textfield__input" type="radio" name="type" id="owner" value="O" checked>
									</div>
	<div class="mdl-textfield mdl-js-textfield">
    <label class="mdl-textfield__label" for="spouse">Spouse</label>
	<input class=" mdl-textfield__input" type="radio" name="type" id="spouse" value="S">
									</div>
	<div class="mdl-textfield mdl-js-textfield">
	<label class="mdl-textfield__label" for="child">Child</label>
	<input class=" mdl-textfield__input" type="radio" name="type" id="child" value="C"><br>
									</div>
	
	 <input type="submit"
	 class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
	 value="save">
</form>
</div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>
</body>
</html>