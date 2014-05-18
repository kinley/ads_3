import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

public class Main {
	
	
public static int[][] create_array_dostig(Vector<Orgraph> vec)
{
	int n=vec.size();
	int[][] R=new int[n][n];
	int i, j;
	for(i=0; i<n; i++)
		for(j=0; j<n; j++)
		R[i][j]=0;
	
	for(i=0; i<n; i++)
	{
		Orgraph q=vec.elementAt(i);
		Orgraph.Element p=q.first;
		
		while(p!=null)
		{
			int r=p.versh;
			R[i][r-1]=1;
			p=p.next;
		}	
		
	}
	for(i=0; i<n; i++)
		R[i][i]=1;
	
	return R; //матрица достижимости
    
}


public static int[][] create_array_contrdostig(int[][] R, int vec_size)
{
	int[][] Q=new int[vec_size][vec_size];
	int i, j;
	for(i=0; i<vec_size; i++)
		for(j=0; j<vec_size; j++)
			Q[i][j]=0;
	
	for(i=0; i<vec_size; i++)
	for(j=0; j<vec_size; j++)
		Q[i][j]=R[j][i]; //транспонирование матрицы/ получили матрицу контрдостижимости
	
	return Q;
	
}


public static int[][] create_array_vzaimodostig(int[][] R, int[][] Q, int vec_size)
{
	int[][] H=new int[vec_size][vec_size];
	int i, j;
	for(i=0; i<vec_size; i++)
		for(j=0; j<vec_size; j++)
			H[i][j]=0;
	
	for(i=0; i<vec_size; i++)
		for(j=0; j<vec_size; j++)
			if(R[i][j]==1 && Q[i][j]==1)
				H[i][j]=1;  //создали матрицу взаимодостижимоси
	
	return H;
}

public static void show_array(int[][] R, int vec_size)
{
	int i, j;
	for(i=0; i<vec_size; i++)
	{
		for(j=0; j<vec_size; j++)
			System.out.print(R[i][j]+" ");
		System.out.println();
	}
}

public static void StrConnComp(int[][] H, int size)
{
	int i=0;
	int j=0;
	int t=0;
	int count =1;
	System.out.println("—ильно св€зные компоненты данного графа:");
	while(i<size)
	{
		j=i;

		while(j!=size && H[i][j]!=0)
			{t++; j++;}
		
		System.out.print(count+") ");
		
		for(j=i; j<t+i; j++)
			System.out.print(j+1+" ");
		System.out.println();
		
		i+=t;
		t=0;
		count++;
		
	}
	
	
}
	
	

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner=new Scanner(new FileReader("src/input0.txt"));
		
		Vector<Orgraph> MyVector=new Vector<Orgraph>();
		int i=0;
		int t=0;

while(scanner.hasNextLine())
{
	t=scanner.nextInt();//вершина графа
	System.out.println(t);
	
	Orgraph org=new Orgraph(t);
	MyVector.addElement(org);
	t=scanner.nextInt();
	while(t!=-1)
	{
		MyVector.elementAt(i).insert(t);
		t=scanner.nextInt();
	}
	
	i++;
	
}
	
		scanner.close();
		
		for(i=0; i<MyVector.size(); i++)
		{
		MyVector.elementAt(i).show();
		System.out.println();
		}
		
		int[][] R=new int[MyVector.size()][MyVector.size()];
		R=create_array_dostig(MyVector);
		
		show_array(R, MyVector.size());
		
		System.out.println();
		
		int[][] Q=new int[MyVector.size()][MyVector.size()];
		Q=create_array_contrdostig(R, MyVector.size());
		show_array(Q, MyVector.size());
		
		System.out.println();
		
		int[][] H=new int[MyVector.size()][MyVector.size()];
		H=create_array_vzaimodostig(R, Q, MyVector.size());
		show_array(H, MyVector.size());
		
		System.out.println();
		StrConnComp(H, MyVector.size());

	}

	


}
