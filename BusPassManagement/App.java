
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        
      Scanner sc=new Scanner(System.in);
     int a=sc.nextInt();
     if(a==1){
        
     DbConnection.insertData();
     }
     else if(a==2){
        // System.out.println("Enter id:");
        // int id=sc.nextInt();
        // System.out.println("Name :");
        // String b=sc.nextLine();
        // sc.nextLine();
        // System.out.println("Phone :");
        // int c=sc.nextInt();
        // System.out.println("Address :");
        // String n=sc.nextLine();
        // sc.nextLine();
        // System.out.println("Source :");
        // String s=sc.nextLine();
      
        // System.out.println("Destination :");
        // String d=sc.nextLine();

      DbConnection.insertVar();
     }
     else if(a==3){
      DbConnection.updateData();
     }
     else if(a==4){
     DbConnection.deleteData();
     }
     else if(a==5){
     DbConnection.readData();
     }
    }
}
