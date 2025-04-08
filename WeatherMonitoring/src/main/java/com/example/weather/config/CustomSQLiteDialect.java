package com.example.weather.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.boot.model.FunctionContributions;
import org.hibernate.boot.model.TypeContributions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.SqlTypes;

public class CustomSQLiteDialect extends Dialect {

    public CustomSQLiteDialect() {
        super();
    }

    @Override
    public void initializeFunctionRegistry(FunctionContributions functionContributions) {
        super.initializeFunctionRegistry(functionContributions);

        functionContributions.getFunctionRegistry().register(
            "concat", new StandardSQLFunction("concat", StandardBasicTypes.STRING)
        );
        functionContributions.getFunctionRegistry().register(
            "mod", new StandardSQLFunction("mod", StandardBasicTypes.INTEGER)
        );
        functionContributions.getFunctionRegistry().register(
            "substr", new StandardSQLFunction("substr", StandardBasicTypes.STRING)
        );
        functionContributions.getFunctionRegistry().register(
            "length", new StandardSQLFunction("length", StandardBasicTypes.INTEGER)
        );
    }

    @Override
    public void contributeTypes(TypeContributions typeContributions, ServiceRegistry serviceRegistry) {
        super.contributeTypes(typeContributions, serviceRegistry);
    }

    @Override
    public boolean dropConstraints() {
        return false;
    }
}
