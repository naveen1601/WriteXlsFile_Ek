import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class TestCompare {

	public static void main(String[] args) {
		int a1 = 10;
		int a2 = 15;
		int a3 = 8;
		int a4 = 12;
		int lastIndex;
		
		int a[] = {8,12,10,5,7};
		
		Arrays.sort(a);
		lastIndex = a.length -1;
		System.out.println("highest number "+a[lastIndex]);
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(a1);
		arr.add(a2);
		arr.add(a3);
		arr.add(a4);
		
		Collections.sort(arr);
		lastIndex = arr.size() -1;

		System.out.println("Highest number is "+arr.get(lastIndex));

		CompareClass cm = new CompareClass();
		
		System.out.println("Return value is "+cm.testExcep(0));
		System.out.println("Return value is "+cm.testExcep(3));
		
	}

}
