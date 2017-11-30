package type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import inference.Infer;
import inference.Subst;
import susbstitution.Substitutable;

public class Scheme implements Substitutable<Scheme> {
	public Type type;
	public List<TVar> as;
	
	public Scheme(Type type, List<TVar> listTV) {
		this.type = type;
		this.as = listTV;
	}

	public Type instantiate(Infer infer) {
		HashMap<TVar,Type> map = new HashMap<>();
		this.as.forEach(tv -> map.put(tv,infer.inferState.fresh()));
		return this.type.apply(new Subst(map));
	}
	
	@Override
	public String toString() {
		return "Scheme(type:"+type+" et ListTVar:"+as+")";
	}

	@Override
	public Scheme apply(Subst s) {
		for(TVar tv : this.as)
			s.map.remove(tv);
		this.type = this.type.apply(s);
		return this ;
	}

	@Override
	public HashSet<TVar> ftv() {
		HashSet<TVar> setT = this.type.ftv();
		this.as.forEach(setT::remove);
		return setT ;
	}
}
