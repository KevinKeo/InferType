package type;

import java.util.ArrayList;
import java.util.Set;

import exception.UnificationException;
import susbstitution.Solvable;
import inference.Subst;
import susbstitution.Substitutable;

public interface Type extends Substitutable<Type>, Solvable<Type> {
	
	default Scheme generalize(TypeEnv env) {
		Set<TVar> setT = this.ftv();
		env.ftv().forEach(setT::remove);
		return new Scheme(this,new ArrayList<>(setT));
	}

	@Override
	default Subst unifies(Type t2){
		if(this.equals(t2))
			return new Subst();
		if(this instanceof TVar)
			return ((TVar)this).bind(t2);
		if(t2 instanceof TVar)
			return ((TVar)t2).bind(this);
		if(this instanceof TArr && t2 instanceof TArr)
			return ((TArr)this).unifyMany((TArr)t2);
		throw new UnificationException("UnificationFail", this,t2);
	}
}
