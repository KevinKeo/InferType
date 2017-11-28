package susbstitution;

import java.util.HashMap;
import java.util.Map;

import type.TVar;
import type.Type;

public class Subst {
	Map<TVar, Type> map;
	
	public Subst() {
		this.map = new HashMap<>();
	}
	
	public Subst(Map<TVar,Type> map) {
		this.map = map ;
	}
}
