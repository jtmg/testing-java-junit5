package guru.springframework.sfgpetclinic.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import guru.springframework.sfgpetclinic.ControllerTests;

class IndexControllerTest implements ControllerTests {
	IndexController indexController;

	@BeforeEach
	void setUp() throws Exception {
		indexController = new IndexController();
	}

	@DisplayName("Testing index page")
	@Test
	void testIndex() {
		assertEquals("index", indexController.index());
		assertEquals("index", indexController.index(), "Wrong view returned");
		assertThat(indexController.index()).isEqualTo("index");
	}

	@Test
	void testOupsHandler() {

		assertThrows(ValueNotFoundException.class, () -> {
			indexController.oupsHandler();
		});
	}

	@Disabled
	@Test
	void testTimeOut() {
		assertTimeout(Duration.ofMillis(100), () -> {
			Thread.sleep(2000);
			System.out.println("I GOT HERE");
		});
	}

	@Disabled
	@Test
	void testTimeOutPrempt() {
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			Thread.sleep(2000);
			System.out.println("I GOT HERE 464654646545");
		});
	}

	@Test
	void testAssumptionTrue() {
		assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
	}

	@Test
	void testAssumptionTrueAssumptionIsTrue() {
		assumeTrue("GURU".equalsIgnoreCase("GURU"));
	}

	@EnabledOnOs(OS.MAC)
	@Test
	void testMeOnMacOS() {

	}

	@EnabledOnOs(OS.WINDOWS)
	@Test
	void testMeOnWindows() {

	}

	@EnabledOnJre(JRE.JAVA_8)
	@Test
	void testMeOnJava8() {

	}

	@EnabledOnJre(JRE.JAVA_11)
	@Test
	void testMeOnJava11() {

	}

	@EnabledIfEnvironmentVariable(named = "USERNAME", matches = "TGouveia")
	@Test
	void testIfUserJT() {

	}

	@EnabledIfEnvironmentVariable(named = "USERNAME", matches = "FRED")
	@Test
	void testIfUserFred() {

	}

}
