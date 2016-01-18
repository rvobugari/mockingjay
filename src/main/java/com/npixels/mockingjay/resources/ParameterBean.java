package com.npixels.mockingjay.resources;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rvobugari on 12/12/15.
 */
public class ParameterBean {
    private Map<String, Object> paramsMap = new HashMap<String, Object>();
    void setParamsMap(String name, Object value){
        paramsMap.put(name, value);
    }

    Map<String, Object> getParamsMap(){
        return paramsMap;
    }
}
