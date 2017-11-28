package expression;

import java.util.Collections;

import susbstitution.FreshName;
import type.Infer;
import type.Scheme;
import type.TArr;
import type.TVar;
import type.Type;

public class Lam implements Expr{
	String name;
	Expr e;
	
	public Lam(String name, Expr e) {
		this.name=name;
		this.e=e;
	}
	
	@Override
	public Type infer(Infer infer) {
		TVar tv = FreshName.fresh();
		Infer newInfer = infer.inEnv(name, new Scheme(tv,Collections.emptyList()));
		Type t = e.infer(newInfer);
		return new TArr(tv, t);
	}
}
