package com.cccis.es.dao;

import com.cccis.base.mongo.MBaseDao;
import com.cccis.es.model.EsModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CCC on 2016/10/28.
 */
@Repository(EsModelDAO.SPRING_BEAN_NAME)
public class EsModelDAO extends MBaseDao<EsModel> {

    public final static String SPRING_BEAN_NAME = "mongo.EsModelDAO";

    @Override
    public Class getEntityClass() {
        return EsModel.class;
    }
}