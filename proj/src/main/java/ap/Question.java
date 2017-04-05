package ap;

import java.util.*;
import ap.exception.*;

public  class Question{
	private String body;
	private List<String> choices;
	private int correctChoice;
	private List<String> subjects;
	private int weight;


	public Question(String body, List<String> choices, int correctChoice, String subject, int weight) throws InvalidOperationException {
		this.body = body;

		if (choices.size() >= 2 && choices.size() <= 10) {
			this.choices = choices;
		} else {
			throw new InvalidOperationException();
		}
		
		if (correctChoice > 0 && correctChoice <= choices.size()) {
			this.correctChoice = correctChoice;
		} else {
			throw new InvalidOperationException();
		}

		this.subjects = new ArrayList<String>();
		this.subjects.add(subject);

		if (weight > 0 && weight <= 20) {
			this.weight = weight;
		} else {
			throw new InvalidOperationException();
		}
	}
	
	public void remove(String subject) throws InvalidOperationException	{
		if (this.subjects.size() > 1) {
			this.subjects.remove(subject);
		} else {
			throw new InvalidOperationException();
		}
	}
	
	public void add(String subject) throws InvalidOperationException {
		if (this.subjects.size() < 3) {
			this.subjects.add(subject);
		} else {
			throw new InvalidOperationException();
		}
	}
	
	public List<String> getSubjects() {
		return this.subjects;
	}
	
	public float grade(int selectedChoice) {
		if (selectedChoice == this.correctChoice) {
			return this.weight;
		} else {
			return -(weight / (choices.size() - 1));
		}
	}
	
	public void setWeight(int weight) throws InvalidOperationException {
		if (weight > 0 && weight <= 20) {
			this.weight = weight;
		} else {
			throw new InvalidOperationException();
		}
	}
	
	public int getWeight() {
		return this.weight;
	}
}
