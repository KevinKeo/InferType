package type;

import java.util.ArrayList;
import java.util.Set;

import susbstitution.Substitutable;

public interface Type {
	
	default Scheme generalize(TypeEnv env) {
		Set<TVar> setT = Substitutable.ftv(this);
		Substitutable.ftv(env).forEach(setT::remove);	
		return new Scheme(this,new ArrayList<TVar>(setT));
	}
	
}
