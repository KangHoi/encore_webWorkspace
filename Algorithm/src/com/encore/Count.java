package com.encore;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Count {

	public String execute(String book) {
		
	// 구현해보세요.
		int sum=0;
		int result =0;
		String maxWord=null;
		
		
		String sentences = book.toLowerCase();
		String words = book.replaceAll("\\p{Punct}", "");
		String[] word = words.split(" ");
		
		ArrayList listSame = new ArrayList();
		TreeSet listEquals = new TreeSet();
		
		for(String w: word) {
			listSame.add(w);
			listEquals.add(w);
		}
		


		return maxWord;
	}

 public static void main(String[] args) {
		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 ="I like cat. I like cat. I like cat. ";
		Count c = new Count();
		System.out.println(c.execute(book1));
		System.out.println(c.execute(book2));
		System.out.println(c.execute(book3));

	}

}
