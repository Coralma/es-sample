package com.cccis.es.service;

import com.cccis.base.elasticsearch.operation.SearchCondition;
import com.cccis.base.elasticsearch.operation.SearchOperation;
import com.cccis.base.elasticsearch.operation.SimpleQueryBuilder;
import com.cccis.es.dao.EsModelDAO;
import com.cccis.es.model.EsModel;
import com.cccis.es.utils.DateUtils;
import com.cccis.es.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ccc on 2017/7/6.
 */
@Service
public class EsSample {

    @Resource(name = EsModelDAO.SPRING_BEAN_NAME)
    EsModelDAO esModelDAO;

    SearchOperation searchOperation;

    public void init() {
        if(searchOperation == null) {
            searchOperation = new SearchOperation(new String[]{"claim"}, new String[]{"claimtask"});
            SearchCondition condition = SearchCondition.searchCondition()
                    .setPageNo(1).setPageSize(10);
            Object results = searchOperation.search(condition);
        }
    }

    public long queryData() {
        /*SimpleQueryBuilder filterPickupTaskDateBuilder = SimpleQueryBuilder.simpleQuery()
                .andRangeDate("sendCarDate", this.convertStringToDate2("2017-02-01", "from"), this.convertStringToDate2("2017-03-01", "to"));
*/
        SearchCondition condition = SearchCondition.searchCondition()
                .setPageNo(1).setPageSize(25);

        long s = System.currentTimeMillis();
        Object results = searchOperation.search(condition);
        long e = System.currentTimeMillis() - s;
        System.out.println("Query Data: " + e);
        /*if(esModelDAO != null) {
            esModelDAO.save(new EsModel(new BigDecimal(e)));
        }*/
        return e;
    }



    private Date convertStringToDate2(String val, String type) {
        if (null == val || val.trim().length() == 0 || StringUtils.isEmpty(val)) {
            return null;
        } else {
            Date date = DateFormatter.parse(val);
            if ("to".equals(type) && date != null) {
                date.setDate(date.getDate() + 1);
            }
            return date;
        }
    }

    private static class DateFormatter {

        static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
            @Override
            public SimpleDateFormat initialValue() {
                return new SimpleDateFormat(DateUtils.YYYY_MM_DD);
            }
        };

        static Date parse(String str) {
            try {
                return sdf.get().parse(str);
            } catch (Exception e) {
                //                e.printStackTrace();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        EsSample esSample = new EsSample();
        esSample.init();
        esSample.queryData();
    }



   /* public void querySample() {
        searchOperation = new SearchOperation(new String[]{"sample"}, new String[]{"fulltext"});

        SearchCondition condition = SearchCondition.searchCondition()
                .setPageNo(1).setPageSize(25);
        Object results = searchOperation.search(condition);

        long s = System.currentTimeMillis();
        results = searchOperation.search(condition);
        System.out.println("Query Data: " + (System.currentTimeMillis() - s));
    }*/
}
