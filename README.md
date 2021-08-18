# wizer_library_springboot

Repo:   https://github.com/philipafemikhe/wizer_library_springboot.git

To install, follow steps below:

1.  Clone the repository using
    git clone https://github.com/philipafemikhe/wizer_library_springboot.git
    
2. Open the project in your preferd IDE eg intelliJ
3. Right click POM.XML and re-import
4. Add mysql-connector-java-5.1.48 (saved in the resource>static folder of this repo) to your library
    eg in intellij, click File > project structure,
    click library and click + and click java
    select the folder and click ok
5. create mysql database named bookstore
6. Run the application.

Access the application using the following endpoints

Create Category
Create Category
POST	localhost:8070/category
Request body: 

{
    "title":"Angular",
    "description": "Books on Angular JS"
}

Response:
{
    "id": 1,
    "title": " Angular",
    "description": " Books on Angular JS "
}



List All Categories
GET	localhost:8070/category

Response
[
    {
        "id": 2,
        "title": "Angular Js",
        "description": "Books on Angular JS"
    },
    {
        "id": 3,
        "title": "Spring boot",
        "description": "Java Springboot"
    }
]





Get one Category
GET	localhost:8070/category/{id}
Response
{
    "id": 2,
    "title": "Angular Js",
    "description": "Books on Angular JS"
}

Delete Category
DELETE	 localhost:8070/category/{id}
Response

“Category Deleted”


Update Category

PUT	localhost:8070/category/{id}
Request body
{
    "title":"Angular Js",
    "description": "Books on Angular JS…"
}

Response
{
    "id": 2,
    "title": "Angular Js",
    "description": "Books on Angular JS…"
}

 
Book
Create Book
POST	localhost:8070/book
Request Body
{
    "title": "Book1",
    "description": "Description",
    "author": "Philip A"
}

Response
{
    "id": 1,
    "title": "Book1",
    "description": "Description",
    "author": "Philip A",
    "category": null
}


Add Book to Category

PUT	localhost:8070/book/{bookId}/{categoryId}

Response



Get All Books

GET	localhost:8070/book
Response

[
    {
        "id": 1,
        "title": "Book1",
        "description": "Description",
        "author": "Philip A",
        "category": null
    }
]


Get one Book

GET	localhost:8070/book/{id}
Response


    {
        "id": 1,
        "title": "Book1",
        "description": "Description",
        "author": "Philip A",
        "category": null
    }

Update Book
PUT	localhost:8070/book/{id}
Request Body
{
"title": "Book1",
"description": "Description",
"author": "Philip A"
}

Response
{
    "id": 1,
    "title": "Book1 editted",
    "description": "Description..",
    "author": "Philip A",
    "category": null
}


Delete a Book
DELETE		localhost:8070/book/{id}

Response
“Book Deleted”

Add  Book to Category
PUT 	localhost:8070/book/{bookId}/{categoryId}

Response
{
    "id": 1,
    "title": "Book1 editted",
    "description": "Description..",
    "author": "Philip A",
    "category": {
        "id": 3,
        "title": "Spring boot",
        "description": "Java Springboot"
    }
}


Add Multiple Books to category
GET	localhost:8070/book/categorize/{categoryId}

Request Body
[
	{
		"id": 1,
    		"title": "Book1 editted",
    		"description": "Description..",
    		"author": "Philip A",
    		"category": null

	},
	{
"id": 2,
    		"title": "Book2 title",
    		"description": "book descr..",
   		"author": "Philip A",
    		"category": null


	}
]

Response
[
    {
        "id": 1,
        "title": "Book1 editted",
        "description": "Description..",
        "author": "Philip A",
        "category": {
            "id": 2,
            "title": "Angular Js",
            "description": "Books on Angular JS"
        }
    },

    {
"id": 2,
    	"title": "Book2 title",
    	"description": "book descr..",
   	"author": "Philip A",",
        "category": {
            "id": 2,
            "title": "Angular Js",
            "description": "Books on Angular JS"
        }

         }
]


Favorite

POST	localhost:8070/favorite/add

Request body
{
        "id": 1,
        "title": "Book1",
        "description": "Description",
        "author": "Philip A",
        "category": null
    }

Response
{
    "id": 1,
    "book": {
        "id": 1,
        "title": "Book1",
        "description": "Description",
        "author": "Philip A",
        "category": null
    }
}

Get favorite list
GET	localhost:8070/favorite/list
Response
[
    {
        "id": 1,
        "book": {
            "id": 1,
            "title": "Book1 editted",
            "description": "Description..",
            "author": "Philip A",
            "category": {
                "id": 2,
                "title": "Angular Js",
                "description": "Books on Angular JS"
            }
        }
    }
]





