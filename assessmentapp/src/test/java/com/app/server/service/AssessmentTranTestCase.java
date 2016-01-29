package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AssessmentTranRepository;
import com.app.shared.survey.AssessmentTran;
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
public class AssessmentTranTestCase {

    @Autowired
    private AssessmentTranRepository<AssessmentTran> assessmenttranRepository;

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
            Assessments assessments = new Assessments();
            assessments.setAssessmentName(valueGenerator.randomValueGenerate("String", 256, 0));
            assessments.setDuration(2147483647);
            AssessmentQuestion assessmentquestion = new AssessmentQuestion();
            assessmentquestion.setQuestion("SYIRwGC8ScBTKbcKpQ6vvh0wck6xoc7WbLLg0gtgTrMVHFm5Vr");
            assessmentquestion.setQuestionDesc("1");
            assessmentquestion.setQuestionInference(true);
            AssessmentQuestion AssessmentQuestionTest = assessmentquestionRepository.save(assessmentquestion);
            map.put("AssessmentQuestionPrimaryKey", assessmentquestion._getPrimarykey());
            assessments.setAssessmentName(valueGenerator.randomValueGenerate("String", 256, 0));
            assessments.setDuration(2147483647);
            assessments.setFirstQuestionId((java.lang.String) AssessmentQuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            Assessments AssessmentsTest = assessmentsRepository.save(assessments);
            map.put("AssessmentsPrimaryKey", assessments._getPrimarykey());
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("jpZM20uhGb7zCjOMudqzP4LnI23OKnot6HwPsuy9bScpPa0wtZ");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2196);
            user.setUserAccessCode(11);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("kTP25qCIsEG8WBlkkBW3v6GWpCZnoCed2CX0Gao0KuKpGLHege");
            useraccessdomain.setDomainHelp("sndLCyY3gkjv4EYG2CBfi5737u1RyV01QaSFq3zYWwCPZXWgup");
            useraccessdomain.setDomainIcon("lvJaFNjp27diQFb2SuLXexW6wcRxVS6gjG3V417BEfjdNRNI1U");
            useraccessdomain.setDomainName("UZ7dW0JPImOJ8p0cceWQy1o26cWBKFGHf8geRTYuIgJmc1FmTA");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("DgWl9Qm7lKZdBJOUl7Ago19mtCx9h8RfSmecz56CPZfT0PgPQP");
            useraccesslevel.setLevelHelp("9NOIHmYsy99IS1WRvJ13GY2vmICDVN8WAXvvdKtCkG5MAkPWBO");
            useraccesslevel.setLevelIcon("l0XEN7HccPjgz3YBq6tCMx6Z2QyLaEqqkjRCwMeYTwJPWTsTgS");
            useraccesslevel.setLevelName("HdqQbqAZ2Y65jSs6QqYPQPQayF9z3eavdTTqOm746H7KrGQXMq");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("iVKwbAfLkZnLMDdPUzyk7x9ZwbPcNQsRmT5y1LRCwhqR4oV6QQ");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2405);
            user.setUserAccessCode(5);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("t8iJGBwGnUjnlZAehioei1w9I7Mf4urGp6qz2bVWGTIDC8TTE9");
            Question question = new Question();
            question.setLevelid(2);
            question.setQuestion("Byphn85xHucp3XqI6Bkw16FzlYE8XOs0p70RoHC5kKtrvfHq0y");
            question.setQuestionDetails("u");
            question.setQuestionIcon("Sw0kFgd2lD9VT9gWdmrccjAPKGlbNtL68BBLWjphKU7TJD7Wl9");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("V2JNWUnSm8Kz05QUIkUCKl1j3QC8MqIQE9yPGOQmKzFG8jMd1O");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("UoF5Qjo4L3EyQcbOeQBNdbO7Zd78E8w3jtoK4ViqE4QgbYbHqi");
            userdata.setOneTimePassword("IKQOPm2fwM7wyOkOsho8aW5Zn6Vl8Gw6");
            userdata.setOneTimePasswordExpiry(7);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("bws33ezJb8uN9wHPeRVPghTwekZ3JRXhVYediRcMFkSlwcCAfh");
            userdata.setLast5Passwords("DFShfNQJZ6mcDhrQyiOeIL6p3TXFD4S56775W7Bl2rrtRy4a2U");
            userdata.setOneTimePassword("mRgGscFhUzB4Rt7u25PYubQnCEq2ffng");
            userdata.setOneTimePasswordExpiry(3);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("Xf1kmyw3uDwQxMF8WGQjQEPWNO3CE5HA7VoODYOKroJ5nLcjFD");
            userdata.setUser(user);
            user.setUserData(userdata);
            User UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
            AssessmentTran assessmenttran = new AssessmentTran();
            assessmenttran.setAssessmentId((java.lang.String) AssessmentsTest._getPrimarykey()); /* ******Adding refrenced table data */
            assessmenttran.setAssessmentStartsAt(1234l);
            assessmenttran.setEndTime(new java.sql.Timestamp(123456789));
            assessmenttran.setStartTime(new java.sql.Timestamp(123456789));
            assessmenttran.setStatusCode(2147483647);
            assessmenttran.setUserId((java.lang.String) UserTest._getPrimarykey());
            assessmenttran.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            assessmenttran.setEntityValidator(entityValidator);
            assessmenttran.isValid();
            assessmenttranRepository.save(assessmenttran);
            map.put("AssessmentTranPrimaryKey", assessmenttran._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("AssessmentTranPrimaryKey"));
            AssessmentTran assessmenttran = assessmenttranRepository.findById((java.lang.String) map.get("AssessmentTranPrimaryKey"));
            assessmenttran.setAssessmentStartsAt(1234l);
            assessmenttran.setEndTime(new java.sql.Timestamp(123456789));
            assessmenttran.setStartTime(new java.sql.Timestamp(123456789));
            assessmenttran.setStatusCode(2147483647);
            assessmenttran.setVersionId(1);
            assessmenttran.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            assessmenttranRepository.update(assessmenttran);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByassessmentId() {
        try {
            java.util.List<AssessmentTran> listofassessmentId = assessmenttranRepository.findByAssessmentId((java.lang.String) map.get("AssessmentsPrimaryKey"));
            if (listofassessmentId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AssessmentTranPrimaryKey"));
            assessmenttranRepository.findById((java.lang.String) map.get("AssessmentTranPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<AssessmentTran> listofuserId = assessmenttranRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("AssessmentTranPrimaryKey"));
            assessmenttranRepository.delete((java.lang.String) map.get("AssessmentTranPrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            assessmentsRepository.delete((java.lang.String) map.get("AssessmentsPrimaryKey")); /* Deleting refrenced data */
            assessmentquestionRepository.delete((java.lang.String) map.get("AssessmentQuestionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
