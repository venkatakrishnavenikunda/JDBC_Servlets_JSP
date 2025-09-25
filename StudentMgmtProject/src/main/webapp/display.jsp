<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, school.entity.Students" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Student Data</title>
<style>
    table { border-collapse: collapse; margin: auto; width: 70%; }
    th, td { border: 1px solid black; padding: 8px; text-align: center; }
    th { background-color: lightgray; }
    form { display: inline; }
</style>
</head>
<body style="background-color:black;color:white">
    <h2 style="text-align:center; color:red">All FAMILY MEMBERS</h2>

    <table>
        <tr>
            <th style="color:red" >ID</th>
            <th style="color:red" >NAME</th>
            <th style="color:red"> AGE</th>
            <th style="color:red">Action</th>
        </tr>
        <%
            // Get the student list from request attribute
            List<Students> list = (List<Students>) request.getAttribute("students");
            if (list != null && !list.isEmpty()) {
                for (Students s : list) {
        %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getAge() %></td>
                <td>
                    <!-- Update button -->
                    <form action="edit.jsp" method="get">
                        <input type="hidden" name="id" value="<%= s.getId() %>">
                        <input type="submit" value="Update">
                    </form>

                    <!-- Delete button -->
                    <form action="delete" method="get">
                        <input type="hidden" name="id" value="<%= s.getId() %>">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="4">No records found!</td>
            </tr>
        <%
            }
        %>
    </table>

    <div style="text-align:center; margin-top: 20px;">
        <a href="index.jsp">Back to Home</a>
    </div>
</body>
</html>
