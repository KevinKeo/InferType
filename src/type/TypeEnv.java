package type;

import java.util.HashMap;
import java.util.Map;


public class TypeEnv {
	Map<TVar, Scheme> env;
	
	public TypeEnv() {
		env = new HashMap<>();
	}
	
	public void extend (TVar var, Scheme scheme) {
		env.put(var, scheme);
	}
	
	public void remove(TVar var) {
		this.env.remove(var);
	}
	
	public Map<TVar, Scheme> getEnv(){
		return this.env;
	}
}
