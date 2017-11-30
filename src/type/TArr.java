package type;

import inference.Subst;

import java.util.HashSet;

public class TArr implements Type{
	private  Type typeLeft, typeRight;

	public TArr(Type left, Type right) {
		this.typeLeft=left;
		this.typeRight=right;
	}

	@Override
	public Type substitute(Subst s) {
		return new TArr(this.typeLeft.substitute(s), this.typeRight.substitute(s)) ;
	}

	@Override
	public HashSet<TVar> ftv() {
		HashSet<TVar> r = this.typeLeft.ftv();
		r.addAll(this.typeRight.ftv());
		return r ;
	}

	public Subst unifyMany(TArr t2){
		Subst su1 = this.typeLeft.unifies(t2.typeLeft);
		Subst su2 = this.typeRight.substitute(su1).unifies(t2.typeRight.substitute(su1));
		return su2.compose(su1);
	}

	//Getters

	public Type typeLeft(){
		return this.typeLeft ;
	}

	public Type typeRight(){
		return this.typeRight ;
	}

	@Override
	public String toString() {
		return typeLeft.toString()+" -> "+typeRight.toString();
	}
}
