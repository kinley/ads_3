package zadanie0;

import java.awt.Component;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Z05 {
	private static double ln(double n){
		if(n==1) return 0;
		else return Math.log(n) + ln(n-1);
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		double N = in.nextDouble();
		if(N>0)
			System.out.println(ln(N));
		else{
			Component frame = null;
			JOptionPane.showMessageDialog(frame, "Number N can't be negative!");
		}
		in.close();
	}
}
