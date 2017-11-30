package inference;

import java.util.HashMap;

import type.TVar;
import type.Type;

public class Subst {
	private HashMap<TVar, Type> substituteMap;
	
	public Subst() {
		this.substituteMap = new HashMap<>();
	}
	
	public Subst(HashMap<TVar,Type> substituteMap) {
		this.substituteMap = substituteMap;
	}

	public Subst compose(Subst s2){
		Subst subst = new Subst(this.substituteMap);
		s2.substituteMap.forEach((k, v) -> v = v.substitute(this));
		subst.substituteMap.putAll(s2.substituteMap);
		return subst ;
	}

	public HashMap<TVar,Type> substituteMap(){
		return this.substituteMap;
	}
}
