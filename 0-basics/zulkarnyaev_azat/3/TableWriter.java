package ru.kpfu.ivmiit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class TableWriter {
	private List<String> tableRows = new LinkedList<String>();

	private void readTableFromFile(String fileName) {
		String row = "";
		try {
			File inFile = new File(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(inFile)));
			while (row != null) {
				row = br.readLine();
				if(row!=null){
					tableRows.add(row);
				}
			}
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File " + fileName + " not found!");
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	private void writeTable() {
		for (String row : tableRows) {
			String[] parts = row.split(" ");
			if (parts.length >= 4) {
				try {
					double firstNumber = Double.parseDouble(parts[2]);
					double secondNumber = Double.parseDouble(parts[3]);
					System.out.printf("%20s %20s %10.3f %10.3f %10.3f\n", parts[0], parts[1], firstNumber, secondNumber, (float)firstNumber/secondNumber);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.err.println();
				}
			}
		}
	}
	public static void main(String[] args){
		TableWriter writer=new TableWriter();
		writer.readTableFromFile("data.txt");
		writer.writeTable();
	}
}
