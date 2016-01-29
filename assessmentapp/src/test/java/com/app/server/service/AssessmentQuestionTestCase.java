package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AssessmentQuestionRepository;
import com.app.shared.survey.AssessmentQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.survey.AssessmentAnswer;
import com.app.server.repository.AssessmentAnswerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AssessmentQuestionTestCase {

    @Autowired
    private AssessmentQuestionRepository<AssessmentQuestion> assessmentquestionRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            AssessmentQuestion assessmentquestion = new AssessmentQuestion();
            assessmentquestion.setQuestion("RjTMpSv6fP8xxRmAmgnqZC61892Plp7Ve0dumzmAWWgcspgj0p");
            assessmentquestion.setQuestionDesc("C");
            assessmentquestion.setQuestionInference(true);
            java.util.List<AssessmentAnswer> listOfAssessmentAnswer = new java.util.ArrayList<AssessmentAnswer>();
            AssessmentAnswer assessmentanswer = new AssessmentAnswer();
            assessmentanswer.setAnswer("kchOYTnwbWTWBlmzVq5AgIla1Cq1aPStNQeqK6TU1wDYFqFaxh");
            assessmentanswer.setAnswerDesc("a");
            listOfAssessmentAnswer.add(assessmentanswer);
            assessmentquestion.addAllAssessmentAnswer(listOfAssessmentAnswer);
            assessmentquestion.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            assessmentquestion.setEntityValidator(entityValidator);
            assessmentquestion.isValid();
            assessmentquestionRepository.save(assessmentquestion);
            map.put("AssessmentQuestionPrimaryKey", assessmentquestion._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AssessmentAnswerRepository<AssessmentAnswer> assessmentanswerRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AssessmentQuestionPrimaryKey"));
            AssessmentQuestion assessmentquestion = assessmentquestionRepository.findById((java.lang.String) map.get("AssessmentQuestionPrimaryKey"));
            assessmentquestion.setQuestion("9YZSJSSzUGgPDQ8t0YzdHquL0MN80tTK9AMWFMM3dtm0v3HtRa");
            assessmentquestion.setQuestionDesc("1");
            assessmentquestion.setVersionId(1);
            assessmentquestion.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            assessmentquestionRepository.update(assessmentquestion);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AssessmentQuestionPrimaryKey"));
            assessmentquestionRepository.findById((java.lang.String) map.get("AssessmentQuestionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AssessmentQuestionPrimaryKey"));
            assessmentquestionRepository.delete((java.lang.String) map.get("AssessmentQuestionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
