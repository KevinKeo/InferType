package inference;

import java.util.ArrayList;
import java.util.List;

import expression.Expr;
import expression.Var;
import susbstitution.Substitutable;
import type.*;

public class Infer {
	private TypeEnv env;
	private List<Constraint> constraints;
	private InferState inferState;

	public Infer(){
		this(new TypeEnv(),new ArrayList<>(),new InferState());
	}

	public Infer(TypeEnv env, List<Constraint> constraints, InferState inferState) {
		this.env = env ;
		this.constraints = constraints ;
		this.inferState = inferState ;
	}
	
	public Infer uni(Type t1, Type t2) {
		Constraint c = new Constraint(t1, t2);
		constraints.add(c);
		return this;
	}
	
	public Infer inEnv(Var var, Scheme scheme) {
		Infer m = new Infer(new TypeEnv().combine(env),this.constraints,this.inferState) ;
		m.env.remove(var);
		m.env.extend(var, scheme);
		return m;
	}

	private Subst solver(Subst subst){
		if(this.constraints.isEmpty()) return subst ;
		Constraint cs = this.constraints.get(0) ;
		Subst su1 = cs.typeLeft().unifies(cs.typeRight()) ;
		this.constraints.remove(0);
		this.constraints = Substitutable.substitute(su1,constraints);
		return solver(su1.compose(subst));
	}

	private Type runSolve(Subst s, Type t){
		for(TVar tv : s.substituteMap().keySet()){
			t = t.substitute(s);
		}
		return t ;
	}

	public Type infer(Expr e){
		Type t = e.infer(this);
		Subst s = this.solver(new Subst());
		return this.runSolve(s,t);
	}

	public InferState inferState(){
		return this.inferState ;
	}

	public TypeEnv typeEnv(){
		return this.env ;
	}
}
	