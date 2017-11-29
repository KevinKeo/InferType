package type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import expression.Var;


public class TypeEnv {
	public Map<Var, Scheme> env;
	
	public TypeEnv() {
		env = new HashMap<>();
	}
	
	public void extend (Var var, Scheme scheme) {
		env.put(var, scheme);
	}
	
	public void remove(Var var) {
		this.env.remove(var);
	}
	
	public Map<Var, Scheme> getEnv(){
		return this.env;
	}
	 public TypeEnv combine(TypeEnv typeEnv) {
	        Map<Var, Scheme> newEnv = new HashMap<>();
	        newEnv.putAll(typeEnv.env);
	        (env.keySet()).forEach(newEnv::remove);
	        env.putAll(newEnv);
	        return this;
	}
}
