
ayush gupta <guptaayush6122@gmail.com>
3:36 PM (0 minutes ago)
to me

import java.util.*;
import java.io.*;
import java.sql.*;

class Database
{
int displayAdminMenu()
{       System.out.println("\t\t\t\t\t\t\t+-----------------------------------------------------------------------------+");
       System.out.println("\t\t\t\t\t\t\t|..................................Menu.......................................|");  
System.out.println("\t\t\t\t\t\t\t+-----------------------------------------------------------------------------+");
       System.out.println("\t\t\t\t\t\t\t|                press 1: view all prospect record                            |");
System.out.println("\t\t\t\t\t\t\t|                press 2: show all record list by filter                      |");
System.out.println("\t\t\t\t\t\t\t|                press 3: add monitor with full customer details              |");
System.out.println("\t\t\t\t\t\t\t|                press 4: delete prospect records                             |");
System.out.println("\t\t\t\t\t\t\t|                press 5: change password                                     |");
System.out.println("\t\t\t\t\t\t\t|                press 6: add new admin                                       |");
System.out.println("\t\t\t\t\t\t\t|                press 7: show all monitor                                    |");
System.out.println("\t\t\t\t\t\t\t|                press 8: deactivate account                                  |");
System.out.println("\t\t\t\t\t\t\t|                press 9: orderby all record                                  |");
System.out.println("\t\t\t\t\t\t\t|                press 10: exit or logout                                     |");
System.out.println("\t\t\t\t\t\t\t+-----------------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t|                Enter ur choice:                                             |");
System.out.println("\t\t\t\t\t\t\t+-----------------------------------------------------------------------------+");
System.out.println("Enter ur choice:");
Scanner s=new Scanner(System.in);
int val=Integer.parseInt(s.nextLine());
return val;

}
















int displayy()
{   System.out.println("\t\t\t\t\t\t\t\t\t+--------------------------------------------------+");
   System.out.println("\t\t\t\t\t\t\t\t\t|.....................Menu.........................|");                    //System.out.println(" ") is used  for print menu after filter option show this four options
   System.out.println("\t\t\t\t\t\t\t\t\t|              press 1: list by hotness            |");
   System.out.println("\t\t\t\t\t\t\t\t\t|              press 2: list by model              |");
   System.out.println("\t\t\t\t\t\t\t\t\t|              press 3: list by date               |");
   System.out.println("\t\t\t\t\t\t\t\t\t|              press 4: list by monitor            |");
   System.out.println("\t\t\t\t\t\t\t\t\t+--------------------------------------------------+");
   System.out.println("\t\t\t\t\t\t\t\t\t|              Enter ur choice:                    |");
   System.out.println("\t\t\t\t\t\t\t\t\t+--------------------------------------------------+");
   System.out.println("Enter ur choice:");
Scanner s=new Scanner(System.in);
int val=Integer.parseInt(s.nextLine());
return val;

}










int displayyy()
{
System.out.println("\t\t\t\t\t\t\t\t\t+-----------------------------------------------------+");
   System.out.println("\t\t\t\t\t\t\t\t\t|.....................Menu............................|"); //System.out.println(" ") is used  for print menu after filter option show this four options
System.out.println("\t\t\t\t\t\t\t\t\t+-----------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t\t|            press 1: order by  date  asc             |");
System.out.println("\t\t\t\t\t\t\t\t\t|            press 2: order by  date  desc            |");
System.out.println("\t\t\t\t\t\t\t\t\t|            press 3: order by  id  asc               |");
System.out.println("\t\t\t\t\t\t\t\t\t|            press 4: order by  id  desc              |");
System.out.println("\t\t\t\t\t\t\t\t\t|            press 5: order by  monitor  asc          |");
System.out.println("\t\t\t\t\t\t\t\t\t|            press 6: order by  monitor  desc         |");
System.out.println("\t\t\t\t\t\t\t\t\t|            press 7: order by  name  asc             |");
System.out.println("\t\t\t\t\t\t\t\t\t|            press 8: order by  name  desc            |");
System.out.println("\t\t\t\t\t\t\t\t\t+-----------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t\t|            Enter ur choice:                         |");
System.out.println("\t\t\t\t\t\t\t\t\t+-----------------------------------------------------+");
System.out.println("Enter ur choice:");
Scanner s=new Scanner(System.in);
int val=Integer.parseInt(s.nextLine());
return val;

}








void orderby(int choice,Connection con) throws Exception
{
int choice6=displayyy();
try
{
switch(choice6) {
    case 1:
    orderbyasc(con);
    break;
    case 2:
    orderbydesc(con);
    break;
    case 3:
    orderbyidasc(con);
    break;
    case 4:
    orderbyiddesc(con);
    break;
    case 5:
    orderbymonitorasc(con);
break;
    case 6:
    orderbymonitordesc(con);
    break;
case 7:
    orderbynameasc(con);
    break;
case 8:
    orderbynamedesc(con);
    break;
  default:
     System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
     System.out.println("\t\t\t\t\t\t\t\t|                        invalid input                                 |");
     System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
int choice1=displayAdminMenu();
adminMenu(choice1,con);

}
}
catch(Exception e3)
{
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                     failed order by                                  |");
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
int choice8=displayAdminMenu();
adminMenu(choice8, con);
}

}







void orderbynameasc(Connection con)  throws Exception
{
String query="select * from prospect order by name ASC";

Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
  while(rs.next()){
   
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));

       
}
int choice=displayAdminMenu();
 
