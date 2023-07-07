package com.example.jooqdemo.repositories;

import com.example.jooqdemo.model.Author;
import com.example.jooqdemo.model.Book;
import com.example.jooqdemo.model.BookCopy;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.example.jooqdemo.generated.tables.Author.AUTHOR;
import static com.example.jooqdemo.generated.tables.Book.BOOK;
import static com.example.jooqdemo.generated.tables.BookCopy.BOOK_COPY;

@Repository
@AllArgsConstructor
public class BookCopyRepository {

    private DSLContext dslContext;

    public List<BookCopy> findAll(){
        Result<Record> result = dslContext.select().from(BOOK_COPY)
                .join(BOOK).on(BOOK.ID.equal(BOOK_COPY.ID_BOOK))
                .join(AUTHOR).on(AUTHOR.ID.equal(BOOK.ID_AUTHOR))
                .fetch();
        List<BookCopy> books = new ArrayList<>();
        for (Record bookCopy : result) {
            Integer id = bookCopy.getValue(BOOK_COPY.ID);
            String isbn = bookCopy.getValue(BOOK_COPY.ISBN);
            Author author = new Author(bookCopy.getValue(AUTHOR.ID),bookCopy.getValue(AUTHOR.NAME),bookCopy.getValue(AUTHOR.SURNAME));
            Book book = new Book(bookCopy.getValue(BOOK.ID),bookCopy.getValue(BOOK.TITLE),author);
            books.add(new BookCopy(id,book,isbn));
        }
        return books;
    }


    public List<BookCopy> findBookCopyByTitle(String bookTitle) {
        Result<Record> result = dslContext.select().from(BOOK_COPY)
                .join(BOOK).on(BOOK.ID.equal(BOOK_COPY.ID_BOOK))
                .join(AUTHOR).on(AUTHOR.ID.equal(BOOK.ID_AUTHOR))
                .where(BOOK.TITLE.equal(bookTitle))
                .fetch();
        List<BookCopy> books = new ArrayList<>();
        for (Record bookCopy : result) {
            Integer id = bookCopy.getValue(BOOK_COPY.ID);
            String isbn = bookCopy.getValue(BOOK_COPY.ISBN);
            Author author = new Author(bookCopy.getValue(AUTHOR.ID),bookCopy.getValue(AUTHOR.NAME),bookCopy.getValue(AUTHOR.SURNAME));
            Book book = new Book(bookCopy.getValue(BOOK.ID),bookCopy.getValue(BOOK.TITLE),author);
            books.add(new BookCopy(id,book,isbn));
        }
        return books;
    }
}
