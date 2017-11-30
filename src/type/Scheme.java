package type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import inference.Infer;
import inference.Subst;
import susbstitution.Substitutable;

public class Scheme implements Substitutable<Scheme> {
	private Type type;
	private List<TVar> as;
	
	public Scheme(Type type, List<TVar> listTV) {
		this.type = type;
		this.as = listTV;
	}

	public Type instantiate(Infer infer) {
		HashMap<TVar,Type> map = new HashMap<>();
		this.as.forEach(tv -> map.put(tv,infer.inferState().fresh()));
		return this.type.substitute(new Subst(map));
	}
	
	@Override
	public String toString() {
		return "Scheme(type:"+type+" et ListTVar:"+as+")";
	}

	@Override
	public Scheme substitute(Subst s) {
		for(TVar tv : this.as)
			s.substituteMap().remove(tv);
		this.type = this.type.substitute(s);
		return this ;
	}

	@Override
	public HashSet<TVar> ftv() {
		HashSet<TVar> setT = this.type.ftv();
		this.as.forEach(setT::remove);
		return setT ;
	}
}
