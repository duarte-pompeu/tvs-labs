import java.util.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import ap.Question;
import ap.exception.*;

public class TestQuestion {
	
	@Test
	public void choiceLengthOnMinBoundary() throws InvalidOperationException {
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
	public void choiceLengthOffMinBoundary() {
		List<String> choices = new ArrayList<String>();
		choices.add("Luis de Camoes");
		choices.add("Fernando Pessoa");

		/*try {
			Question question = new Question("Quem escreveu os Lusiadas", choices, 1, "Portugues", 20);
			fail();
		} catch (InvalidOperationException e)*/
	}

	@Test
	public void choiceLengthOnMaxBoundary() {

	}

	@Test
	public void choiceLengthOffMaxBoundary() {

	}

	@Test
	public void correctChoiceOnMinBoundary() {

	}

	@Test
	public void correctChoiceOffMinBoundary() {

	}
}