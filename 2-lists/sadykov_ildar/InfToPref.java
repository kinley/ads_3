

import java.util.Scanner;

public class InfToPref 
{
	
	static boolean isOp(String a)	//проверка - является ли символ знаком операции
	{
		if (a.equals("+")||a.equals("-")||a.equals("*")||a.equals("/")) return true;
		else return false;
	}
	static int getFirstOp(String s)
	{
		int n=s.length();
		int open=0,
			close=0,
			r = 0;
		String a;
		int fS=firstSkobka(s);
		for(int i=fS;i<n;i++)
		{
			a=s.charAt(i) + "";
			if (a.equals("(")) open++;
			if (a.equals(")")) close++;
			if (isOp(a)&&(open==close)) 
				{
				r=i;
				break;
				}
		}				
		return r;		// если 0 - нет подходящих операций, иначе -
	}					// первая операция, для которой 
						// число откр. и закр. скобок слева равны
	
	static int firstSkobka(String s)	//ищем первую открывающую скобку
	{
		int n=s.length(); 
		int fS=-1;
		String a;
		for (int i=0;i<n;i++)
		{
			a=s.charAt(i) + "";
			if (a.equals("(")) 
				{				
				fS=i;
				break;
				}
		} 
		return fS;
	}
	
	static int lastSkobka(String s, int r)	//r- операция, найденная в getFirstOp
	{
		int n=s.length();
		int open=0,
			close=0,
			l = 0;//return
		String a;
		for(int i=r+1;i<n;i++)
		{
			a=s.charAt(i) + "";
			if (a.equals("(")) open++;
			else
				if (a.equals(")")) close++;
			if(open==close)	
				{
				l=i;
				break;
				}
						
		}			
		return l;//последняя закрывающая скобка
	}
	
	 static String toPostfix(String s)
	{
		 String result = s;
		int fS=firstSkobka(s);			
		int r=getFirstOp(result);
		int ls=lastSkobka(result,r);
		while(fS!=-1)
		{
			int n=result.length();
			String temp = "";
			
			if(fS!=0)		temp=result.substring(0,fS);	
			
			if(fS+1<=r-1) 	temp=temp+result.substring(fS+1,r-1);

			if(r+2<=ls)		temp=temp+result.substring(r+2,ls);

			temp=temp+result.charAt(r);

			if(ls!=n-1) 	temp=temp+result.substring(ls+1);
			
			result=temp;
			
			fS=firstSkobka(result);
			if(fS!=-1)
			{
			r=getFirstOp(result);
			ls=lastSkobka(result,r);
			}
		}		
		return result;
	}
	
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter string: ");
		String s=in.nextLine();
		in.close();
		s=toPostfix(s);
		System.out.println("result= "+s);
	}
}
//правильные записи формул со скобками
//	(a)-(b)
//	(d)*(((a)+(b))-(c))
//	((a)+(b))*(c)
//	(((c)*((a)-(b)))-(d))/(((e)-(f))+(v))