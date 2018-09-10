package cciph;

import java.util.ArrayList;
import java.util.List;

public class Cipher {
	public String cipher(String txt, int key) {
		int val;
		String cipText = "";
		
		for(int i = 0; i < txt.length(); i++) {
			
			val = (int)txt.charAt(i);
			if(val == 32) {
				cipText += " ";
				continue;
			}
			
			val += key;
			if(val>122) {
				val = (val % 122) + 96;
			}
			cipText += (char)val;
		}
		return cipText;
	}
	
	public String decipher(String txt, int key) {
		int val;
		String decText = "";
		
		for(int i = 0; i < txt.length(); i++) {
			
			val = (int)txt.charAt(i);
			if(val == 32) {
				decText += " ";
				continue;
			}
			
			val -= key;
			if(val<97) {
				val = 26 + val; // (123 - (97 - val)
			}
			decText += (char)val;
		}		
		return decText;
	}
	
	public String freqDecipher(String txt) {
		String decText = "";
		
		List<Letter> freq = freqAnalysis(txt);
		decText += "Ordered by likeliness:\n";
		for(int i=0;i<26;i++) {
			decText += "Attempt " + (i+1) + ": " + (decipher(txt,freq.get(i).let - 't')) + "\n";
		}
		
		return decText;
	}
	
	private List<Letter> freqAnalysis(String txt){
		
		List<Letter> freq = new ArrayList<Letter>();
		int val;
		
		for(int i = 0; i < 26; i++) {
			freq.add(new Letter((char) ('a'+ i), 0));
		}
		
		for(int i = 0; i < txt.length(); i++) {
			val = (int)txt.charAt(i);
			if(val == 32) {
				continue;
			}
			freq.get(val-97).count++;
		}
		freq.sort(new Letter.countComp());
		
		return freq;
	}
}
