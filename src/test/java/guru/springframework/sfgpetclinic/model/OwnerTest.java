package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.ModelTests;

class OwnerTest implements ModelTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void dependentAssertions() {
		Owner owner = new Owner(1l, "Joe", "Buck");
		owner.setCity("Key West");
		owner.setTelephone("12311231234");

		assertAll("Properties Test",
				() -> assertAll("Person Properties",
						() -> assertEquals("Joe", owner.getFirstName(), "First name did not match"),
						() -> assertEquals("Buck", owner.getLastName(), "Last name did not match")),
				() -> assertAll("Owner Properties",
						() -> assertEquals("Key West", owner.getCity(), "City did not match"),
						() -> assertEquals("12311231234", owner.getTelephone(), "Telephone did not match"))

		);
	}

}
