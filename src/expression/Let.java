package expression;

import type.Infer;
import type.Scheme;
import type.Type;

public class Let implements Expr {
	Var name;
	Expr e1, e2;

	public Let(Var name, Expr e1, Expr e2) {
		this.name = name;
		this.e1 = e1;
		this.e2 = e2;
	}
	
	@Override
	public Type infer(Infer infer) {
		Type t1 = e1.infer(infer);
		Scheme sc = t1.generalize(infer.env);
		Infer newInfer = infer.inEnv(name, sc);
		Type t2 = e2.infer(newInfer);
		return t2;
	}
	
	@Override
	public String toString() {
		return "Let(var:"+name.toString()+" e1:"+e1.toString()+" e2:"+e2.toString()+")";
	}
}
