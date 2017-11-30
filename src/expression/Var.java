package expression;

import exception.UnboundVariableException;
import inference.Infer;
import type.Type;

public class Var implements Expr{
	private String name;
	public Var(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public Type infer(Infer infer) {
		if (infer.typeEnv().envMap().containsKey(this) == false)
			throw new UnboundVariableException(this);
		
		return infer.typeEnv().envMap().get(this).instantiate(infer);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Var) {
			return this.name.equals(((Var)obj).name);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Var("+name+")";
	}
}
