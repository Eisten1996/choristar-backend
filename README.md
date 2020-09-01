choristar-backend

agregacion de datos por postman
http://localhost:8080/api/users
metodo post
- Agregar User
````
{
    "dni": "123456",
    "firstName": "Eisten",
    "lastName": "Flores",
    "email": "esiten@gmail.com",
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
http://localhost:8080/api/claim/123456
- Agregar Claim

```
{
    "dateClaim":"2019-02-20",
    "typeClaim":{
        "claim":"No hay internet"
    },
    "stateClaim":"En proceso"
}
```

http://localhost:8080/api/request/123456
- Agregar Request

```
{
    "dateClaim":"2019-02-20",
    "typeClaim":{
        "claim":"No hay internet"
    },
    "stateClaim":"En proceso"
}
```