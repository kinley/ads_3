package domashka;

public class number4 {
	
	
	public static int nod(int x, int y)
	{
	    if (y == 0)
	    	return x;
	    return nod(y, x % y);
	}
	

	public static void main(String[] args) {
		
		System.out.println(nod(54,36));

	}

}
