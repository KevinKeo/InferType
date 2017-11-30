package type;

public class TCon implements Type{
	public String name;
	
	public TCon(String name) {
		this.name=name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TCon) {
			return this.name.equals(((TCon) obj).name);
		}
		return false ;
	}
}
