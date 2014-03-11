package zadanie1;

import java.util.Calendar;
import java.util.Scanner;

public class Person {
	private String surname;
	private String name;
	private String gender;
	private int birthyear;
	private int children;
	
	Person(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter surname: ");
		surname = in.nextLine();
		System.out.print("Enter name: ");
		name = in.nextLine();
		System.out.print("Enter gender (type 'm' or 'f'): ");
		gender = in.next();
		System.out.print("Enter birthyear: ");
		birthyear = in.nextInt();
		System.out.print("Enter number of children: ");
		children = in.nextInt();
		in.close();
	}
	Person(String sname, String nm, String gen, int byear, int chl){
		surname = sname;
		name = nm;
		gender = gen;
		birthyear = byear;
		this.children = chl;
	}
	
	public void show(){
		System.out.printf("%s %s. Gender: %s. Born in %d. Has children: %d.\n", surname, name, gender, birthyear, children);
	}
	
	public void setSurname(String s){
		surname = s;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public void addChildren(int n){
		children += n;
	}
	
	public int getChildren(){
		return children;
	}
	
	public boolean isAdult(){//name? 
		return ((Calendar.getInstance().get(Calendar.YEAR) - birthyear > 16) ? true : false);
	}
	
	public Person createChild(String nm, String gen, int byear, int cld){
		children++;
		Person child = new Person(getSurname(), nm, gen, byear, cld);
		return child;
	}
	
	public static void main(String[] args){
		Person person1 = new Person();
		if(person1.isAdult()){
			person1.setSurname("Lekas");
		}
		Person person2 = person1.createChild("Ada", "f", 2000, 0);
		Person person3 = new Person("Smith", "Will", "m", 1976, 0);
		int n = person1.getChildren();
		person3.addChildren(n);
		person1.addChildren(-n);
		person2.setSurname(person3.getSurname());
		
		person1.show();
		person2.show();
		person3.show();
	}
}
