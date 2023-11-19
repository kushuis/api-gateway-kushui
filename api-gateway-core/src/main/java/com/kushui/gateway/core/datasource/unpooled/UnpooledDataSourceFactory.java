package com.kushui.gateway.core.datasource.unpooled;

import com.kushui.gateway.core.datasource.DataSource;
import com.kushui.gateway.core.datasource.DataSourceFactory;
import com.kushui.gateway.core.datasource.DataSourceType;
import com.kushui.gateway.core.session.Configuration;

/**
 * @description 非池化数据源工厂
 */
public class UnpooledDataSourceFactory implements DataSourceFactory {

    protected UnpooledDataSource dataSource;

    public UnpooledDataSourceFactory() {
        this.dataSource = new UnpooledDataSource();
    }

    @Override
    public void setProperties(Configuration configuration, String uri) {
        this.dataSource.setConfiguration(configuration);
        //这里是写死了，实际要从configuration中获取是dubbo还是http
        this.dataSource.setDataSourceType(DataSourceType.Dubbo);
        this.dataSource.setHttpStatement(configuration.getHttpStatement(uri));
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

}
