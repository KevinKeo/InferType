package solver;

import java.util.List;

import susbstitution.Subst;
import type.Constraint;

public class Unifier {
	public Subst subst;
	public List<Constraint> constraints;

	public Unifier(Subst subst, List<Constraint> constraints){
		this.subst = subst ;
		this.constraints = constraints;
	}
}
