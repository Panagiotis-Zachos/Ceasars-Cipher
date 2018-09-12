package cciph;

import java.util.Comparator;

public class Letter {
	
	public char let;
	public int count;
	
	public Letter(char let,int count) {
		this.let = let;
		this.count = count;
	}
	
	static class countComp implements Comparator<Letter>{	// Descending
		public int compare(Letter o1, Letter o2) {
			return o2.count - o1.count;
		}
	}
}
