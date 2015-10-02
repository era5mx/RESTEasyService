<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*, mx.com.extend.semarnat.foresta.data.*, mx.com.extend.semarnat.foresta.util.*, mx.com.extend.semarnat.foresta.service.*, mx.com.extend.semarnat.foresta.wsclient.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REST WebService Test page</title>
</head>
<body>
	<%
		StudentWSClient client = new StudentWSClient();
	%>
	<p>
		Display student over age <br>

		<%
			Collection<Student> students = client.getStudentsOverAge("20");
		%>

		Student over age Size :
		<%=students.size()%><br>
		<%
			for (Student aStudent : students) {
		%>
		<%=aStudent.toString()%><br>
		<%
			}
		%>
	</p>
	<p>
		Display students by name (Mike, Jane, Debbie) <br>

		<%
			List<String> studentsName = Arrays.asList("Mike", "Jane", "Debbie");
			Collection<Student> studentList = client.getStudentsByNameJson(studentsName);
		%>

		Student over age Size :
		<%=studentList.size()%><br>
		<%
			for (Student bStudent : studentList) {
		%>
		<%=bStudent.toString()%><br>
		<%
			}
		%>
	</p>
</body>
</html>