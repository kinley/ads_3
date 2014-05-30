package semZad;

public class semZadMain {
	public static void main(String[] args) {
		In Dict = new In("dictionary.txt");
		In File = new In("file.txt");
		Dictionary file = new Dictionary();
		Dictionary dict = new Dictionary();
		while (!File.isEmpty()){
			String s = File.readLine(); 
			file.insert(s);
		}
		while (!Dict.isEmpty()){
			dict.insert(Dict.readLine());
		}
		String word = "";
		while (!file.isMarked()) {
			if (dict.inDictionary(word)){
				file.remove(word);
			}
			word = file.getNextWord(word);
		}
		file.show();
	}
}