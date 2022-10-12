package com.example.profileservice.service;

import com.example.profileservice.entity.DbSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class SequenceGeneratorService {
    @Autowired
    private MongoOperations mongoOperations;

    public int getSequenceNumber(String sequenceName){

        DbSequence counter = mongoOperations.findAndModify(Query.query(where("_id").is(sequenceName)),
                new Update().inc("seq", 1),
                options().returnNew(true).upsert(true),
                DbSequence.class);
//        //get sequence no
//       Query query =new Query(Criteria.where("id").is(sequenceName));
//        //Update the sequence no
//        Update update = new Update().inc("seq",1);
//        //modify in document
//        DbSequence counter =mongoOperations.findAndModify(query,update,options().returnNew(true).upsert(true),DbSequence.class);
        return !Objects.isNull(counter)? counter.getSeq() : 1;
    }
}
