package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import guru.springframework.sfgpetclinic.ModelTests;

class PersonTest implements ModelTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void groupedAssertions() {
		// given
		Person person = new Person(1l, "Joe", "Buck");
		// then

		assertAll("Test Props set", () -> assertEquals("Joe", person.getFirstName()),
				() -> assertEquals("Buck", person.getLastName()));
	}

	@Test
	void groupedAssertionsMsgs() {
		// given
		Person person = new Person(1l, "Joe", "Buck");
		// then

		assertAll("Test Props set", () -> assertEquals("Joe", person.getFirstName(), "First Name failed"),
				() -> assertEquals("Buck", person.getLastName(), "Last name Failed"));
	}

	@RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
	@DisplayName("My Repeated Test")
	void myRepeatedTest() {
		// TODO - impl
	}

	@RepeatedTest(5)
	void myRepeatedTestDI(TestInfo aTestInfo, RepetitionInfo aRepetitionInfo) {
		// System.out.println(aTestInfo.getDisplayName() + ": " +
		// aRepetitionInfo.getCurrentRepetition());
	}

}
