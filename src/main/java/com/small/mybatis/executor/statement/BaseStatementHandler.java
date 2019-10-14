package com.small.mybatis.executor.statement;

import com.small.mybatis.executor.parameter.ParameterHandler;
import com.small.mybatis.executor.resultset.ResultSetHandler;
import com.small.mybatis.session.Configuration;

/**
 * @ClassName BaseStatementHandler
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 22:48
 * @Version 1.0
 **/
public abstract class BaseStatementHandler implements StatementHandler {
    protected Configuration configuration;
    protected ResultSetHandler resultSetHandler;
    protected ParameterHandler parameterHandler;
    protected Object[] args;

    public BaseStatementHandler(Configuration conf, Object[] args) {
        this.configuration = conf;
        this.args = args;
        this.resultSetHandler = conf.newResultHandler();
        this.parameterHandler = conf.newParameterHandler(args);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public ResultSetHandler getResultSetHandler() {
        return resultSetHandler;
    }

    public void setResultSetHandler(ResultSetHandler resultSetHandler) {
        this.resultSetHandler = resultSetHandler;
    }

    @Override
    public ParameterHandler getParameterHandler() {
        return parameterHandler;
    }

    public void setParameterHandler(ParameterHandler parameterHandler) {
        this.parameterHandler = parameterHandler;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
