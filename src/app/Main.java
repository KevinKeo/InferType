package app;

import java.util.ArrayList;

import expression.App;
import expression.LBool;
import expression.LInt;
import expression.Lam;
import expression.Let;
import expression.Var;
import inference.Constraint;
import inference.Infer;
import inference.InferState;
import type.Type;
import type.TypeEnv;

public class Main {
	public static void main(String[] args) {
		Infer infer= new Infer(new TypeEnv(), new ArrayList<Constraint>(), new InferState());
	
		Var x = new Var("x");
		Var a = new Var("a");
		Var b = new Var("b");
		Lam l = new Lam(x, x);
		Lam l2 = new Lam(a,new Lam(b,b));
		
		Var f = new Var("f");
		App a1 = new App(f, new LBool(true));
		App a2 = new App(f, new LInt(1));
		
		App superApp = new App(new App(l2,a1),a2);
		
		Let let = new Let(f, l, superApp);

		Type finalType = infer.infer(let);

		System.out.println(finalType);
	}
}
