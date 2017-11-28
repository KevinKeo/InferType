package susbstitution;

import java.util.Collections;
import java.util.Set;

import type.Scheme;
import type.TArr;
import type.TCon;
import type.TVar;
import type.Type;
import type.TypeEnv;

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
		
	public static Set<TVar> ftv(Type a){
		if(a instanceof TCon)
			return ftv((TCon)a);
		if(a instanceof TVar) 
			return ftv((TVar)a) ;
		if(a instanceof TArr) 
			return ftv((TArr)a) ;
		return null ;
	}
	
	public static Set<TVar> ftv(TCon a){
		return Collections.emptySet();
	}
	
	public static Set<TVar> ftv(TVar a){
		return Collections.singleton(a);
	}
	
	public static Set<TVar> ftv(TArr a){
		 Set<TVar> r = ftv(a.typeLeft); 
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
	
	public static Set<TVar> ftv(Scheme sc){
		Set<TVar> setT = ftv(sc.type);
		sc.as.forEach(setT::remove);
		return setT ;
	}
	
	//-----------------TYPEENV
	
	public static TypeEnv apply(Subst s, TypeEnv te) {
		te.env.replaceAll((k,v) -> apply(s,v));
		return te ;
	}
	
	public static Set<TVar> ftv(TypeEnv te){
		Set<TVar> res = Collections.emptySet();
		te.env.values().forEach(sc -> res.addAll(ftv(sc)));
		return res ;
	}
}
