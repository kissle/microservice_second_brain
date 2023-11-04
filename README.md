# microservice_second_brain

This repository is intended to build a second brain application using a microservice architecture.

The second brain consists of different entities and therefore service which are split up for demonstration purposes. 

## Backends 
### Notes 

The notes service is one of the main parts in a second brain note-taking system. It captures all ideas entered by the owner of the second brain. 

### Books 
The second most common type of resources in a second brain are books. Much information can be derived from books and stored as notes in a second brain. 
Therefor this service is a reference to books. 

### Creators
Authors or Creators are treated as the same in the project. Since they can create different resources like books, YouTube videos, podcasts, etc. they are treated 
as a dedicated entity not bound to one of the different resources. 

## Frontend
For simplicity all is managed in one frontend. 