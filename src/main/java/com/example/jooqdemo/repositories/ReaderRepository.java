package com.example.jooqdemo.repositories;

import com.example.jooqdemo.model.Reader;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.example.jooqdemo.generated.tables.Reader.READER;

@Repository
@AllArgsConstructor
public class ReaderRepository {
    private DSLContext dslContext;

    public List<Reader> findAll(){
        Result<Record> result = dslContext.select().from(READER).fetch();
        List<Reader> readers = new ArrayList<>();
        for (Record reader : result) {
            Integer id = reader.getValue(READER.ID);
            String name = reader.getValue(READER.NAME);
            String surname = reader.getValue(READER.SURNAME);
            String street = reader.getValue(READER.STREET);
            String postalCode = reader.getValue(READER.POSTAL_CODE);
            String city = reader.getValue(READER.CITY);
            String phoneNumber = reader.getValue(READER.PHONE_NUMBER);

            readers.add(new Reader(id,name,surname,street,postalCode,city,phoneNumber));
        }
        return readers;
    }

    public Reader findReaderById(int readerId) {
        Result<Record> result = dslContext.select().from(READER).where(READER.ID.equal(readerId)).fetch();

        if (result.size() != 1){
            throw new RuntimeException("Returned few Readers with the same id");
        }

        Record record = result.get(0);
        Integer id = record.getValue(READER.ID);
        String name = record.getValue(READER.NAME);
        String surname = record.getValue(READER.SURNAME);
        String street = record.getValue(READER.STREET);
        String postalCode = record.getValue(READER.POSTAL_CODE);
        String city = record.getValue(READER.CITY);
        String phoneNumber = record.getValue(READER.PHONE_NUMBER);

        return new Reader(id, name, surname, street, postalCode,city, phoneNumber);



    }
}
