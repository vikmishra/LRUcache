package com.vikas.LRUCache;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author VIKAS
 * 
 */
public class FileUtils {
	private static final int maxFileSizeInMB = 10;

	public static String readFromFile(int hashKey) {
		// TODO Auto-generated method stub
		String val = null;
		Properties properties = new Properties();
		try {
			File file = new File("values.txt");
			FileInputStream fileInputStream = new FileInputStream(file);

			properties.load(fileInputStream);
			String key = String.valueOf(hashKey);
			val = properties.getProperty(key);
			if (val != null) {
				properties.remove(key);
				FileOutputStream fileoutputStream = new FileOutputStream(file);
				properties.store(fileoutputStream, null);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return val;
	}

	public static void writeToFile(Node end) {
		/* Step 1: Nothing to do if key already in file */
		String str = readFromFile(end.getKey());
		if (str != null) { // String already in file
			System.out.println(end.getKey()+" Key present Already ");
		}

		/* Step 2:Check File Size */

		File file = new File("values.txt");

		if (file.exists()) {

			double bytes = file.length();
			double megabytes = (bytes / 1024 * 1024);

			System.out.println("bytes : " + bytes);
			System.out.println("megabytes : " + megabytes);

			if (megabytes > maxFileSizeInMB) {
				file.delete(); // Delete the File if Sixe Exceed, wlii create
								// file later
			}

		} else {
			System.out
					.println("File does not exists, will be creating a new file");
		}

		/* STEP 3 : Write Key Value to the file */
		FileWriter fstream;
		BufferedWriter out;

		try {
			fstream = new FileWriter("values.txt", true);

			out = new BufferedWriter(fstream);

			// since you only want the value, we only care about
			// pairs.getValue(), which is written to out
			out.append(end.getKey() + "=" + end.getValue() + "\n");
			// lastly, close the file and end
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deletekeyval(int hashKey) {
		Properties properties = new Properties();
		try {
			File file = new File("values.txt");
			FileInputStream fileInputStream = new FileInputStream(file);

			properties.load(fileInputStream);
			String key = String.valueOf(hashKey);
			properties.remove(key);
			FileOutputStream fileoutputStream = new FileOutputStream(file);
			properties.store(fileoutputStream, null);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
