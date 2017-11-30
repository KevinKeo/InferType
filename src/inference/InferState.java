package inference;

import type.TVar;

public class InferState {
	private int counter = -1;

	public TVar fresh(){
		this.counter++;
		return new TVar("t"+counter) ;
	}
}
