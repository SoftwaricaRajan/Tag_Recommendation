package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bic.BIC;

public class EnTagRecConsoleApp {
	public static void main(String[] args) throws IOException {
		System.out.println("enter your question");
		/// swObj = JOptionPane.showInputDialog(null,"Enter your question");
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String swObj = bfr.readLine().toString();
		System.out.println("input=" + swObj);
		BIC.enTagRec(swObj);
	}
}
