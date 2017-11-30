package type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import susbstitution.FreshName;
import susbstitution.Subst;
import susbstitution.Substitutable;

public class Scheme {
	public Type type;
	public List<TVar> as;
	
	public Scheme(Type type, List<TVar> listTV) {
		this.type = type;
		this.as = listTV;
	}
	
	/* 
	 * instantiate ::  Scheme -> Infer Type
	   instantiate (Forall as t) = do
	   	as' <- mapM (const fresh) as
	    let s = Map.fromList $ zip as as'
	    return $ runSolve s t
	 */
	public Type instantiate() {
		HashMap<TVar,Type> map = new HashMap<>();
		this.as.forEach(tv -> map.put(tv,FreshName.fresh()));
		return Substitutable.apply(new Subst(map), this.type);
	}
	
	@Override
	public String toString() {
		return "Scheme(type:"+type.toString()+" et ListTVar:"+as.toString()+")";
	}

}
