# Spring Boot Example

Spring Boot Example Built On Vortex implementation

You Can Find The Example On Github at The Following link

{% hint style="info" %}
[https://github.com/Yazan98/Destiny-Api](https://github.com/Yazan98/Destiny-Api)
{% endhint %}

Project Components

1. Auth Api \(Register, Login, UpdatePassword, GetUserById\)
2. Recipes Api \(getRecipeByID, GetCommentsByRecipeId, Create Comment, RecipesByCategoryId\)
3. Notifications \(Offers Topic\) With Firebase
4. Categories Api \(GetAll, GetCategoryById, Create Category\)
5. Cities Api
6. Offers Api
7. Places Api
8. User Places Api

**Spring Boot Configuraiton**

1. Jwt Tokens
2. Spring Security
3. Firebase Configuration
4. Firebase User Register With Realtime Database
5. Token Filter
6. Firebase Notifications
7. Error Handler For Any Exception

**Application Deployment**

1. Heroku Base Url : [https://destiny98.herokuapp.com/v1/](https://destiny98.herokuapp.com/v1/)\*\*
2. Docker Image : [https://hub.docker.com/repository/docker/yt98/destiny\_api/general](https://hub.docker.com/repository/docker/yt98/destiny_api/general)

**Postman Collection**

{% hint style="info" %}
\*\*\*\*[**https://github.com/Yazan98/Destiny-Api/blob/master/Destiny%20Api.postman\_collection.json**](https://github.com/Yazan98/Destiny-Api/blob/master/Destiny%20Api.postman_collection.json)\*\*\*\*
{% endhint %}

## Success Response

```text
{
    "code": 201,
    "message": "Account Created",
    "status": "Success",
    "data": {
        "token": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5YXphbiIsIm5hbWUiOiJ5YXphbiIsImlkIjo0MiwiZXhwIjoxNTgwMTUzMzk1LCJpYXQiOjE1ODAxMzUzOTUsInN0YXR1cyI6Ik5PVF9BQ1RJVkFURUQifQ.CqYZcVhotMgOqSFDFDPCLU8YmQ82A2cLMzXN1BxJyIA",
        "user": {
            "id": 42,
            "username": "yazan",
            "email": "yazan@yahoo.com",
            "phoneNumber": "123456789",
            "image": "image url",
            "enabled": false,
            "accountStatus": "NOT_ACTIVATED",
            "location": {
                "latitude": 0.0,
                "longitude": 0.0,
                "name": "Amman"
            }
        }
    }
}
```

## Error Response

```text
{
    "code": 400,
    "message": "User Username Required",
    "status": "Failed",
    "error": {
        "type": "Invalid Or Missing Value",
        "details": {
            "name": "Username",
            "reason": "Attribute Missing"
        },
        "stacktrace": [...]
    }
}
```



