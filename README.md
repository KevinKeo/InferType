# InferType

## Contexte
Implémentation partielle de l'algorithme de Hindler Milner par génération de contraintes (http://dev.stephendiehl.com/fun/006_hindley_milner.html) en Java dans le cadre du cursus ingénieur à l'IMT Atlantique.

## Description
Le système de type de Hindley Milner est un classique sur lequel repose de nombreux systèmes
de type. Il permet de typer des programmes fonctionnels d’ordre supérieur et prend en compte le
polymorphisme. Son algorithme d’inférence lui permet d’inventer le type le plus général pour un
programme donné.

Le programme prend en entré l’arbre syntaxique d’une lambda-expression et retourne le type de cette expression, ou
une erreur si l’expression n’est pas typable. 

La grammaires des programmes à typer est définie par six cas :

```
E  ::=  x  |  \x->E  |  E  E  |  let  x  =  E  in  E  |  1  |  True
```

