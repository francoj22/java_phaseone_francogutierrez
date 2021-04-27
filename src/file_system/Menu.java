package file_system;

import java.util.Scanner;
import java.io.File;
import java.util.Objects;

public class Menu {
	private static Scanner scanner;
	private static Scanner menu;

	public static void menuCases(int menuChoise) {
		switch(menuChoise) {
			case 1: 
				System.out.println("Please select the directory");
				Scanner scanner = new Scanner(System.in);
				String directory = scanner.nextLine();
				File file = new File(directory);
			
				if(!Objects.isNull(file.list())) {
					System.out.println("Files found ... Loading ...");
					String[] sortedFiles = FileUtility.sortFileAsc(file.list());
					for(String string: sortedFiles) {
						System.out.println(string);
					}
				} else {
					System.out.println("There are not files in the provide directory");
				}
				generateMenu();
				break;
			case 2: 
				subMenu();
				break;
			case 3:
				System.out.println("Thanks for using the application");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option please select a valid one");
				generateMenu();
				break;
	
		}
		
	}
	public static void generateMenu() {
		System.out.println("------------LockedMe.com------------------");
        System.out.println("|      Wrote by  Franco Gutierrez         |");
        System.out.println("------------Tested on macOS----------------");
		menu = new Scanner(System.in);
		System.out.println("Select one of the following operations ");
		System.out.println("1) Current file names in asc ording");
		System.out.println("2) SubMenu options to add, delete and search a file");
		System.out.println("3) Close aplication");
		System.out.print("Enter a selected option:");
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("");
			int firstMenu = scanner.nextInt();
			menuCases(firstMenu);
		}
	}
	
	public static void subMenu() {
		
		System.out.println("Select one of the following options");
		System.out.println("1) add a file");
		System.out.println("2) delete a file");
		System.out.println("3) search for details in a file");
		System.out.println("4) go back to principal menu");
		System.out.println("please select a choise:");
		scanner = new Scanner(System.in);
		int option = scanner.nextInt();

		switch (option) {
		case 1:
			System.out.println("Creating file option");
			FileUtility.createFile();
			break;
		case 2:
			System.out.println("Deleting file option");
			FileUtility.deleteFile();
			break;
		case 3:
			System.out.println("Searching file option");
			FileUtility.searchFile();
			break;
		case 4:
			System.out.println("Go Back");
			generateMenu();
			break;

		default:
			System.out.println("Redirecting to Main Menu");
			generateMenu();
		}
		
	}

}
