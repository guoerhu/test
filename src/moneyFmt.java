import java.util.Scanner;


public class moneyFmt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner read=new Scanner(System.in);
		 System.out.println("金额格式化：");
		 System.out.println("请输入金额：");
		 String s = read.next();

		 String a[]= s.split("\\.");
		 int x=a[0].length() > 3 ? (a[0].length())%3 : 0;
		 //String s2 = a[0].substring(0,x)+","+a[0].substring(x);
		 StringBuffer bf =new StringBuffer();
		  bf.append(a[0].substring(0,x));
		 int n=a[0].substring(x).length()/3;
		 for(int i=0;i<n;){
			bf.append(",").append(a[0].substring(i,i+3));
			i+=3;
		 }
		 bf.append(".").append(a[1]);
		 System.out.println(bf.toString());
		 
	}

}
