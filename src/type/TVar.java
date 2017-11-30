package type;

public class TVar implements Type{
	String name;
	
	public TVar(String name) {
		this.name=name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TVar) {
			return this.name.equals(((TVar)obj).name);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "TVar("+name+")";
	}
}
