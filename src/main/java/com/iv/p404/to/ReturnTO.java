package com.iv.p404.to;

import com.iv.p404.model.Book;
import com.iv.p404.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReturnTO {
    Customer customer;
    Book book;
    String error;
}
