package com.mysticenergy.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

/**
 * Created by 书生 on 2018/2/20.
 */
public class BaseDao<T> {

    @Autowired
    private MongoTemplate mongoTemplate;

    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void getClz() {
        clazz = (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    /**
     * 插入单条
     */
    public void insert(T t) {
        mongoTemplate.insert(t);
    }

    /**
     * 插入多条
     */
    public void insert(Collection<T> objects) {
        mongoTemplate.insert(objects, clazz);
    }

    /**
     * 根据id查询
     */
    public T findById(String id) {
        return mongoTemplate.findById(id, clazz);
    }

    /**
     * 根据条件查询所有
     */
    public List<T> findAll(Query query) {
        return mongoTemplate.find(query, clazz);
    }

    /**
     * 根据条件删除所有
     */
    public void remove(Query query) {
        mongoTemplate.remove(query, clazz);
    }

    /**
     * 删除所有数据
     */
    public void clear() {
        remove(new Query());
    }

}
