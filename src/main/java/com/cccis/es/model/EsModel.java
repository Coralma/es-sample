package com.cccis.es.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ccc on 2017/7/6.
 */
@Document(collection = "EsModel")
public class EsModel implements Serializable {

    @org.springframework.data.annotation.Id
    private String id;

    private BigDecimal executeTime;

    public EsModel(BigDecimal executeTime) {
        this.executeTime = executeTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(BigDecimal executeTime) {
        this.executeTime = executeTime;
    }
}
