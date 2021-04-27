package file_system;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileUtility {
	
	private static Scanner scanner;

	static void createFile() {
		try {
			
			System.out.println("please write the root directory ");
			scanner = new Scanner(System.in);
			String rootName = scanner.nextLine();
			System.out.println("please now write the file name");
			String nameFile= scanner.nextLine();
			File file = new File(rootName + "/" + nameFile.toLowerCase().trim()); //tested on macOS
			if(file.createNewFile()) {
				System.out.println(nameFile+" has been added to the directory");
			}
			else {
				System.out.println("The file already exist");
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		Menu.subMenu();
	}
	
	static void deleteFile() {
		scanner = new Scanner(System.in);
		System.out.print("please write the root directory= ");
		String rootName = scanner.nextLine();
		System.out.println("Enter the file that you would like to delete");
		String nameFile = scanner.nextLine();
		File file = new File(rootName + "/" + nameFile.toLowerCase().trim());
		if (file.delete())
			System.out.println(nameFile + " was deleted!!");
		else
			System.out.println("File Not Found");

		Menu.subMenu();
	}
	
	static void searchFile() {
		
		scanner = new Scanner(System.in);
		System.out.print("please write the root directory= ");
		String rootName = scanner.nextLine();
		System.out.println("Enter the file that you would like to find");
		String nameFile = scanner.nextLine();
		File file = new File(rootName + "/" + nameFile.toLowerCase().trim());
		try {
			
			if (file.exists()) {
				System.out.println("Loading Details: ");
				System.out.println("File name: " + file.getName());
				System.out.println("Absolute path: " + file.getAbsolutePath());
				System.out.println("Writeable: " + file.canWrite());
				System.out.println("Readable " + file.canRead());
				System.out.println("File size in bytes " + file.length());
			} else {
				System.out.println("This file was not found");

			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		

		Menu.subMenu();
	}

	static String[] sortFileAsc(String [] files) {
		//Insertion sort
		for (int i = 0; i < files.length; i++) {
			String current = files[i];
			int j = i - 1;
			while (j >= 0 && files[j].compareToIgnoreCase(current) > 0 ) {
				files[j + 1] = files[j];
				j--;
			}
			files[j + 1] = current;
		}
		return files;
	}
}
