package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.QuestionLinkageRepository;
import com.app.shared.survey.QuestionLinkage;
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
import com.app.shared.survey.AssessmentQuestion;
import com.app.server.repository.AssessmentQuestionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class QuestionLinkageTestCase {

    @Autowired
    private QuestionLinkageRepository<QuestionLinkage> questionlinkageRepository;

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
            AssessmentAnswer assessmentanswer = new AssessmentAnswer();
            assessmentanswer.setAnswer("YS3Rs21AwnmVH9G8iJTL09OwuoWva1qGIzJvpOyq4peCHwZAEs");
            assessmentanswer.setAnswerDesc("A");
            AssessmentAnswer AssessmentAnswerTest = assessmentanswerRepository.save(assessmentanswer);
            map.put("AssessmentAnswerPrimaryKey", assessmentanswer._getPrimarykey());
            AssessmentQuestion assessmentquestion = new AssessmentQuestion();
            assessmentquestion.setQuestion("3tlpQXf0C9oEUOM2Fcdhk8DLfp0rHE6ajZOEre58IJjqsMkzRU");
            assessmentquestion.setQuestionDesc("I");
            assessmentquestion.setQuestionInference(true);
            AssessmentQuestion AssessmentQuestionTest = assessmentquestionRepository.save(assessmentquestion);
            map.put("AssessmentQuestionPrimaryKey", assessmentquestion._getPrimarykey());
            QuestionLinkage questionlinkage = new QuestionLinkage();
            questionlinkage.setAnswerId((java.lang.String) AssessmentAnswerTest._getPrimarykey()); /* ******Adding refrenced table data */
            questionlinkage.setFirstGenQuestion(true);
            questionlinkage.setLastGenQuestion(true);
            questionlinkage.setLinkedQuestionId("MkXKleYpIY8yKgd76DyO59UzVrmWayM1Pdf4ODkLiKd48WJnI7");
            questionlinkage.setQuestionId((java.lang.String) AssessmentQuestionTest._getPrimarykey());
            questionlinkage.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            questionlinkage.setEntityValidator(entityValidator);
            questionlinkage.isValid();
            questionlinkageRepository.save(questionlinkage);
            map.put("QuestionLinkagePrimaryKey", questionlinkage._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AssessmentAnswerRepository<AssessmentAnswer> assessmentanswerRepository;

    @Autowired
    private AssessmentQuestionRepository<AssessmentQuestion> assessmentquestionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionLinkagePrimaryKey"));
            QuestionLinkage questionlinkage = questionlinkageRepository.findById((java.lang.String) map.get("QuestionLinkagePrimaryKey"));
            questionlinkage.setLinkedQuestionId("1HFAkahnhp8S9yRaWvSQpkRXLwAE6Dvc9YDCCOVZD0ohKBX4Jx");
            questionlinkage.setVersionId(1);
            questionlinkage.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            questionlinkageRepository.update(questionlinkage);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByanswerId() {
        try {
            java.util.List<QuestionLinkage> listofanswerId = questionlinkageRepository.findByAnswerId((java.lang.String) map.get("AssessmentAnswerPrimaryKey"));
            if (listofanswerId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByquestionId() {
        try {
            java.util.List<QuestionLinkage> listofquestionId = questionlinkageRepository.findByQuestionId((java.lang.String) map.get("AssessmentQuestionPrimaryKey"));
            if (listofquestionId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionLinkagePrimaryKey"));
            questionlinkageRepository.findById((java.lang.String) map.get("QuestionLinkagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindLinkageByQuestionAnswer() {
        try {
            questionlinkageRepository.FindLinkageByQuestionAnswer("ab", "ab");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionLinkagePrimaryKey"));
            questionlinkageRepository.delete((java.lang.String) map.get("QuestionLinkagePrimaryKey")); /* Deleting refrenced data */
            assessmentquestionRepository.delete((java.lang.String) map.get("AssessmentQuestionPrimaryKey")); /* Deleting refrenced data */
            assessmentanswerRepository.delete((java.lang.String) map.get("AssessmentAnswerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
