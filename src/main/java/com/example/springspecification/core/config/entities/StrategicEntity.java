package com.example.springspecification.core.config.entities;

import org.hibernate.HibernateException;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitEntityNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Locale;

/** Class to Pluralize All Entities, you don't have to worry about creating a class in Plural,
 * so the proper functioning of this project doesn't use other languages. Always use English.
 * @author Guilherme Lourenco
 * @version 1.00
 * @since Release 01 of the application
 */
@Component
public class StrategicEntity extends ImplicitNamingStrategyJpaCompliantImpl {

    @Autowired
    private Environment environment;

    private static String prefix = "core.config.entities.entityName.";

    @Override
    protected Identifier toIdentifier(String stringForm, MetadataBuildingContext buildingContext) {
        String tableOrFieldName = environment.getProperty(prefix.concat(stringForm));
        if(tableOrFieldName == null) {
            tableOrFieldName = stringForm;
        }
        return super.toIdentifier(tableOrFieldName , buildingContext);
    }

    @Override
    public Identifier determinePrimaryTableName(ImplicitEntityNameSource source) {
        if (source == null) {
            throw new HibernateException("Entity naming information was not provided.");
        } else {
            String tableName = this.transformEntityName(source.getEntityNaming());
            if (tableName == null) {
                throw new HibernateException("Could not determine primary table name for entity");
            } else {
                return this.toIdentifier(tableName, source.getBuildingContext());
            }
        }
    }

}
