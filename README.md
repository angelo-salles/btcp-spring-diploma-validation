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
  
## Prática de Teste Unitário Sem Mock

Solução dos exercícios adaptados para a minha implementação da api de diplomas, onde
os testes unitários estão na pasta de ````/test````, no arquivo com o mesmo nome que
foi pedido no exercício (```CertificateServiceImplTest```).

Para as seguintes classes, que seriam equivalente as pedidas no exercícios, a cobertura
foi de 100%:
  - ```/utils/CalculateAverage.java```
  - ```/utils/StudentSituation.java```
  - ```/service/StudentService.java```