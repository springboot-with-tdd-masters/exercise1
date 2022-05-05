###CATIPON###

###To Create:
POST: http://localhost:8080/api/addBook
Body > JSON
{
"author": "author3",
"title": "title3"
}

###To Read:
GET: http://localhost:8080/api/getBook/{id}

###To Update:
PUT: http://localhost:8080/api/updateBook
{
"id": "2",
"author": "author",
"title": "title"
}

###To Delete:
DELETE: http://localhost:8080/api/deleteBook/2