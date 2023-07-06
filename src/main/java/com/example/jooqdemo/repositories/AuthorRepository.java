package com.example.jooqdemo.repositories;

import com.example.jooqdemo.generated.tables.records.AuthorRecord;
import com.example.jooqdemo.model.Author;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.example.jooqdemo.generated.tables.Author.AUTHOR;

@Repository
@AllArgsConstructor
public class AuthorRepository {
    private DSLContext dslContext;

    public List<Author> findAll(){
        Result<Record> result = dslContext.select().from(AUTHOR).fetch();
        List<Author> authors = new ArrayList<>();
        for (Record author : result) {
            Integer id = author.getValue(AUTHOR.ID);
            String name = author.getValue(AUTHOR.NAME);
            String surname = author.getValue(AUTHOR.SURNAME);
            authors.add(new Author(id,name, surname));
        }
        return authors;
    }
}
