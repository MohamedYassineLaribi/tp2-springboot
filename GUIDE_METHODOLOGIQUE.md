# Guide Descriptif du Projet - Gestion des Étudiants

Ce document détaille les concepts fondamentaux et les étapes méthodologiques suivies pour la réalisation et la correction de cette application Web MVC avec Spring Boot.

## 🌟 Concepts de Base Expliqués

### 1. Spring Boot & Spring MVC
L'application repose sur le framework **Spring Boot**, qui simplifie le démarrage d'applications Java.
- **Modèle (Model)** : Représente les données (nos entités `Etudiant` et `Classification`).
- **Vue (View)** : L'interface utilisateur réalisée avec Thymeleaf.
- **Contrôleur (Controller)** : Le cerveau qui reçoit les requêtes, appelle les services et renvoie les vues.
  > [!NOTE]
  > L'erreur initiale était l'usage de `@RestController` (qui renvoie du JSON) au lieu de `@Controller` (qui renvoie des pages HTML).

### 2. Thymeleaf (Moteur de Template)
Thymeleaf est utilisé pour générer le HTML côté serveur. Il permet d'injecter des données Java directement dans le HTML via des attributs comme `th:text` ou `th:each`.

### 3. Layout Dialect & Héritage de Page
Pour éviter de répéter le code du menu (Navbar) sur chaque page, nous avons utilisé un **Template Global** (`template.html`).
- Chaque page spécifique (ex: `listeEtudiants.html`) "décore" ce template de base.
- Cela garantit une interface cohérente et un code plus propre.

### 4. Spring Data JPA & Repositories
La gestion de la base de données est simplifiée par les interfaces `Repository`. Elles permettent d'effectuer des opérations CRUD (Create, Read, Update, Delete) sans écrire de code SQL complexe.

### 5. Pagination
La pagination permet d'afficher les données par blocs (ex: 2 par 2) au lieu d'une longue liste.
- **Pageable** : Un objet Spring qui définit quel bloc de données charger.
- **Page** : Un conteneur qui contient les données du bloc actuel + les infos sur le nombre total de pages.

---

## 🛠️ Étapes de Réalisation

### Phase 1 : Analyse et Correction
- Identification des erreurs de compilation et de logique (correction de l'annotation `@Controller`).
- Ajustement des dépendances dans `pom.xml` (Bootstrap, Thymeleaf, Layout Dialect).

### Phase 2 : Implémentation de la Pagination (Entité Etudiant)
- Ajout de la méthode `getAllEtudiantsParPage` dans le service.
- Mise à jour du contrôleur pour accepter les paramètres `page` et `size`.
- Ajout des boutons de navigation (Pills Bootstrap) dans la vue.

### Phase 3 : Création du Template Global
- Création de `template.html` avec une barre de navigation (Navbar) contenant des liens vers toutes les fonctionnalités.
- Migration des pages existantes vers ce nouveau système d'héritage.

### Phase 4 : Mise en place du module Classification
- Création de la couche Repository pour manipuler la table `Classification`.
- Développement d'un service complet (CRUD + Pagination).
- Création d'un contrôleur dédié et de formulaires dynamiques permettant de lier une classification à un étudiant existant via une liste déroulante (`select`).

### Phase 5 : Vérification
- Compilation du projet pour s'assurer de l'absence d'erreurs.
- Test de la navigation entre les modules Etudiants et Classifications.
