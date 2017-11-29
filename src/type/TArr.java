package type;

public class TArr implements Type{
	public Type typeLeft;
	public Type typeRight;
	
	public TArr(Type left, Type right) {
		this.typeLeft=left;
		this.typeRight=right;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return typeLeft.toString()+" -> "+typeRight.toString();
	}
}
