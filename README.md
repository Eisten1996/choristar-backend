choristar-backend

agregacion de datos por postman
- Agregar User
http://localhost:8080/api/user
metodo post
```
{
    "dni": "71755575",
    "firstName": "Eisten",
    "lastName": "Flores",
    "email": "eisten@gmail.com",
    "password": "123456",
    "dateBirth": "1996-08-13",
    "stateUser": {
        "nameUser": "al dia",
        "description": "No cuenta con deuda"
    },
    "typeUser": {
        "nameTypeUser": "Cliente",
        "description": "Cliente de la empresa"
    },
    "services": [
        {
            "stateService": "habilitado",
            "dateHire": "2019-02-20",
            "price": 20.0,
            "typeService": {
                "service": "trio-choristar",
                "description": "internet telefono TV"
            }
        }
    ]
}
```
- Agregar Claim
http://localhost:8080/api/claim/71755575

```
{
    "dateClaim":"2019-02-20",
    "typeClaim":{
        "claim":"No hay internet"
    },
    "stateClaim":"En proceso"
}
```
- Agregar Request
http://localhost:8080/api/request/71755575

```
{
    "dateClaim":"2019-02-20",
    "typeClaim":{
        "claim":"No hay internet"
    },
    "stateClaim":"En proceso"
}
```
- Obtener usuario por dni
http://localhost:8080/api/user?dni=71755575

- Obtener usuario por id
http://localhost:8080/api/user/5f51962dbaa21c09ba8a4549
