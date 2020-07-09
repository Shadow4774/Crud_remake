<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="menu.jsp"%>
		<main class="mdl-layout__content">
			<div class="page-content">
				<div class="mdl-grid center-items ">
					<div class="mdl-cell mdl-cell--4-col ">
						<div class="mdl-card mdl-shadow--6dp ">
							<div
								class="mdl-card__title demo-layout-transparent mdl-color-text--white">
								<h2 class="mdl-card__title-text">
									<c:if test="${user != null}"> Edit User</c:if>
										<c:if test="${user == null}"> Add New User</c:if>
								</h2>
							</div>
							<div class="mdl-card__supporting-text">
								<c:if test="${user !=null}">
									<form name="myForm" action="ServletControl?op=update" method="post" onsubmit="return validateForm()">
										
								</c:if>
								<c:if test="${user ==null}">
									<form name="myForm" action="ServletControl?op=insert" method="post" onsubmit="return validateForm()">
								</c:if>
								<c:if test="${user !=null}">
									<input type="hidden" name="id"
										value="<c:out value ='${user.id}'/>" />
								</c:if>
                                   
								<div class="mdl-textfield mdl-js-textfield">
								<label class="MDL-textfield - floating-label" for="name">name:</label>
									<input class="mdl-textfield__input" type="text" name="name"
										value="<c:out value='${user.name}'/>" id="name" /> 
										
										
								</div>

								<div class="mdl-textfield mdl-js-textfield">
								<label class="MDL-textfield - floating-label" for="surname">surname:</label>
									<input class=" mdl-textfield__input" type="text"
										name="surname"
										value="<c:out value='${user.surname}'/>" id="surname" />
									
								</div>


								<div class="mdl.textfield mdl-js-textfield">
								<label class="MDL-textfield - floating-label" for="date">date:</label>
									<input class=" mdl-textfield__input" type="date"
												name="birth" value="2000-01-01"
												id="birth" /><br>
									
								</div>
								
								
								Type:
                                <div class="mdl-textfield mdl-js-textfield">
                                <label class="mdl-textfield__label" for="owner">Owner</label>
							    <input class="mdl-textfield__input" type="radio" name="type"
										value="O" id="owner" checked/>
									
								</div>
								
								
								<div class="mdl-textfield mdl-js-textfield">
								<label class="mdl-textfield__label" for="spouse">Spouse</label>
									<input class="mdl-textfield__input" type="radio" name="type"
										value="S" id="spouse" />
									
								</div>
								
								
								<div class="mdl-textfield mdl-js-textfield">
								<label class="mdl-textfield__label" for="child">Child</label>
									<input class="mdl-textfield__input" type="radio" name="type"
										value="C" id="child" />
									
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