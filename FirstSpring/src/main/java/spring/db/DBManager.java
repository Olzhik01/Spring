package spring.db;

import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/group23_db?useUnicode=true&serverTimezone=UTC", "root", "");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addBook(books book){

        try{

            PreparedStatement statement =
                    connection.prepareStatement("" +
                            "INSERT into books (name,author,price) " +
                            "VALUES (?,?,?)");

            statement.setString(1,book.getName());
            statement.setString(2,book.getAuthor());
            statement.setInt(3,book.getPrice());
            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static ArrayList<books> getAllBooks(){
        ArrayList<books> book = new ArrayList<>();
        try{

            PreparedStatement statement =
                    connection.prepareStatement("" +
                            "SELECT * FROM books");

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                book.add(new books(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("author"),
                        resultSet.getInt("price")
                ));

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return book;
    }

    public static ArrayList<books> searchByName(String name){
        ArrayList<books> searchBooks = new ArrayList<>();
        try{

            PreparedStatement statement =
                    connection.prepareStatement("" +
                            "SELECT * FROM books WHERE name=?");

            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                searchBooks.add(new books(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("author"),
                        resultSet.getInt("price")
                ));

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return searchBooks;
    }






}
