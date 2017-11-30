package type;

import exception.UnificationException;
import inference.Subst;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class TVar implements Type {
	private String name;
	
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
		return s.substituteMap().getOrDefault(this,this);
	}

	@Override
	public HashSet<TVar> ftv() {
		return new HashSet<>(Collections.singleton(this));
	}

	public boolean occursCheck(Type t){
		return t.ftv().contains(this);
	}

	public Subst bind(Type t){
		if (this == t) return new Subst();
		if (this.occursCheck(t)) throw new UnificationException("InfiniteType",this,t);
		HashMap<TVar,Type> map = new HashMap();
		map.put(this,t);
		return new Subst(map);
	}

	/*@Override
	public Subst unifies(Type t2){
		return same(t2).orElse(this.bind(t2));
	}*/
}
