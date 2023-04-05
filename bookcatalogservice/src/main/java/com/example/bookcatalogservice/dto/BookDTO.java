package com.example.bookcatalogservice.dto;

import java.util.List;

import com.example.bookcatalogservice.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	
	int bookCount;
	List<Book> books;
}