adminMenu(choice,con);
}











void orderbynamedesc(Connection con)  throws Exception


{
String query="select * from prospect order by name DESC";

Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
  while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
}
int choice=displayAdminMenu();
 
adminMenu(choice,con);
}








void orderbyidasc(Connection con)  throws Exception
{
String query="select * from prospect order by id ASC";

Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
  while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
}
int choice=displayAdminMenu();
 
adminMenu(choice,con);
}








void orderbyiddesc(Connection con)  throws Exception
{
String query="select * from prospect order by id DESC";

Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
  while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
}
int choice=displayAdminMenu();
 
adminMenu(choice,con);
}









void orderbymonitorasc(Connection con)  throws Exception
{
String query="select * from prospect order by monitor ASC";

Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
  while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
}
int choice=displayAdminMenu();
 
adminMenu(choice,con);
}








void orderbymonitordesc(Connection con)  throws Exception
{
String query="select * from prospect order by monitor DESC";

Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
  while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
}
int choice=displayAdminMenu();
 
adminMenu(choice,con);
}





void orderbyasc(Connection con)  throws Exception
{
String query="select * from prospect order by date ASC";

Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
  while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
}
int choice=displayAdminMenu();
 
adminMenu(choice,con);
}










void orderbydesc(Connection con) throws Exception
{
String query="select * from prospect order by date DESC";

Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
  while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
}
int choice=displayAdminMenu();
 
adminMenu(choice,con);
}




void deleteprospect(Connection con) throws Exception                                            //delete data row from table
{
Scanner sc=new Scanner(System.in);
System.out.println("enter id:");
String input=sc.nextLine();
String query="delete from prospect where id="+input+"";
Statement st=con.createStatement();
   int result=st.executeUpdate(query);
    String  query1 = "SELECT * from prospect where id="+input+"";
      ResultSet rs = st.executeQuery(query1);
  if(result>0)
  {
  while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
}
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                delete successful from prospect                       |");
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
int choice=displayAdminMenu();
 
adminMenu(choice,con);
  }
else
{
       System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|         delete unsuccessful from prospect or does't exist            |");
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
int choice=displayAdminMenu();
 
adminMenu(choice,con);
}
}





void filter(int choice1,Connection con) throws Exception
{
int choice=displayy();
try
{
switch(choice) {
  case 1:
    filterhotness(con);
    break;
    case 2:
    filtermodel(con);
    break;
case 3:
    filterdate(con);
    break;
   case 4:
   filtermonitor(con);
    break;
  default:
     System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
     System.out.println("\t\t\t\t\t\t\t\t|                      invalid input                                   |");
     System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
int choice20=displayAdminMenu();
     adminMenu(choice20,con);
}
}
catch(Exception e)
{
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                     failed list by filter                            |");
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
int choice21=displayAdminMenu();
 
adminMenu(choice21,con);
}


}






void filterhotness(Connection con) throws Exception
{
Scanner sc=new Scanner(System.in);
System.out.println("enter hotness :");
        String input=sc.nextLine();
String query="SELECT * FROM  prospect WHERE  hotness = '"+input+"'";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
}
int choice=displayAdminMenu();
 
