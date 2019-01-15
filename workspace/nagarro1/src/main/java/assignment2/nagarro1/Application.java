package assignment2.nagarro1;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import assignment2.nagarro1.*;

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
 * @last updated date 1/14/2019
 * 
 * @description ASSIGNMENT 1(business logic)
 */
public class Application {
	// recursive call to enter details of item

	public void input() {
		List<EnterDetails> ls = new ArrayList<EnterDetails>();
		char ch = 'y';
		do {
			Scanner scr = new Scanner(System.in);
			try {
				System.out.println("ENTER ITEM NAME");
				String name = scr.nextLine();
				System.out.println("ENTER ITEM TYPE ");
				String type = scr.nextLine();
				if (!type.equals("raw")) {
					if (!type.equals("manufacture")) {
						if (!type.equals("imported")) {
							throw new Exception("ENTER TYPE(NAME/MANUFACTURE/IMPORTED)");
						}
					}
				}
				System.out.println("ENTER ITEM PRICE");
				int price = scr.nextInt();
				if (price <= 0) {
					throw new Exception("ENTER PRICE GREATER THAN 0");
				}
				System.out.println("ENETR ITEM QUANTITY");
				int qty = scr.nextInt();
				if (qty < 0) {
					throw new Exception("ATLEAST ONE ITEM TO BE PURCHASED");
				}
				EnterDetails obj = new EnterDetails(name, type, price, qty);
				ls.add(obj);
				System.out.println(" Do you want to enter details of any other item (y/n):");
				String s = scr.next();
				ch = s.charAt(0);
			} catch (Exception e) {
				System.out.println(e);
				ch = 'y';
			}
		} while (ch == 'y');
		// calculate the total cost after applying the tax
		
		for (EnterDetails l : ls){
			calc(l.getName(), l.getType(), l.getPrice(), l.getQuant());	
		}
	}

	public void calc(String name, String type, int price, int qty) {
		double total = 0;
		double tax=0;
		if (type.equals("raw")) {
			tax = (0.125 * price);
			total = (tax + price) * qty;

		} else if (type.equals("manufacture")) {
			double tax1 = (0.125 * price);
			tax = (0.02) * (tax1 + price);
			total = (tax + price) * qty;

		} else {
			double tax1 = (0.1) * price;
			double s = tax1 + price;
			if (s <= 100) {
				tax=tax1+5;
				total = (5 + s) * qty;
			} else if (s <= 200 && s > 100) {
				tax=tax1+10;
				total = (10 + s) * qty;
			} else {
				double k = (5 / 100) * s;
				tax=tax1+k;
				total = (k + s) * qty;
			}
		}
		// after calculating tax display the output
		output(name, type, price, tax, total);
	}

	public void output(String name, String type, int price, double tax, double cost) {
		System.out.println(name + " " + type + " " + price + " " +tax + " " + cost);
	}
}
