package type;

public class TArr implements Type{
	Type typeLeft;
	Type typeRight;
	
	public TArr(Type left, Type right) {
		this.typeLeft=left;
		this.typeRight=right;
	}
	
}
