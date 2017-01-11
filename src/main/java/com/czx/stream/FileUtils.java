package com.czx.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.czx.Test;

public class FileUtils {

	private static void copyFolder(File src, File dest) throws IOException {  
	    if (src.isDirectory()) {  
	        if (!dest.exists()) {  
	            dest.mkdir();  
	        }  
	        String files[] = src.list();  
	        for (String file : files) {  
	        	String newFile = file;
	            File srcFile = new File(src, file); 
	            if(newFile.indexOf(".java")>0){
	            	newFile = newFile.replaceAll(".java", ".java1");
	        	}
	            File destFile = new File(dest, newFile);  
	            // µÝ¹é¸´ÖÆ  
	            copyFolder(srcFile, destFile);  
	        }  
	    } else {  
	        InputStream in = new FileInputStream(src);  
	        OutputStream out = new FileOutputStream(dest);  
	  
	        byte[] buffer = new byte[1024];  
	  
	        int length;  
	          
	        while ((length = in.read(buffer)) > 0) {  
	            out.write(buffer, 0, length);  
	        }  
	        in.close();  
	        out.close();  
	    }  
	}  
	
	public static void main(String[] args) throws IOException {
		FileUtils.copyFolder(new File("D:\\Workspaces\\ytEmm\\src\\com\\jz\\emm\\yhData\\webservice\\test\\WebServiceTest.java"),new File("C:\\WebServiceTest.java1"));
	}
}
