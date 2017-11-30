package type;

import java.util.ArrayList;
import java.util.Set;

import susbstitution.Substitutable;

public interface Type extends Substitutable<Type> {
	
	default Scheme generalize(TypeEnv env) {
		Set<TVar> setT = this.ftv();
		env.ftv().forEach(setT::remove);
		return new Scheme(this,new ArrayList<>(setT));
	}
	
}
