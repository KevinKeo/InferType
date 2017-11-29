package susbstitution;

import java.util.HashMap;
import java.util.Map;

import type.TVar;
import type.Type;

public class Subst {
	public HashMap<TVar, Type> map;
	
	public Subst() {
		this.map = new HashMap<>();
	}
	
	public Subst(HashMap<TVar,Type> map) {
		this.map = map ;
	}

	public Subst compose(Subst s2){
		Subst subst = new Subst(this.map);
		s2.map.forEach((k,v) -> v = Substitutable.apply(this, v));
		subst.map.putAll(s2.map);
		return subst ;
	}
}
