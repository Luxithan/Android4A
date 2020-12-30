# Android4A
Projet 4A (Kotlin)

## Présentation
Ce projet est une application mobile qui permet tout d'abord de se connecter avec un login et un mot de passe puis d'afficher une liste de cartes Pokémon ainsi que leur point de vie (hp).

Cette application utilise une base de données (ROOM) afin de stocker les logins et mot de passe, elle récupère les données via une API Rest, sur https://api.pokemontcg.io/v1/cards puis les affiche via RecyclerView


## Prérequis
* Installation d'Android Studio
  * Installation d'un émulateur mobile / Avoir un téléphone Android

* Notions de programmation en KOTLIN


## Environnement de travail
* IDE : Android Studio 4.1.1
* Language : KOTLIN


## Objectifs du projet
* Apprentissage et amélioration en programmation Kotlin
  * KOTLIN

* Injection de dépendance
  * Koin
  
* Mise en place d'un patron architectural.
  * MVVM

* Mise en place d'une architecture logicielle.
  * Clean Architecture
  
* Utilisation d'une réelle BDD.
  * ROOM

* Appel WebService à une API Rest.
  * Retrofit

* Ecran avec une liste d’éléments.
  * RecyclerView


## Images de l'application
### Ecran de Login :

#### Blocage des boutons tant que les deux champs ne sont pas remplis
![ecran1](https://github.com/Luxithan/Android4A/blob/master/vide1.PNG)
![ecran2](https://github.com/Luxithan/Android4A/blob/master/vide2.PNG)
![ecran3](https://github.com/Luxithan/Android4A/blob/master/vide3.PNG)
![ecran4](https://github.com/Luxithan/Android4A/blob/master/plein.PNG)

#### Succès: Création du compte
![ecran5](https://github.com/Luxithan/Android4A/blob/master/succes_compte.PNG)

#### Succès: Login
![ecran6](https://github.com/Luxithan/Android4A/blob/master/succes_login.PNG)

#### Erreur: Identifiant inconnu
![ecran7](https://github.com/Luxithan/Android4A/blob/master/erreur_identifiant.PNG)

#### Erreur: Mot de passe inconnu
![ecran8](https://github.com/Luxithan/Android4A/blob/master/erreur_password.PNG)

#### Erreur: Identifiant déjà existant
![ecran9](https://github.com/Luxithan/Android4A/blob/master/erreur_identifiant.PNG)
