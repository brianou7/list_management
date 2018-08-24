import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ListManagement {
	
	private List<Integer> list = new ArrayList<Integer>();
	private Scanner in = new Scanner(System.in);
	
	public void show() {
		if (!list.isEmpty()) {
			System.out.print("\nThe list is rigth now: [");
			
			for (Integer item: list) {
				System.out.print(item);
				
				if (list.indexOf(item) != list.size() - 1) {
					System.out.print(", ");
				}
			}
			
			System.out.print("]\n\n");
		}else {
			System.out.println("\nThe list is empty just now!\n");
		}
	}
	
	public void alter() {
		try {
			System.out.println("\nInsert the positions to alter (Start position is zero [0])");
			System.out.println("The max position is " + (list.size() - 1));
			System.out.print("This position: ");
			int a = in.nextInt();
			System.out.print("By this: ");
			int b = in.nextInt();
			
			int x = list.get(a);
			int y = list.get(b);
			list.set(a, y);
			list.set(b, x);
			
			System.out.println("\nThe elements in the specified positions were altered correctly!");
;		} catch(InputMismatchException e) {
			System.out.println("\nHas inserted an invalid value, please try again\n");
		} catch(IndexOutOfBoundsException e) {
			System.out.println("\nHas inserted an invalid position, please try again\n");
		}
	}
	
	public void insert() {
		try {
			System.out.println("\nInsert an element or several elements seperated by commas: ");
			System.out.print("Values: ");
			String values = in.next();
			
			List<Integer> list_inserted = Arrays.stream(values.replaceAll("\\s+","").split(",")).map(Integer::parseInt).collect(Collectors.toList());
			list.addAll(list_inserted);
			System.out.println("The values inserted correctly!\n");
		} catch(InputMismatchException e) {
			System.out.println("\nHas inserted an invalid value, please try again\n");
		}
		
	}
	
	public void print_options() {
		System.out.println("Select one of the following options (Insert 8 or 9 at any time to clean console or repeat the menu respectively): \n");
		System.out.println("1: Show data from list");
		System.out.println("2: Alter positions");
		System.out.println("3: Insert data to list");
		System.out.println("0: Exit\n");
	}
	
	public void clean() {
		System.out.flush();
		// print_options();
	}
	
	public void menu() {
		print_options();
		
		while (true){
			try {		
				System.out.print("Option: ");
				int option = in.nextInt();
				
				if (option == 1) {
					show();
				}else if (option == 2) {
					alter();
				}else if (option == 3) {
					insert();
				}else if (option == 8) {
					clean();
				}else if (option == 9) {
					print_options();
				}else if (option == 0) {
					System.out.println("Bye, come back soon!");
					break;
				}else{
					System.out.println("\nHas selected an invalid option, please try again\n");
				}
			} catch(InputMismatchException e) {
				System.out.println("\nHas occurred a problem, please try again\n");
			}
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to List Management app!!!\n");
		ListManagement app = new ListManagement();
		app.menu();
	}

}
