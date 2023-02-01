# Application star war mission finale

Cette application a été conçue par Andrii, David, Eve & Iliasse

## Technologies :

JAVA (JDK 11), JEE, Spring web, Spring Data, JPA Hibernate, MariaBD (10.6.11)

IDE : Eclipse, IntelliJ

## Architecture :

Modèle MVC, couche DAO, base de donnée (H2)

## Etapes de la construction d'application

### 0 - Création de la maquette HTML

La maquette est disponible dans le dossier src/templates
Elle a été conçue pour permettre de ne pas recréer les éléments répétitifs (boutons, formulaires, ...)
La maquette intègre la bibliothèque Bootstrap 5

### 1 - Creation des entitées

- Création du modèle (Class JAVA)
- Ajout des annotations JPA qui vont permettre l'ORM (la création des entitées à partir des classes)

### 2 - Création de la couche DAO

- Création des Repositories : </br>
Ces interfaces JPA vont permettre de fournir des fonctionnalités de base pour les opérations CRUD (create, read, update, delete) et de tri pour les récupérations de données dans une base de données.
L'interface JpaRepository va donc dispenser le developpeur d'écrire lui même le code SQL pour communiquer avec la base de donnée. </br>
Exemple de méthodes : findAll, findOne, delete, save, findBy<<Property>>

### 3 - Création de la couche Service

- Création des services permettant de déléguer une partie du code CRUD

### 4 - Création de la couche service

- Couche web permet de créer des services web. L'application va pouvoir communiquer via Rest API
- Utilisation de Postman (pour manipuler les méthodes POST, GET, PUT, DELETE)