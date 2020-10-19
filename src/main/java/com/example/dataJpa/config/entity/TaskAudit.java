package com.example.dataJpa.config.entity;



import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;



@Entity
public class TaskAudit {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
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
  private UUID taskInstanceId;

  private String taskName;

  private String taskType;

  @NotNull
  @Column(columnDefinition = "BINARY(16)")
  @Type(type = "uuid-binary")
  private UUID processInstanceId;

  @NotNull
  @Column(columnDefinition = "VARCHAR(4000)")
  private String variables;

  @NotNull
  @Convert(converter = StatusConverter.class)
  private Status status;

  private String assignee;

  private Timestamp assignedDateTime;

  @NotNull
  private Timestamp startDateTime;

  private String completedBy;

  private Timestamp completedDateTime;

  private String terminatedBy;

  private Timestamp terminatedDateTime;

  @NotNull
  private String lastModifiedBy;

  @NotNull
  private Timestamp lastModifiedDateTime;

  @NotNull
  private String eventType;

  protected TaskAudit() {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
  }

  public TaskAudit(UUID tenantId, String tenantName, UUID taskInstanceId, String taskName, String taskType, UUID processInstanceId,
                   String variables, Status status, String assignee, Timestamp assignedDateTime, Timestamp startDateTime,
                   String completedBy, Timestamp completedDateTime, String terminatedBy, Timestamp terminatedDateTime,
                   String lastModifiedBy, Timestamp lastModifiedDateTime, String eventType) {
    this.tenantId = tenantId;
    this.tenantName = tenantName;
    this.taskInstanceId = taskInstanceId;
    this.taskName = taskName;
    this.taskType = taskType;
    this.processInstanceId = processInstanceId;
    this.variables = variables;
    this.status = status;
    this.assignee = assignee;
    this.assignedDateTime = assignedDateTime;
    this.startDateTime = startDateTime;
    this.completedBy = completedBy;
    this.completedDateTime = completedDateTime;
    this.terminatedBy = terminatedBy;
    this.terminatedDateTime = terminatedDateTime;
    this.lastModifiedBy = lastModifiedBy;
    this.lastModifiedDateTime = lastModifiedDateTime;
    this.eventType = eventType;
  }



  public TaskAudit(TaskAudit taskAudit) {
    this.tenantId = taskAudit.getTenantId();
    this.tenantName = taskAudit.getTenantName();
    this.taskInstanceId = taskAudit.getTaskInstanceId();
    this.taskName = taskAudit.getTaskName();
    this.taskType = taskAudit.getTaskType();
    this.processInstanceId = taskAudit.getProcessInstanceId();
    this.variables = taskAudit.getVariables();
    this.status = taskAudit.getStatus();
    this.assignee = taskAudit.getAssignee();
    this.assignedDateTime = taskAudit.getAssignedDateTime();
    this.startDateTime = taskAudit.getStartDateTime();
    this.completedBy = taskAudit.getCompletedBy();
    this.completedDateTime = taskAudit.getCompletedDateTime();
    this.terminatedBy = taskAudit.getTerminatedBy();
    this.terminatedDateTime = taskAudit.getTerminatedDateTime();
    this.lastModifiedBy = taskAudit.getLastModifiedBy();
    this.lastModifiedDateTime = taskAudit.getLastModifiedDateTime();
    this.eventType = taskAudit.getEventType();
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

  public UUID getTaskInstanceId() {
    return taskInstanceId;
  }

  public void setTaskInstanceId(UUID taskInstanceId) {
    this.taskInstanceId = taskInstanceId;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public String getTaskType() {
    return taskType;
  }

  public void setTaskType(String taskType) {
    this.taskType = taskType;
  }

  public UUID getProcessInstanceId() {
    return processInstanceId;
  }

  public void setProcessInstanceId(UUID processInstanceId) {
    this.processInstanceId = processInstanceId;
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

  public String getAssignee() {
    return assignee;
  }

  public void setAssignee(String assignee) {
    this.assignee = assignee;
  }

  public Timestamp getAssignedDateTime() {
    return assignedDateTime;
  }

  public void setAssignedDateTime(Timestamp assignedDateTime) {
    this.assignedDateTime = assignedDateTime;
  }

  public Timestamp getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(Timestamp startDateTime) {
    this.startDateTime = startDateTime;
  }

  public String getCompletedBy() {
    return completedBy;
  }

  public void setCompletedBy(String completedBy) {
    this.completedBy = completedBy;
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
    TaskAudit that = (TaskAudit) obj;
    return Objects.equals(tenantId, that.tenantId)
        && Objects.equals(tenantName, that.tenantName)
        && Objects.equals(taskInstanceId, that.taskInstanceId)
        && Objects.equals(taskName, that.taskName)
        && Objects.equals(taskType, that.taskType)
        && Objects.equals(processInstanceId, that.processInstanceId)
        && Objects.equals(variables, that.variables)
        && Objects.equals(status, that.status)
        && Objects.equals(assignee, that.assignee)
        && Objects.equals(assignedDateTime, that.assignedDateTime)
        && Objects.equals(startDateTime, that.startDateTime)
        && Objects.equals(completedBy, that.completedBy)
        && Objects.equals(completedDateTime, that.completedDateTime)
        && Objects.equals(terminatedBy, that.terminatedBy)
        && Objects.equals(terminatedDateTime, that.terminatedDateTime)
        && Objects.equals(lastModifiedBy, that.lastModifiedBy)
        && Objects.equals(lastModifiedDateTime, that.lastModifiedDateTime)
        && Objects.equals(eventType, that.eventType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, tenantName, taskInstanceId, taskName, taskType, processInstanceId, variables, status, assignee, assignedDateTime,
        startDateTime, completedBy, completedDateTime, terminatedBy, terminatedDateTime, lastModifiedBy, lastModifiedDateTime, eventType);
  }
}
