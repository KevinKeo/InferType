package expression;

public class Var implements Expr{
	String name;
	public Var(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
}
