/**
 *
 */
package com.example.dataJpa.config.entity;

import javax.persistence.AttributeConverter;

/**
 * @author k_sre
 *
 */
public class StatusConverter implements AttributeConverter<Status, String> {

@Override
public final String convertToDatabaseColumn(final Status status) {
return status.toString();
}

@Override
public final Status convertToEntityAttribute(final String dbValue) {
return Status.byDBValue(dbValue);
}
}

