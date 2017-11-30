package susbstitution;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import type.*;

public class Substitutable {
	
	//-----------------TYPE
	
	public static Type apply(Subst s, Type a) {
		if(a instanceof TCon)
			return apply(s, (TCon)a) ;
		if(a instanceof TVar) 
			return apply(s, (TVar)a) ;
		if(a instanceof TArr) 
			return apply(s, (TArr)a) ;
		return null ;
	}
	
	public static Type apply(Subst s, TCon a) {
		return a ;
	}
	
	public static Type apply(Subst s, TVar a) {
		Type t = s.map.get(a) ;
		if(t == null) t = a ;
		return t ;
	}
	
	public static Type apply(Subst s, TArr a) {
		return new TArr(apply(s,a.typeLeft), apply(s,a.typeRight)) ;
	}
		
	public static HashSet<TVar> ftv(Type a){
		if(a instanceof TCon)
			return ftv((TCon)a);
		if(a instanceof TVar) 
			return ftv((TVar)a) ;
		if(a instanceof TArr) 
			return ftv((TArr)a) ;
		return null ;
	}
	
	public static HashSet<TVar> ftv(TCon a){
		return new HashSet<TVar>();
	}
	
	public static HashSet<TVar> ftv(TVar a){
		return new HashSet<TVar>(Collections.singleton(a));
	}
	
	public static HashSet<TVar> ftv(TArr a){
		HashSet<TVar> r = ftv(a.typeLeft); 
		r.addAll(ftv(a.typeRight));
		return r ;
	}
	
	//------------------SCHEME
	
	public static Scheme apply(Subst s, Scheme sc){
		for(TVar tv : sc.as)
			s.map.remove(tv);
		sc.type = apply(s,sc.type);
		return sc ;
	}
	
	public static HashSet<TVar> ftv(Scheme sc){
		HashSet<TVar> setT = ftv(sc.type);
		sc.as.forEach(setT::remove);
		return setT ;
	}

	//-----------------[A]

	/*public static <A> List<A> runSolve(Subst s, List<A> a){
		return a.stream().map(m -> runSolve(s,m)).collect(Collectors.toList());
	}*/

	//-----------------Constraint
	public static Constraint apply(Subst s, Constraint c){
		return new Constraint(apply(s, c.t1), apply(s, c.t2));
	}

	public static List<Constraint> apply(Subst s, List<Constraint> c){
		return c.stream().map(m -> apply(s,m)).collect(Collectors.toList());

	}

	//-----------------TYPEENV
	
	public static TypeEnv apply(Subst s, TypeEnv te) {
		te.env.replaceAll((k,v) -> apply(s,v));
		return te ;
	}
	
	public static HashSet<TVar> ftv(TypeEnv te){
		HashSet<TVar> res = new HashSet<>();
		te.env.values().forEach(sc -> res.addAll(ftv(sc)));
		return res ;
	}
}
