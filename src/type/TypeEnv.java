package type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import expression.Var;
import inference.Subst;
import susbstitution.Substitutable;


public class TypeEnv implements Substitutable<TypeEnv> {
	private Map<Var, Scheme> envMap;
	
	public TypeEnv() {
		envMap = new HashMap<>();
	}
	
	public void extend (Var var, Scheme scheme) {
		envMap.put(var, scheme);
	}
	
	public void remove(Var var) {
		this.envMap.remove(var);
	}
	
	public Map<Var, Scheme> envMap(){
		return this.envMap;
	}
	 public TypeEnv combine(TypeEnv typeEnv) {
	        Map<Var, Scheme> newEnv = new HashMap<>();
	        newEnv.putAll(typeEnv.envMap);
	        (envMap.keySet()).forEach(newEnv::remove);
	        envMap.putAll(newEnv);
	        return this;
	}

	@Override
	public TypeEnv apply(Subst s) {
		this.envMap.replaceAll((k, v) -> v.apply(s));
		return this ;
	}

	@Override
	public HashSet<TVar> ftv() {
		HashSet<TVar> res = new HashSet<>();
		this.envMap.values().forEach(sc -> res.addAll(sc.ftv()));
		return res ;
	}
}
