package susbstitution;

import type.TVar;

public class FreshName {
	private static int counter = -1 ;
	
	public static TVar fresh(){
		counter++;
	    return new TVar(/*String.valueOf((char)(counter%26 + 'A'))+Integer.toString(counter / 26)*/"t"+counter) ;
	}
}
