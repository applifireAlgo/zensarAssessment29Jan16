package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.LoginRepository;
import com.app.shared.authentication.Login;
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
import com.app.shared.contacts.CoreContacts;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.location.Address;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;
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
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(12);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("Km37CKYmpscq8Rcj4QdBu7YWi0aZSsdiFlOpP2V5rofzrQXmWO");
            corecontacts.setFirstName("k9zf7hnNt2WnBRCuxuf8kOmLjHJA5ouH8eRUjH1ItFo8OiqO9C");
            Gender gender = new Gender();
            gender.setGender("gL1YHjzcYlriqKRGoA3kKXPDsk2iAcgZCHq2OiVbukNuvNVwcH");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("26");
            language.setAlpha3("vlx");
            language.setAlpha4("xRSx");
            language.setAlpha4parentid(11);
            language.setLanguage("6LOJNDoDbeqLfnHifa3efO8f1eEjFUXVD6purH5Dt1IoMwsiuH");
            language.setLanguageDescription("PeAdKcugLYH6eA0TvwVGZuMKSBtSe3GL5SvptnV8f7z8JxLvfn");
            language.setLanguageIcon("BlIHNTloE8DEtgSGbYrBJ4NeFacoqbapF0QqS8n88KzQwPqE1S");
            language.setLanguageType("Wll9YSzOFYlWtAfRp6MBA2AO2WXia61b");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("k4CWh1dCLCcuil4FvebVc5SLkiM2ACFX7jH45B68YrID7jAo2n");
            timezone.setCountry("XEPqm4uA3btXeBNMAmFMJx27uj149JaHdBpv2KjNkm7Nff0LaV");
            timezone.setGmtLabel("3A07kPD6lCx5bEOYHWkYo29BwJKNURnpKjn5B1g56WZLcKn5d9");
            timezone.setTimeZoneLabel("I9BOxNhVa7Gc047A1FrwuUrY5uR1LKypcoofRlRFXKNuIwErzs");
            timezone.setUtcdifference(5);
            Title title = new Title();
            title.setTitles("Avalv6TEDyw9CcUzPq2IgSwTzHS9pKXRWBe7OBZ0vYzijuOn5o");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(38);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("wtgh6GZ3KBoa4PoGO2PGnxeLA5pFwXnuTAqCut7BNWGAZG8TIL");
            corecontacts.setFirstName("i24I0ArxmhclkKGVTJNKYdMH9HqGTcH6mzLoTXnL3sbL8JiuVQ");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("4KO5mscxxmwXMJK3mRPu7r68GcMnITUJs4LZWsWYnU4jdYbmm0");
            corecontacts.setMiddleName("A6U8tN7Vef42H6ij8g6tFPHlTbaDFPSUGKoAqtfxAnymwL8L3d");
            corecontacts.setNativeFirstName("gDMR6q62MGFSNxH5nx8lYHcpdVPTufkKWOJsmA7GIEgImTfYhd");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("KJTMP83JwBQ3XaowFGrJUeapwNZtUCPT7ckExrRpHJN81OzuoP");
            corecontacts.setNativeMiddleName("gUceqdTpRp1TvRD9qBZMQYGqwT4JanrecqgTVClrqRfxCjtTLO");
            corecontacts.setNativeTitle("0rmInf7t95976136SpLNjKHUNSVyl9roRpLmugBLhd1FOFstt4");
            corecontacts.setPhoneNumber("hCK1URAIs6U24nqcM1Vp");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("7z0boWPKcKU9JWLwzTJxp3NsS86AyDNi3GATRpc4idGJsO95lX");
            address.setAddress2("eUJiaaA9UwO6kyVKsFdiscjICadgBtzCZcVaQ7rHPquhpyYB0m");
            address.setAddress3("wwZkqZoe4bfwRuBELpqKan5gOa2uflYvke2dB7xi86MwMvXwtm");
            address.setAddressLabel("OrBS5HLQfL9");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("MUYaF0B6HZRY0ShTE4WTyOOffpPBcSFtqzu0oxDGruWbsO0QeN");
            addresstype.setAddressTypeDesc("iraqBMZpdkESI031hIL36itX8w1KCG7Lk5XKl83xuPd9Ro1Mp9");
            addresstype.setAddressTypeIcon("SC4yUHxZaMx1hqPRpn0LRp8XnCVR18rorF62q8PUkLljvapGHr");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("kkvPtZ3hdfxhVMA9F19qOhKwxML5kImj");
            city.setCityDescription("89hTLh9UCWRnX4cw2fOiQhm9lP1A8WiUWG6os2oxrKUhdt5vAk");
            city.setCityFlag("tazEGlMErpO7082bzOKNzBnoucn5OcgcNSZTE0ahhY9KAMbwav");
            city.setCityLatitude(1);
            city.setCityLongitude(10);
            city.setCityName("jOOD964IjNUcLrAohGBzCoGqMMNETrhuvcwwqUKTneveGQOifv");
            Country country = new Country();
            country.setCapital("cUBtrYWy8w36ZMgIylzUpAOa1p6gKYF0");
            country.setCapitalLatitude(0);
            country.setCapitalLongitude(1);
            country.setCountryCode1("o7J");
            country.setCountryCode2("PPG");
            country.setCountryFlag("xWRm40cEPXJCpnzqn0mGGQ04khfEby4PBm1DSM42Iuqil2nIyN");
            country.setCountryName("9CKHzqsI5aTlEd94HedtPEdzdspMIAlFygiVmQURFZrpNCt8FM");
            country.setCurrencyCode("JIO");
            country.setCurrencyName("SMSpicH7Tb0XAXJM4Eg8DHPwUJiFGb1SeUgetvhtBhIk1Ue4X8");
            country.setCurrencySymbol("lOJNPGCSyBRcla8sFL9iOGnRfXYjBvew");
            country.setIsoNumeric(4);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("BLhXk4kZZza1daxJTIWkhTCJ8QOuqkNsvPwSdtWnfWzCSpF6c1");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(1);
            state.setStateCode(2);
            state.setStateCodeChar2("XNNQnQmDoANmZ7FauDuEGdYrddWNgc3A");
            state.setStateCodeChar3("EoZKvNNaE4WWdtaKeGAgBI74lRgqCgWX");
            state.setStateDescription("IpD5Kc7MZkQLvzthXdycZW86dFP7Yzz7rwKw7JC9m5Hs67XdLJ");
            state.setStateFlag("45dF7FkPH4Oud4crt0okauQgN8Oh2WplL54vH0wVjZziWzGPY4");
            state.setStateName("ZskvK5f4aCOB2g6vDiqJN42dQBSaZtsJq0CT48EA7OvlRohJFK");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("clEb7J6lE9ZQo7amCCD9IplZlJ6UmtO8");
            city.setCityDescription("Yf7tJ8jacs2M4wzd02BeLwNZ70HXPCwKpjAVnrfMY8n7InGk2X");
            city.setCityFlag("PBuFjqCdf8rF89TEKD3eW5S0HZ0RcCN3pBROArXUb0OWkSQ3ZC");
            city.setCityLatitude(9);
            city.setCityLongitude(3);
            city.setCityName("1nzI2qtYMQjS7Hy8kd6NAcBvRPtMIYjFUwpbU1227c8KFMChC9");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("gIsqukIouvSEoFoDIzYX0K9XwfiXooLJxYzzIL70diyYgcgHFz");
            address.setAddress2("1dowXCAPDTHUsWeLV7fULkXRLheW8ABytbFFLx2QS1ISlhJHME");
            address.setAddress3("5tbptCDll9MUZ4GfHMUNHxPI9XRgEmPI1Y3vgogmU1c62Zh2l8");
            address.setAddressLabel("5hlamcHXj6f");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("YtVZETkOM5suW444ZCz0ZRii0QRxxOONcOAo8iIzsygNnwlEz2");
            address.setLongitude("YcrH5j2ZnCjMBuecPaPx0ogM4GNQmLGhase0Vjc0hCz0c76FIK");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("rD5ond");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("N");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("GJmDQ5o42tAKutQfWIRKzt2efDVDd0CrmWy8hozDuGUOlDj4tG");
            communicationgroup.setCommGroupName("46ZagVihmOAA08AK96AwcYlt7icOrVzH4niaj56guckZ7oihnP");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("0vJuiJ17tBLYwj33JbKmaUGW8T2V2OdXrJVBsrDNAgNTbivauN");
            communicationtype.setCommTypeName("fcJ6ibxwEuRVLsFCrx38dclxwULV2chgffKynUY0P1gpLU82B0");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("M");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("o5W70IKcOmxhYsLTwSRuctybLvLR7T05SUBrc2BmqsdxyHGkZr");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(681);
            user.setUserAccessCode(1);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("boGXoR9LX0KFay31keyMZDZqyb4LwQtIImbtYtNY8ubbFvEpCO");
            useraccessdomain.setDomainHelp("6lI1kigTv0yw136lXJJwaCMWgQMr9907IGnJX6E0yXkrUHjVVN");
            useraccessdomain.setDomainIcon("lC3uSUgzEroigoNlU94sZXixeeBa8ZHtSvCu8HluWBlOllh1hT");
            useraccessdomain.setDomainName("eTAsrNkWy3oWEw121mfsiPpLQCu5tjGydgjeEWcntdUQOy5iO2");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("eFkdOnTWtLq0g3zOz2I78VtOnIIp2xxkvzRwllvGhlSYLYDij0");
            useraccesslevel.setLevelHelp("ZtFr8STvFKJjzrb6RyjR0u3s9E4hdIWI0LTAChFRvi0hqStDfs");
            useraccesslevel.setLevelIcon("UgVghWNOkvfErf022SmDQkYC59W9ezLIYi8qbC4dUV5s6oMlYd");
            useraccesslevel.setLevelName("oS3Lg1xxKkdv5NBhbYyugJcVK5ap7HfBkQvxnJmu6XtMDkX72K");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("5cokbHRyvq8pbq9Bqs4tT8QFzYdu8xzGotwJMnMbkOpzIgp9iF");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1323);
            user.setUserAccessCode(6);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("kWPDQPf4qF1pRZ34GmNz2JgpRk6IJthwxA9MYhc7ZPALpCL1jJ");
            Question question = new Question();
            question.setLevelid(2);
            question.setQuestion("4dokRzZQ5baDdll3QQ26BbUQ72XbbIVVywTOxmZ4sqwMU8qZgi");
            question.setQuestionDetails("z");
            question.setQuestionIcon("AljdMXM5RkWrQHJKhQrsqxZCufZzUoqcbJq3y4cXpx4075RcxY");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("QRZgFkNHXAHY7rNVMpCqJZ4jx3h2efi4AkLhbkAhFJrAf5b4cZ");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("WCNO6EojIUbsUtNxblJSx7SnxNX2s23dGfTQ8POcFOrSVpsE0V");
            userdata.setOneTimePassword("U7NeYThD3sKMBv6q5RgNopaKZ7hyWNnV");
            userdata.setOneTimePasswordExpiry(0);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("gvZM9h9aczImeBC0zXyQxpveqToChUfpwS4MJUiTIITYxVQy4J");
            userdata.setLast5Passwords("YnHiFt3jns5evH0cY6F1KGUD7Pcu1xjBTyDzAs6YO6QXTotMls");
            userdata.setOneTimePassword("aFSAeAazi1CzBueXXWVCfubIc48jtgdp");
            userdata.setOneTimePasswordExpiry(2);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("QTYAftXizwnRPTBpHZhJmbr84pr8tEdHrvRvVWRzVC4MuTmohL");
            userdata.setUser(user);
            user.setUserData(userdata);
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(8);
            login.setIsAuthenticated(true);
            login.setLoginId("oXVEMSRLQnEdqazDZD25TlEHoK8p8Russ7zWm5NknmwO1NQdTL");
            login.setServerAuthImage("OSmNFVBhcbED5bnVF1nA7HF6MLzNH0DN");
            login.setServerAuthText("qfPAWus5k0yKxAw1");
            user.setUserId(null);
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

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
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(4);
            login.setLoginId("acpAvkkDyO7dxmpK84tJk24JQKltO8S9RkvTZxDLljOYHsa3CN");
            login.setServerAuthImage("FBKR65AY4nxSMLsVRWl8PzLizxb9nfWk");
            login.setServerAuthText("B4YiWQObK6zYy69u");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
