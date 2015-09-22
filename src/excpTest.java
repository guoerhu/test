import java.util.Scanner;


public class excpTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		 Scanner sc1=new Scanner(System.in);
		 System.out.println("请输入信息：");
		 String input =sc1.next();

	    do{
			 
//         Scanner sc2=new Scanner(System.in);
//         System.out.println("请输入信息：");
		//	 int i=Integer.parseInt(input);
			 int i=Integer.valueOf(input);
			 
			 try { System.out.println("100/i="+100/i);
			 }
//		     catch (NumberFormatException e) {		
		     catch (ArithmeticException e) {		
			 //   e.printStackTrace();
		    	 System.out.println("除数为零");
	    	}
		    	 Scanner sc=new Scanner(System.in);
				 System.out.println("请输入信息：");
				 input =sc.next(); 
	   }while(input!="e");
 }
}
