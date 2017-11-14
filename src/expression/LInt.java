package expression;

public class LInt implements Literal{
	private Integer x;
	
	public LInt(int x) {
		// TODO Auto-generated constructor stub
		this.x=x;
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return x.getClass().toString();
	}

	@Override
	public String infer() {
		// TODO Auto-generated method stub
		return this.getType();
	}

}
