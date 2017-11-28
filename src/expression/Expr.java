package expression;

import type.Infer;
import type.Type;

public interface Expr {
	
	public Type infer(Infer infer);
}
