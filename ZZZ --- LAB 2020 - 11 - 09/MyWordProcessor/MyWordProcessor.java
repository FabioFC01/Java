import java.util.Scanner;

public class MyWordProcessor {
	private String text;
	public MyWordProcessor() {
		text = "";
	}
	public void add(String line) {
		text += line + "\n";
	}
	public int size() {
		Scanner in = new Scanner(text);
		int size = 0;
		while (in.hasNextLine()) {
			String tmp = in.nextLine();
			size++;
        }
        in.close();
		return size;
	}
	public int wordSize() {
		Scanner in = new Scanner(text);
		int size = 0;
		while (in.hasNext()) {
			String tmp = in.next();
			size++;
        }
        in.close();
		return size;
	}
	public String[] toWords() {
		Scanner in = new Scanner(text);
		String[] words = new String[wordSize()];
		int i = 0;
		while (in.hasNext()) {
			words[i] = in.next();
			i++;
        }
        in.close();
		return words;
	}
	public String maxString() {
		String[] words = toWords();
		String max = words[0];
		for (int i = 1; i < words.length; i++) {
			String currentWord = words[i];
			if (currentWord.compareTo(max) > 0) max = currentWord;
		}
		return max;
	}
	public int findAndReplace(String find, String replace) {
		int occ = 0;
		String[] words = toWords();
		int pos = 0;
		for (int i = 0; i < wordSize(); i++) {
			if (find.equals(words[i])) {
				String tmp1 = text.substring(0, pos);
				String tmp2 = text.substring(pos + find.length());
				text = tmp1 + replace + tmp2;
				occ++;
				words = toWords();
				i = -1;
				pos = 0;
			}
			else {
				pos += words[i].length() + 1;
			}
		}
		return occ;
	}
	public String toString() {
		return text;
	}
}
