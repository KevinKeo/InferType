package expression;

import type.TCon;

public class LBool implements Lit {
	boolean bool;

	public LBool(boolean bool) {
		this.bool = bool;
	}

	@Override
	public TCon getType() {
		return new TCon("Bool");
	}
}
