package type;

import java.util.List;

import expression.Lit;
import expression.Var;

public class Infer {
	public TypeEnv env;
	public List<Constraint> constraints;
	public InferState inferState;
	
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
		Var var = new Var(name);
		m.env.remove(var);
		m.env.extend(var, scheme);
		return m;
	}
	
	public Type infer(Lit e) {
		return e.getType();
	}

	
	/*public Scheme(Var x) {
		if (env.getEnv().containsKey(x) == false) {
			throw new UnboundVariableException(x);
		}
	}*/
	 	
	/*lookupEnv :: TypeEnv -> Var -> Infer (Subst, Type)
	lookupEnv (TypeEnv env) x = do
	  case Map.lookup x env of
	    Nothing -> throwError $ UnboundVariable (show x)
	    Just s  -> do t <- instantiate s
	                  return (nullSubst, t)
	   */            		  
	 /* instantiate ::  Scheme -> Infer Type
	                		 instantiate (Forall as t) = do
	                		    as' <- mapM (const fresh) as
	                		    let s = Map.fromList $ zip as as'
	                		    return $ apply s t

	                		  generalize :: TypeEnv -> Type -> Scheme
	                		  generalize env t  = Forall as t
	                		      where as = Set.toList $ ftv t `Set.difference` ftv env
	                		      
	                		      */
}
	