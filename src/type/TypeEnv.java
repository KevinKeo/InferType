package type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import expression.Var;
import inference.Subst;
import susbstitution.Substitutable;


public class TypeEnv implements Substitutable<TypeEnv> {
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

	@Override
	public TypeEnv apply(Subst s) {
		this.env.replaceAll((k,v) -> v.apply(s));
		return this ;
	}

	@Override
	public HashSet<TVar> ftv() {
		HashSet<TVar> res = new HashSet<>();
		this.env.values().forEach(sc -> res.addAll(sc.ftv()));
		return res ;
	}
}
