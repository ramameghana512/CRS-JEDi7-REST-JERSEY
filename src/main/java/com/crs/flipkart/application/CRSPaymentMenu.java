/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

import com.crs.flipkart.utils.ServiceUtils;

/**
 * @author TEST
 *
 */
public class CRSPaymentMenu {
	Scanner scn;

	public String displayPaymentMethods() {
		// TODO Auto-generated method stub
		scn = new Scanner(System.in);
		System.out.println("Choose payment mode\n\t1)Offline\n\t2)Online");
		System.out.print("Enter Choice: ");
		int paymentMethod = scn.nextInt();
		switch (paymentMethod) {
		case 1:
			return displayOffline();
		case 2:
			return displayOnline();
		}
		return null;
	}

	private String displayOnline() {
		// TODO Auto-generated method stub
		System.out.println("\nEnter Debit/Credit Card Details:-");
		System.out.print("\n\tCard number: ");
		scn.next();
		System.out.print("\n\tExpiry Date: ");
		scn.next();
		System.out.print("\n\tCVV: ");
		scn.next();
		String refNo = "R" + ServiceUtils.createUserId();
		return refNo;
	}

	private String displayOffline() {
		// TODO Auto-generated method stub
		System.out.print("Enter Reference Details for Offline payment: ");
		return scn.next();
	}
}
