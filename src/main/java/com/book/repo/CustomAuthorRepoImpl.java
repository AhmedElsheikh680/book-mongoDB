package com.book.repo;


import com.book.entity.Author;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.internal.bulk.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class CustomAuthorRepoImpl implements CustomAuthorRepo{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void updateEmail(Author author) {
        Query query = new Query(Criteria.where("email").is(author.getEmail()));
        Update update = new Update();
        update.set("name", author.getName());
        update.set("phone", author.getPhone());

       UpdateResult updateRequest =  mongoTemplate.updateFirst(query, update, Author.class);
       if (updateRequest !=null) {
           System.out.println(updateRequest.getModifiedCount() + " Document(s) Updated...");
       } else {
           System.out.println("No Documents Updated");
       }

    }
}
