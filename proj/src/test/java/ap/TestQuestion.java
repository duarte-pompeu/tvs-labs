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
	public void testChoiceLengthOnMaxBoundary() {

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