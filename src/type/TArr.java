package type;

import inference.Subst;

import java.util.HashSet;

public class TArr implements Type{
	public Type typeLeft;
	public Type typeRight;
	
	public TArr(Type left, Type right) {
		this.typeLeft=left;
		this.typeRight=right;
	}
	
	@Override
	public String toString() {
		return typeLeft.toString()+" -> "+typeRight.toString();
	}

	@Override
	public Type apply(Subst s) {
		return new TArr(this.typeLeft.apply(s), this.typeRight.apply(s)) ;
	}

	@Override
	public HashSet<TVar> ftv() {
		HashSet<TVar> r = this.typeLeft.ftv();
		r.addAll(this.typeRight.ftv());
		return r ;
	}

	public Subst unifyMany(TArr t2){
		Subst su1 = this.typeLeft.unifies(t2.typeLeft);
		Subst su2 = this.typeRight.apply(su1).unifies(t2.typeRight.apply(su1));
		return su2.compose(su1);
	}
}
