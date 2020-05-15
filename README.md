# climbing-community-site

Site communautaire, autour de l’escalade, des Amis de l'escalade

Projet réalisé dans le cadre du parcours développeur d'application Java d'OpenClassrooms.


## Prérequis

- Java 8
- MySql 8.0.20
- Maven 3.3.9

## Déploiment

- Clonez le projet : 

```shell
git clone https://github.com/nicolasdotnet/climbing-community-site.git
```

- Créer une base de donnée dans MySql avec les paramétres suivants : 

Nom de la base  : db_community_escalade

Identifiant : root

Mot de passe : mysql

Pour une installation personnalisée, vous pouvez modifier les valeurs des clès du fichier ressources/application.properties du projet :  

```shell
spring.datasource.url=jdbc:mysql://localhost:3306/NOM_DATABASE?serverTimezone=UTC
spring.datasource.username=VOTRE_USERNAME
spring.datasource.password=VOTRE_PASSWORD
```

- Exécutez la commande maven dans votre terminal à la racine du projet :

```shell
mvn spring-boot:run
```
Spring Boot va charger les scripts SQL de création de la base de données (schema.sql) et du jeu de données de démo (data.sql) présent à la racine du répertoire ressources/ du projet.

## Lancement de l'application

- Aller sur un navigateur à l'adresse http://localhost:9090

Il existe un compte Membre dans la base démo :

Identifiant : membre

Mot de passe : 123