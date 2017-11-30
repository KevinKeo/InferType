package type;

import susbstitution.Subst;

import java.util.Collections;
import java.util.HashSet;

public class TVar implements Type {
	String name;
	
	public TVar(String name) {
		this.name=name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TVar) {
			return this.name.equals(((TVar)obj).name);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "TVar("+name+")";
	}

	@Override
	public Type apply(Subst s) {
		return s.map.getOrDefault(this,this);
	}

	@Override
	public HashSet<TVar> ftv() {
		return new HashSet<>(Collections.singleton(this));
	}
}
