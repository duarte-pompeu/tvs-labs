import java.util.*;
import org.testng.annotations.Test;
import ap.Question;

public class TestQuestion {
	
	@Test
	public void choiceLengthOnMinBoundary() {
		List<String> choices = new ArrayList<String>();
		choices.add("Luis de Camoes");
		choices.add("Fernando Pessoa");
		Question question = new Question("Quem escreveu os Lusiadas", choices, 1, "Portugues", 20);
	}

	@Test
	public void choiceLengthOffMinBoundary() {

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