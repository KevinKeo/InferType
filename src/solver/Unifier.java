package solver;

import java.util.ArrayList;
import java.util.List;

import susbstitution.Subst;
import type.Constraint;

public class Unifier {
	public Subst subst;
	public List<Constraint> constraints;
	
	public Unifier() {
		subst = new Subst();
		constraints = new ArrayList<>();
	}

	public Unifier(Subst subst, List<Constraint> constraints){
		this.subst = subst ;
		this.constraints = constraints;
	}
}
