package ru.kpfu.ivmiit.apa;

import java.util.Iterator;

public class Polynom {
	private class Pair implements Comparable<Pair>{
		public int koef;
		public int pow;
		Pair(int koef, int pow){
			this.koef=koef;
			this.pow=pow;
		}
		@Override
		public int compareTo(Pair otherPair) {
			if(this.pow>otherPair.pow){
				return 1;
			}if(this.pow==otherPair.pow){
				return 0;
			}
			return -1;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return koef+"*x^"+pow;
		}
	}
	CustomList<Pair> list=new CustomList<>();
	public void readFromFile(String fileName){
		In in=new In(fileName);
		int[] nums = in.readAllInts();
		for(int i=0;i<nums.length;i=i+2){
			try{
				if(nums[i]!=0){
					Pair pair =new Pair(nums[i], nums[i+1]);
					list.add(pair);
				}
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Ошибка входных данных!");
			}
		}
	}
	public void sort(){
		Iterator<Pair> iterator=list.iterator();
		Iterator<Pair> iterator2=list.iterator();
		
		int index1=0;
		int index2=0;
		while(iterator.hasNext()){
			iterator2=list.iterator();
			index2=0;
			Pair pair=iterator.next();
			while(iterator2.hasNext()){
				Pair pair2=iterator2.next();
				if(pair.compareTo(pair2)<0){
					list.swap(index1, index2);
				}
				index2++;
			}
			
			index1++;
		}
	}
	public void shrink(){
		Iterator<Pair> iterator=list.iterator();
		Iterator<Pair> iterator2=list.iterator();
		int shift=1;
		int index;
		Pair pair1=null;
		Pair pair2=null;
		while(iterator.hasNext()){
			pair1=iterator.next();
			iterator2=list.iterator(shift);
			index=shift;
			shift++;
			while(iterator2.hasNext()){
				pair2=iterator2.next();
				if(pair2.compareTo(pair1)==0){
					pair1.koef+=pair2.koef;
					list.removeElement(index);
				}
				index++;
			}
		}
	}
	public void write(){
		Iterator<Pair> iterator=list.iterator();
		while(iterator.hasNext()){
			Pair p=iterator.next();
			System.out.println(iterator.hasNext()?p+"+":p);
		}
	}
	public static void main(String[] args) {
		Polynom poly=new Polynom();
		poly.readFromFile("input.txt");
		poly.shrink();
		poly.write();
		poly.sort();
		poly.write();
		
	}
	
}
