package com.second.objectrepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Snippet {
	public static void main(String[] args) throws IOException {
		FileWriter file=new FileWriter("C:\\Users\\hp\\Desktop\\vamshjhaGJHAS.text");
		System.out.println(file);
		BufferedWriter bufferedWriter=new BufferedWriter(file);
		
		bufferedWriter.write("NITHIN ");
		bufferedWriter.newLine();
		bufferedWriter.write("RAGHAVA");
		bufferedWriter.write("SRI INDU");
		bufferedWriter.newLine();
		bufferedWriter.write("CIVIL");
		bufferedWriter.flush();
		
		
		  
	}
}

