package app;

import java.util.ArrayList;

import expression.App;
import expression.LBool;
import expression.LInt;
import expression.Lam;
import expression.Let;
import expression.Var;
import solver.Solve;
import solver.Unifier;
import susbstitution.Subst;
import type.Constraint;
import type.Infer;
import type.InferState;
import type.Type;
import type.TypeEnv;

public class Main {
	public static void main(String[] args) {
		/*Infer infer = new Infer(new TypeEnv(), new ArrayList<Constraint>(), new InferState());

		Expr boolExp = new LBool(true);
        Type t = boolExp.infer(infer);
        System.out.println(t);*/
        
		/*
		 * TEST 2 
		 * Infer infer = new Infer(new TypeEnv(), new ArrayList<Constraint>(), new InferState());
		
		Expr boolExp = new LBool(true);
        Lam lamExp = new Lam(new Var("x"),boolExp);
        Type t2 = lamExp.infer(infer);
        System.out.println(t2);*/

		/* TEST 3
		 * Infer infer = new Infer(new TypeEnv(), new ArrayList<Constraint>(), new InferState());

		
        Var f = new Var("f");
        Var x = new Var("x");
        Lam l = new Lam(x, x);
        App app = new App(f, new LBool(true));
        Let expFinal = new Let(f, l, app);

        Type t3 = expFinal.infer(infer); */


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

		Type t = let.infer(infer);

		Unifier u = new Unifier(new Subst(),infer.constraints);

		Subst s = Solve.solver(u);
		Type finalType = Solve.runSolve(s,t);
		System.out.println(finalType);
		//System.out.println(u.subst.map);
	}
}
