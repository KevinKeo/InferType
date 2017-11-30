package expression;

import type.Infer;
import type.TCon;
import type.Type;

public interface Lit extends Expr{
	TCon getType();
	
	default Type infer(Infer infer) {
		return this.getType();
	}
}
