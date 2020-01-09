<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"/>
<style>
* {
  box-sizing: border-box;
}

/* Style the search field */
form.example input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 80%;
  background: #f1f1f1;
}

/* Style the submit button */
form.example button {
  float: left;
  width: 20%;
  padding: 10px;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none; /* Prevent double borders */
  cursor: pointer;
}

form.example button:hover {
  background: #0b7dda;
}

/* Clear floats */
form.example::after {
  content: "";
  clear: both;
  display: table;
}

/*Tag css*/
.post-tag {
    color: #3E6D8E;
    background-color: #E0EAF1;
    border-bottom: 1px solid #3E6D8E;
    border-right: 1px solid #7F9FB6;
    padding: 3px 4px 3px 4px;
    margin: 2px 2px 2px 0;
    text-decoration: none;
    font-size: 90%;
    line-height: 2.4;
    white-space: nowrap;
}

a.post-tag:hover {
    background-color: #3E6D8E;
    color: #E0EAF1;
    border-bottom: 1px solid #37607D;
    border-right: 1px solid #37607D;
    text-decoration: none;
}
</style>

<h2>EnTagRecommandation System</h2>
<hr/>


<form class="example" action="entagsearch" method="get" style="margin:left;max-width:400px">
	<input type="text" name="question" placeholder="Search..">
	<button type="submit"><i class="fa fa-search"></i></button>
</form>

<hr/>

<c:if test="${recommandedTag != null }">
 <strong>Tag Recommanded : &nbsp;</strong><a class="post-tag"> ${recommandedTag} </a>
</c:if>

<br/><hr/><br/>
<c:if test="${recommandedErrors != null }">
	Console Output:<br/>
	<div style="color: #3E6D8E;background-color: #E0EAF1;">
		
		<c:forEach var="recommandedError" items="${recommandedErrors }">
			<div>
				<i> ${recommandedError} </i>
			</div>
		</c:forEach>
	</div>
</c:if>
	
<c:import url="footer.jsp"/>