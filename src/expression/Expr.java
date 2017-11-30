package expression;

import type.Infer;
import type.Type;

public interface Expr {
	
	Type infer(Infer infer);
}
