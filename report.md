# Rapport 

## Structure du projet
Le projet est structuré en trois grosses parties :
* D'un côté les différentes expressions avec l'interface Inferable qui indique le process pour chaque expression
* D'un autre les types avec le type générique Type, les différents types (TCon, TArr, TVar), le Scheme.
* Enfin la classe Infer contenant les environements, la liste de contraintes et le solver.

## Implémentation
Nous sommes parties vers une implémentation très fonctionnelle au départ, très proche du code en haskell avec des méthodes statiques pour avoir les grandes fonctionnalités de l'algorithme.
Une fois le code fonctionnel, nous avons réalisé un important réfactoring pour avoir une orientation objet.
Ce choix a été fait car nous n'étions pas à l'aise avec l'algorithme et préférions mettre en place une architecture qu'une fois les grosses fonctionnalités de l'algorithme codées.
À présent le code est fonctionnel et il est tout à fait possible d'ajouter, par exemple, des expressions avec un paradigme orienté objet.

## Execution 
Pour executer le code, il suffit de lancer la commande suivante : 
``` 
git clone https://github.com/icyks/InferType.git & cd InferType & mvn install build test
``` 
Cette commande lancera une serie de test avec différents cas de figures.
