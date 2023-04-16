# Project: Actor

## End-point: Create
### Method: POST
>```
>http://localhost:8082/demo_war_exploded/api/actor
>```
### Headers

|Content-Type|Value|
|---|---|
|Accept|application/json|


### Headers

|Content-Type|Value|
|---|---|
|Content-Type|application/json|


### Body (**raw**)

```json
{
    "firstName":"tina2",
    "lastName":"jojo"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get
### Method: GET
>```
>http://localhost:8082/demo_war_exploded/api/actor?column=firstName&value=tina
>```
### Headers

|Content-Type|Value|
|---|---|
|Content-Type|text/plain|


### Query Params

|Param|value|
|---|---|
|column|firstName|
|value|tina|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get All
### Method: GET
>```
>http://localhost:8082/demo_war_exploded/api/actor/getAll
>```
### Headers

|Content-Type|Value|
|---|---|
|Content-Type|text/plain|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get Rows Count
### Method: GET
>```
>http://localhost:8082/demo_war_exploded/api/actor/count
>```
### Headers

|Content-Type|Value|
|---|---|
|Content-Type|text/plain|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: DeleteByColumnValue
### Method: DELETE
>```
>http://localhost:8082/demo_war_exploded/api/actor?column=firstName&value=tina2
>```
### Query Params

|Param|value|
|---|---|
|column|firstName|
|value|tina2|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: DeleteEntity
### Method: DELETE
>```
>http://localhost:8082/demo_war_exploded/api/actor
>```
### Headers

|Content-Type|Value|
|---|---|
|Content-Type|application/json|


### Body (**raw**)

```json
    {
        "actor": {
            "firstName": "tina",
            "id": 3,
            "lastName": "jojo",
            "lastUpdate": "2023-04-08T03:58:45Z"
        },
        "film": {
            "description": "efjoawe",
            "id": 3,
            "language": {
                "id": 1,
                "lastUpdate": "2023-04-08T04:19:53Z",
                "name": "english"
            },
            "lastUpdate": "2023-04-08T05:37:55Z",
            "length": 88,
            "originalLanguage": {
                "id": 1,
                "lastUpdate": "2023-04-08T04:19:53Z",
                "name": "english"
            },
            "rating": "PG",
            "rentalDuration": 5,
            "rentalRate": 2.00,
            "replacementCost": 14.00,
            "specialFeatures": "Trailers",
            "title": "hoh"
        },
        "id": {
            "actorId": 3,
            "filmId": 3
        },
        "lastUpdate": "2023-04-14T18:40:08Z"
    }
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Options
### Method: OPTIONS
>```
>http://localhost:8082/demo_war_exploded/api/actor
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Put
### Method: PUT
>```
>http://localhost:8082/demo_war_exploded/api/actor
>```
### Headers

|Content-Type|Value|
|---|---|
|Content-Type|application/json|


### Body (**raw**)

```json
 {
        "firstName": "tina",
        "id": 3,
        "lastName": "jojo555555",
        "lastUpdate": "2023-04-08T03:58:45Z"
    }
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
_________________________________________________
Powered By: [postman-to-markdown](https://github.com/bautistaj/postman-to-markdown/)
