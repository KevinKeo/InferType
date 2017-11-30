package expression;

import inference.Infer;
import type.Scheme;
import type.Type;

public class Let extends Expr {
	private Var name;
	private Expr e1, e2;

	public Let(Var name, Expr e1, Expr e2) {
		this.name = name;
		this.e1 = e1;
		this.e2 = e2;
	}
	
	@Override
	public Type infer(Infer infer) {
		Type t1 = e1.infer(infer);
		Scheme sc = t1.generalize(infer.typeEnv());
		Infer newInfer = infer.inEnv(name, sc);
		Type t2 = e2.infer(newInfer);
		return t2;
	}
	
	@Override
	public String toString() {
		return "Let(var:"+name+" e1:"+e1+" e2:"+e2+")";
	}
}
