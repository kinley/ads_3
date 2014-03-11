package ru.kpfu.ivmiit;

public class ArrayWriter {
	private final int WIDTH = 10;
	private final int HEIGHT = 10;
	private final char TRUE_SYMBOL = '*';
	private final char FALSE_SYMBOL = ' ';
	private boolean[][] logicArray=new boolean[WIDTH][HEIGHT];

	private void fillArray(){
		for(int i=0; i<WIDTH;i++){
			for(int j=0;j<HEIGHT;j++){
				logicArray[i][j]=Math.random()>0.5?true:false;
			}
		}
	}
	private void writeArray(){
		System.out.print("   ");
		for(int i=0;i<WIDTH;i++){
			System.out.print(i+1+" ");
		}
		System.out.println();
		for(int i=0; i<WIDTH;i++){
			System.out.print(i+1+"  ");
			for(int j=0;j<HEIGHT;j++){
				System.out.print(logicArray[i][j]?TRUE_SYMBOL+" ":FALSE_SYMBOL+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ArrayWriter writer=new ArrayWriter();
		writer.fillArray();
		writer.writeArray();
	}
	
}
