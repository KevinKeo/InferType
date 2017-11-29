package type;

public class TCon implements Type{
	public String name;
	
	public TCon(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
