import java.util.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import ap.Question;
import ap.exception.*;

public class TestQuestion {
	
	@Test
	public void testQuestion1() throws InvalidOperationException {
		List<String> choices = new ArrayList<String>();
		choices.add("Luis de Camoes");
		choices.add("Fernando Pessoa");

		Question question = new Question("Quem escreveu os Lusiadas", choices, 1, "Portugues", 20);

		question.add("Cultura");

		assertEquals(question.getSubjects().get(0), "Portugues");
		assertEquals(question.getSubjects().get(1), "Cultura");
		assertEquals(question.getSubjects().size(), 2);
		assertEquals(question.getWeight(), 20);
		assertEquals(question.grade(1), 20.0f);
		assertEquals(question.grade(2), -20.0f);
	}

	@Test
	public void testQuestion2() {
		List<String> choices = new ArrayList<String>();
		choices.add("4");
		Question question = null;

		try {
			question = new Question("Quanto e 2 + 2", choices, 1, "Matematica", 20);
			fail();
		} catch (InvalidOperationException e) {
			// success
		}
	}

	@Test
	public void testQuestion3() throws InvalidOperationException {
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
	public void testQuestion4() {
		List<String> choices = new ArrayList<String>();
		choices.add("Vais");
		choices.add("partir");
		choices.add("naquela");
		choices.add("estrada");
		choices.add("onde");
		choices.add("um");
		choices.add("dia");
		choices.add("chegaste");
		choices.add("a");
		choices.add("sorrir");
		choices.add("Clemente");
		Question question = null;

		try {
			question = new Question("Vais partir", choices, 8, "Cultura", 17);
			fail();
		} catch (InvalidOperationException e) {
			// success
		}
	}

	@Test
	public void testQuestion5() throws InvalidOperationException {
		List<String> choices = new ArrayList<String>();
		choices.add("Vinte");
		choices.add("Dezanove");

		Question question = new Question("Nota do grupo 14", choices, 1, "Psicologia", 20);

		question.add("TVS");
		question.setWeight(16);

		assertEquals(question.grade(1), 16.0f);
		assertEquals(question.getWeight(), 16);
		assertEquals(question.getSubjects().get(0), "Psicologia");
		assertEquals(question.grade(2), -16.0f);
		assertEquals(question.getSubjects().size(), 2);
		assertEquals(question.getSubjects().get(1), "TVS");
	}

	@Test
	public void testQuestion6() {
		List<String> choices = new ArrayList<String>();
		choices.add("Scooby");
		choices.add("Dooby");
		Question question = null;

		try {
			question = new Question("Doo?", choices, 0, "Yabba", 15);
			fail();
		} catch (InvalidOperationException e) {
			// success
		}
	}
}