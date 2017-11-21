package type;

import java.util.List;

import exception.UnboundVariableException;
import expression.Expr;
import expression.Lit;
import expression.Var;

public class Infer {
	TypeEnv env;
	List<Constraint> constraints;
	InferState inferState;
	
	public Infer(TypeEnv env, List<Constraint> constraints, InferState inferState) {
		this.env = env ;
		this.constraints = constraints ;
		this.inferState = inferState ;
	}
	
	public Infer uni(Type t1, Type t2) {
		Constraint c = new Constraint(t1, t2);
		constraints.add(c);
		return this;
	}
	
	public Infer inEnv(String name,Scheme scheme) {
		Infer m = new Infer(this.env,this.constraints,this.inferState) ;
		TVar tvar = new TVar(name);
		m.env.remove(tvar);
		m.env.extend(tvar, scheme);
		return m;
	}
	
	public Type infer(Lit e) {
		return e.getType();
	}

	public Type infer(Var x) {
		if (env.getEnv().containsKey(x) == false) {
			throw new UnboundVariableException(x);
		}
		
		return null;
	}
	
	lookupEnv :: TypeEnv -> Var -> Infer (Subst, Type)
	lookupEnv (TypeEnv env) x = do
	  case Map.lookup x env of
	    Nothing -> throwError $ UnboundVariable (show x)
	    Just s  -> do t <- instantiate s
	                  return (nullSubst, t)
}
	