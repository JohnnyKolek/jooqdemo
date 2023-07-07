package com.example.jooqdemo.repositories;


import com.example.jooqdemo.model.Author;
import com.example.jooqdemo.model.Book;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.example.jooqdemo.generated.tables.Author.AUTHOR;
import static com.example.jooqdemo.generated.tables.Book.BOOK;

@Repository
@AllArgsConstructor
public class BookRepository {

    private DSLContext dslContext;

    public List<Book> findAll(){
        Result<Record> result = dslContext.select().from(BOOK).join(AUTHOR).on(AUTHOR.ID.equal(BOOK.ID_AUTHOR)).fetch();
        List<Book> books = new ArrayList<>();

        for (Record book : result) {
            Integer id = book.getValue(BOOK.ID);
            String title = book.getValue(BOOK.TITLE);
            Author author = new Author(book.getValue(AUTHOR.ID),book.getValue(AUTHOR.NAME),book.getValue(AUTHOR.SURNAME));
            books.add(new Book(id,title,author));
        }
        return books;
    }


}
