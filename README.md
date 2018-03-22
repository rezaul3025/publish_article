# publish_article
============================================
Java version: 1.8
Memory database: H2
Build tool : Maven
Packaging : WAR

Spring components:
Boot, Data, Rest

Please, follow the following instructions to build, test & run the application 

Go to project folder,

Build:
$ mvn clean install

Test: 
$ mvn clean test

Run:
$ mvn spring-boot:run


Test Urls
==================================

Create a article
================
Endpoint: localhost:8080/api/v1/article/create

Request
Method: POST

Body:

 {
        "header": "test",
        "description": "test desc",
        "text": "test text",
        "publishDate": "2018-04-23T00:00:00",
        "author": "test author",
        "keywords": "test keywords"
  }
Response
Body:

{
  "id": 0
}

Update a article
================
Endpoint: localhost:8080/api/v1/article/1/update

Request
Method: POST

Body:

 {
        "header": "test update",
        "description": "test desc update",
        "text": "test text",
        "publishDate": "2018-04-23T00:00:00",
        "author": "test author",
        "keywords": "test keywords"
  }
Response
Body:

{
  "id": 0
}

Delete article
===============
Endpoint: localhost:8080/api/v1/article/1/delete

Request
Method: DELETE

Response
0

Find by author
=====================
Endpoint: localhost:8080/api/v1/article/author?name=test author

Request
Method: GET

Response
Body:

[
    {
        "id": 1,
        "header": "test",
        "description": "test desc",
        "text": "test text",
        "publishDate": "2018-04-12T00:00:00",
        "author": "test author",
        "keywords": "test keywords"
    }
]

Find one
=====================
Endpoint: localhost:8080/api/v1/article/findone/1

Request
Method: GET

Response
Body:

{
        "id": 1,
        "header": "test",
        "description": "test desc",
        "text": "test text",
        "publishDate": "2018-04-12T00:00:00",
        "author": "test author",
        "keywords": "test keywords"
 }

Find by keywords
=====================
Endpoint: localhost:8080/api/v1/article/findkeywords?keywords=test

Request
Method: GET

Response
Body:

[
    {
        "id": 1,
        "header": "test",
        "description": "test desc",
        "text": "test text",
        "publishDate": "2018-04-12T00:00:00",
        "author": "test author",
        "keywords": "test keywords"
    }
]

Find by given period
=====================
Endpoint: localhost:8080/api/v1/article/findbetween?start=2018-04-04 12:00&end=2018-04-12 12:00

Request
Method: GET

Response
Body:

[
    {
        "id": 1,
        "header": "test",
        "description": "test desc",
        "text": "test text",
        "publishDate": "2018-04-12T00:00:00",
        "author": "test author",
        "keywords": "test keywords"
    }
]


