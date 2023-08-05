import java.sql.*;
import java.util.Scanner;

public class deleteQuery
{
    public static void main(String args[])
    {
        String url="jdbc:mysql://localhost:3306/demo";
        String username="root";
        String password="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,username,password);

            String Q = "delete from Employee where ID=? ";
            PreparedStatement preparedStatement=connection.prepareStatement(Q);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter ID which you want to delete: ");
            int ID=sc.nextInt();

            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
            ResultSet resultSet=preparedStatement.executeQuery("select * from Employee");
            while (resultSet.next())
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
