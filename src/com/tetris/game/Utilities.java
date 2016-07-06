package com.tetris.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.tetris.frontend.FrontEnd;

public class Utilities {

	public static boolean isNumber(String txt) {
		int i=0; 
		boolean isNumber = !txt.isEmpty(); 
		
		while(i < txt.length() && isNumber) {
			if(Character.isDigit(txt.charAt(i)))
				i++; 
			else 
				isNumber = false; 
		}
		
		return isNumber; 
	}
	
	public static int requestIntegerOption(int min, int max) throws IOException {
		String opt = "";
		int option = 0; 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		
		while(option < min || option > max) {
			FrontEnd.print("\tChoose one option: ");
			opt = in.readLine(); 
		
			if(Utilities.isNumber(opt)) 
				option = Integer.parseInt(opt);
		}
		
		return option; 
	}
}
