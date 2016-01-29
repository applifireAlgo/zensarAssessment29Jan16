package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.QuestionInferenceRepository;
import com.app.shared.survey.QuestionInference;
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
import com.app.shared.survey.AssessmentQuestion;
import com.app.server.repository.AssessmentQuestionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class QuestionInferenceTestCase {

    @Autowired
    private QuestionInferenceRepository<QuestionInference> questioninferenceRepository;

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
            assessmentquestion.setQuestion("qUqiAOb3Zy1MZyQGZKRNrcFahUzg0Ab68g41I72RoPrxCtJOXE");
            assessmentquestion.setQuestionDesc("A");
            assessmentquestion.setQuestionInference(true);
            AssessmentQuestion AssessmentQuestionTest = assessmentquestionRepository.save(assessmentquestion);
            map.put("AssessmentQuestionPrimaryKey", assessmentquestion._getPrimarykey());
            QuestionInference questioninference = new QuestionInference();
            questioninference.setInferenceHeading("iBSWbODwUmk97imhmdOQe1VoMvqhYAS7fZkDKPQSsERwivsYTR");
            questioninference.setInferenceKeyword("B");
            questioninference.setInferenceNoValue("GNNMFtqPcK9hj8fe6Z0PHkeXwSg6gHKSSUaxvlreqxGYHWJ5y5");
            questioninference.setInferenceYesValue("ZZYTjnYlehqo2NEqVSgkMYcwzcFVTGRkXgSLMk724pD2pR8TjV");
            questioninference.setQuestionId((java.lang.String) AssessmentQuestionTest._getPrimarykey());
            questioninference.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            questioninference.setEntityValidator(entityValidator);
            questioninference.isValid();
            questioninferenceRepository.save(questioninference);
            map.put("QuestionInferencePrimaryKey", questioninference._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AssessmentQuestionRepository<AssessmentQuestion> assessmentquestionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionInferencePrimaryKey"));
            QuestionInference questioninference = questioninferenceRepository.findById((java.lang.String) map.get("QuestionInferencePrimaryKey"));
            questioninference.setInferenceHeading("ukP48ocOwXEE6FuiUTEhcjUZSHF1ZTfJiQSqN8IW6thFz5E7Is");
            questioninference.setInferenceKeyword("Y");
            questioninference.setInferenceNoValue("219FbM7yp7Z7ZC9ECuUJpuQH5QuWgYLLEg1gpaXYdPK06b1uIN");
            questioninference.setInferenceYesValue("lPvdWVgwvcXmgcqiMdrZtxrhGrR6hDB2vwfxuJNUyJZ9OM3eiu");
            questioninference.setVersionId(1);
            questioninference.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            questioninferenceRepository.update(questioninference);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByquestionId() {
        try {
            java.util.List<QuestionInference> listofquestionId = questioninferenceRepository.findByQuestionId((java.lang.String) map.get("AssessmentQuestionPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("QuestionInferencePrimaryKey"));
            questioninferenceRepository.findById((java.lang.String) map.get("QuestionInferencePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionInferencePrimaryKey"));
            questioninferenceRepository.delete((java.lang.String) map.get("QuestionInferencePrimaryKey")); /* Deleting refrenced data */
            assessmentquestionRepository.delete((java.lang.String) map.get("AssessmentQuestionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
