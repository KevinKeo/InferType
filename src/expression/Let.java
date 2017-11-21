package expression;

public class Let implements Expr {
	String name;
	Expr e1, e2;

	public Let(String name, Expr e1, Expr e2) {
		this.name = name;
		this.e1 = e1;
		this.e2 = e2;
	}
}
