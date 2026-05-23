# SpeedrunChallenges

Plugin Minecraft Paper 1.21.1 proposant plusieurs mini-jeux et défis speedrun multijoueurs.

## Fonctionnalités

- Système de challenges sélectionnables
- Lobby configurable
- Téléportation aléatoire des joueurs
- Scoreboard dynamique
- BossBar personnalisée
- Compteur de morts
- Freeze de départ
- Countdown visuel
- Support multijoueur

---

# Challenges disponibles

## Diamond Challenge

Le premier joueur qui obtient un diamant gagne la partie.

---

## Mob Kill Challenge

Le premier joueur qui tue le mob demandé gagne.

Exemples :

* Zombie
* Creeper
* Blaze
* Enderman

---

## Any Mob Challenge

Trois mobs aléatoires sont choisis.

Le premier joueur à tuer les 3 mobs gagne.

Fonctionnalités :

* BossBar dynamique
* Barre de progression
* Traductions françaises
* Progression en temps réel

---

## Advancement Challenge

Un avancement Minecraft aléatoire est choisi.

Le premier joueur qui le complète gagne.

Fonctionnalités :

* Traductions françaises
* Descriptions des objectifs
* Reset automatique des advancements

Exemples :

* Diamonds!
* Monster Hunter
* Acquire Hardware
* Sweet Dreams

---

## Death Challenge

Une façon de mourir est choisie aléatoirement.

Le premier joueur à mourir correctement gagne.

Exemples :

* Se noyer
* Mourir de chute
* Brûler
* Explosion
* Électrocution

---

## Death Swap

Les joueurs échangent leurs positions toutes les X minutes.

Le but est de préparer des pièges pour faire mourir son adversaire.

Fonctionnalités :

* Countdown avant swap
* Swap automatique
* BossBar
* Timer configurable

---

## Block Hunt

Un bloc aléatoire est choisi.

Le premier joueur qui casse le bon bloc gagne.

Exemples :

* Oak Log
* Obsidian
* Sand
* Gold Block

---

## Ore Challenge

Un minerai aléatoire est choisi.

Le premier joueur qui le trouve gagne.

Exemples :

* Diamond Ore
* Emerald Ore
* Gold Ore
* Ancient Debris

---

## Random Item Challenge

Un objet aléatoire doit être obtenu.

L'objet peut être :

* crafté
* looté
* récupéré sur un mob
* trouvé dans une structure

Fonctionnalités :

* Grande variété d’items
* Traductions françaises
* Détection automatique inventaire

Exemples :

* Cake
* Blaze Rod
* Saddle
* Ender Pearl
* Hopper
* Trident

---

## XP Challenge

Un niveau d’expérience aléatoire est choisi.

Le premier joueur qui atteint le niveau demandé gagne.

Exemples :

* Niveau 10
* Niveau 20
* Niveau 30

---

## Dimension Race

Une dimension doit être atteinte.

Modes disponibles :

* Nether
* End
* Random

Le premier joueur qui atteint la bonne dimension gagne.

---

## Damage Challenge

Un type de dégâts est choisi.

Les joueurs doivent accumuler suffisamment de dégâts sans stratégie fixe.

Fonctionnalités :

* BossBar dynamique
* Progression en temps réel
* Affichage en cœurs
* Plusieurs types de dégâts

Exemples :

* Dégâts de chute
* Feu
* Lave
* Cactus
* Gel

---

# Commandes

## Challenges

```text
/challenge
```

Ouvre le menu de sélection des challenges.

---

## Stop challenge

```text
/stopchallenge
```

Arrête la partie actuelle.

---

## Lobby

### Définir le lobby

```text
/setlobby
```

Définit le lobby à la position actuelle.

### Supprimer le lobby

```text
/removelobby
```

Supprime le lobby configuré.

---

## Reset du monde

```text
/resetworld
```

Reset les mondes de jeu.

Le serveur doit ensuite être redémarré pour terminer complètement la régénération des mondes.

# Technologies utilisées

- Java
- Paper API 1.21.1
- Gradle
- Bukkit / Spigot API

---

# Installation

1. Télécharger le `.jar`
2. Le placer dans :

```text
/plugins
```

3. Redémarrer le serveur

---

# Serveur recommandé

- Paper 1.21.1+
- Java 21

---

# Roadmap

Fonctionnalités prévues :

- GUI améliorée
- Nouveaux challenges
- Classement global
- Config YAML
- Modes équipe
- Statistiques
- SQLite/MySQL
- Système de saisons

---

# Auteur

Développé par Simon Dourte.
