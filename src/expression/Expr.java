package expression;

import inference.Infer;
import type.Type;

public interface Expr {
	
	Type infer(Infer infer);
}
