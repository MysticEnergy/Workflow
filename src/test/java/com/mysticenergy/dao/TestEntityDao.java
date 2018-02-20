package com.mysticenergy.dao;

import com.mysticenergy.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by 书生 on 2018/2/20.
 */
@Repository
public class TestEntityDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void clear() {
        Query query = new Query();
        mongoTemplate.remove(query, TestEntity.class);
    }

    public void addOne(TestEntity test) {
        mongoTemplate.insert(test);
    }

    public TestEntity findById(String id) {
        return mongoTemplate.findById(id, TestEntity.class);
    }

}