adminMenu(choice,con);

 
}













void filtermodel(Connection con)throws Exception
{
Scanner sc=new Scanner(System.in);
System.out.println("enter model :");
        String input=sc.nextLine();
String query="SELECT * FROM  prospect WHERE  model= '"+input+"'";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
}

int choice=displayAdminMenu();
 
adminMenu(choice,con);

}














void filterdate(Connection con)throws Exception
{
Scanner sc=new Scanner(System.in);
System.out.println("enter date :");
        String input=sc.nextLine();
String query="SELECT * FROM  prospect WHERE  date = '"+input+"'";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
}

int choice=displayAdminMenu();
 adminMenu(choice,con);



}






void loopMenu(int choice,Connection con)  throws Exception
{
try
{
switch(choice)
{
  case 1:
    show(con);
    break;
  case 2:
  filter(choice, con);
    break;
case 3:
try
{
    prospect(con);
}
catch(Exception e1)
{
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|           Registration failed because id is already exist            |");
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
int choice3=displayAdminMenu();
adminMenu(choice3,con);
}

    break;
case 4:
   deleteprospect(con);
    break;
case 5:
   updatepassword(con);
    break;
case 6:
try{
   addadmin(con);
}
catch(Exception e)
{
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------------------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                    admin Registration failed or this  id is already rgistered plz try with other id                 |");
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------------------------------------------------------------------------------+ \n\n");
int choice1=displayAdminMenu();
 
        adminMenu(choice1,con);
}
    break;
case 7:
   allmonitor(con);
    break;
case 8:
   deactivate(con);
    break;
case 9:
orderby(choice, con);
    break;
case 10:
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------+");
    System.out.println("\t\t\t\t\t\t\t\t|       exit or logout successfully            |");
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------+ \n\n");
    break;
  default:
  System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
  System.out.println("\t\t\t\t\t\t\t\t|           select invalid option please try again                     |");
  System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
  int choice17=displayAdminMenu();
  adminMenu(choice17, con);
}
}
catch(Exception e1)
{
 System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
 System.out.println("\t\t\t\t\t\t\t\t|    invalid input string because accept numeric option only           |");
 System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
  int choice11=displayAdminMenu();
adminMenu(choice11, con);
}
}




void adminMenu(int choice,Connection con) throws Exception
{
try
{
switch(choice) {
  case 1:
    show(con);
    break;
  case 2:
  filter(choice, con);
    break;
case 3:
try
{
    prospect(con);
}
catch(Exception e1)
{
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|           Registration failed because id is already exist            |");
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
int choice3=displayAdminMenu();
adminMenu(choice3,con);
}

    break;
case 4:
   deleteprospect(con);
    break;
case 5:
   updatepassword(con);
    break;
case 6:
try{
   addadmin(con);
}
catch(Exception e)
{
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------------------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                    admin Registration failed or this  id is already rgistered plz try with other id                 |");
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------------------------------------------------------------------------------+ \n\n");
int choice1=displayAdminMenu();
 
        adminMenu(choice1,con);
}
    break;
case 7:
   allmonitor(con);
    break;
case 8:
   deactivate(con);
    break;
case 9:
orderby(choice, con);
    break;
case 10:
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------+");
    System.out.println("\t\t\t\t\t\t\t\t|       exit or logout successfully            |");
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------+ \n\n");
    break;
    default:
    System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
    System.out.println("\t\t\t\t\t\t\t\t|           select invalid option please try again                     |");
    System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
    int choice17=displayAdminMenu();
    adminMenu(choice17, con);
  }
  }
  catch(Exception e1)
  {
   System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
   System.out.println("\t\t\t\t\t\t\t\t|    invalid input string because accept numeric option only           |");
   System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
    int choice11=displayAdminMenu();
  adminMenu(choice11, con);
  }
}










void filtermonitor(Connection con)throws Exception
{
Scanner sc=new Scanner(System.in);
System.out.println("enter monitor :");
        String input=sc.nextLine();
String query="SELECT * FROM  prospect WHERE  monitor= '"+input+"'";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
}
int choice=displayAdminMenu();
 
adminMenu(choice,con);

}




