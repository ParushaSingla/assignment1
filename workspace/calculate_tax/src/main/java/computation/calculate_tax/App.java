package computation.calculate_tax;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

/**
 * @class name App
 * 
 * @version info JavaSE-1.8
 * 
 * @author parushasingla
 * 
 * @creation date 1/11/2019
 * 
 * @last updated by parushasingla
 * 
 * @last updated date 1/16/2019
 * 
 * @description ASSIGNMENT 1(business logic)
 */

// recursive call to enter details of item
public class App {
	public void input() {
		List<Enter> ls = new ArrayList<Enter>();
		

		char ch = 'y';
		do {
			int i = 0;
			String type_1;
			int price;
			Type type;
			Scanner scr = new Scanner(System.in);
			try {
				System.out.println("ENTER ITEM NAME :-");
				String name = scr.nextLine();
				System.out.println("ENTER ITEM TYPE AND PRICE ");
				String str = scr.nextLine();
				String[] sparr = str.split(" ");
				if (sparr.length > 2 || sparr.length < 2 ||sparr[0].equals(" ") || sparr[1].equals(" ")) {
					throw new My_Exception("ENTER CORRECT PRICE AND TYPE");
				}
			
				if (sparr[0].matches("[a-zA-Z]+")) {
					type_1 = sparr[0];
					if(sparr[1].matches("[a-zA-Z]+"))
					{
						throw new My_Exception("ENTER PRICE IN INTEGER");
					}
					price = Integer.parseInt(sparr[1]);
				} else {
					type_1 = sparr[1];
					if(sparr[0].matches("[a-zA-Z]+"))
					{
						throw new My_Exception("ENTER PRICE IN INTEGER");
					}
					price = Integer.parseInt(sparr[0]);
				}
				if (price <= 0) {
					throw new My_Exception("PRICE SHOULD NOT EQUAL TO 0 OR LESS");
				}

				switch (type_1) {
				case "raw":
					type = Type.RAW;
					;
					break;
				case "imported":
					type = Type.IMPORTED;
					break;
				case "manufactured":
					type = Type.MANUFACTURED;
					break;
				default:
					throw new My_Exception("ENTER TYPE(RAW/MANUFACTURED/IMPORTED)");
				}
				System.out.println("ENETR ITEM QUANTITY");
				int qty = scr.nextInt();
				if (qty < 0) {
					throw new My_Exception("ATLEAST ONE ITEM TO BE PURCHASED");
				}
				
				Enter obj = new Enter(name, type, price, qty);
				ls.add(obj);
				System.out.println(" Do you want to enter details of any other item (y/n):");
				String s = scr.next();
				ch = s.charAt(0);
			} catch (My_Exception e) {
				System.out.println(e);
			}
		} while (ch == 'y');
		// calculate the total cost after applying the tax

		for (Enter l : ls) {
			calc(l.getName(), l.getType(), l.getPrice(), l.getQuant());
		}
	}

	public void calc(String name, Type type, int price, int qty) {
		double total = 0;
		double tax = 0;
		if (type.equals(Type.RAW)) {
			tax = (0.125 * price);
			total = (tax + price) * qty;

		} else if (type.equals(Type.MANUFACTURED)) {
			double tax1 = (0.125 * price);
			tax = (0.02) * (tax1 + price);
			total = (tax + price) * qty;

		} else {
			double tax1 = (0.1) * price;
			double s = tax1 + price;
			if (s <= 100) {
				tax = tax1 + 5;
				total = (5 + s) * qty;
			} else if (s <= 200 && s > 100) {
				tax = tax1 + 10;
				total = (10 + s) * qty;
			} else {
				double k = (5 / 100) * s;
				tax = tax1 + k;
				total = (k + s) * qty;
			}
		}
		// after calculating tax display the output
		output(name, type, price, tax, total);
	}

	public void output(String name, Type type, int price, double tax, double cost) {
        
		System.out.printf(name + "\t" + type + "\t" + price + "\t" + tax + "\t" + cost);
		System.out.println();
	}

}
