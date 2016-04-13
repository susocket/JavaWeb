<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Customer Support</title>
	</head>
	<body>
             <a href="<c:url value="/login?logout" />">Logout</a> <br /><br />
		<h2> Create a Ticket</h2>
                Hello  <c:out value="${username}" /><%= request.getSession().getAttribute("username") %><br /><br />
                <form method="post" action="tickets" enctype="multipart/form-data">
			<input type="hidden" name="action" value="create" />            
                        <label>Subject</label> <br />
                        <input type="text"  name="subject" ><br /><br />
			<textarea rows="5" cols="30" name="body"></textarea><br /><br />
			<b>Attachments:</b> <br />
			<input type="file" name="file1" /><br /><br />
			<input type="submit" value="Submit" />
		</form>

	</body>
</html>