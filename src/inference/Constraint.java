package inference;

import susbstitution.Substitutable;
import type.TVar;
import type.Type;

import java.util.HashSet;

public class Constraint implements Substitutable<Constraint> {
	private Type t1,t2;
	
	public Constraint(Type t1, Type t2) {
		this.t1=t1;
		this.t2=t2;
	}
	
	@Override
	public String toString() {
		return t1 +" - "+ t2;
	}


	@Override
	public Constraint apply(Subst s) {
		return new Constraint(this.t1.apply(s), this.t2.apply(s));
	}

	@Override
	public HashSet<TVar> ftv() {
		return null; //TODO - never call
	}

	public Type typeLeft(){
		return this.t1 ;
	}

	public Type typeRight(){
		return this.t2 ;
	}
}
