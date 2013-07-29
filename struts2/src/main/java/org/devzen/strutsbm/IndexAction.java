package org.devzen.strutsbm;

import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/")
public class IndexAction extends ActionSupport implements ModelDriven<FooBean> {

    private List<FooBean> fooList = new ArrayList<FooBean>();

    private FooBean model = new FooBean();

    @Action(value = "index", results = {
            @Result(name = "success", location = "/jsp/index.jsp")
    })
    public String index() {
        for (int i = 0; i < 100; i++) {
            fooList.add(new FooBean(10 + i, "name" + i, i % 2 == 0));
        }
        return SUCCESS;
    }

    @Action(value = "index2", results = {
            @Result(name = "success", type="freemarker", location = "/jsp/index.ftl")
    })
    public String index2() {
        for (int i = 0; i < 100; i++) {
            fooList.add(new FooBean(10 + i, "name" + i, i % 2 == 0));
        }
        return SUCCESS;
    }


    @Action(value = "index3", results = {@Result(name = "success", type = "json", params = {"root", "fooList"})})
    public String index3() throws Exception {
        for (int i = 0; i < 100; i++) {
            fooList.add(new FooBean(10 + i, "name" + i, i % 2 == 0));
        }
        return SUCCESS;
    }

    @Override
    public FooBean getModel() {
        return model;
    }

    public List<FooBean> getFooList() {
        return fooList;
    }

    public void setFooList(List<FooBean> fooList) {
        this.fooList = fooList;
    }
}
