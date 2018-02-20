package com.mysticenergy.dao;

import com.mysticenergy.common.BaseTest;
import com.mysticenergy.entity.TestEntity;
import com.mysticenergy.util.UuidGenerator;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 书生 on 2018/2/20.
 */
public class TestEntityDaoTest extends BaseTest {

    @Autowired
    private TestEntityDao testEntityDao;

    @Before
    public void init() {
        testEntityDao.clear();
    }

    @Test
    public void testAddOneAndFind() throws Exception {
        TestEntity testEntity = new TestEntity()
                .set_id(UuidGenerator.uuid())
                .setNames("test");

        testEntityDao.insert(testEntity);

        TestEntity testEntity1 = testEntityDao.findById(testEntity.get_id());

        Assertions.assertThat(testEntity1).isNotNull();
        Assertions.assertThat(testEntity1).isEqualToComparingFieldByField(testEntity);
        System.out.println(testEntity1);

    }

}