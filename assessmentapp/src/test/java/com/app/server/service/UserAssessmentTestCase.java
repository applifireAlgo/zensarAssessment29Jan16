package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.UserAssessmentRepository;
import com.app.shared.survey.UserAssessment;
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
public class UserAssessmentTestCase {

    @Autowired
    private UserAssessmentRepository<UserAssessment> userassessmentRepository;

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
            assessmentanswer.setAnswer("5AbhVODXCV1nRTn9bQo5dgWpS4uyXt59JygbKtNHDNzK23mjuq");
            assessmentanswer.setAnswerDesc("W");
            AssessmentAnswer AssessmentAnswerTest = assessmentanswerRepository.save(assessmentanswer);
            map.put("AssessmentAnswerPrimaryKey", assessmentanswer._getPrimarykey());
            AssessmentTran assessmenttran = new AssessmentTran();
            Assessments assessments = new Assessments();
            assessments.setAssessmentName(valueGenerator.randomValueGenerate("String", 256, 0));
            assessments.setDuration(2147483647);
            AssessmentQuestion assessmentquestion = new AssessmentQuestion();
            assessmentquestion.setQuestion("wYWmH1kNjlKhfUV8FL3KHet83EGsmxyy0VMZ1VUtwWrobLbnzg");
            assessmentquestion.setQuestionDesc("N");
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
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("RWNcc1l3eWLlfHKXMaFnLDE9JD0l7qhir6sJcq8FP5nn8iyOd0");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2744);
            user.setUserAccessCode(0);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("MlSQI6OGGkowAbvQynTtI437e6bKkfYrlWTA8ksBjyloSTZfwt");
            useraccessdomain.setDomainHelp("YFcyd1FDjsq0iiYH6SuTdeSNMDuVwn8XZGPMBSD2psSXH5dYZE");
            useraccessdomain.setDomainIcon("RnYv1134rGPCS57HdkcuHfer8KizEkbsqg2GXF1SQdYjUe4fV7");
            useraccessdomain.setDomainName("lrRWwJxhV9qp24TwWzwPxALROsjCrycwXflOP6tgNpbct4qLou");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("49XuyYj1NAXaongW6eqSmvlZo723DRwjG5SpCsyWXsuHr3ZXCs");
            useraccesslevel.setLevelHelp("7nCSua1rrfMySnBE28YOfZUQjAMfWepgxA3RFbIrL79EQKNUjS");
            useraccesslevel.setLevelIcon("Gnhx4OSbqlKVOwYv18WIykcMvm7M6LxcLyKqp82b36HQayMbX4");
            useraccesslevel.setLevelName("labcvI2PoXhKaJcYp0raBzHvwRTLHB6xRDMpLi11oXYfKe9zgV");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("Ktx38cpcfFsYxZOQ2qBmZLppNwcnUaOGpYVJRbCvJ5n51kvBfS");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1884);
            user.setUserAccessCode(8);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("DoW433G1HjDmf3SGqgmFt7GPJuX3AeeagPTPihq2FA6FOLw543");
            Question question = new Question();
            question.setLevelid(6);
            question.setQuestion("8vQbgevCUOoNgIhCGz7TPhoFKrY3TSq7tW6zmkgqiUZ5nQyVnB");
            question.setQuestionDetails("O");
            question.setQuestionIcon("HVv72il87PYXr9TMGZFdTQZv1i5iX0rBSyRappN6ZCeeIHVrWW");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("SKCFPLlYX9SkcFc2uZPhXnnNEYvuIjpo9s5YVV1hoPctfXnHRO");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("zNk3QUonuL5pNeYkjpnoBw4U07FEVhKlyOdorBwiWtWqVcfTTZ");
            userdata.setOneTimePassword("5f9zaFZ4yUbWo5MGNnlIFpAhtMC3VqKS");
            userdata.setOneTimePasswordExpiry(2);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("CPVj7akarxHr89uAmqrZVybKV45e80hVxvJF90yNBLSoTjVmg1");
            userdata.setLast5Passwords("rfEmZa0FPYlnVI2Ff5ALbKLBZxjR5PzBSZYBU8Xzzux3Cl8I9k");
            userdata.setOneTimePassword("eJ7bXZRsTTqsdrVt7FqWhOltkrPQOSdC");
            userdata.setOneTimePasswordExpiry(2);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("KgAXhdNSKmU59YQrAXRtnYoFQltanHHi4v1MTbrBB7B4R8Istf");
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
            UserAssessment userassessment = new UserAssessment();
            userassessment.setAnswerId((java.lang.String) AssessmentAnswerTest._getPrimarykey()); /* ******Adding refrenced table data */
            userassessment.setAssessmentTranId((java.lang.String) AssessmentTranTest._getPrimarykey()); /* ******Adding refrenced table data */
            userassessment.setQuestionId((java.lang.String) AssessmentQuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            userassessment.setUserId((java.lang.String) UserTest._getPrimarykey());
            userassessment.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            userassessment.setEntityValidator(entityValidator);
            userassessment.isValid();
            userassessmentRepository.save(userassessment);
            map.put("UserAssessmentPrimaryKey", userassessment._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("UserAssessmentPrimaryKey"));
            UserAssessment userassessment = userassessmentRepository.findById((java.lang.String) map.get("UserAssessmentPrimaryKey"));
            userassessment.setVersionId(1);
            userassessment.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            userassessmentRepository.update(userassessment);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByanswerId() {
        try {
            java.util.List<UserAssessment> listofanswerId = userassessmentRepository.findByAnswerId((java.lang.String) map.get("AssessmentAnswerPrimaryKey"));
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
            java.util.List<UserAssessment> listofassessmentTranId = userassessmentRepository.findByAssessmentTranId((java.lang.String) map.get("AssessmentTranPrimaryKey"));
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
            java.util.List<UserAssessment> listofquestionId = userassessmentRepository.findByQuestionId((java.lang.String) map.get("AssessmentQuestionPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("UserAssessmentPrimaryKey"));
            userassessmentRepository.findById((java.lang.String) map.get("UserAssessmentPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<UserAssessment> listofuserId = userassessmentRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("UserAssessmentPrimaryKey"));
            userassessmentRepository.delete((java.lang.String) map.get("UserAssessmentPrimaryKey")); /* Deleting refrenced data */
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
