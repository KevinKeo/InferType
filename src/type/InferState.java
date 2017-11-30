package type;

public class InferState {
	int counter = -1;

	public TVar fresh(){
		this.counter++;
		return new TVar("t"+counter) ;
	}
}
