import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 测试输入中文字符的长度为2
 * @author db2admin
 *
 */
public class tes1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer();
        String ch="[\u0391-\uFFE5]";
        System.out.println("请输入信息：");
       BufferedReader str=new BufferedReader(new InputStreamReader(System.in));        
        String temp=str.readLine();
        
        System.out.println(temp);
        
//        Scanner sc=new Scanner(System.in);
//        System.out.println("请输入信息：");
//        String temp=sc.next();
        //String temp="你好12abc";
		if(temp.matches(ch)){
			buf.append(temp+" ");					
		}else{
			buf.append(temp);
		}
		int len=buf.toString().length();
		System.out.println(len);
        
        
        
	}

}
