package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.UserAssessmentTempRepository;
import com.app.shared.survey.UserAssessmentTemp;
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
import com.app.shared.survey.AssessmentTran;
import com.app.server.repository.AssessmentTranRepository;
import com.app.shared.survey.Assessments;
import com.app.server.repository.AssessmentsRepository;
import com.app.shared.survey.AssessmentQuestion;
import com.app.server.repository.AssessmentQuestionRepository;
import com.app.shared.authentication.User;
import com.app.server.repository.UserRepository;
import com.app.shared.authentication.UserAccessDomain;
import com.app.server.repository.UserAccessDomainRepository;
import com.app.shared.authentication.UserAccessLevel;
import com.app.server.repository.UserAccessLevelRepository;
import com.app.shared.authentication.PassRecovery;
import com.app.shared.authentication.Question;
import com.app.server.repository.QuestionRepository;
import com.app.shared.authentication.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAssessmentTempTestCase {

    @Autowired
    private UserAssessmentTempRepository<UserAssessmentTemp> userassessmenttempRepository;

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
            assessmentanswer.setAnswer("2SC4BfVG1cY43jn9UxCh8pU0DK9a9zfpucD7FnDoprnUQZdrao");
            assessmentanswer.setAnswerDesc("4");
            AssessmentAnswer AssessmentAnswerTest = assessmentanswerRepository.save(assessmentanswer);
            map.put("AssessmentAnswerPrimaryKey", assessmentanswer._getPrimarykey());
            AssessmentTran assessmenttran = new AssessmentTran();
            Assessments assessments = new Assessments();
            assessments.setAssessmentName(valueGenerator.randomValueGenerate("String", 256, 0));
            assessments.setDuration(2147483647);
            AssessmentQuestion assessmentquestion = new AssessmentQuestion();
            assessmentquestion.setQuestion("EwfSyLDB9y9YaNfI5S8FRKE3NcrW43EtH7v5BNlieLSGjmr2rc");
            assessmentquestion.setQuestionDesc("l");
            assessmentquestion.setQuestionInference(true);
            AssessmentQuestion AssessmentQuestionTest = assessmentquestionRepository.save(assessmentquestion);
            map.put("AssessmentQuestionPrimaryKey", assessmentquestion._getPrimarykey());
            assessments.setAssessmentName(valueGenerator.randomValueGenerate("String", 256, 0));
            assessments.setDuration(2147483647);
            assessments.setFirstQuestionId((java.lang.String) AssessmentQuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            Assessments AssessmentsTest = assessmentsRepository.save(assessments);
            map.put("AssessmentsPrimaryKey", assessments._getPrimarykey());
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("llFKbfVZg71OTEhE1Uff3vGy5q9KIjkHftXsyizOZa4kLFfmog");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1973);
            user.setUserAccessCode(8);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("Dzx9oq5CQ4JTZ2Ny1z2GDPQR71eOKv6BAYL1ZgmvX2HxEYR52K");
            useraccessdomain.setDomainHelp("G9K65eBAm0m41g9XF62tmx1SLFwdAx4o62WithKAGsS1NCiZIx");
            useraccessdomain.setDomainIcon("Mer4LpVbhydKshp8WWOGRTUdEZvSkW5VUonrWse0AN5aT9ZcUG");
            useraccessdomain.setDomainName("jBQuezg9SuJjwGsg8DdB8OSJQ9cX06DnPS6PeML7SFGTmMpc5J");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("DfhfVkAm0jX4OMthdpKYnKzBjULRCH2QbM2pior6uvuMtOZkcF");
            useraccesslevel.setLevelHelp("8wVaWdc6Z5Bq0s8BRTBA8eZXAlOuZzrpnMKb2cWlHJ0oc4Vvkw");
            useraccesslevel.setLevelIcon("SeWe1EHRvEQQznLWq2NIlHrRTyKhwFvTvVWPRc7cojCiZgWFQO");
            useraccesslevel.setLevelName("Ud9HWOEjpr4rqIMpPg9Y3zLYI60TR99jCfbPTmBYnUJq5TLinL");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("pU2YZTnITjANJ8TYuowtsol2BtJ6pHeVZnKRyatZMaQQVmLHc0");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1734);
            user.setUserAccessCode(2);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("IJiWyOJi9M08BujqSjSra51Xawpe0cQFmVetQONVbShSMSrBhx");
            Question question = new Question();
            question.setLevelid(5);
            question.setQuestion("uxFhe27r7pI7mGq0Sbbaac2rLb3QJILA1O8m3rDrUJOvJkK9Fy");
            question.setQuestionDetails("8");
            question.setQuestionIcon("tE3sHYKWzxD34HkIDqDFiW7cQqZuKJ84cSckS5yhWnmusfoX9K");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("RI87ecP7K0FAgA2W1D0wlDZjPS2Glb1oiXgFoThFGYaOwHI7Ae");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("1K23ElXWuo6ZbNzPrDAeh064rsw9GfmtjFlKBrJUKQgBgMQAu0");
            userdata.setOneTimePassword("nq0hUJMuIgLfSkN8qUt4K3lr0Me1P8nV");
            userdata.setOneTimePasswordExpiry(1);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("yBGuiP0MNMfD412TD9lvEBoMWsPZcmpAeEIXZRpVnrwlh3c9uI");
            userdata.setLast5Passwords("wbrBz3sbQP7hAafZrrwmXq8l23mctmQHqW24qsEfqLoDMehxkC");
            userdata.setOneTimePassword("VGFXrGdMO07g3MgwHj3qTs8pRWDGMCMV");
            userdata.setOneTimePasswordExpiry(6);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("L6ak6kQ11EoaRDRkcznI5af2Q5ZGAUnnRSg3XhzpZc4lHubXKJ");
            userdata.setUser(user);
            user.setUserData(userdata);
            User UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
            assessmenttran.setAssessmentId((java.lang.String) AssessmentsTest._getPrimarykey()); /* ******Adding refrenced table data */
            assessmenttran.setAssessmentStartsAt(1234l);
            assessmenttran.setEndTime(new java.sql.Timestamp(123456789));
            assessmenttran.setStartTime(new java.sql.Timestamp(123456789));
            assessmenttran.setStatusCode(2147483647);
            assessmenttran.setUserId((java.lang.String) UserTest._getPrimarykey()); /* ******Adding refrenced table data */
            AssessmentTran AssessmentTranTest = assessmenttranRepository.save(assessmenttran);
            map.put("AssessmentTranPrimaryKey", assessmenttran._getPrimarykey());
            UserAssessmentTemp userassessmenttemp = new UserAssessmentTemp();
            userassessmenttemp.setAnswerId((java.lang.String) AssessmentAnswerTest._getPrimarykey()); /* ******Adding refrenced table data */
            userassessmenttemp.setAssessmentTranId((java.lang.String) AssessmentTranTest._getPrimarykey()); /* ******Adding refrenced table data */
            userassessmenttemp.setQuestionId((java.lang.String) AssessmentQuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            userassessmenttemp.setUserId((java.lang.String) UserTest._getPrimarykey());
            userassessmenttemp.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            userassessmenttemp.setEntityValidator(entityValidator);
            userassessmenttemp.isValid();
            userassessmenttempRepository.save(userassessmenttemp);
            map.put("UserAssessmentTempPrimaryKey", userassessmenttemp._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AssessmentAnswerRepository<AssessmentAnswer> assessmentanswerRepository;

    @Autowired
    private AssessmentTranRepository<AssessmentTran> assessmenttranRepository;

    @Autowired
    private AssessmentsRepository<Assessments> assessmentsRepository;

    @Autowired
    private AssessmentQuestionRepository<AssessmentQuestion> assessmentquestionRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAssessmentTempPrimaryKey"));
            UserAssessmentTemp userassessmenttemp = userassessmenttempRepository.findById((java.lang.String) map.get("UserAssessmentTempPrimaryKey"));
            userassessmenttemp.setVersionId(1);
            userassessmenttemp.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            userassessmenttempRepository.update(userassessmenttemp);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByanswerId() {
        try {
            java.util.List<UserAssessmentTemp> listofanswerId = userassessmenttempRepository.findByAnswerId((java.lang.String) map.get("AssessmentAnswerPrimaryKey"));
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
    public void test3findByassessmentTranId() {
        try {
            java.util.List<UserAssessmentTemp> listofassessmentTranId = userassessmenttempRepository.findByAssessmentTranId((java.lang.String) map.get("AssessmentTranPrimaryKey"));
            if (listofassessmentTranId.size() == 0) {
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
            java.util.List<UserAssessmentTemp> listofquestionId = userassessmenttempRepository.findByQuestionId((java.lang.String) map.get("AssessmentQuestionPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("UserAssessmentTempPrimaryKey"));
            userassessmenttempRepository.findById((java.lang.String) map.get("UserAssessmentTempPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<UserAssessmentTemp> listofuserId = userassessmenttempRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAssessmentTempPrimaryKey"));
            userassessmenttempRepository.delete((java.lang.String) map.get("UserAssessmentTempPrimaryKey")); /* Deleting refrenced data */
            assessmenttranRepository.delete((java.lang.String) map.get("AssessmentTranPrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            assessmentsRepository.delete((java.lang.String) map.get("AssessmentsPrimaryKey")); /* Deleting refrenced data */
            assessmentquestionRepository.delete((java.lang.String) map.get("AssessmentQuestionPrimaryKey")); /* Deleting refrenced data */
            assessmentanswerRepository.delete((java.lang.String) map.get("AssessmentAnswerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
