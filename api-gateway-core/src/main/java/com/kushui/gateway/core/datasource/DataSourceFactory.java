package com.kushui.gateway.core.datasource;


import com.kushui.gateway.core.session.Configuration;

/**
 * @description 数据源工厂
 */
public interface DataSourceFactory {

    void setProperties(Configuration configuration, String uri);

    DataSource getDataSource();

}
