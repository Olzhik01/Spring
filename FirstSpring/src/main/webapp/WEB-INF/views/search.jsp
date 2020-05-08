<%@ page import="spring.db.books" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <form action="/searchBook" method="post">
            <label>Name of book: </label>
            <input type="text" name="name"><br><br>
            <button type="submit">Search book</button>
        </form>



        <table cellpadding="20">
            <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>AUTHOR</th>
                <th>PRICE</th>
            </tr>
            </thead>
            <tbody>
            <%
                ArrayList<books> books = (ArrayList<books>) request.getAttribute("searchBooks");
                if(books!=null){
                    for (books book:books){

            %>
            <tr>
                <td><%=book.getId()%></td>
                <td><%=book.getName()%></td>
                <td><%=book.getAuthor()%></td>
                <td><%=book.getPrice()%> KZT</td>
            </tr>

            <%
                    }
                }
            %>
            </tbody>
        </table>



</body>
</html>
