<%@ page import="java.util.ArrayList" %>
<%@ page import="spring.db.books" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <form action="/addBook" method="post">
            <label>Name of book: </label>
            <input type="text" name="nameBook"><br><br>
            <label>Author of book: </label>
            <input type="text" name="authorBook"><br><br>
            <label>Price of book: </label>
            <input type="number" name="priceBook"><br><br>
            <button type="submit">Add Book</button>
        </form>

        <a href="/searchPage">Go to search page</a>
        <br>

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
                    ArrayList<books> books = (ArrayList<books>) request.getAttribute("books");
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
