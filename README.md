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
- Zombie
- Creeper
- Blaze
- Enderman

---

## Any Mob Challenge
Trois mobs aléatoires sont choisis.

Le premier joueur à tuer les 3 mobs gagne.

Inclut :
- BossBar dynamique
- Barre de progression
- Validation des objectifs

---

## Advancement Challenge
Un avancement Minecraft aléatoire est choisi.

Le premier joueur qui le complète gagne.

Exemples :
- Diamonds!
- Monster Hunter
- Acquire Hardware

---

## Death Challenge
Une façon de mourir est choisie aléatoirement.

Le premier joueur à mourir correctement gagne.

Exemples :
- Se noyer
- Mourir de chute
- Brûler
- Explosion

---

## Death Swap
Les joueurs échangent leurs positions toutes les X minutes.

Le but est de préparer des pièges pour faire mourir son adversaire.

Fonctionnalités :
- Countdown avant swap
- Swap automatique
- BossBar
- Timer configurable

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
