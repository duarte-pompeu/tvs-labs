import java.util.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import ap.Question;
import ap.exception.*;

public class TestQuestion {
	
	@Test
	public void testChoiceLengthOnMinBoundary() throws InvalidOperationException {
		List<String> choices = new ArrayList<String>();
		choices.add("Luis de Camoes");
		choices.add("Fernando Pessoa");

		Question question = new Question("Quem escreveu os Lusiadas", choices, 1, "Portugues", 20);

		assertEquals(question.getSubjects().get(0), "Portugues");
		assertEquals(question.getSubjects().size(), 1);
		assertEquals(question.getWeight(), 20);
		assertEquals(question.grade(1), 20.0f);
		assertEquals(question.grade(2), -20.0f);
	}

	@Test
	public void testChoiceLengthOffMinBoundary() {
		List<String> choices = new ArrayList<String>();
		choices.add("4");
		Question question = null;

		try {
			question = new Question("Quanto e 2 + 2", choices, 1, "Matematica", 20);
			fail();
		} catch (InvalidOperationException e) {
			assertEquals(question, null);
		}
	}

	@Test
	public void testChoiceLengthOnMaxBoundary() throws InvalidOperationException {
		List<String> choices = new ArrayList<String>();
		choices.add("A");
		choices.add("B");
		choices.add("C");
		choices.add("D");
		choices.add("E");
		choices.add("F");
		choices.add("10");
		choices.add("11");
		choices.add("12");
		choices.add("13");

		Question question = new Question("Converta para hex: 12", choices, 3, "Informatica", 1);

		question.setWeight(18);
		question.add("Matematica");
		question.add("Cenas");

		assertEquals(question.getWeight(), 18);
		assertEquals(question.getSubjects().size(), 3);
		assertEquals(question.grade(8), -2.0f);
		assertEquals(question.grade(3), 18.0f);
		assertEquals(question.getSubjects().get(2), "Cenas");
		assertEquals(question.getSubjects().get(0), "Informatica");
		assertEquals(question.getSubjects().get(1), "Matematica");
	}

	@Test
	public void testChoiceLengthOffMaxBoundary() {

	}

	@Test
	public void testCorrectChoiceOnMinBoundary() {

	}

	@Test
	public void testCorrectChoiceOffMinBoundary() {

	}
}