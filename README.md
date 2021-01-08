# <div align="center">![pageres](src/main/resources/p404.png)</div>
![Days](https://img.shields.io/static/v1?label=Working-Days&message=2&color=blue)
![Status](https://img.shields.io/static/v1?label=Done&message=100%&color=green)


This information on the service is accessible through this API, contemplating:
1. Books.
2. Customers.
3. Renting a book.
4. Returning a book.
5. Book quality degrades.
6. Book quality enhances.
7. Minimum stock function.


*See [Challenge](src/main/resources/Challenge.md) for the tasks details.*

## Example implementation on localhost
##### Get minimum stock
```java
class P404Test {

    private final String url = "http://localhost:8080/bookToHome";

    List<Book> minimumStock() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url + "/minimumStock", List.class);
    }
}
```

## API Endpoints

Base path: `/bookToHome`


### Books
##### Save Book
###### There is a @RequestBody expected

    /book

### Customers
##### Save Customer
###### There is a @RequestBody expected

    /customer

### Rent
##### Rent a book
`customer: customer id`

`book: book id`

    /rent?customer=#&book=#

##### Return Book
###### Params:
`customer: customer id`

`book: book id`

       /returnBook?customer=#&book=#

### Stock
##### Get all Books that are in their corresponding minimum stock

    /minimumStock


Coded with ❤️ by Juan Patricio Doyle ✨2021

