package java.ap;

import java.util.*;
import java.ap.exception.*;

public  class Question{
	public Question(String body, List<String> choices, int correctChoice, 
	String subject, int weight)
	{}
	
	public void remove(String subject) throws InvalidOperationException
	{}
	
	public void add(String subject) throws InvalidOperationException
	{}
	
	public List<String> getSubjects()
	{ return null;}
	
	public float grade(int selectedChoice)
	{ return 0;}
	
	public void setWeight(int weight) throws InvalidOperationException
	{}
	
	public int getWeight()
	{ return 0; }
}
