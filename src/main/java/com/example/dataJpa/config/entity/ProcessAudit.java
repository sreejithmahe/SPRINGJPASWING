package com.example.dataJpa.config.entity;



import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "process_audit")
public class ProcessAudit {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO , generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private Long id;

  @NotNull
  @Column(columnDefinition = "BINARY(16)")
  @Type(type = "uuid-binary")
  private UUID tenantId;

  private String tenantName;

  @NotNull
  @Column(columnDefinition = "BINARY(16)")
  @Type(type = "uuid-binary")
  private UUID processDefinitionId;

  @Column(columnDefinition = "BINARY(16)")
  @Type(type = "uuid-binary")
  private UUID parentProcessInstanceId;

  @NotNull
  @Column(columnDefinition = "BINARY(16)")
  @Type(type = "uuid-binary")
  private UUID processInstanceId;

  private String processName;

  @NotNull
  @Column(columnDefinition = "VARCHAR(4000)")
  private String variables;

  @NotNull
  @Convert(converter = StatusConverter.class)
  private Status status;

  @NotNull
  private Timestamp startDateTime;

  private Timestamp completedDateTime;

  private String terminatedBy;

  private Timestamp terminatedDateTime;

  @NotNull
  private String lastModifiedBy;

  @NotNull
  private Timestamp lastModifiedDateTime;

  @NotNull
  private String eventType;

  protected ProcessAudit() {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
  }

  public ProcessAudit(UUID tenantId, String tenantName, UUID processDefinitionId, UUID parentProcessInstanceId, UUID processInstanceId,
                      String processName, String variables, Status status, Timestamp startDateTime, Timestamp completedDateTime, String terminatedBy,
                      Timestamp terminatedDateTime, String lastModifiedBy, Timestamp lastModifiedDateTime, String eventType) {
    this.tenantId = tenantId;
    this.tenantName = tenantName;
    this.processDefinitionId = processDefinitionId;
    this.parentProcessInstanceId = parentProcessInstanceId;
    this.processInstanceId = processInstanceId;
    this.processName = processName;
    this.variables = variables;
    this.status = status;
    this.startDateTime = startDateTime;
    this.completedDateTime = completedDateTime;
    this.terminatedBy = terminatedBy;
    this.terminatedDateTime = terminatedDateTime;
    this.lastModifiedBy = lastModifiedBy;
    this.lastModifiedDateTime = lastModifiedDateTime;
    this.eventType = eventType;
  }

  

  public ProcessAudit(ProcessAudit processAudit) {
    this.tenantId = processAudit.getTenantId();
    this.tenantName = processAudit.getTenantName();
    this.processDefinitionId = processAudit.getProcessDefinitionId();
    this.parentProcessInstanceId = processAudit.getParentProcessInstanceId();
    this.processInstanceId = processAudit.getProcessInstanceId();
    this.processName = processAudit.getProcessName();
    this.variables = processAudit.getVariables();
    this.status = processAudit.getStatus();
    this.startDateTime = processAudit.getStartDateTime();
    this.completedDateTime = processAudit.getCompletedDateTime();
    this.terminatedBy = processAudit.getTerminatedBy();
    this.terminatedDateTime = processAudit.getTerminatedDateTime();
    this.lastModifiedBy = processAudit.getLastModifiedBy();
    this.lastModifiedDateTime = processAudit.getLastModifiedDateTime();
    this.eventType = processAudit.getEventType();
  }

  public UUID getTenantId() {
    return tenantId;
  }

  public void setTenantId(UUID tenantId) {
    this.tenantId = tenantId;
  }

  public String getTenantName() {
    return tenantName;
  }

  public void setTenantName(String tenantName) {
    this.tenantName = tenantName;
  }

  public UUID getProcessDefinitionId() {
    return processDefinitionId;
  }

  public void setProcessDefinitionId(UUID processDefinitionId) {
    this.processDefinitionId = processDefinitionId;
  }

  public UUID getParentProcessInstanceId() {
    return parentProcessInstanceId;
  }

  public void setParentProcessInstanceId(UUID parentProcessInstanceId) {
    this.parentProcessInstanceId = parentProcessInstanceId;
  }

  public UUID getProcessInstanceId() {
    return processInstanceId;
  }

  public void setProcessInstanceId(UUID processInstanceId) {
    this.processInstanceId = processInstanceId;
  }

  public String getProcessName() {
    return processName;
  }

  public void setProcessName(String processName) {
    this.processName = processName;
  }

  public String getVariables() {
    return variables;
  }

  public void setVariables(String variables) {
    this.variables = variables;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Timestamp getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(Timestamp startDateTime) {
    this.startDateTime = startDateTime;
  }

  public Timestamp getCompletedDateTime() {
    return completedDateTime;
  }

  public void setCompletedDateTime(Timestamp completedDateTime) {
    this.completedDateTime = completedDateTime;
  }

  public String getTerminatedBy() {
    return terminatedBy;
  }

  public void setTerminatedBy(String terminatedBy) {
    this.terminatedBy = terminatedBy;
  }

  public Timestamp getTerminatedDateTime() {
    return terminatedDateTime;
  }

  public void setTerminatedDateTime(Timestamp terminatedDateTime) {
    this.terminatedDateTime = terminatedDateTime;
  }

  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }

  public Timestamp getLastModifiedDateTime() {
    return lastModifiedDateTime;
  }

  public void setLastModifiedDateTime(Timestamp lastModifiedDateTime) {
    this.lastModifiedDateTime = lastModifiedDateTime;
  }

  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ProcessAudit that = (ProcessAudit) obj;
    return Objects.equals(tenantId, that.tenantId)
        && Objects.equals(tenantName, that.tenantName)
        && Objects.equals(processDefinitionId, that.processDefinitionId)
        && Objects.equals(parentProcessInstanceId, that.parentProcessInstanceId)
        && Objects.equals(processInstanceId, that.processInstanceId)
        && Objects.equals(processName, that.processName)
        && Objects.equals(variables, that.variables)
        && Objects.equals(status, that.status)
        && Objects.equals(startDateTime, that.startDateTime)
        && Objects.equals(completedDateTime, that.completedDateTime)
        && Objects.equals(terminatedBy, that.terminatedBy)
        && Objects.equals(terminatedDateTime, that.terminatedDateTime)
        && Objects.equals(lastModifiedBy, that.lastModifiedBy)
        && Objects.equals(lastModifiedDateTime, that.lastModifiedDateTime)
        && Objects.equals(eventType, that.eventType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, tenantName, processDefinitionId, parentProcessInstanceId, processInstanceId, processName, variables, status,
        startDateTime, completedDateTime, terminatedBy, terminatedDateTime, lastModifiedBy, lastModifiedDateTime, eventType);
  }
}
