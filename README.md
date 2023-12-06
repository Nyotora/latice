# Latice

## Présentation

Latice est un jeu de plateau que nous avons du réaliser dans le cadre d'une SAé au second semestre de BUT1 informatique.

Notre client est l’entreprise GamIUTer, et celle-ci voudrait une version numérique simplifiée du jeu LATICE qu’elle vient juste de découvrir, voici une image du jeu :

![image](https://github.com/Nyotora/latice/assets/101416486/6b9fdf0c-fd18-45c1-8698-50221ce1e62c)

L’entreprise voudrait recevoir rapidement la version numérique du jeu pour pouvoir y jouer et le commercialiser le plus tôt possible, c’est pour cela qu’elle a décidé de simplifier les règles du jeu de base pour que nous, développeurs et responsables du projet, puissions lui livrer le plus rapidement.

Voici les quelques simplifications qu’a proposé l’entreprise :

*	Le jeu ne pourra être joué que par 2 joueurs
* Le jeu ne comportera pas de pierres, elles seront remplacées par des point :
   - Une demi-pierre rapportera 1 point
   - pierre de soleil rapportera 2 points

*	Il n’y aura pas de limite de points
*	L’achat d’une action supplémentaire coûtera 2 points
*	L’action d’échanger nos tuiles échangera toutes les tuiles de notre rack, il n’y aura pas de choix de tuile possible
*	Le jeu ne comportera pas de tuile vent (mais le client ne sera pas contre le fait de l’avoir en supplément 😉)

Les règles du jeu sont disponibles sur le site du jeu : https://latice.com/how/

Notre client précise par la suite qu’il veut pouvoir disposer d’un menu ou bien encore mieux d’une interface graphique permettant d’effectuer les actions suivantes :
- Jouer une tuile
- Acheter une action supplémentaire
- Échanger tout le rack et passer son tour
- Passer son tour

## Stack technique
Nous sommes donc chargés du développement de cette forme simplifié du jeu LATICE. L’application devra être implémentée en Java, tout en utilisant JavaFX pour réaliser l’IHM (Interface Homme-Machine) afin de proposer une expérience utilisateur plus agréable. 

Nous sommes personnellement partis sur l’utilisation du logiciel Eclipse en tant qu’IDE de programmation car nous étions plus à l’aise avec celui-ci. Pour pouvoir utiliser le potentiel de git sur Eclipse, nous avons créé un projet Maven.

Qui dit jeu, plateau, tuiles, dit images ! Effectivement nous avons voulu créer notre propre LATICE, avec nos propres thèmes. Nous avons donc dû créer nos propres éléments de jeu sur un éditeur d’image, et nous avons utilisé pour ceci deux logiciels open source : PhotoFiltre et Krita.

Nous voulions réaliser des petites cinématiques pour introduire chaque partie selon le thème choisi, nous devions donc utiliser un logiciel de montage vidéo pour monter ces cinématiques. De plus nous voulions animer la tuile vent, et rajouter des petites animations grâce à des images animées au format GIF, nous avons donc d’abord réalisé des petites vidéos au format MP4, pour les convertir ensuite en GIF. Pour le montage vidéo nous avons utilisé le logiciel open source Da Vinci Resolve.

Certaines de nos cinématiques ont été réalisées grâce à de la modélisation et de l’animation 3D pour nous laisser une certaine liberté dans la mise en scène, pour que ce soit le plus raccord avec le thème choisi. Pour cela nous avons utilisé le logiciel open source Blender.

Nous avons décidé de mettre des musiques pour chaque thèmes, et notamment de faire jouer la première en même temps que la cinématique, ce qui nous a contraint à en modifier certaines pour qu’elles s’adaptent à la cinématique. Pour celà nous avons utilisé le logiciel open source Audacity. 


## Imagerie
![start](https://github.com/Nyotora/latice/assets/101416486/d256f49d-1fcb-46f5-bb90-7146c21d68e4)
![select](https://github.com/Nyotora/latice/assets/101416486/e8f45e14-cc91-4a62-8746-27cacf13cb53)
![pokemon](https://github.com/Nyotora/latice/assets/101416486/09df3ab3-52d7-492e-b58a-edf74cfb24cd)
![op](https://github.com/Nyotora/latice/assets/101416486/9aa57218-f017-49d3-9c6f-b3925f6881c6)
![zelda](https://github.com/Nyotora/latice/assets/101416486/dfde3778-d064-4c67-b3b6-2c4cbd553078)

