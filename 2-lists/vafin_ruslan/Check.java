import java.util.ArrayList;
import java.util.List;


public class Check {
	private static List<Integer> list;
	
	public static void main(String[] args){
		String s = StdIn.readString();
		StdOut.println(s.length());
		list = new ArrayList<Integer>();
		String s1;
		for(int i=0;i<s.length();i++){
			s1 = s.charAt(i) + "";
		    if (s1.equals("(")) {
		    	StdOut.println("(");
		    	list.add(0);
		    }
		    else if(s1.equals(")")){
		    	StdOut.println(")");
		    	list.add(1);
		    }
		    else if(s1.matches("[+-/*]")){
		    	StdOut.println("+");
		    	list.add(2);
		    }
		    else if(s1.matches("[a-z]")){
		    	StdOut.println("a");
		    	list.add(3);
		    }
		    else{
		    	StdOut.println("!!!Wrong expression!");
		    	return;
		    }
		}	
		while(check()){}
		if(list.size()==1 && list.get(0) == 3)
			StdOut.println("Correct expression");
		else
			StdOut.println("Wrong expression!");
	}
	
	private static boolean check(){
		boolean f = false;
		for(int i=0;i<list.size()-7;i++){
			if(list.get(i)==0)
				f = checkSequence(i);
		}
		return f; 
	}
	
	private static boolean checkSequence(int i){
		if(list.get(i+1)==3)
			if(list.get(i+2)==1)
				if(list.get(i+3)==2)
					if(list.get(i+4)==0)
						if(list.get(i+5)==3)
							if(list.get(i+6)==1){
								list.removeAll(list.subList(i, i+6));
								list.add(3);
								return true;
							}
		return false;
	}
}
