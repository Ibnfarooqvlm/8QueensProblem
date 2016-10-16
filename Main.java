package com.ahamed.eightqueensproblem;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double startTime = System.currentTimeMillis();
		EightQueens eq = new EightQueens();
		eq.populateValues();
		double endTime = System.currentTimeMillis();
		System.out.println("\nTotal Time Taken: " + (endTime - startTime)/1000 + " sec");
	}

}
