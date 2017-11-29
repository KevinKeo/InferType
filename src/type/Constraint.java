package type;

public class Constraint {
	public Type t1,t2;
	
	public Constraint(Type t1, Type t2) {
		this.t1=t1;
		this.t2=t2;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return t1.toString() +" - "+ t2.toString();
	}
	
	
}
