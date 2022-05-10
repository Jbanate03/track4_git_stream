package org.ssglobal.training.codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Score {

	ScoreInfo student1 = new ScoreInfo("Smith","John",70);
	ScoreInfo student2 = new ScoreInfo("Doe","Mary",85);
	ScoreInfo student3 = new ScoreInfo("Page","Alice",82);
	ScoreInfo student4 = new ScoreInfo("Cooper","Jill",97);
	ScoreInfo student5 = new ScoreInfo("Flintstone","Fred",66);
	ScoreInfo student6 = new ScoreInfo("Rubble","Barney",80);
	ScoreInfo student7 = new ScoreInfo("Smith","Judy",48);
	ScoreInfo student8 = new ScoreInfo("Dean","James",90);
	ScoreInfo student9 = new ScoreInfo("Russ","Joe",55);
	ScoreInfo student10 = new ScoreInfo("Wolfe","Bill",73);
	ScoreInfo student11 = new ScoreInfo("Dart","Mary",54);
	ScoreInfo student12 = new ScoreInfo("Rogers","Chris",78);
	ScoreInfo student13 = new ScoreInfo("Toole","Pat",51);
	ScoreInfo student14 = new ScoreInfo("Khan","Omar",93);
	ScoreInfo student15 = new ScoreInfo("Smith","Ann",95);
	
	List<ScoreInfo> scores  = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10, student11, student12, student13, student14, student15));
	Stream<ScoreInfo> scoreStream = scores.stream();
	
	
	public int getNumScores() {
		return (int) scores.stream().count();
	}
	
	private Function<ScoreInfo, Integer> averageScore = (s) -> {
		return s.getScore();
		
	};
	
	public double getAverage() {
		return scores.stream().map(averageScore).mapToInt(Integer::intValue).average().orElse(0);
	}
	
	
	private Predicate<ScoreInfo> AListers = (s) -> {
		if (s.getScore() > 90) { 
			return true;
			}
		return false;
	};
	
	public int getNumberAListers() {
		return (int) scores.stream().filter(AListers).count();
	}
	
	private Predicate<ScoreInfo> failedStudents = (s) -> {
		if (s.getScore() < 70) { 
			return true;
			}
		return false;
	};
	
	public String getFailingStudentList() {
		return scores.stream().filter(failedStudents).collect(Collectors.toList()).toString();
	}
	
	private Predicate<ScoreInfo> passedStudents = (s) -> {
		if (s.getScore() >= 70) {
			return true;
		} else {
			return false;
		}
	};

	public String printPassingStudents() {
		return scores.stream().filter(passedStudents).collect(Collectors.toList()).toString();
	}
	
	private Comparator<ScoreInfo> sortedLastNames = (s1, s2) -> {
		if (s1.getLastName().compareTo(s2.getLastName()) == 0) {
			return 0;
		} else if (s1.getLastName().compareTo(s2.getLastName()) < 0) {
			return -2;
		} else {
			return 2;
		}
	};
	
	public void displayAllStudents() {
		scores.stream().sorted(sortedLastNames).collect(Collectors.toList()).forEach((s) -> System.out.println(String.join(" ", s.getFirstName(), s.getLastName(), String.valueOf(s.getScore()))));
	}
	
	private Comparator<ScoreInfo> sortedScores = (s1, s2) -> {
		if (s1.getScore() == s2.getScore()) {
			return 0;
		} else if (s1.getScore() < s2.getScore()) {
			return -2;
		} else {
			return 2;
		}
	};
	
	public void getStudentRecords() {
		scores.stream().sorted(sortedScores).collect(Collectors.toList()).forEach((s) -> System.out.println(String.join(" ", s.getFirstName(), s.getLastName(), String.valueOf(s.getScore()))));
	}
	
}