void addadmin(Connection con) throws Exception
{

Scanner sc=new Scanner(System.in);
System.out.println("enter email :");
String email=sc.nextLine();
System.out.println("enter password :");
String password=sc.nextLine();
System.out.println("enter username :");
String username=sc.nextLine();
System.out.println("enter date of registration :");
String dateofregistration=sc.nextLine();
System.out.println("enter id :");
int id=Integer.parseInt(sc.nextLine());
String query="insert into admin values('"+email+"','"+password+"','"+username+"','"+dateofregistration+"',"+id+")";
Statement st=con.createStatement();
int result=st.executeUpdate(query);
    String  query1 = "SELECT * from admin where  id="+id+"";
      ResultSet rs = st.executeQuery(query1);
if(result>0)
{
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                     admin add Successful                             |");
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");

  while(rs.next())
  {
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t\t\t\t"+rs.getString(2)+"\t\t\t\t"+rs.getString(3)+"\t\t\t\t"+rs.getString(4)+"\t\t\t\t"+rs.getString(5));
System.out.println("\n\n");
}


}
else
{
System.out.println("\t\t\t\t\t\t\t\t+-----------------------------------------------------------------------------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                       admin Registration failed or this  id is already rgistered plz try with other id                                  |");
System.out.println("\t\t\t\t\t\t\t\t+-----------------------------------------------------------------------------------------------------------------------------------------+ \n\n");
}


int choice=displayAdminMenu();
 
adminMenu(choice,con);


}










void allmonitor(Connection con) throws Exception
{

String query="select monitor from prospect";

Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
  while(rs.next()){
System.out.println(rs.getString(1));
}
int choice=displayAdminMenu();
 
adminMenu(choice,con);

}







void forgotpassword(Connection con) throws Exception
{
//login(con);
Scanner s=new Scanner(System.in);
System.out.println("enter your email");
String e=s.next();
System.out.println("enter your id");
int idd=s.nextInt();
System.out.println("enter new your password");
String password=s.next();
String query ="update admin SET password='"+password+"' where email='"+e+"'AND id="+idd+"";
Statement st=con.createStatement();
   int result=st.executeUpdate(query);
    String  query1 = "SELECT * from admin where  id="+idd+"";
      ResultSet rs = st.executeQuery(query1);
if(result>0)
{
  while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
}
System.out.println("\t\t\t\t\t+----------------------------------------------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t|                     reset password successfull then you can access database                              |");
System.out.println("\t\t\t\t\t+----------------------------------------------------------------------------------------------------------+ \n\n");
int choice=displayAdminMenu();
adminMenu(choice,con);
 }
 else
 {
System.out.println("\t\t\t\t\t\t\t+------------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t|                   reset password unsuccessfull                         |");
System.out.println("\t\t\t\t\t\t\t+------------------------------------------------------------------------+ \n\n");
 }
 }






