import java.sql.*;
import java.util.*;
import java.util.Scanner;
class JDBC{
public static void main(String main[])throws SQLException
{
  Connection conn = null;
  Statement stat  = null;
  ResultSet  res  = null;
  PreparedStatement insert = null,update = null;
//creating object for input
Scanner input = new Scanner(System.in);

  try
    {
      //psql driver
      Class.forName("org.postgresql.Driver");
      //connection estabilishing
      conn = DriverManager.getConnection("jdbc:postgresql://192.168.16.1/ty8804","ty8804","");
      // insert 
      insert = conn.prepareStatement("insert into employee values(?,?,?)");
      //update sequence wise 1st ? for sal  
      update = conn.prepareStatement("update employee set salary = ? where empid = ?");
      if(conn==null)
      {
	  System.out.println("Connection failed");
      }
      else
      {
	  System.out.println("Connection sucessfull");
      }
    // psql query statments
      stat = conn.createStatement();
    // query
     // res = stat.executeQuery("select * from student");

}catch(Exception e){System.out.print(e);}
//menu driven 
int ch;
do
{
System.out.print("\n1 Insert \n2 Modify \n3 Delete \n4 Search \n5 View All\n0 Exit\n"); 
System.out.println("Enter your Choice :");
ch = input.nextInt();

  switch(ch)
    {
	  //for insert data
	case 1:
		{
		    System.out.print("\nEnter Id :");
		    int id = input.nextInt();
		    System.out.print("\nEnter name :");
		    String name = input.next();
		    System.out.print("\nEnter salary :");
		    float salary = input.nextFloat();
		    insert.setInt(1,id);
		    insert.setString(2,name);
		    insert.setFloat(3,salary);
		    insert.executeUpdate();
		    
		}
		    break;
	//for upadate data	
	case 2:
		{
		    System.out.print("Enter Id :");
		    int id = input.nextInt();
		    System.out.print("Enter updated salary :");
		    float salary = input.nextFloat();
		    update.setInt(2,id);
		    update.setFloat(1,salary);
		    update.executeUpdate();
		    break;
		
		}
		    
      //for delete data
	case 3:
		{
		    System.out.print("Enter Id to Delete :");
		    int id = input.nextInt();
		    stat.executeUpdate("delete from employee where empid= "+id);
			   break;
		}
    //for searching data
	case 4:
		{
		     System.out.print("Enter Id to Search :");
		     int id = input.nextInt();
		     res = stat.executeQuery("select * from employee where empid= "+id);
		     if(res.next())
		      {
			  System.out.print("Emp id = "+res.getInt(1));
			  System.out.print("Emp Name = "+res.getString(2));
			  System.out.print("Emp Salary = "+res.getFloat(3));
		      }
		      else
		      {
			  System.out.print("Not found ");
		      }
			  break;
		}
    //display all data
	case 5:
		{
		    res = stat.executeQuery("select * from employee");
		    while(res.next())
		    {
			  System.out.print("\nEmp id = "+res.getInt(1));
			  System.out.print("\nEmp Name = "+res.getString(2));
			  System.out.print("\nEmp Salary = "+res.getFloat(3));
		    }
						break;
		  
		}
								
         }
 


}while(ch!=0);
}
}
