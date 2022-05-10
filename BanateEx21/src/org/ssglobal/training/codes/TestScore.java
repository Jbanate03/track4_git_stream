package org.ssglobal.training.codes;

public class TestScore {

	public static void main(String[] args) {
		Score score = new Score();
		
		System.out.println(score.getNumScores());
		System.out.println(score.getAverage());
		System.out.println(score.getNumberAListers());
		System.out.println(score.getFailingStudentList());
		score.printPassingStudents();
		score.displayAllStudents();
		score.getStudentRecords();

	}
	
}
