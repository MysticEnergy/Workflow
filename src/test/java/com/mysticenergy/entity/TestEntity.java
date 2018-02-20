package com.mysticenergy.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by 书生 on 2018/2/20.
 */
@Document(collection = "TestEntity")
public class TestEntity {

    @Id
    private String _id;

    private String names;

    public String get_id() {
        return _id;
    }

    public TestEntity set_id(String _id) {
        this._id = _id;
        return this;
    }

    public String getNames() {
        return names;
    }

    public TestEntity setNames(String names) {
        this.names = names;
        return this;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "_id='" + _id + '\'' +
                ", names='" + names + '\'' +
                '}';
    }
}
