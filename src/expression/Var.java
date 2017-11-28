package expression;

import exception.UnboundVariableException;
import type.Infer;
import type.Type;

public class Var implements Expr{
	String name;
	public Var(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public Type infer(Infer infer) {
		if (infer.env.getEnv().containsKey(this) == false) 
			throw new UnboundVariableException(this);
		
		return infer.env.getEnv().get(this).instantiate();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Var) {
			return this.name.equals(((Var)obj).name);
		}
		return false;
	}
}
