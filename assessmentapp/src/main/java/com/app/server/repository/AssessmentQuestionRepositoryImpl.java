package com.app.server.repository;
import com.app.shared.survey.AssessmentQuestion;
import com.athena.server.repository.SearchInterfaceImpl;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.config.server.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.app.shared.survey.AssessmentAnswer;

@Repository
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "4", comments = "Repository for AssessmentQuestion Transaction table", complexity = Complexity.MEDIUM)
public class AssessmentQuestionRepositoryImpl extends SearchInterfaceImpl implements AssessmentQuestionRepository<AssessmentQuestion> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<AssessmentQuestion> findAll() throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            java.util.List<com.app.shared.survey.AssessmentQuestion> query = emanager.createQuery("select u from AssessmentQuestion u where u.systemInfo.activeStatus=1").getResultList();
            return query;
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in retrieving entity", e);
        }
    }

    @Override
    @Transactional
    public AssessmentQuestion save(AssessmentQuestion entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            java.util.List<com.app.shared.survey.AssessmentAnswer> assessmentanswer = new java.util.ArrayList<com.app.shared.survey.AssessmentAnswer>();
            for (java.util.Iterator iterator = entity.getAssessmentAnswer().iterator(); iterator.hasNext(); ) {
                com.app.shared.survey.AssessmentAnswer childEntity = (com.app.shared.survey.AssessmentAnswer) iterator.next();
                if (childEntity.getPrimaryKey() != null) {
                    com.app.shared.survey.AssessmentAnswer ans = emanager.find(AssessmentAnswer.class, childEntity.getPrimaryKey());
                    assessmentanswer.add(ans);
                } else {
                    assessmentanswer.add(childEntity);
                }
            }
            entity.setAssessmentAnswer(assessmentanswer);
            emanager.persist(entity);
            return entity;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        }
    }

    @Override
    @Transactional
    public List<AssessmentQuestion> save(List<AssessmentQuestion> entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                com.app.shared.survey.AssessmentQuestion obj = entity.get(i);
                emanager.persist(obj);
            }
            return entity;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity Saving", e);
        }
    }

    @Transactional
    @Override
    public void delete(String id) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            com.app.shared.survey.AssessmentQuestion s = emanager.find(com.app.shared.survey.AssessmentQuestion.class, id);
            emanager.remove(s);
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void deleteAssessmentAnswer(List<AssessmentAnswer> assessmentanswer) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (com.app.shared.survey.AssessmentAnswer _assessmentanswer : assessmentanswer) {
                com.app.shared.survey.AssessmentAnswer s = emanager.find(com.app.shared.survey.AssessmentAnswer.class, _assessmentanswer.getAnswerId());
                emanager.remove(s);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void update(AssessmentQuestion entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            emanager.merge(entity);
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    @Override
    @Transactional
    public void update(List<AssessmentQuestion> entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                com.app.shared.survey.AssessmentQuestion obj = entity.get(i);
                emanager.merge(obj);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity updation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    @Transactional
    public AssessmentQuestion findById(String questionId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("AssessmentQuestion.findById");
            query.setParameter("questionId", questionId);
            com.app.shared.survey.AssessmentQuestion listOfAssessmentQuestion = (com.app.shared.survey.AssessmentQuestion) query.getSingleResult();
            return listOfAssessmentQuestion;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }
}
