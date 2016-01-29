package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.CoreContacts;
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
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("hxcNYB65f6HwEDV68IIipFFbGny9C2GCux1Vh5Fko8Z6D3kfrx");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Aj");
            language.setAlpha3("Ubi");
            language.setAlpha4("pX0D");
            language.setAlpha4parentid(1);
            language.setLanguage("BzCihGymVvT1KVRzTHVari9ovXcEafyMBQTIoIevhRhbr18dey");
            language.setLanguageDescription("josZ2d4pBwRxrPI24oOKTOIODNwAY66gW75ikui7qKov5Zs1nX");
            language.setLanguageIcon("L8F2LnmQNXBONq990fNdgEwCdPvt1YDoDMPY3yLeZ3eSvLECTU");
            language.setLanguageType("D72tgwPISdhBmpzHje2mcI42rpoEvGTJ");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("KJZY0OtXzyIPfSX216mx5YhFgZqNMHMq6CpV1t41EdPFmZrgbx");
            timezone.setCountry("CusU0V4yeHBJnwp4BGMm35WL6wo9Pl6HYSK5znx15H5JZIwoLN");
            timezone.setGmtLabel("BsPG5hdVmnEuQ3mPLH6zCJYlfSOIilgKL9ZRuv3uCTzJZbAr0O");
            timezone.setTimeZoneLabel("okYPFBh09cb0KGsDUKFQYpmii0Hx65l4DPP0T6FOBFlU1NKkz8");
            timezone.setUtcdifference(4);
            Title title = new Title();
            title.setTitles("6FDJRe8jRSsYdRnKelcbEV69qBoZQQOdFx5xDeUST8WSgnlReQ");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(111);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("HKymWkRqX30JtunFBDyF7vBDxJAv3x2O1UTFRDFd0MhPzyAnEU");
            corecontacts.setFirstName("MuQWV5OonSstjLBwijJy3pbKmGJRZl7KxMBKitqA8bZm7EsWZL");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("MkqLRZBhRPgKn0EdJxhBPotHihc5gE9adHZPCwBcrMOo84vAex");
            corecontacts.setMiddleName("WVZ4Q7YpxAe45bA3ssBxl4FyKk79uNdDsfDPAD96HKK7C7E4ot");
            corecontacts.setNativeFirstName("MEhHRpfD5zBCG2JyKumWMwwtzKAsG9sGFC1249hTQThgoK5uh9");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("rqyGiOGCPuvDUYhEN2jAopWovhwIkAeNtgeiVj123SOEbMJjof");
            corecontacts.setNativeMiddleName("TdlVOFcmgIXwgNUHVD57iaiLvfT6KqumHILaIzxTvHKGEVlrG7");
            corecontacts.setNativeTitle("cInTfceIzWixw5znS26KdJgQLTsK1CI7TrDFTWoEvIXBiBNV9u");
            corecontacts.setPhoneNumber("Lw6O7onSpTawvD2aOnlE");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("qEDpj3xOKjER6IlStdXyXbjjYpoG8HQMDhwZvqo7xOsp7ERAcf");
            address.setAddress2("Rqcrsgnmyakpmfelo0VG7XY65CvN0Kw2Bgli3253INBFQkPeIY");
            address.setAddress3("aC3Q7hXE6iKhWbnkbfIk4TqZ5YI30Uz3V2Jd4qWt8HAsQancPt");
            address.setAddressLabel("cJyKSgnX9X3");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("e0wcd0J9ciy2rpwGzjFZEF4dR3kuFpYDtF2EmJ5ur6WF2Wl0bN");
            addresstype.setAddressTypeDesc("bgdwiwltrpIw1RBCq3jeh5bC5p1QmQuPMG5dH90eJILUHmK9lH");
            addresstype.setAddressTypeIcon("uIlOfaWS8gQiGb0Mmex3kfyHacNXA0MtNq5P6pHeMzgSAquKfk");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("GNqSBLUkFRagyvrfzos8zVul0DSg3C7R");
            city.setCityDescription("SVKZrvsAfoVDhg2yNKl7W7kog1yLWIZ8OhUGZbbRjEf2ot8Uno");
            city.setCityFlag("68dWbnL47bocJGuQIHFzdfDhgJUoPl2CY3QxDSILdBRyuwUo3G");
            city.setCityLatitude(2);
            city.setCityLongitude(0);
            city.setCityName("wixw4iMA847oQSAux55HTgWKgltnoPHJyZsN4KZrzlkh1Xr0pA");
            Country country = new Country();
            country.setCapital("QPHuVvpV6P3PRtHq9V7Zn4KEy5im2vcR");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(0);
            country.setCountryCode1("dAb");
            country.setCountryCode2("5ur");
            country.setCountryFlag("CkxurmoiCHBapucbK1dGv5pwZUmZElrjyEeyJl9zFCphLurrWB");
            country.setCountryName("4MCUbbjOROOFxsNh6WsFpjApMFpYOlW8LdF0Y1yBCgsiUWELUb");
            country.setCurrencyCode("nlQ");
            country.setCurrencyName("Sit2wYKnmzOBkkW2FGU1PPbKDSsauhWM4JaoHHYcNt1nCWNpT9");
            country.setCurrencySymbol("cze5xGcsMtXYPFAx5XupdrVsvqbou3xh");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("tWqPwM0VLxW5L395wzlTCHhxKtsUjbip51l7JgxYxWoBaFVfLV");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(8);
            state.setStateCode(1);
            state.setStateCodeChar2("UZyy1WMwjHHDa3gxuMGIbiUGq8YpETqP");
            state.setStateCodeChar3("pVQYQVbYfZuEDd7HvHoQLBYlUgVvRU7n");
            state.setStateDescription("aWNbNsRw0PLnu4PM2ThsL9zGmofhqKIYKbKxXYFbNietUy3MFv");
            state.setStateFlag("EckZS5vYLnR7FLO1ZDhBV8JJcvfViwUz2nLqBJ4WUoV5CyFEAt");
            state.setStateName("AnkVUMYbfsWRrf4nok7BQABOBhnsdNoj3xYNhYV86hHdLule5u");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("QEfTDceEGKIGq5JH4abrTELx8ISImgkM");
            city.setCityDescription("UhFseBGhqCc2b7WA3SVZ1rvl5obNmoHB6nzvhkb8uMMTwnWWGW");
            city.setCityFlag("xD8OsS5zj0djkdpWaejaLaStF5pIBovjpLojFXEZkpp1qi4K8d");
            city.setCityLatitude(10);
            city.setCityLongitude(3);
            city.setCityName("A5bGPp0r9OqdAcWTHVbeKVwpblYrw0U7G1RBIdcbA4IS1wbAnA");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("extFsmuFGXvIc4iuz8aU4Cw7wtmM4raUfiKqk2Ql7qTWmpvT5I");
            address.setAddress2("YbAVUyY7hen01WH8gpSUbSH5lJm6hgIOshWQRZUGYxxV2A8MRZ");
            address.setAddress3("mDqEZq2qsF1fia2g9DSMLHrqTR8IcKeP9dax3Uau32SnEWeVyT");
            address.setAddressLabel("tngQnBRluX2");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("6218Udle9eA3M9118vgg6AdGvX1Zkbi3tpzELpdBCxBkJR5z6u");
            address.setLongitude("l4U7PWt3axU5GEcwNCraSUdU9Rv2n2n1BB8UGLNkK5yULDS8Ug");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("cEUDW8");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("4");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("ToU2uVLKbTwHqEZtPz9w2IjOFi28gJQptJydRCeNOL6TGxMmKa");
            communicationgroup.setCommGroupName("QfGN0m9qo45UWzl93KAnOdMD7HeEnB8LwfMSl4UmYkQszqSuqz");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("JJ9lWxrzEvXcO5JEcZKNGyj3IKL5kjfam2DpXv6GwRpfduWaq7");
            communicationtype.setCommTypeName("ATiUM77HtGnIn9hiSE8EyWsA3JjdhwId2ajdlun7YpA7n7Ase9");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("z");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(61);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("fgEHYQOYhRSASGXlg1cgGT4PYejshocTD9HJKdE4L5kCJjKRCs");
            corecontacts.setFirstName("0hepDsSb3QsT6QHv9lu4nzE03d4sXSMoZ4D9IeTu3gGufjeCA7");
            corecontacts.setLastName("c5CLMeJ73mQ9r3ol59eRd6Eevy2NuglzqfsEIUu6RETBfbPgkv");
            corecontacts.setMiddleName("TTDFLAEAfwIGm4SLYIzoeBUFHJQTg0EYjUxBCh10VN0yvWGeYf");
            corecontacts.setNativeFirstName("0mfsdOtgdbCaAS9RMgzZ9h8jzmirJ6Uta6F5qNQWMTJUJ2YfTO");
            corecontacts.setNativeLastName("cMKkG88ep6TIOusVpqwjgvi46hNPBYy6SdeNLJyueHddAk9lms");
            corecontacts.setNativeMiddleName("HJrE9H04pPKJMkEm5pZ1cFBiTekqGh9HR4BYEGvCPrrqxS6TiK");
            corecontacts.setNativeTitle("EsUJWySG94weXF0leiHgDdHmQQbc2z3u9T6AD1g2ZSK7rpYlkb");
            corecontacts.setPhoneNumber("T3q58r5MByH8t6VlhsiD");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
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
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
