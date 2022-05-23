# R-servation_billets_avions
Réservation billets avions  JAVA/SWING

Le but est de créer une application de réservation de billets d’avions en ligne pour une compagnie aérienne
qui dispose de plusieurs avions d’autonomies et de capacités d’accueil différentes. Cette application sera
divisée en deux parties : la réservation d’un ou plusieurs billets par un client et l’administration et la
consultation des statistiques pour l’administrateur.
L’application devra tenir compte des accès concurrents (par ex., deux clients différents ne peuvent
pas réserver chacun la dernière place disponible dans un avion). Elle devra également gérer l’annulation
des transactions. Les numéros d’identifiants uniques des clés primaires seront générés automatiquement.
Il conviendra de définir les contraintes dintégrité. Par exemple, un avion ne pourra pas être utilisé pour
un vol si son autonomie est inférieure à la distance à parcourir, ou encore il ne pourra pas partir d’une
ville s’il est en vol au moment prévu du départ.
Un trajet est identifié par sa ville de départ et sa ville d’arrivée. Le prix et la durée des trajets
(heure d’arrivée de chaque vol) seront définis à partir de la distance entre les deux villes à atteindre.
Cette distance sera calculée en utilisant la l’atitude et longitude des villes desservies par la compagnie
aérienne. Le prix prendra également en compte la catégorie des passagers (senior, junior. . . ) ainsi que la
classe (économique, affaire, . . . ). Le prix au Km est fixé pour chaque classe, le prix au Km d’une classe
peut être modifié sans que les autres classes ne voient leurs prix changer. Un pourcentage de réduction
est attribué à chaque catégorie (junior : 40% de réduction, senior : 25% de réduction). Pour une classe
donnée, tous les avions auront le même prix au Km. Pour chaque avion, il faudra pouvoir préciser la
capacité de l’avion en classe affaire, en classe économique, en 1 classe...
Il sera supposé que tous les avions volent à la même vitesse. Les vols sont indépendants et sans escales.
Les numéros de vols correspondent à des vols réguliers (le vol no 6632 correspond à un trajet Casa-Paris
chaque lundi, départ à 11h40). Toutes les informations relatives aux réservations non annulées seront
conservées au moins un an.
Une réservation pourra concerner une ou plusieurs personnes (on peut réserver plusieurs places pour
un vol dans des catégories différentes et des classes différentes, par exemple 2 adultes en classe affaire,
1 senior en classe économique, 3 juniors en classe économique). Le client fournira son nom, son prénom,
la ville de départ et la ville darrivée, le nombre de passagers et leurs catégories, la classe, ainsi que
la date et lheure souhaitée. En réponse, il obtiendra tous les vols qui se rapprochent de la date et de
l’heure demandées (tous les vols du même jour dans un intervalle de +/- 4 heures par rapport à l’heure
demandée, et s’il n’y a pas de vol le jour même tous les vols du jour le plus proche de celui désiré). Dès
acceptation par le client, un numéro de réservation est alors fourni à celui-ci.
L’administrateur pourra modifier ou ajouter des catégories tarifaires (juniors, seniors, ...), et obtenir
des statistiques sur les taux doccupation de chaque avion pour une durée spécifiée. Il pourra notamment
obtenir, par trimestre ou par an, la liste des vols dont le taux d’occupation est inférieur à un seuil fixé au
moment de l’interrogation. On veut aussi pouvoir sortir des statistiques par client et par département
d’origine du client.




Description du répertoire:

-Répertoire classes
dossier1:
\ReservationBilletsAvion\src\Connection
-Contient la classe d'etablissement de connexion avec la base de données (JDBC)
dossier2:
\ReservationBilletsAvion\src\Métier
-Contient les différents classes de notre Application par exemple (Trajet , Avion , Client)
il existe des classes nommé bis par ex Trajetbis qui contiennent les attributs de la classe d'origine plus des additions
dossier3:
\ReservationBilletsAvion\src\Présentation 
-Contient les différents classes d'intérface graphique ainsi que des classes de coloriage comme \ReservationBilletsAvion\src\Présentation\Pan3.java 
qu'on a utilisé pour colorié un JPANEL à l'aide de l'outils Graphics component pour mettre en arriere plan une image


Execution de l'application:

1. Créer une nouvelle base de données sur votre serveur Mysql sous le nom "reservationbilletsavions" puis importer le fichier reservationbilletsavions.sql présent dans le répértoire DataBase script.
2. Importer le projet sur votre IDE
3. Verifier que tous les libreries externes sont chargé surtout le jar de la date Picker présent dans le répértoire :\ReservationBilletsAvion\src\Métier
4. Executer l'application depuis la classe Main (Classe Princiaple)

Pour plus d'informations voir le rapport PDF et la présentation PPT
