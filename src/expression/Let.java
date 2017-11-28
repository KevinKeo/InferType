package expression;

import type.Infer;
import type.Scheme;
import type.Type;

public class Let implements Expr {
	String name;
	Expr e1, e2;

	public Let(String name, Expr e1, Expr e2) {
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
}
