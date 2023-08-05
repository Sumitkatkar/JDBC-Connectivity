import java.sql.*;
import java.util.*;

class studentInfo
{
    public static void main(String args[])
    {
        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String username="root";
        String password="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection= DriverManager.getConnection(url,username,password);

            Boolean temp = true;
            while(temp==true)
            {
                Scanner sc = new Scanner(System.in);

                studentInfo s1 = new studentInfo();
                System.out.println(" 1.Add \n 2.Update \n 3.Remove\n 4.Show \n 5.Exit");
                System.out.println("==================================");
                System.out.print("Enter your choice=");
                int ch=sc.nextInt();
                System.out.println("==================================");




                switch(ch)
                {
                    case 1:
                        String Q = "insert into student(ID,Name,Age)" + "values(?,?,?)";
                        PreparedStatement preparedStatement=connection.prepareStatement(Q);
                        System.out.println("Enter Roll No: ");
                        int roll = sc.nextInt();

                        System.out.println("Enter Name: ");
                        String name = sc.next();

                        System.out.println("Enter Age: ");
                        int age = sc.nextInt();

                        preparedStatement.setInt(1,roll);
                        preparedStatement.setString(2,name);
                        preparedStatement.setInt(3,age);
                        preparedStatement.executeUpdate();

                        System.out.println("==================================");
                        System.out.println("Adding...");
                        System.out.println("==================================");
                        break;

                    case 2:
                        String a="update student set age=? where ID = ?";
                        PreparedStatement preparedStatement2=connection.prepareStatement(a);

                        System.out.println("Enter ID which you want to update: ");
                        int g=sc.nextInt();
                        System.out.println("Enter updated age: ");
                        int ag=sc.nextInt();
                        preparedStatement2.setInt(1,ag);
                        preparedStatement2.setInt(2,g);
                        preparedStatement2.execute();

                        System.out.println("==================================");
                        System.out.println("Updatting");
                        System.out.println("==================================");
                        break;
                    case 3:
                       String e = "delete from student where ID=? ";
                        PreparedStatement preparedStatement1=connection.prepareStatement(e);
                        System.out.println("Enter ID which you want to delete: ");
                        int ID=sc.nextInt();

                        preparedStatement1.setInt(1,ID);
                        preparedStatement1.execute();
                        System.out.println("==================================");
                        System.out.println("Removing...");
                        System.out.println("==================================");
                        break;
                    case 4:
                        Statement statement=connection.createStatement();
                       ResultSet resultSet=statement.executeQuery("select * from student");
                        while(resultSet.next())
                        {
                            System.out.println(resultSet.getInt( 1)+" "+resultSet.getString( 2)+" "+resultSet.getInt( 3));
                        }
                        System.out.println("==================================");
                        System.out.println("Showing...");
                        System.out.println("==================================");
                        break;
                    case 5:
                        connection.close();
                        System.out.println("==================================");
                        System.out.println("Thank you");
                        System.out.println("==================================");
                        System.exit(0);
                        break;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}