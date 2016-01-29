package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AppCustomerRepository;
import com.app.shared.customers.AppCustomer;
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
import com.app.shared.customers.AppCustomerCategory;
import com.app.server.repository.AppCustomerCategoryRepository;
import com.app.shared.customers.AppCustomerType;
import com.app.server.repository.AppCustomerTypeRepository;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppCustomerTestCase {

    @Autowired
    private AppCustomerRepository<AppCustomer> appcustomerRepository;

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
            AppCustomerCategory appcustomercategory = new AppCustomerCategory();
            appcustomercategory.setCustomerCategory("28CBgWmquo2KeZvSr7jC60yhbGvujmBOmZfJrlvhDQ6XmJIIbi");
            AppCustomerCategory AppCustomerCategoryTest = appcustomercategoryRepository.save(appcustomercategory);
            map.put("AppCustomerCategoryPrimaryKey", appcustomercategory._getPrimarykey());
            AppCustomerType appcustomertype = new AppCustomerType();
            appcustomertype.setCustomerType("1JxUfN1JZnLmb5anBGFhcyJmqlg1sLOO0m2eEqDtk3QBGlsfsH");
            appcustomertype.setDefaults(1);
            appcustomertype.setSequenceId(2147483647);
            AppCustomerType AppCustomerTypeTest = appcustomertypeRepository.save(appcustomertype);
            map.put("AppCustomerTypePrimaryKey", appcustomertype._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(28);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("Af491ccYMP1DLafjVYjIhqoK8QWfJPNe6X9o5eGg76Br29NdUE");
            corecontacts.setFirstName("cKTklbFYeC2T9WCMruAUlCJCEvpCXYH0B1QeQDfDlJ8cuuzIsu");
            Gender gender = new Gender();
            gender.setGender("g1wj6un50u0dTWv7yBjoY8MkQp22k9uHI8QzoTAAzrQQiDxv48");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("MP");
            language.setAlpha3("oHA");
            language.setAlpha4("4FWw");
            language.setAlpha4parentid(3);
            language.setLanguage("cWRhihqvTBNhaax3FBUvpospiaOyZ5LkJ8yKIcwVwv1PVHfWLT");
            language.setLanguageDescription("xVKv7xe1MYMoAGbblRCZzHue1TvbhlcPepSg14UdG97oWKkipj");
            language.setLanguageIcon("FuRLwOMtOCr4nOsoxoXiRauS4Ag7aQSyxkbreAJhWut2i9THVB");
            language.setLanguageType("7zUDHx9B6YZ5zRKh8d3Csak64b4gONuM");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("fQDwQjeuJAhZNPSSES5grYdDW6zNr6ipZjxCtJO8ICvcrmyC0n");
            timezone.setCountry("bVSzPVsYtCnoFZpGCHdoIHAx3mmgsBptFt4JQo35sefcCco3lA");
            timezone.setGmtLabel("wQv3eYsqV8Idh1A6TUS8sGm29nGmzcdBInZX93ENXYgcvd8fFh");
            timezone.setTimeZoneLabel("ViW1llZlQjrKck9OFwzWRfq26cJ7Y30pYyc9yU6a5xB2pIImlA");
            timezone.setUtcdifference(0);
            Title title = new Title();
            title.setTitles("n4VZLx0vOAGHOGX2hEPoCIXyb8XvldTjemrXs8PVblzGmiYoRN");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(1);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("wlxIc7PDjZuta36vPY6bXDrCx2g8nznNIT6X7UebybZsZ9snV6");
            corecontacts.setFirstName("vzN4igLfuiWfKajgbTiAq7IMJfDVbiey9f8FT4hVGa8BZZMGRK");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("zL3QBLIVWsyYsKSicDbKUsi13LYPnUK0NCZ1mqnE7TNdcfpQ1J");
            corecontacts.setMiddleName("7nQByuN1hSyBgSPj7O9JP90l6C4USLiBZjz43XnmQcdxgeWPqh");
            corecontacts.setNativeFirstName("e9t0xoirFVNKpPlDGhCJ8a778yerJvIsg5jrLF0DtjSD5Qg0Q0");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("HRg32eg301J5XUfqvnJuCaEw9GsoaVvFauIYT4W8EPxVggiWON");
            corecontacts.setNativeMiddleName("7eiz8RzFB08vMgUoYdxgdxNOnIdSNp8DKdkq0pe7wApCTMrcJc");
            corecontacts.setNativeTitle("zVHwFPsgv3O3sHud3GQU2AWYrEmgrTm1RBXkSkJkqy7w4eka4u");
            corecontacts.setPhoneNumber("yHpFtVEuFmtNgwYBXcTC");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("gwXh8sKhx3SU698RzkDXspcWql2p6ATNevd5kLN0BGLnO4QLZ0");
            address.setAddress2("ECdlihfv6WJe02A6kiO01H0RA8XSCuWAczak7hokPqp44RZuHl");
            address.setAddress3("51JwFk0ynvYFfJZVV2R9Z26BCeQaUswN6XRoch8letvWtujhA3");
            address.setAddressLabel("FLEIFWpJ495");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("gxMWeCfJLUpGD3xaIdVrcTUgqT2GtujeJNfQG6JaZU5hhcN9cJ");
            addresstype.setAddressTypeDesc("gFWm1yW2JshMRLXp3EpIFpXNDMCSXquynLOYwS8yTV7upux1SO");
            addresstype.setAddressTypeIcon("HaOQffpPPZiII4TZnH1SzGAlpo3ijgiCUacMVLEIOstTXigDkC");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("WFAWOkjCwCnJaoPFrFiVisFI4olv9HC6");
            city.setCityDescription("ICHUf4BD5tveRAwg8qUpetUVsDEDWFkzJwvJlJUwkUlzemcGnx");
            city.setCityFlag("LuC3Z4QPjw4G63X63FHVVzsWl2jR8rsnzDYMkXM4SZnF5GraFA");
            city.setCityLatitude(0);
            city.setCityLongitude(10);
            city.setCityName("f2Se26QkScfjRpNWNRknt56K5C2MqkoP9dprOB6YX5lBt6Z9Ym");
            Country country = new Country();
            country.setCapital("6TgqqJY1MNqyD4RJLgSy0QCGVCUAYIKo");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(7);
            country.setCountryCode1("c7r");
            country.setCountryCode2("19F");
            country.setCountryFlag("Q4ADUED9lmI1vNEVcAoDJnnHPg7Eyfge1JQ6q4xvXbp7sCvvjD");
            country.setCountryName("wTWKJVIEIYwmFRh4MlgWTGRyfKX9H29o34x4iFyKQVDL4kzd91");
            country.setCurrencyCode("87d");
            country.setCurrencyName("1PcisfJBH5EqDJA0AxgtTjkEGVXEkRuiQH4rdXRdb3ayWqN5Lr");
            country.setCurrencySymbol("arXQuEbgJicgIX4PUTErRfhxwFNvSwXO");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("vGd32MQvffzJ5LHdaDtkQJaXGNUBTzkCa32FQLpvtHh15QKFgj");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(9);
            state.setStateCode(1);
            state.setStateCodeChar2("xkIEC9fUzRIO8ilp2iq9BlmwzvrFuibL");
            state.setStateCodeChar3("8nBJVul8RCN8MuwdV8tVWRcBEGFdS0Ys");
            state.setStateDescription("qWhzMG0s8kZCsGOp8so4IGqQ0ZyQofxO8KcW2pDw9M0p4KunlU");
            state.setStateFlag("Z1UcszY9rfgoG12ZKrab9umRXM9qdDT4HNNZAP56K5JYqkrsMp");
            state.setStateName("WgCd99lXt70DbIcsSuzCNbWbCVg9sWzSdEAHL3m7JHYIbJ0ICt");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("SnW5B6tYwfJDgTsrdcHxBW79fyniIHk1");
            city.setCityDescription("QnLlXDZr46cHGABeeLQdtM0eVhCFp0mKOuBYOFtN3408BK89zV");
            city.setCityFlag("HbUkwM9ec4t2xRb2Vxtd1tbPclmE2nhS1uzjCaLvWenkORBVbR");
            city.setCityLatitude(2);
            city.setCityLongitude(0);
            city.setCityName("wbgltbOOTgAqgF7qMuEGyhTgNRvOPaG1EcqoCYhq9Odjfpz8Jr");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("Bv3JoouAlq87iWSdUahSsaaLppxz5aImJ0w4HlERZVtt5NUDqo");
            address.setAddress2("SVlSXeEcst33fa7vz1ib5yIakC8d6cl4a37eebpro1NeoU7FWY");
            address.setAddress3("wbcej7A0kDhYIyhJ9NmCR0tZT1KvKqk8olXOXjgRlCpSsIOfzw");
            address.setAddressLabel("NBQ2onm8Uy8");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("86brN1ugCSbispBcBTAtaFlUlzpddYpXLfRDwBsXuH25l74Och");
            address.setLongitude("5eC3SEUJ7T6Hldc6eyw0II9W344BJEIlZiFbGZXyT2w0XCYmII");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("vw8QjK");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("q");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("mBWIRNALViUGAQ9p4qynFuEytfBRc0hX1r58Htd3pkj99PJMjx");
            communicationgroup.setCommGroupName("98CcM1Bf50VueL0jhn1MVPoH86vor4NICk7kEUiXh2NUXom81L");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("lPc3OriV3eddZMKbQO4moy3KAIshFCmidWIYVWUCbILN1zVBkh");
            communicationtype.setCommTypeName("mJWLwHCw8aoFVyjNDj8ePlIGBVIEMK8AYqsG6fg5ukdcI5rMRB");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("b");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            AppCustomer appcustomer = new AppCustomer();
            appcustomer.setAppCustomerCategory((java.lang.String) AppCustomerCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setAppCustomerType((java.lang.String) AppCustomerTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
            appcustomer.setCustomerName("M9zXEoooRWhME46j9WmBKaYsJqgVH7PiXHk2TKSW0ZBMCpHK40");
            appcustomer.setCustomerStatus(1);
            appcustomer.setDeploymentModel(true);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appcustomer.setEntityValidator(entityValidator);
            appcustomer.isValid();
            appcustomerRepository.save(appcustomer);
            map.put("AppCustomerPrimaryKey", appcustomer._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppCustomerCategoryRepository<AppCustomerCategory> appcustomercategoryRepository;

    @Autowired
    private AppCustomerTypeRepository<AppCustomerType> appcustomertypeRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            AppCustomer appcustomer = appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
            appcustomer.setCustomerName("5XYWV96stvlRYLu4viGRqsce1SbxFzl2kVBH3Eu6IhY46vrYET");
            appcustomer.setCustomerStatus(0);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setVersionId(1);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appcustomerRepository.update(appcustomer);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerCategory() {
        try {
            java.util.List<AppCustomer> listofappCustomerCategory = appcustomerRepository.findByAppCustomerCategory((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
            if (listofappCustomerCategory.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerType() {
        try {
            java.util.List<AppCustomer> listofappCustomerType = appcustomerRepository.findByAppCustomerType((java.lang.String) map.get("AppCustomerTypePrimaryKey"));
            if (listofappCustomerType.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<AppCustomer> listofcontactId = appcustomerRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.delete((java.lang.String) map.get("AppCustomerPrimaryKey")); /* Deleting refrenced data */
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            appcustomertypeRepository.delete((java.lang.String) map.get("AppCustomerTypePrimaryKey")); /* Deleting refrenced data */
            appcustomercategoryRepository.delete((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
