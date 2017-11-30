package susbstitution;

import inference.Subst;
import type.TVar;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public interface Substitutable<T extends Substitutable<T>> {

    T apply(Subst s);
    HashSet<TVar> ftv();

    static <Y extends Substitutable<Y>> List<Y> apply(Subst s, List<Y> c){
        return c.stream().map(e -> e.apply(s)).collect(Collectors.toList());
    }

}
