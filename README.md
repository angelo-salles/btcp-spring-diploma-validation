# Aula 1 - Testing Automatizado com JUnit

## Prática Validações e Exceções

Este repositório contém as validações e exceções para o projeto spring de diploma feito
anteriormente e refatorado para atender os requisitos deste exercício prático.

- ### POST ``` /api/aula1/analyzeNotas ```
    - retorna o diploma de um estudante
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
        "message": "Sua média foi de: 7,7",
        "average": 7.7,
        "student": {
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
    }
    ````