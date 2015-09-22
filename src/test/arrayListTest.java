package test;

import java.util.ArrayList;
import java.util.Arrays;

public class arrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c","d"));
	       System.out.println(list);
	        for(int i=0;i<list.size();i++){
	        	System.out.println("i"+i);
	        	list.remove(i);
	            System.out.println(list.size());
	        }
	        System.out.println(list);
	        
	        
	        ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("a","b","c","d"));
	        for(String s:list1){
	            if(s.equals("a")){
	                list1.remove(s);
	            }
	        } 
	        
//	        .next()必须在.remove()之前调用。在一个foreach循环中，编译器会使.next()在删除元素之后被调用，
//	        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("a","b","c","d"));
//	        java.util.Iterator<String> iter = list2.iterator();
//	        while(iter.hasNext()){
//	                String s = iter.next();
//	                if(s.equals("a")){
//	                    iter.remove();
//	            }
//	        }
	        
	}
	
}
