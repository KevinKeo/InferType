package expression;

import inference.Infer;
import type.TCon;
import type.Type;

public abstract class Lit extends Expr{

	abstract TCon getType();
	
	public Type infer(Infer infer) {
		return this.getType();
	}
}
