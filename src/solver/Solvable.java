package solver;

import susbstitution.Subst;



/**
 * Created by borsing on 30/11/17.
 */
public interface Solvable<T> {

    Subst unifies(T s2);

}
