package com.techelevator.view;


import com.techelevator.tenmo.models.Account;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleService {

	private PrintWriter out;
	private Scanner in;

	public ConsoleService(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output, true);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		out.println();
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	public String getUserInput(String prompt) {
		out.print(prompt+": ");
		out.flush();
		return in.nextLine();
	}

	public Integer getUserInputInteger(String prompt) {
		Integer result = null;
		do {
			out.print(prompt+": ");
			out.flush();
			String userInput = in.nextLine();
			try {
				result = Integer.parseInt(userInput);
			} catch(NumberFormatException e) {
				out.println(System.lineSeparator() + "*** " + userInput + " is not valid ***" + System.lineSeparator());
			}
		} while(result == null);
		return result;
	}
	//***************************************************************************************
	public void showUsers(Account[] users) {

		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Users");
		System.out.println(String.format("%-20s %-20s", "ID", "Name"));
		System.out.println("----------------------------------------------------------------------------------");

		for (Account account1 : users) {
			System.out.println(String.format("%-20d %-20s", account1.getUser_id(), account1.getUser_name()));

		}

	}
//*******************************************************************************************
	public void printBalance(Account account) {

		if (account == null) {
			System.out.println("No results found... Please try again.");
			return;
		}

		System.out.println("Your current account balance is:  $" + account.getBalance());

//*****************************************************************************************

	}

	public int userIdFromUser() {
		System.out.println("Enter the userid ");
		int days = Integer.parseInt(in.next());
		return days;
	}

	//********************************************************************************



}
