package semZad;

import java.lang.String;
import java.util.List;
import java.util.ArrayList;

public class Trie{
	private char flag; 
	private List<Trie> Link; 
	private int N = 0;
	private boolean isWord;
	private static int ChN = 0; 
	 

	public char getflag() {
		return flag;
		}
	public boolean nextsListContainsMark(char f) {
		for (int i = 0; i<Link.size(); i++)		{
			if (Link.get(i).getflag() == f) 
				return true;
		}
		return false;
	}
	public Trie(char f)	{
		flag = f; 
		Link = new ArrayList<Trie>();
		isWord = false;	
	}
	public Trie(){
	}
	public void insertString(String s){
		char c;
		for(int i=0; i < s.length(); i++){
			c = s.charAt(i);
			if (!nextsListContainsMark(c)){
				Trie tt = new Trie(c);
				Link.add(tt);
			}
		}
		isWord = true; 
		N++;
	}
	public String nextWord(String s){
		String word = new String();
		ChN++;		
		return word;
	}
	public boolean isEmpty() {
		return (N==0);
	}
	public boolean isMarked() 	{
		return (ChN == N);
	}
	public boolean isWord(String s)	{
		for(int i=0; i < s.length(); i++){
			char c = s.charAt(i);
			if (!nextsListContainsMark(c))			
				return false;
						
		}

		return (isWord);
	}
	public void remove(String s){
		char c;
		if (isWord(s)) {
			for(int i=0; i < s.length(); i++)
				c = s.charAt(i);
			isWord = false; 				
			N--;
		}
	}
	public void show(){
		if (!this.isEmpty()){
			String s = this.firstWord();
			System.out.println(s);
			for (int i = 1; i<N; i++){
				s = this.nextWord(s);
				System.out.println(s);
			}
		}
		else System.out.println("Слова не найдены!");
	}
	public String firstWord(){
		String word = new String();
		for (char i = 'a'; i<='z'; i++)	{
			if (nextsListContainsMark(i)){
				word+=i;
				if (isWord(word)){
					ChN=1;
					return word; 
				}
				else{
					if (!Link.isEmpty()) 
						Link.get(i);
					else					
						for (int j =0; j<(word.length()-1); j++)
							Link.get(word.charAt(j));
				}
			}
		}
		ChN = 1;
		return word;
	}
}