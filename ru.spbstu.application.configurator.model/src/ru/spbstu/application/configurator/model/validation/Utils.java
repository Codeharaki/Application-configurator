package ru.spbstu.application.configurator.model.validation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Utils {
	public static String changeString(String str) {
		System.out.println(str);
		char[] chars = str.toCharArray();
		char[] ch = new char[chars.length-2];
		int count =0;
		for (int i=2; i<chars.length; ++i) {
			ch[count] = chars[i];
			++count;
		
		}
		 	
		str = String.copyValueOf(ch);
		 String newString;
	        if (str.startsWith(".")){
	            char[] c = str.toCharArray();
	            int i=0;
	            for (i=0; i<str.length(); ++i){
	                if (c[i]=='.'||c[i] =='/'){
	                    continue;
	                }else {
	                    break;
	                }
	            }
	            newString = str.substring(i,str.length());
	            
	            return newString;
	        }
	       
		return str;
	}
	
	
	public static String checkFolder(String path, String config) {
		if (path.startsWith("lib")) {
			return path;
		}else {
			String fullPath = config + path;
			return fullPath;
		}
	}

}
