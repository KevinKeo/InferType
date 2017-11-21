package type;

import java.util.HashMap;
import java.util.Map;

public class Subst {
	Map<TVar, Type> map;
	public Subst() {
		this.map = new HashMap<>();
	}
}
