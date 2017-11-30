package expression;

import java.util.Collections;

import inference.Infer;
import type.Scheme;
import type.TArr;
import type.TVar;
import type.Type;

public class Lam extends Expr{
	private Var name;
	private Expr e;
	
	public Lam(Var name, Expr e) {
		this.name=name;
		this.e=e;
	}
	
	@Override
	public Type infer(Infer infer) {
		TVar tv = infer.inferState().fresh();
		Infer newInfer = infer.inEnv(name, new Scheme(tv,Collections.emptyList()));
		Type t = e.infer(newInfer);
		return new TArr(tv, t);
	}
	
	@Override
	public String toString() {
		return "Lam(var:"+name+" expr:"+e+")";
	}
}
