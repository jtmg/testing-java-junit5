package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

public class ModelImp implements Model {

	private Map<String, Object> vets = new HashMap<>();

	@Override
	public void addAttribute(String key, Object o) {
		// TODO Auto-generated method stub

		vets.put(key, o);
	}

	@Override
	public void addAttribute(Object o) {

	}

	public Map<String, Object> vets() {
		return vets;
	}

}
