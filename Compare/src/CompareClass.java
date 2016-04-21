public class CompareClass {
	
	int fir = 12;
	int res;
	
	public int testExcep(int div) {
		try{
			res = fir/div;
		}
		catch(ArithmeticException e)
		{
			return 5;
		}
		finally{
			System.out.println("finally executed");
		}
		return 10;
		
	}
	
	

	
}
