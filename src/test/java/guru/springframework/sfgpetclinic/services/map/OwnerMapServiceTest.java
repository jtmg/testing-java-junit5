package guru.springframework.sfgpetclinic.services.map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;

@DisplayName("Owner Map Service Test - ")
class OwnerMapServiceTest {

	OwnerMapService ownerMapService;
	PetTypeService petTypeService;
	PetService petService;

	@BeforeEach
	void setUp() throws Exception {
		petTypeService = new PetTypeMapService();
		petService = new PetMapService();
		ownerMapService = new OwnerMapService(petTypeService, petService);
		System.out.println("First Before Each");
	}

	@DisplayName("Verify Zero Owners")
	@Test
	void ownersAreZero() {
		int ownerCount = ownerMapService.findAll().size();
		assertThat(ownerCount).isZero();
	}

	@DisplayName("Pet Type - ")
	@Nested
	class TesCreatePetTyes {

		@BeforeEach
		void setUp() throws Exception {
			PetType petType = new PetType(1l, "Dog");
			PetType petType2 = new PetType(2l, "Cat");

			petTypeService.save(petType);
			petTypeService.save(petType2);

			System.out.println("Nested Before Each");
		}

		@Test
		void testPetCount() {
			int petTypeCount = petTypeService.findAll().size();
			assertThat(petTypeCount).isNotZero().isEqualTo(2);
		}

		@DisplayName("Save Owners Tests - ")
		@Nested
		class SaveOwnersTests {

			@BeforeEach
			void setUp() throws Exception {
				ownerMapService.save(new Owner(1l, "Before", "Each"));
				System.out.println("Owners Before Each");
			}

			@Test
			void saveOwner() {
				Owner owner = new Owner(2l, "joe", "buck");

				Owner savedOwner = ownerMapService.save(owner);

				assertThat(savedOwner).isNotNull();
			}
		}
	}

	@DisplayName("Verify Still Zero Owners")
	@Test
	void ownersAreStillZero() {
		int ownerCount = ownerMapService.findAll().size();

		assertThat(ownerCount).isZero();
	}

}