void updatepassword(Connection con) throws Exception
{
//login(con);
Scanner s=new Scanner(System.in);
System.out.println("enter your email");
String e=s.next();
System.out.println("enter your id");
int idd=s.nextInt();
System.out.println("enter new your password");
String password=s.next();
String query ="update admin SET password='"+password+"' where email='"+e+"'AND id="+idd+"";
Statement st=con.createStatement();
   int result=st.executeUpdate(query);
    String  query1 = "SELECT * from admin where  id="+idd+"";
      ResultSet rs = st.executeQuery(query1);
if(result>0)
{
  while(rs.next()){
System.out.println("\t\t\t\t\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
}
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                     update successfull                               |");
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
int choice=displayAdminMenu();
 
adminMenu(choice,con);
 }
 else
 {
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                   update unsuccessfull                               |");
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
int choice=displayAdminMenu();
 
adminMenu(choice,con);
 }
 }







void prospect(Connection con) throws Exception
{

Scanner sc=new Scanner(System.in);
System.out.println("enter id :");
int id=Integer.parseInt(sc.nextLine());
System.out.println("enter name :");
String name=sc.nextLine();
System.out.println("enter phone :");
String phone=sc.nextLine();
System.out.println("enter model:");
String model=sc.nextLine();
System.out.println("enter color :");
String color=sc.nextLine();
System.out.println("enter date:");
String date=sc.nextLine();
System.out.println("enter varient:");
String varient=sc.nextLine();
System.out.println("enter monitor:");
String monitor=sc.nextLine();
//String query="create table monitor(id int primary key,username varchar(30),password varchar(30),mobile varchar(12))";
String query="insert into prospect values("+id+", '"+name+"','"+phone+"','"+model+"','"+color+"','"+date+"','"+varient+"','"+monitor+"')";
//String query="update student set email='amit@yahoo.com' where id=1002";
//String query="alter table student add column admissionnumber int";
//String query="alter table student drop column admissionnumber ";
//String query="select from student where id=1011";
//String query="delete from student where id=1018";
Statement st=con.createStatement();
int result=st.executeUpdate(query);
if(result>0)
{
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                   Registration Successful                            |");
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
}
else
{
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                    Registration failed                               |");
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
}
int choice=displayAdminMenu();
  adminMenu(choice,con);
}










void show(Connection con) throws Exception {

String query ="select * from prospect";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
while(rs.next())
{  
    System.out.println("\t\t\t\t\t"+rs.getString(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6)+ "\t\t" + rs.getString(7)+ "\t\t" + rs.getString(8));
}
int choice=displayAdminMenu();
 
adminMenu(choice,con);
 
}








 void admin(Connection con) throws Exception
 {
Scanner sc=new Scanner(System.in);
System.out.println("enter email :");
String email=sc.nextLine();
System.out.println("enter password :");
String password=sc.nextLine();
System.out.println("enter your name :");
String username=sc.nextLine();
System.out.println("enter date of registration :");
String dateofregistration=sc.nextLine();
System.out.println("enter id :");
int id=Integer.parseInt(sc.nextLine());
//String query="create table monitor(id int primary key,username varchar(30),password varchar(30),mobile varchar(12))";
String query="insert into admin values('"+email+"','"+password+"','"+username+"','"+dateofregistration+"',"+id+")";
//String query="update student set email='amit@yahoo.com' where id=1002";
//String query="alter table student add column admissionnumber int";
//String query="alter table student drop column admissionnumber ";
//String query="select from student where id=1011";
//String query="delete from student where id=1018";
Statement st=con.createStatement();
int result=st.executeUpdate(query);
if(result>0)
{
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                  Registration Successful in admin                    |");
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
}
else
{
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------------------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                 Registration failed already used this id in admin or plz use other id                               |");
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------------------------------------------------------------------------------+ \n\n");
}
int choice=displayAdminMenu();
 
adminMenu(choice,con);
 

}



 
 
 
 
 








void login(Connection con) throws Exception
{
@SuppressWarnings("resource")
Scanner s=new Scanner(System.in);
System.out.println("enter your registered  email");
String e=s.next();
System.out.println("enter your registered password");
String password1=s.next();
String query ="select * from admin where password='"+password1+"' AND email='"+e+"'";
     Statement st=con.createStatement();
ResultSet  rs=st.executeQuery(query);
     int rowCount = rs.last() ? rs.getRow() : 0 ;
  if(rowCount>0)
  {
 System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------+");
 System.out.println("\t\t\t\t\t\t\t\t|                  Login successful                        |");
 System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------+ \n\n");
 
 
   int choice=displayAdminMenu();
   try
{
switch(choice) {
  case 1:
    show(con);
    break;
  case 2:
  filter(choice, con);
    break;
case 3:
try
{
    prospect(con);
}
catch(Exception e1)
{
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|         Registration failed because id is already exist              |");
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
int choice3=displayAdminMenu();
adminMenu(choice3,con);
}

    break;
case 4:
   deleteprospect(con);
    break;
case 5:
   updatepassword(con);
    break;
case 6:
try{
   addadmin(con);
}
catch(Exception e1)
{
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------------------------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                    admin Registration failed or this  id is already rgistered plz try with other id                 |");
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------------------------------------------------------------------------------+ \n\n");
int choice1=displayAdminMenu();
 
        adminMenu(choice1,con);
}
    break;
case 7:
   allmonitor(con);
    break;
case 8:
   deactivate(con);
    break;
case 9:
orderby(choice, con);
    break;
case 10:
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t|       exit or logout successfully           |");
System.out.println("\t\t\t\t\t\t\t\t+---------------------------------------------+ \n\n");
    break;
  default:
 System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
   System.out.println("\t\t\t\t\t\t\t\t|           select invalid option please try again                     |");
   System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
   int choice17=displayAdminMenu();
   adminMenu(choice17, con);
 }
  }
  catch(Exception e1)
  {
   System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
   System.out.println("\t\t\t\t\t\t\t\t|    invalid input string because accept numeric option only           |");
   System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
    int choice11=displayAdminMenu();
    adminMenu(choice11,con);
  }

  }
  else
  {  
      System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
 System.out.println("\t\t\t\t\t\t\t\t|           Not Registered..Please make registration first             |");
 System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
 
  }
 

}








void deactivate(Connection con) throws Exception
{

Scanner sc=new Scanner(System.in);
System.out.println("enter id:");
String input=sc.nextLine();
String query="delete from admin where id="+input+"";
Statement st=con.createStatement();
   int result=st.executeUpdate(query);
    String  query1 = "SELECT * from admin where  id="+input+"";
      ResultSet rs = st.executeQuery(query1);
if(result>0)
{
  while(rs.next()){
System.out.println("\t\t\t\t\t"+rs.getString(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getString(4)+"\t\t\t"+rs.getString(5));
}
System.out.println("\t\t\t\t\t\t\t\t+-------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|       deactivate account successfull      |");
System.out.println("\t\t\t\t\t\t\t\t+-------------------------------------------+ \n\n");
int choice=displayAdminMenu();
 
adminMenu(choice,con);
}
else
{
       System.out.println("\t\t\t\t\t\t\t\t+-------------------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|       deactivate account unsuccessfull or does't exist      |");
System.out.println("\t\t\t\t\t\t\t\t+-------------------------------------------------------------+ \n\n");
int choice=displayAdminMenu();
 
adminMenu(choice,con);
}
}
}














class Test
{
public static void main(String[] args) throws Exception
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/project";
String username="root";
String password="kdl32w700b";
 Connection con= DriverManager.getConnection(url,username,password);
Test t=new Test();
int choice=t.display();
Database obj=new Database();
try
{
switch(choice)
{
  case 1:
    obj.login(con);
break;
  case 2:
 try{
 obj.admin(con);
 }
 catch(Exception e)
 {
 System.out.println("\t\t\t\t\t\t\t\t+------------------------------------------------------------------------------------------------------+");
 System.out.println("\t\t\t\t\t\t\t\t|               Registration failed already used this id in admin or plz use other id                  |");
 System.out.println("\t\t\t\t\t\t\t\t+------------------------------------------------------------------------------------------------------+ \n\n");
 }
    break;
case 3:
obj.forgotpassword(con);
break;
case 4:
System.out.println("\t\t\t\t\t\t\t\t+-----------------------------------------------------+");
    System.out.println("\t\t\t\t\t\t\t\t|              exit successfully                      |");
System.out.println("\t\t\t\t\t\t\t\t+-----------------------------------------------------+");
    break;
  default:
 System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
 System.out.println("\t\t\t\t\t\t\t\t|           select invalid option please try again                     |");
 System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
}

}
catch(Exception e)
{
System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+");
 System.out.println("\t\t\t\t\t\t\t\t|    invalid input string because accept numeric option only           |");
 System.out.println("\t\t\t\t\t\t\t\t+----------------------------------------------------------------------+ \n\n");
 int choice11=obj.displayAdminMenu();
obj.adminMenu(choice11, con);
}
}

int display()
{
System.out.println("\t\t\t\t\t\t\t\t+-----------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|   **********  WELCOME TO OUR SHOWROOM  **********   |");
System.out.println("\t\t\t\t\t\t\t\t+-----------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|   **********  ADMIN LOGIN/SIGNUP PAGE  **********   |");
System.out.println("\t\t\t\t\t\t\t\t+-----------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|               Press 1 for Login                     |");
System.out.println("\t\t\t\t\t\t\t\t|               Press 2 for Registration              |");
System.out.println("\t\t\t\t\t\t\t\t|               Press 3 forgot password               |");
System.out.println("\t\t\t\t\t\t\t\t|               press 4 exit or logout                |");
System.out.println("\t\t\t\t\t\t\t\t+-----------------------------------------------------+");
System.out.println("\t\t\t\t\t\t\t\t|                Enter ur choice:                     |");
System.out.println("\t\t\t\t\t\t\t\t+-----------------------------------------------------+");

System.out.println("Enter ur choice:");
Scanner s=new Scanner(System.in);
int val=Integer.parseInt(s.nextLine());
return val;

}


}
