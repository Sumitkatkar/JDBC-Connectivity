import java.sql.*;
import java.util.*;

public class database
{
   public static void main(String args[])
   {
     try
     {
         String url="jdbc:mysql://localhost:3306/demo";
         String username="root";
         String password="";

         Class.forName("com.mysql.cj.jdbc.Driver");

         Connection connection=DriverManager.getConnection(url,username,password);

         String Q = "insert into Employee(ID,Name,Salary)" + "values(?,?,?)";

         PreparedStatement preparedStatement=connection.prepareStatement(Q);

         Scanner sc = new Scanner(System.in);
         System.out.println("Enter Roll No: ");
         int roll = sc.nextInt();

         System.out.println("Enter Name: ");
         String name = sc.next();

         System.out.println("Enter Salary: ");
         int sal = sc.nextInt();

         preparedStatement.setInt(1,roll);
         preparedStatement.setString(2,name);
         preparedStatement.setInt(3,sal);

         preparedStatement.executeUpdate();
         ResultSet resultSet=preparedStatement.executeQuery("select * from Employee");

         while(resultSet.next())
         {
             System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
         }

         connection.close();

     }
     catch (Exception e)
     {
         System.out.println(e);
     }
   }
}
