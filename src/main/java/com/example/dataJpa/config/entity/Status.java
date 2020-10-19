/**
 *
 */
package com.example.dataJpa.config.entity;

/**
 * @author k_sre
 *
 */
public enum Status {
/**
 * @author k_sre
 *
 */
PENDING {
@Override
public String toString() {
return "Pending";
}
}, /**
 * @author k_sre
 *
 */
COMPLETED {
@Override
public String toString() {
return "Completed";
}
}, /**
 * @author k_sre
 *
 */
TERMINATED {
@Override
public String toString() {
return "Terminated";
}
};

/**
 * @param dbValue
 * @return status
 */
public static Status byDBValue(final String dbValue) {
for (Status status : values()) {
if (status.toString().equalsIgnoreCase(dbValue)) {
return status;
}
throw new IllegalArgumentException();
}
return Status.PENDING;
}
}

