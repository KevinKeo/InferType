package type;

import java.util.List;

public class Scheme {
	Type type;
	List<TVar> listTV;
	
	public Scheme(Type type, List<TVar> listTV) {
		this.type = type;
		this.listTV = listTV;
	}
}
