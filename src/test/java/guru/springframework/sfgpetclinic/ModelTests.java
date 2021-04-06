package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("model")
public interface ModelTests {

	@BeforeEach
	default void beforeEach(TestInfo aTestInfo, RepetitionInfo aRepetitionInfo) {
		System.out.println("NAME: " + aTestInfo.getDisplayName() + " -> " + aRepetitionInfo.getCurrentRepetition()
				+ " of " + aRepetitionInfo.getTotalRepetitions());
	}

}
