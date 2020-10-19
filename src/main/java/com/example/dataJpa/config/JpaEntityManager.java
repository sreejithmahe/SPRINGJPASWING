package com.example.dataJpa.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.boot.SchemaAutoTooling;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.H2Dialect;

public class JpaEntityManager {
private EntityManagerFactory emFactoryObj;
private final String PERSISTENCE_UNIT_NAME = "JPATest";
private final Map<String, String> properties=new HashMap<String, String>();


// This Method Is Used To Retrieve The 'EntityManager' Object
public EntityManager getEntityManager() {
	properties.put("javax.persistence.jdbc.driver","com.mysql.cj.jdbc.Driver");
	properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/percona");
	properties.put("javax.persistence.jdbc.user", "Gram");
	properties.put("javax.persistence.jdbc.password","Gram@2020");
	properties.put(Environment.SHOW_SQL, "true");

	properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	properties.put(Environment.HBM2DDL_AUTO, "update");

	emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME,properties);emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME,properties);

return emFactoryObj.createEntityManager();
}
}
