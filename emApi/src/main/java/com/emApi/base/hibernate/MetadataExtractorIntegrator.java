package com.emApi.base.hibernate;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class MetadataExtractorIntegrator implements Integrator {
    public static final Database database = new MetadataExtractorIntegrator().getDatabase();

    private Database db;

    public Database getDatabase() {
        return this.db;
    }

    @Override
    public void integrate(Metadata metadata
            , SessionFactoryImplementor sessionFactoryImplementor, SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        db = metadata.getDatabase();
    }

    @Override
    public void disintegrate(SessionFactoryImplementor sessionFactoryImplementor
            , SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
    }
}
