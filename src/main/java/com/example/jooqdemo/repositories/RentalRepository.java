package com.example.jooqdemo.repositories;

import com.example.jooqdemo.model.*;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.jooqdemo.generated.tables.Reader.READER;
import static com.example.jooqdemo.generated.tables.Rental.RENTAL;
import static com.example.jooqdemo.generated.tables.BookCopy.BOOK_COPY;
import static com.example.jooqdemo.generated.tables.Book.BOOK;
import static com.example.jooqdemo.generated.tables.Author.AUTHOR;

@Repository
@AllArgsConstructor
public class RentalRepository {

    private DSLContext dslContext;

    public List<Rental> findAll() {
        Result<Record> result = dslContext.select().from(READER)
                .join(RENTAL).on(READER.ID.equal(RENTAL.ID_READER))
                .join(BOOK_COPY).on(RENTAL.ID_BOOK_COPY.equal(RENTAL.ID))
                .join(BOOK).on(BOOK_COPY.ID_BOOK.equal(BOOK.ID))
                .join(AUTHOR).on(BOOK.ID_AUTHOR.equal(AUTHOR.ID))
                .fetch();
        List<Rental> rentals = new ArrayList<>();
        for (Record record : result) {
            Integer id = record.getValue(RENTAL.ID);
            Author author = new Author(record.getValue(AUTHOR.ID), record.getValue(AUTHOR.NAME), record.getValue(AUTHOR.SURNAME));
            Book book = new Book(record.getValue(BOOK.ID), record.getValue(BOOK.TITLE), author);
            BookCopy bookCopy = new BookCopy(record.getValue(BOOK_COPY.ID), book, record.getValue(BOOK_COPY.ISBN));
            Reader reader = new Reader(record.getValue(READER.ID), record.getValue(READER.NAME),record.getValue(READER.SURNAME) ,record.getValue(READER.STREET),record.getValue(READER.POSTAL_CODE), record.getValue(READER.CITY), record.getValue(READER.PHONE_NUMBER));
            LocalDate rentalDate = record.getValue(RENTAL.RENTAL_DATE);
            rentals.add(new Rental(id,bookCopy, reader, rentalDate));

        }

        return rentals;
    }
}
