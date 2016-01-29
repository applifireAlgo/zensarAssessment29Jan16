package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.Address;
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
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("Ckk20BoNNN7JRIY35m3qjyqcrVznXY5hXSPvdr8SxcvRkjKC8w");
            addresstype.setAddressTypeDesc("KsrBCKqeeNiEv0AfNYKjmxCkuGTZVWv5lovQKScbF3inoeKQta");
            addresstype.setAddressTypeIcon("fARiBmHUWSguDYuTbWnUt4QEcXQnzoHnRgwz2v5Bh7LosbURm3");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("zLmfGhBuNQvSyzysWTXrQ8l8IXs3N1oV");
            city.setCityDescription("G9lgdUm2UvEGl3ShaOV9xbSmoxPhrKNs9EVMesGQlmWBuSM66w");
            city.setCityFlag("2oGaGHgKNm6eeIEecjcmv3Y1fpJ1ayYa9upWqIabWvtQ2dFsSY");
            city.setCityLatitude(0);
            city.setCityLongitude(1);
            city.setCityName("NHUHW0ZKp5uROoiimWf4kmi8sxGUHA14C8Rds2sQRydcMiXWtp");
            Country country = new Country();
            country.setCapital("2GhfvJyP4TTbwhS1DQtPhPAYZHWOP3B4");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(9);
            country.setCountryCode1("oRT");
            country.setCountryCode2("fXN");
            country.setCountryFlag("xoTpWVWRgYGMCKQbgk0CU3SusiCBlrwOQrI5ahaWEDAXfWmQ4k");
            country.setCountryName("wMZc8VXy5sO3co6vWC0gQY6YKqL0Y0qzV87Vq2aeArS2V9Bu4Y");
            country.setCurrencyCode("yYB");
            country.setCurrencyName("JJIV6zEfiNWmzniqzxmlJWJ6J0ViyjR42WpJZQ4gG7jdyHBtNY");
            country.setCurrencySymbol("JIwCGU3aB1VbaxhRVuCQMoy1KjvRA3Il");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("RHRVRZabdX8nuq4Uq8Ot47Zj17zKK8E8Jnz2LFKWIxpyfBLlMh");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(6);
            state.setStateCode(1);
            state.setStateCodeChar2("Nq3CJNF9nDVXc9TdMkprvI8dztEZjQG9");
            state.setStateCodeChar3("zJZGYVlo3t3fC4pkrCBg5dQIHTnbkc4N");
            state.setStateDescription("H3AIgnHS2mGWi3AVL1YM4XzfDzz7KOv9ZiKmUJp5xHIK3H4GnU");
            state.setStateFlag("dploGSqwaIWaWMDBluixCmYDqsDBWZw8kjNGqU7r7UANH1baFe");
            state.setStateName("YlGkyDgCW34wS4UZno0nidVdNpv8Kg2gfbEis9onNKY4NoFYnt");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("wDinZWcaw1n6nptzvF2wy3hfSpEzo2y9");
            city.setCityDescription("ydLIkiVJR4dhUEO8CwwxCSx7Peuxjo2raHI6BHcJWNThyDrArG");
            city.setCityFlag("iJqFoYC8lgOw0QF3Fd9iot2gYV3dyOEunypVTLYirH1XHO7bor");
            city.setCityLatitude(1);
            city.setCityLongitude(4);
            city.setCityName("QRLtTQ8FJsrTpNeQvjF9poKYH7ZcdHE5rVckNxcZ76NYlsnXVE");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("lI3ncH6pws7ke3WP6pRIuqAytDoDUcHUWtYRppXtZmB1VrkIJi");
            address.setAddress2("JZWOePYgkTcho9GM1IHm5gwpoM1Xoyo5OhLf7G5UhuXy1CDD2S");
            address.setAddress3("CPXB2lQyEuvKOsJpDPGxJfy5wII8JRpDuC7vRaS2cFbgRm68h7");
            address.setAddressLabel("7vCouaV2NZr");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("WL6CqkPR66HizTVCpiexMHgUIgmlmcVJdFMFebuJUNrXKZQoNK");
            address.setLongitude("ruMahmpnyrQfj9AmKiybGUEPSSlPRWpKud0TQCLby7Mj84j5zC");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("ZCLoXi");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("ZQVZGukc1j1mQRVw9lQPZgQImpfwW7jQhOyvv1BmBjLiFFsELA");
            address.setAddress2("REVQCpuQVMfnU9VbboRLLvbloKVazlMJVEoSxaT5ud5gOwrsqu");
            address.setAddress3("KfZp6naW9Gkzd7ugOyKbf0opmaqW9dRw6CopsaBSZJipROccJg");
            address.setAddressLabel("2muSqu2jBBV");
            address.setLatitude("AUIPEAgJfOezvVtDURweZAaxSiVC3LTRYyWWMcCHfpBY4F6IUS");
            address.setLongitude("9ttiFsJvWkYKQyhvYAJDCLY6wqe6h8RzPCTDk7y32kCa2ZHOwg");
            address.setVersionId(1);
            address.setZipcode("pbYLl9");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
