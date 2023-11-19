package com.kushui.gateway.core.executor;



import com.kushui.gateway.core.executor.result.SessionResult;
import com.kushui.gateway.core.mapping.HttpStatement;

import java.util.Map;

/**
 * @description 执行器
 */
public interface Executor {

    SessionResult exec(HttpStatement httpStatement, Map<String, Object> params) throws Exception;

}