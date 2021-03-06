package com.app.server.repository;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "", versionNumber = "1", comments = "Repository for UserAssessment Transaction table", complexity = Complexity.MEDIUM)
public interface UserAssessmentRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException;

    public void delete(String id) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanConstraintViolationException, SpartanPersistenceException;

    public void update(List<T> entity) throws SpartanPersistenceException;

    public List<T> findByAssessmentTranId(String assessmentTranId) throws Exception, SpartanPersistenceException;

    public List<T> findByUserId(String userId) throws Exception, SpartanPersistenceException;

    public List<T> findByQuestionId(String questionId) throws Exception, SpartanPersistenceException;

    public List<T> findByAnswerId(String answerId) throws Exception, SpartanPersistenceException;

    public T findById(String userAssessmentId) throws Exception, SpartanPersistenceException;
}
