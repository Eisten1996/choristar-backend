choristar-backend

agregacion de datos por postman
http://localhost:8080/api/users
metodo post

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