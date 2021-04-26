package file_system;

import java.util.Scanner;

public class Menu {
	public static void menuCases(int menuChoise) {
		switch(menuChoise) {
			case 1: 
				FileUtility.sortFileAsc();
				break;
			case 2: 
				//TODO
				break;
			case 3:
				//TODO
				break;
			default:
				System.out.println("Invalid option please select a valid one");
				generateMenu();
			
		}
	}
	public static void generateMenu() {
		Scanner menu = new Scanner(System.in);
		System.out.println("Select one of the following operations ");
		System.out.println("1) Current file names in asc ording");
		System.out.println("2) SubMenu options to add, delete and search a file");
		System.out.println("3) Close aplication");
		System.out.print("Enter a selected option:");
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
		int firstMenu = scanner.nextInt();
		menuCases(firstMenu);
	}

}
