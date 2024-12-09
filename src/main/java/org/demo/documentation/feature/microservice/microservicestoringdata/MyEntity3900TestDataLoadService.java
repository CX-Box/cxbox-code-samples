package org.demo.documentation.feature.microservice.microservicestoringdata;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.*;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

@Service
public class MyEntity3900TestDataLoadService {

    @Autowired
    MyEntity3900Repository repository;

    @Autowired
    MyEntity3910Repository repository3910;

    @Autowired
    MyEntity4001Repository repository4001;

    @Autowired
    MyEntity4002ExternalRepository repository4002;

    @Autowired
    MyEntity3081Repository repository3081;

    @Autowired
    MyEntity3137Repository repository3137;

    @Autowired
    MyEntity380Repository repository380;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3900().setCustomField("Test data").setCustomFieldNew("Test data"));
        repository.save(new MyEntity3900().setCustomField("Test data2").setCustomFieldNew("Test data2"));
        repository.save(new MyEntity3900().setCustomField("Test data3").setCustomFieldNew("Test data3"));
        repository.save(new MyEntity3900().setCustomField("Test data4").setCustomFieldNew("Test data4"));
        repository.save(new MyEntity3900().setCustomField("Test data5").setCustomFieldNew("Test data5"));
        repository.save(new MyEntity3900().setCustomField("Test data6").setCustomFieldNew("Test data6"));
        repository.save(new MyEntity3900().setCustomField("Test data7").setCustomFieldNew("Test data7"));
        repository.save(new MyEntity3900().setCustomField("Test data8").setCustomFieldNew("Test data8"));
        repository.save(new MyEntity3900().setCustomField("Test data9").setCustomFieldNew("Test data9"));
        repository.save(new MyEntity3900().setCustomField("Test data10").setCustomFieldNew("Test data10"));
        repository3910.deleteAll();
        repository3910.save(new MyEntity3910().setCustomField("Test data").setCustomFieldNew("Test data").setCustomFieldDateTime(LocalDateTime.now().minusMinutes(3)));
        repository3910.save(new MyEntity3910().setCustomField("Test data2").setCustomFieldNew("Test data2").setCustomFieldDateTime(LocalDateTime.now().minusDays(3)));
        repository3910.save(new MyEntity3910().setCustomField("Test data3").setCustomFieldNew("Test data3").setCustomFieldDateTime(LocalDateTime.now().minusDays(45)));
        repository3910.save(new MyEntity3910().setCustomField("Test data4").setCustomFieldNew("Test data4").setCustomFieldDateTime(LocalDateTime.now().minusYears(1)));
        repository3910.save(new MyEntity3910().setCustomField("Test data5").setCustomFieldNew("Test data5").setCustomFieldDateTime(LocalDateTime.now().minusYears(3)));
        repository3910.save(new MyEntity3910().setCustomField("Test data6").setCustomFieldNew("Test data6").setCustomFieldDateTime(LocalDateTime.now().minusMinutes(35)));
        repository3910.save(new MyEntity3910().setCustomField("Test data7").setCustomFieldNew("Test data7").setCustomFieldDateTime(LocalDateTime.now().minusMonths(6)));
        repository3910.save(new MyEntity3910().setCustomField("Test data8").setCustomFieldNew("Test data8").setCustomFieldDateTime(LocalDateTime.now().minusWeeks(2)));
        repository3910.save(new MyEntity3910().setCustomField("Test data9").setCustomFieldNew("Test data9").setCustomFieldDateTime(LocalDateTime.now().minusMonths(3)));
        repository3910.save(new MyEntity3910().setCustomField("Test data10").setCustomFieldNew("Test data10").setCustomFieldDateTime(LocalDateTime.now().minusWeeks(7)));
        repository4001.deleteAll();
        repository4001.save(new MyEntity4001().setCustomField("Test data").setCustomFieldNew("Test data").setCustomFieldDateTime(LocalDateTime.now().minusMinutes(3)));
        repository4002.deleteAll();
        repository4002.save(new MyEntity4002External().setCustomField("Test data").setCustomFieldNew("Test data"));
        repository4002.save(new MyEntity4002External().setCustomField("Test data2").setCustomFieldNew("Test data2"));
        repository4002.save(new MyEntity4002External().setCustomField("Test data3").setCustomFieldNew("Test data3"));
        repository4002.save(new MyEntity4002External().setCustomField("Test data4").setCustomFieldNew("Test data4"));
        repository4002.save(new MyEntity4002External().setCustomField("Test data5").setCustomFieldNew("Test data5"));
        repository4002.save(new MyEntity4002External().setCustomField("Test data6").setCustomFieldNew("Test data6"));
        repository4002.save(new MyEntity4002External().setCustomField("Test data7").setCustomFieldNew("Test data7"));
        repository4002.save(new MyEntity4002External().setCustomField("Test data8").setCustomFieldNew("Test data8"));
        repository4002.save(new MyEntity4002External().setCustomField("Test data9").setCustomFieldNew("Test data9"));
        repository4002.save(new MyEntity4002External().setCustomField("Test data10").setCustomFieldNew("Test data10"));
        repository3081.deleteAll();
        repository3081.save(new MyEntity3081().setCustomFieldSuggestion("Test data").setCustomFieldNew("Test data").setCustomFieldSuggestionDate(LocalDateTime.now().minusDays(1)));
        repository3081.save(new MyEntity3081().setCustomFieldSuggestion("Test data2").setCustomFieldNew("Test data2").setCustomFieldSuggestionDate(LocalDateTime.now()));
        repository3081.save(new MyEntity3081().setCustomFieldSuggestion("Test data3").setCustomFieldNew("Test data3").setCustomFieldSuggestionDate(LocalDateTime.now().minusMonths(1)));
        repository3081.save(new MyEntity3081().setCustomFieldSuggestion("Test data4").setCustomFieldNew("Test data4").setCustomFieldSuggestionDate(LocalDateTime.now().plusDays(3)));
        repository3081.save(new MyEntity3081().setCustomFieldSuggestion("Test data5").setCustomFieldNew("Test data5").setCustomFieldSuggestionDate(LocalDateTime.now().plusHours(5)));
        repository3081.save(new MyEntity3081().setCustomFieldSuggestion("Test data6").setCustomFieldNew("Test data6").setCustomFieldSuggestionDate(LocalDateTime.now().plusWeeks(4)));
        repository3081.save(new MyEntity3081().setCustomFieldSuggestion("Test data7").setCustomFieldNew("Test data7").setCustomFieldSuggestionDate(LocalDateTime.now().minusYears(4)));
        repository3081.save(new MyEntity3081().setCustomFieldSuggestion("Test data8").setCustomFieldNew("Test data8").setCustomFieldSuggestionDate(LocalDateTime.now().plusYears(6)));
        repository3081.save(new MyEntity3081().setCustomFieldSuggestion("Test data9").setCustomFieldNew("Test data9").setCustomFieldSuggestionDate(LocalDateTime.now().minusDays(9)));
        repository3081.save(new MyEntity3081().setCustomFieldSuggestion("Test data10").setCustomFieldNew("Test data10").setCustomFieldSuggestionDate(LocalDateTime.now()));repository3137.deleteAll();
        repository3137.save(new MyEntity3137().setCustomField("Test data").setCustomFieldNew("Test data").setCustomFieldDateTime(LocalDateTime.now().minusMinutes(3)));
        repository3137.save(new MyEntity3137().setCustomField("Test data2").setCustomFieldNew("Test data2").setCustomFieldDateTime(LocalDateTime.now().minusDays(3)));
        repository3137.save(new MyEntity3137().setCustomField("Test data3").setCustomFieldNew("Test data3").setCustomFieldDateTime(LocalDateTime.now().minusDays(45)).setCustomFieldDouble(Double.valueOf(100200)));
        repository3137.save(new MyEntity3137().setCustomField("Test data4").setCustomFieldNew("Test data4").setCustomFieldDateTime(LocalDateTime.now().minusYears(1)));
        repository3137.save(new MyEntity3137().setCustomField("Test data5").setCustomFieldNew("Test data5").setCustomFieldDateTime(LocalDateTime.now().minusYears(3)));
        repository3137.save(new MyEntity3137().setCustomField("Test data6").setCustomFieldNew("Test data6").setCustomFieldDateTime(LocalDateTime.now().minusMinutes(35)));
        repository3137.save(new MyEntity3137().setCustomField("Test data7").setCustomFieldNew("Test data7").setCustomFieldDateTime(LocalDateTime.now().minusMonths(6)));
        repository3137.save(new MyEntity3137().setCustomField("Test data8").setCustomFieldNew("Test data8").setCustomFieldDateTime(LocalDateTime.now().minusWeeks(2)));
        repository3137.save(new MyEntity3137().setCustomField("Test data9").setCustomFieldNew("Test data9").setCustomFieldDateTime(LocalDateTime.now().minusMonths(3)).setCustomFieldDouble(Double.valueOf(201200)));
        repository3137.save(new MyEntity3137().setCustomField("Test data10").setCustomFieldNew("Test data10").setCustomFieldDateTime(LocalDateTime.now().minusWeeks(7)).setCustomFieldDouble(Double.valueOf(300200)));
        repository3137.save(new MyEntity3137().setCustomField("Test data11").setCustomFieldDateTime(LocalDateTime.now().minusDays(3)));
        repository3137.save(new MyEntity3137().setCustomField("Test data2"));

        repository380.save(new MyEntity380().setType("DICTIONARY_TYPE").setKey("HIGH").setValue("High").setDisplayOrder(1));
        repository380.save(new MyEntity380().setType("DICTIONARY_TYPE").setKey("MIDDLE").setValue("Middle").setDisplayOrder(2));
        repository380.save(new MyEntity380().setType("DICTIONARY_TYPE").setKey("LOW").setValue("Low").setDisplayOrder(3));

    }

}