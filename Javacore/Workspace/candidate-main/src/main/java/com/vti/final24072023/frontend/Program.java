package com.vti.final24072023.frontend;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		register();
	}

	public static void register() throws ClassNotFoundException, SQLException {
		Function function = new Function();
		System.out.println("Mời bạn đăng kí.\n 1. Đăng kí ExperienceCandidate  \n 2. Đăng kí FresherCandidate");
		int n = scanner.nextInt();
		scanner.nextLine();

		switch (n) {
		case 1:
			function.addExperienceCandidate();
			break;

		case 2:
			function.addFresherCandidate();
			break;
		}
		System.out.println("Mời bạn đăng nhập");
		function.login();

	}

}
