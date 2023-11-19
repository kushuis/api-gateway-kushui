package com.kushui.gateway.core.bind;



import com.kushui.gateway.core.executor.result.SessionResult;

import java.util.Map;


public interface IGenericReference {

    SessionResult $invoke(Map<String, Object> params);

}