package com.example.dataJpa.config.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.dataJpa.config.JpaEntityManager;
import com.example.dataJpa.config.entity.ProcessAudit;

public class ProcessAuditService {

	public List<ProcessAudit> getProcessAudits() {

		JpaEntityManager dbEntityManager = new JpaEntityManager();
		EntityManager entityManager = dbEntityManager.getEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> processQuery = builder.createQuery(Long.class);
		Root<ProcessAudit> processRoot = processQuery.from(ProcessAudit.class);
		Expression<Long> countExpression = builder.count(processRoot);
		processQuery.select(countExpression);
		TypedQuery<Long> typedProcessQuery = entityManager.createQuery(processQuery);
		Long count = typedProcessQuery.getSingleResult();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery query = criteriaBuilder.createQuery();
		Predicate whereClause = criteriaBuilder.equal(criteriaBuilder.literal(1), 1);
		Root<ProcessAudit> root = query.from(ProcessAudit.class);
		query.select(root);
		query.where(whereClause);
		TypedQuery<ProcessAudit> queryResult = entityManager.createQuery(query);
		List<ProcessAudit> results = queryResult.getResultList();
		return results;
	}

	public Long getProcessAuditsCount() {
		JpaEntityManager dbEntityManager1 = new JpaEntityManager();
		EntityManager entityManager1 = dbEntityManager1.getEntityManager();

		CriteriaBuilder builder = entityManager1.getCriteriaBuilder();
		CriteriaQuery<Long> processQuery = builder.createQuery(Long.class);
		Root<ProcessAudit> processRoot = processQuery.from(ProcessAudit.class);
		Expression<Long> countExpression = builder.count(processRoot);
		processQuery.select(countExpression);
		TypedQuery<Long> typedProcessQuery = entityManager1.createQuery(processQuery);
		Long count = typedProcessQuery.getSingleResult();
		return count;

	}

}
