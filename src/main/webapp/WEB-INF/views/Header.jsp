<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
		<nav id="header-nav" class="navbar navbar-default">
		  <div class="container">
			<div class="navbar-header">
			  <a href=<c:url value="/"/> class="pull-left visible-md visible-lg">
				<div id="logo-img"></div>
			 </a>
			<div class="navbar-brand">
				<a href=<c:url value="/"/>><h1>ISIS BANK</h1></a>
			</div>
			
			</div>
			
			<div id="collapsable-nav" class="collapse navbar-collapse">
			<ul id="nav-list" class="nav navbar-nav navbar-right">

            <li>
              <a href=<c:url value="/logout"/>>
                <span class="glyphicon glyphicon-log-out"></span><br> Wyloguj sie</a>
            </li>

				
			</ul>
         </div><!-- .collapse .navbar-collapse -->
		  </div><!-- container -->
		</nav>
	</header>
	
<div>
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
			<ul class="nav navbar-nav">
			  <li><a href=<c:url value="/"/>>MOJ BANK</a></li>
			  <li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Konta
				<span class="caret"></span></a>
				<ul class="dropdown-menu">
						<!-- dropdown menu: accounts -->
					<c:forEach items="${loggedClient.accounts}" var="account">
						<li><a href="#"> ${account.name}</a></li>
						<li class="divider"></li>
					</c:forEach>
				  <li><a href="#">nowe konto</a></li>
				</ul>
			  </li>
			  <li><a href="user_account_transfer.html">Wykonaj przelew</a></li>
			  <li><a href="#">Lokaty</a></li>
			  
			  <li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Karty
				<span class="caret"></span></a>
				<ul class="dropdown-menu">
				  <li><a href="#">Debetowe</a></li>
				  <li class="divider"></li>
				  <li><a href="#">Kredytowe</a></li>
				</ul>
			  </li>
			  <li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Kredyty
				<span class="caret"></span></a>
				<ul class="dropdown-menu">
				  <li><a href="#">Gotowkowy</a></li>
				  <li class="divider"></li>
				  <li><a href="#">Hipoteczny</a></li>
				</ul>
			  </li>
			  <li><a href="#">Ustawienia konta</a></li>
			  <li><a href="#">Porozmawiaj z doradca</a>
			  </li>
			</ul>
		  </div>
		</nav>
	</div>