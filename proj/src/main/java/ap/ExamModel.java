 package ap;

import java.util.*;
import ap.exception.*;

public  class ExamModel{
	public  static enum ModelState {OPEN, CLOSED};
	
	public ExamModel()
	{}
	
	public int addGroup(int numberOfQuestions, String subject)
	{ return 0; }
	
	public void removeGroup(int group)
	{}
	
	public void addQuestion(Question q, int groupNumber)
	{}
	
	public void removeQuestion(Question q, int groupNumber)
	{}
	
	public String validate()
	{ return "bueno"; } 
}
