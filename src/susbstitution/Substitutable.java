package susbstitution;

import inference.Subst;
import type.TVar;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public interface Substitutable<T extends Substitutable<T>> {

    T substitute(Subst s);
    HashSet<TVar> ftv();

    static <Y extends Substitutable<Y>> List<Y> substitute(Subst s, List<Y> c){
        return c.stream().map(e -> e.substitute(s)).collect(Collectors.toList());
    }

}
