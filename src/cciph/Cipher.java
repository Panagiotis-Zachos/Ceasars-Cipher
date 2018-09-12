package cciph;

import java.util.ArrayList;
import java.util.List;

public class Cipher {
	public String cipher(String txt, int key) {
		int val;
		char c;
		String cipText = "";
		
		for(int i = 0; i < txt.length(); i++) {
			
			c = txt.charAt(i);
			if(!Character.isAlphabetic(c)){
				cipText += c;
				continue;
			}
			val = (int)c;
			
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
		char c;
		String decText = "";
		
		for(int i = 0; i < txt.length(); i++) {
			
			c = txt.charAt(i);
			if(!Character.isAlphabetic(c)) {
				decText += c;
				continue;
			}
			val = (int)c;
			
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
		char c;
		
		for(int i = 0; i < 26; i++) {
			freq.add(new Letter((char) ('a'+ i), 0));
		}
		
		for(int i = 0; i < txt.length(); i++) {
			c = txt.charAt(i);
			if(!Character.isAlphabetic(c)) {
				continue;
			}
			val = (int)c;
			freq.get(val-97).count++;
		}
		int counter = 0;
		for (int i = 0; i < 26; i++) {
			if(freq.get(i).count != 0) {
				counter++;
			}
		}
		freq.sort(new Letter.countComp());
		
		return freq;
	}
}
