package com.sop.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConfig {

    private static final String PERSISTENCE_UNIT_NAME = "sop-control-unit";

    public static EntityManager createEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        return emf.createEntityManager();
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = DatabaseConfig.class.getClassLoader().getResourceAsStream("database.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            Logger logger = Logger.getLogger(DatabaseConfig.class.getName());
            logger.log(Level.SEVERE, "Erro ao carregar as configurações do banco de dados.", e);
        }
        return properties;
    }

    public static String getProperty(String key) {
        Properties properties = loadProperties();
        return properties.getProperty(key);
    }
}
