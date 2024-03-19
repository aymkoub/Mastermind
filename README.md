Mastermind
==========

![](mastermind.jpg)

L'objectif de ce projet est de concevoir une application permettant à un joueur de jouer au mastermind contre l'ordinateur.

Les règles du jeu
-----------------

Pour les règles classiques, vous pouvez consulter :

- une version simple [https://www.regles-de-jeux.com/regle-du-mastermind/](https://www.regles-de-jeux.com/regle-du-mastermind/).
- une explication plus complète : [https://fr.wikihow.com/jouer-au-Mastermind](https://fr.wikihow.com/jouer-au-Mastermind).


#### Le vocabulaire

Au niveau du vocabulaire, nous emploierons les termes suivants :

- une **combinaison** : c'est une ligne de pions
  - il y a la **combinaison secrète** et les combinaisons tentées par le joueur, appelées **tentatives**.
- un **indice** : information sur le pion d'une combinaison, donnée par l'ordinateur, qui indique si le pion est bien placé, mal placé ou absent
- une **ligne d'indices** : c'est ensemble des indices associés à une combinaison
- une **manche** : c'est l'ensemble des tentatives ayant permis ou non de trouver une combinaison secrète
- une **partie** : c'est un ensemble de manches


Les fonctionnalités
-------------------
 La partie compte maximum de **8 pions différents**
- avant de démarrer une partie, le joueur fixe ces paramètres qui seront les mêmes pour toutes ses manches :
  - le **nombre de manches** : 1 minimum, 3 par défaut, 5 maximum
  - le **nombre de pions disponibles** : 4 minimum, 8 par défaut, 8 maximum
  - le **nombre de pions d'une combinaison** : 2 minimum, 4 par défaut, 6 maximum
  - le **nombre de tentatives** maximum pour trouver la combinaison secrète : 2 minimum, 10 par défaut, 12 maximum
  - le **mode d'affichage des indices** : facile, classique ou numérique
- le **score d'une manche** est calculé à partir de la dernière tentative du joueur comme la somme du nombre de pions mal placés, de trois fois celle du nombre de pions bien placés et de 4 points bonus si on est en mode classique.

L'interface graphique
---------------------

L'application propose 3 écrans :

- un **écran de démarrage** pour choisir les paramètres : nom du joueur, type de partie, etc.
- un **écran de jeu** avec le plateau qui affiche les combinaisons tentées, les indices associés, etc.
- un **écran de fin de partie** qui affiche le score du joueur et s'il a gagné ou perdu

#### Les interactions de l'utilisateur

Un joueur peut réaliser les actions suivantes à **n'importe quel moment d'une partie** :

- choisir les couleurs de sa prochaine combinaison
- valider sa combinaison pour recevoir l'indice de l'ordinateur
- remettre à zéro sa combinaison
- abandonner la manche courante pour passer à la suivante

### L'affichage des indices

L'affichage des indices dépend du mode choisit au niveau des paramètres :

- **mode "facile"** : les jetons noirs et blancs sont affichés en correspondance de la combinaison proposée par le joueur (i.e. à la même place)
- **mode "classique"** (mode par défaut) : les jetons noirs sont affichés en premier, puis les jetons blancs
- **mode numérique** : on affiche le nombre de pions bien placés et le nombre de pions mal placés.
  
### Précisions
L exécutable fonctionne sur Linux, Windows et Mac.
