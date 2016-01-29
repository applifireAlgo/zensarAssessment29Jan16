package com.app.server.repository;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "2", comments = "Repository for QuestionLinkage Transaction table", complexity = Complexity.MEDIUM)
public interface QuestionLinkageRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException;

    public void delete(String id) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanConstraintViolationException, SpartanPersistenceException;

    public void update(List<T> entity) throws SpartanPersistenceException;

    public List<T> findByQuestionId(String questionId) throws Exception, SpartanPersistenceException;

    public List<T> findByAnswerId(String answerId) throws Exception, SpartanPersistenceException;

    public T findById(String questionLinkId) throws Exception, SpartanPersistenceException;

    public T FindLinkageByQuestionAnswer(String questionId, String answerId) throws Exception, SpartanPersistenceException;
}
