package solver;

import exception.UnificationException;
import susbstitution.Subst;
import susbstitution.Substitutable;
import type.Constraint;
import type.TArr;
import type.TVar;
import type.Type;

import java.util.HashMap;

public class Solve {

	public static Subst unifies(Type t1, Type t2) {
		if(t1.equals(t2))
		    return new Subst();
		if(t1 instanceof TVar)
		    return bind((TVar)t1,t2);
		if(t2 instanceof TVar)
		    return bind((TVar)t2,t1);
		if(t1 instanceof TArr && t2 instanceof TArr){
            return unifyMany((TArr)t1,(TArr)t2);
        }
        throw new UnificationException("UnificationFail", t1,t2);
	}

	public static Subst bind(TVar a, Type t){
        if (a == t) return new Subst();
        if (occursCheck(a,t)) throw new UnificationException("InfiniteType",a,t);
        HashMap<TVar,Type> map = new HashMap();
        map.put(a,t);
        return new Subst(map);
	}

	public static boolean occursCheck(TVar a, Type t){
	    return Substitutable.ftv(t).contains(a);
    }

    public static Subst unifyMany(TArr t1, TArr t2){
        Subst su1 = unifies(t1.typeLeft,t2.typeLeft);
        Subst su2 = unifies(Substitutable.apply(su1,t1.typeRight), Substitutable.apply(su1,t2.typeRight));
        return su2.compose(su1);
    }

    public static Subst solver(Unifier u){
        if(u.constraints.isEmpty()) return u.subst ;
        Constraint cs = u.constraints.get(0) ;
        Subst su1 = unifies(cs.t1,cs.t2) ;
        u.constraints.remove(0);
        return solver(new Unifier(su1.compose(u.subst),Substitutable.<Constraint>apply(su1,u.constraints)));
    }


    public static Type runSolve(Subst s, Type t){
        for(TVar tv : s.map.keySet()){
            t = Substitutable.apply(s,t);
        }
        return t ;
    }
}
