package com.iv.p404;

import com.iv.p404.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class P404ApplicationTests {

    private final String url = "http://localhost:8080/bookToHome";

    @Test
    void saveBook() {
        Book book = Book.builder().title("Rayuela").quantity(4).build();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Book> response = restTemplate.postForEntity(url+"/book",book, Book.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.valueOf(200));
    }

}
