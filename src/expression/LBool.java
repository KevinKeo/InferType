package expression;

public class LBool implements Literal{
	private Boolean bool;
	
	public LBool(Boolean bool) {
		// TODO Auto-generated constructor stub
		this.bool = bool;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return bool.getClass().toString();
	}

	@Override
	public String infer() {
		// TODO Auto-generated method stub
		return this.getType();
	}
}
