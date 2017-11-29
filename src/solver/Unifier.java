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
		constraints = new ArrayList<Constraint>();
	}
}
