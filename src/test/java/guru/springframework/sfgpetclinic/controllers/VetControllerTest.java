package guru.springframework.sfgpetclinic.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelImp;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;

class VetControllerTest implements ControllerTests {

	VetController controller;
	VetService vetService;
	SpecialtyService specialtyService;

	@BeforeEach
	void setUp() throws Exception {
		specialtyService = new SpecialityMapService();
		vetService = new VetMapService(specialtyService);

		controller = new VetController(vetService);

		Vet v1 = new Vet(1l, "joe", "buck", null);
		Vet vet2 = new Vet(2l, "jimmy", "smith", null);

		vetService.save(v1);
		vetService.save(vet2);

	}

	@Test
	void testListVets() {

		Model model = new ModelImp();
		String view = controller.listVets(model);

		assertThat("vets/index").isEqualTo(view);

		Set modelAttr = (Set) ((ModelImp) model).vets().get("vets");
		assertThat(modelAttr.size()).isEqualTo(2);
	}

}
