import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class FileTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String str="aff977年";
		System.out.println(str.length());
		String inPath="D:/a.txt";
		String outPath="D:/b.txt";
		File file3= new File(inPath);
		file3.delete();
//		if(!file3.exists()){
//		    file2.delete();
//			file3.createNewFile();
//		}
		
//		FileWriter fw =new FileWriter(file3,true);//加true是在文件后追加
		FileOutputStream os1 = new FileOutputStream(file3);
		OutputStreamWriter fw =new OutputStreamWriter(os1);
		fw.write(str);
		fw.flush();
		fw.close();
		System.out.println(file3.length());
		
		copyfile(inPath,outPath);
		
		File file= new File(outPath);
		
		//FileReader reader = new FileReader(file);
		//字符流
		System.out.println(file.length());
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader reader =new InputStreamReader(fis);
		StringBuffer sb =new StringBuffer();
		int length;
		while((length=reader.read())!=-1){
			sb.append((char)length);
		}
		System.out.println(sb.toString());
		//字节流
//		int i =fis.available();
//		System.out.println("fis.available():"+i);
//		byte[] b = new byte[1]; 
//		int length;
//		while((length=reader.read())!=-1){
//			sb.append(length);
//			sb.append((char)length);
//		}
	}

	private static void copyfile(String inPath, String outPath) throws IOException {

		File file= new File(inPath);
		File file2= new File(outPath);
		
//		if(!file2.exists()){
//			file2.delete();
//			file2.createNewFile();
//		}
		System.out.println("file.length():"+file.length());
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream  bis =new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream(file2);
		BufferedOutputStream  bos =new BufferedOutputStream(fos);
		
		byte[] bytes = new byte[1024];
		int i =fis.available();
		System.out.println("fis.available():"+i);
        //byte[] bytes = new byte[i];
		int length;
		while((length=fis.read(bytes))!=-1){
			System.out.println("length:"+length);
			fos.write(bytes,0,length);
		}
		fis.close();
		fos.close();
//		while((length=bis.read(bytes))!=-1){
//			System.out.println("length:"+length);
//			bos.write(bytes,0,length);
//		}
//		bis.close();
//		bos.close();
	}

}
