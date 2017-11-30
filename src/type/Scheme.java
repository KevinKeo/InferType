package type;

import java.util.HashMap;
import java.util.List;

import susbstitution.Subst;
import susbstitution.Substitutable;

public class Scheme {
	public Type type;
	public List<TVar> as;
	
	public Scheme(Type type, List<TVar> listTV) {
		this.type = type;
		this.as = listTV;
	}

	public Type instantiate(Infer infer) {
		HashMap<TVar,Type> map = new HashMap<>();
		this.as.forEach(tv -> map.put(tv,infer.inferState.fresh()));
		return Substitutable.apply(new Subst(map), this.type);
	}
	
	@Override
	public String toString() {
		return "Scheme(type:"+type.toString()+" et ListTVar:"+as.toString()+")";
	}

}
