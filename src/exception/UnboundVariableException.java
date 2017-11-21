package exception;

import expression.Var;

public class UnboundVariableException extends RuntimeException{
	public UnboundVariableException(Var x) {
		super("variable "+x.getName()+" not bound");
	}
}
