package type;

import java.util.List;

import expression.Var;

public class Infer {
	public TypeEnv env;
	public List<Constraint> constraints;
	public InferState inferState;
	
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
	
	public Infer inEnv(Var var,Scheme scheme) {
		Infer m = new Infer(new TypeEnv().combine(env),this.constraints,this.inferState) ;
		m.env.remove(var);
		m.env.extend(var, scheme);
		return m;
	}
}
	