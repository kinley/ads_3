package DZ;
import java.util.Random;

public class MergeSort {
	
	private static int[] aux;
	
	public static void sortDown(int[] array){
		
		aux= new int [array.length];
		sortDown(array,0,array.length-1);
		
	}
	
	private static void sortDown(int[] array, int low, int high){
		
		if(high<=low) return;
		int mid=low+(high-low)/2;
		sortDown(array,low,mid);
		sortDown(array,mid+1,high);
		merge(array,low,mid,high);
		
	}
	
	private static void sortUp(int[] array){
		
		int N=array.length;
		aux=new int [N];
		for (int sz=1;sz<N;sz=sz+sz)
			for(int low=0;low<N-sz;low+=sz+sz)
				merge(array,low,low+sz-1,Math.min(low+sz+sz-1, N-1));
		
	}
	
	
	private static void merge(int[] array,int low, int mid, int high){
		
		int i=low, j=mid+1;
		for(int k=low;k<=high;k++)
			aux[k]=array[k];
		for(int k=low;k<=high;k++)
			if(i>mid)
				array[k]=aux[j++];
			else 
				if(j>high)
					array[k]=aux[i++];
				else
					if(less(aux[j],aux[i]))
						array[k]=aux[j++];
					else
						array[k]=aux[i++];	
	}

	private static boolean less(Comparable a, Comparable b) {
		// TODO Auto-generated method stub
		return a.compareTo(b)<0;
	}
	
	//подсчет времени выполнения алгоритма
	public static long time(String name, int[] array){
		long startTime=0, endTime=0;
		
		if(name.equals("Down")){ 
			startTime = System.nanoTime();
			sortDown(array);
			endTime = System.nanoTime();
		}
		
		if(name.equals("Up")){
			startTime = System.nanoTime();
			sortUp(array);
			endTime = System.nanoTime();
		}
		
		return endTime-startTime;
	}
	
	//сравнение алгоритмов
	public static void compareAlgs(int n){
		long totalUp=0, totalDown=0;
		Random rand = new Random();
 		int [] a=new int[n];
		int [] b=new int[n];
		int k=100;
		for(int i=0;i<k;i++){
			for(int j=0;j<n;j++){
				a[j]=rand.nextInt();
				b[j]=a[j];
			}
				totalUp+=time("Up",a);
				totalDown+=time("Down",b);
		}
		
		totalUp=totalUp/k;
		totalDown=totalDown/k;
		
		System.out.println("Для " + n + " чисел:");
		if(totalUp>totalDown)
			System.out.println("Восходящая сортировка быстрее нисходящей в " + String.format("%.3f", (double)totalUp/totalDown) + " раз");
		else
			System.out.println("Нисходящая сортировка быстрее восходящей в " + String.format("%.3f", (double)totalDown/totalUp) + " раз");
		
	}
	
	public static void main(String[] args){
			for(int i=1000;i<=1000000;i=i*10)
			compareAlgs(i);
		
	}
}
