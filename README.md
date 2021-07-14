# Aula 1 - Testing Automatizado com JUnit

## Prática Validações e Exceções

Este repositório contém as validações e exceções para o projeto spring de diploma feito
anteriormente e refatorado para atender os requisitos deste exercício prático.

- ### POST ```/api/aula1```
  - criação de um novo estudante
  - body request:
    ````
    {
      "name": "Kamila",
      "subjects": [
        {
            "subject": "Caclulo I",
            "note": 5
        },
        {
            "subject": "Caclulo II",
            "note": 8
        },
        {
            "subject": "Caclulo III",
            "note": 10
        }
      ]
    }
    ````
  - body response:
    ````
    {
      "id": 1,
      "name": "Kamila",
      "subjects": [
          {
              "id": 1,
              "subject": "Caclulo I",
              "note": 5
          },
          {
              "id": 2,
              "subject": "Caclulo II",
              "note": 8
          },
          {
              "id": 3,
              "subject": "Caclulo III",
              "note": 10
          }
      ]
    }
    ````
  

- ### POST ``` /api/aula1/analyzeNotas/{id} ```
    - retorna o diploma de um estudante
    - body response:
    ````
    {
      "message": "Você foi aprovado! Sua média foi de: 7,7",
      "average": 7.7,
      "student": {
          "id": 1,
          "name": "Kamila",
          "subjects": [
              {
                  "id": 1,
                  "subject": "Caclulo I",
                  "note": 5
              },
              {
                  "id": 2,
                  "subject": "Caclulo II",
                  "note": 8
              },
              {
                  "id": 3,
                  "subject": "Caclulo III",
                  "note": 10
              }
          ]
      }
    }
    ````
  
- ### GET ````/api/aula1/students````
  - retorna todos os estudantes cadastrados no banco
  - body response:
  ```
  [
    {
        "id": 1,
        "name": "Kamila",
        "subjects": [
            {
                "id": 1,
                "subject": "Caclulo I",
                "note": 5
            },
            {
                "id": 2,
                "subject": "Caclulo II",
                "note": 8
            },
            {
                "id": 3,
                "subject": "Caclulo III",
                "note": 10
            }
        ]
    }
  ]
  ```
  
- ### GET ````api/aula1/student/{id}````
  - retorna um estudante em específico
  - body response:
  ```
  {
        "id": 1,
        "name": "Kamila",
        "subjects": [
            {
                "id": 1,
                "subject": "Caclulo I",
                "note": 5
            },
            {
                "id": 2,
                "subject": "Caclulo II",
                "note": 8
            },
            {
                "id": 3,
                "subject": "Caclulo III",
                "note": 10
            }
        ]
    }
  ```
  
## Prática de Teste Unitário

Solução dos exercícios adaptados para a minha implementação da api de diplomas, onde
os testes unitários estão na pasta de ````/test````.

Para as seguintes classes, que seriam equivalente as pedidas no exercícios, foram
feitos os testes unitários:
  - ```/utils/CalculateAverage.java```
  - ```/utils/StudentSituation.java```
  - ```/service/StudentService.java```