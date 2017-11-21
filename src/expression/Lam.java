package expression;

public class Lam implements Expr{
	String name;
	Expr e;
	public Lam(String name, Expr e) {
		this.name=name;
		this.e=e;
	}
}
