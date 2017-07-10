package com.cccis.es.action;

import java.util.List;

import com.cccis.base.elasticsearch.operation.SimpleQueryBuilder;
import com.cccis.es.model.PartModel;
import com.cccis.es.service.EsSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CCC on 2016/10/25.
 */
@Controller
@RequestMapping("/claim")
public class PartAction {


    @Autowired
    EsSample esSample;

    public PartAction() {
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public @ResponseBody
    String apply() {
        esSample.init();
        long t = esSample.queryData();
        return "es take time " + t + "(ms)";
    }

}