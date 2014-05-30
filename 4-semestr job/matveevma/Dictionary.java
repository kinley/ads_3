package semZad;

public class Dictionary {
	Trie trie;

	public Dictionary() {
		trie = new Trie(' ');
	}

	public void insert(String s) {
		trie.insertString(s);
	}

	public void remove(String s) {
		trie.remove(s);
	}

	public boolean inDictionary(String s) {
		return trie.isWord(s);
	}


	public void show(){
		trie.show();
	}
	public String firstWord(){
		return trie.firstWord();
	}

	public String getNextWord(String s){
		return trie.nextWord(s);
	}
	public boolean isEmpty(){
		return trie.isEmpty();
	}
	public boolean isMarked(){
		return trie.isMarked();
	}
}