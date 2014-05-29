
public class main_algorithm {
	
	private static boolean equals(avtomat M1, avtomat M2) {
		 
		list spisok = new list();
		structure nabor = new structure();
		nabor.init(M1.S, M2.S);
		
		array tmp1=nabor.find_state(M1.s0);
		array tmp2=nabor.find_state(M2.s0);
		
		spisok.push(tmp1,tmp2);
		
		while(!spisok.isEmpty())
		{
			para temp_para=spisok.pop();
			
			tmp1=temp_para.s1;
			tmp2=temp_para.s2;
			array A1=nabor.find(tmp1);
			array A2=nabor.find(tmp2);
			if(A1!=A2)
			{
				nabor.union(A1,A2);
				int k;
				for(k=0; k<M1.S.length; k++)	//ищем индекс состояния tmp1
					{
					if(M1.S[k]==tmp1.state) break;
					}
				int l;
				for(l=0; l<M2.S.length; l++)	//ищем индекс состояния tmp2
				{
				if(M2.S[l]==tmp2.state) break;
				}
				int m=M1.I.length;
				for(int i=0; i<m; i++)
					{
						tmp1=nabor.find_state(M1.d[i][k]);
						tmp2=nabor.find_state(M2.d[i][l]);
						spisok.push(tmp1, tmp2);
					}	
			}			
		}
		boolean equals=true;
		
		array temp=nabor.first;
		//далее - проверка на вхождение в каждый класс 
		//эквивалентности допускающих и не допускающих состояний
		while(temp!=null && equals)
		{
			boolean F,T;		
			array tmp=temp;
			T=ExistsInF(tmp.state, M1.F, M2.F); 
			tmp=tmp.next;
			while(tmp!=null)
			{
				F=ExistsInF(tmp.state, M1.F, M2.F);
				if((T && !F) || (!T && F) ) 
				{
					equals=false; break;
				}
				tmp=tmp.next;
			}	
			temp=temp.next_array;
		}
		return equals;
		
	}
	
	////////////////////////////////////
	
	private static boolean ExistsInF(int state, int[] f, int[] f2) 
	{
		//System.out.println("?");
		for(int i=0; i<f.length; i++)
		{
			if(state==f[i]) return true;
		}
		for(int i=0; i<f2.length; i++)
		{
			if(state==f2[i]) return true;
		}		
		//System.out.println("?");
		return false;
	}
	
	public static void main(String[] args)
	{
		//множества состояний A1 и A2 не должны пересекаться!
		//множества входных состояний A1 и А2 должны быть одинаковыми
		//иначе все будет плохо
		
		//эквивалентны
		
		avtomat A1=new avtomat();
		avtomat.createFromFile(A1,"A1.txt");
		avtomat B1=new avtomat();
		avtomat.createFromFile(B1,"B1.txt");		
				//можно использовать 
				//create(A1); 
				//create(A2);
		System.out.println("A1 equals B1:" + equals(A1,B1));
		
		////////////////////////////////////////////
		
		//эквивалентны
		
		avtomat A2=new avtomat();
		avtomat.createFromFile(A2,"A2.txt");
		
		avtomat B2=new avtomat();
		avtomat.createFromFile(B2,"B2.txt");		
		
		System.out.println("A2 equals B2:" + equals(A2,B2));
		
		////////////////////////////////////////////
		
		//не эквивалентны
		
		avtomat A3=new avtomat();
		avtomat.createFromFile(A3,"A3.txt");
		avtomat B3=new avtomat();
		avtomat.createFromFile(B3,"B3.txt");
		System.out.println("A3 equals B3:" + equals(A3,B3));
		////////////////////////////////////////////
	
		//для проверки автоматов: если эквивалентны, то одна и та же строка будет принадлежать языкам обоих автоматов
		A1.show();
		A1.run();
		B1.show();
		B1.run();
		
		//четное число нулей принадлежит, нечетное - нет
		A2.show();
		A2.run();
		B2.show();
		B2.run();
		
		
		//02102010 - одному принадлежит, другому - нет
		A3.show();
		A3.run();
		B3.show();
		B3.run();
		
	}

	


	
	
}
