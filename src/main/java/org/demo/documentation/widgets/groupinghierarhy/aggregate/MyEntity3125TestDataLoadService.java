package org.demo.documentation.widgets.groupinghierarhy.aggregate;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.aggfields.MyEntity3124;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.aggfields.MyEntity3124Repository;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.aggfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.agglevels.MyEntity3125;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.agglevels.MyEntity3125Repository;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.customfunction.MyEntity3126;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.customfunction.MyEntity3126Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3125TestDataLoadService {

    @Autowired
    MyEntity3125Repository repository;

    @Autowired
    MyEntity3124Repository repository3124;

    @Autowired
    MyEntity3126Repository repository3126;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository3124.deleteAll();
        repository3126.deleteAll();

        repository3126.save(new MyEntity3126().setCustomField("test data"));

        repository3124.save(new MyEntity3124().setCustomField("Description 4").setCustomFieldNumber(75000L).setCustomFieldDictionary(CustomFieldDictionaryEnum.LAND).setCustomFieldNumberOther(500L));
        repository3124.save(new MyEntity3124().setCustomField("Description 1").setCustomFieldNumber(65000L).setCustomFieldDictionary(CustomFieldDictionaryEnum.MOVABLE).setCustomFieldNumberOther(700L));
        repository3124.save(new MyEntity3124().setCustomField("Description 2").setCustomFieldNumber(45000L).setCustomFieldDictionary(CustomFieldDictionaryEnum.MOVABLE).setCustomFieldNumberOther(600L));
        repository3124.save(new MyEntity3124().setCustomField("Description 3").setCustomFieldNumber(55000L).setCustomFieldDictionary(CustomFieldDictionaryEnum.IMMOVABLE));

        repository.save(new MyEntity3125()
                .setLocation("Saint Petersburg, Obvodny Canal Embankment")
                .setObject("St. Petersburg, Obvodny Canal Embankment, 16-18, lit. A")
                .setInsuranceAmount(23000.66)
                .setInsuranceValue(1200L)
                .setNetAnnualRate(0.13)
                .setAcquisition(35.02)
                .setGrossAnnualRate(2L)
                .setAnnualPremium(53000L)
                .setUnderinsurancePercentage(5L)
        );
        repository.save(new MyEntity3125()
                .setLocation("Saint Petersburg, Obvodny Canal Embankment")
                .setObject("St. Petersburg, Obvodny Canal Embankment, 16-18, lit. A")
                .setInsuranceAmount(80000.00)
                .setInsuranceValue(1200L)
                .setNetAnnualRate(0.16)
                .setAcquisition(45.02)
                .setGrossAnnualRate(5L)
                .setAnnualPremium(3000L)
                .setUnderinsurancePercentage(7L)
        );
        repository.save(new MyEntity3125()
                .setLocation("Saint Petersburg, Obvodny Canal Embankment")
                .setObject("St. Petersburg, Obvodny Canal Embankment, 16-18, lit. B")
                .setInsuranceAmount(90000.00)
                .setInsuranceValue(1200L)
                .setNetAnnualRate(0.13)
                .setAcquisition(35.08)
                .setGrossAnnualRate(2L)
                .setAnnualPremium(53000L)
                .setUnderinsurancePercentage(5L)
        );
        repository.save(new MyEntity3125()
                .setLocation("Saint Petersburg, Obvodny Canal Embankment")
                .setObject("St. Petersburg, Obvodny Canal Embankment, 16-18, lit. B")
                .setInsuranceAmount(60000.00)
                .setInsuranceValue(1200L)
                .setNetAnnualRate(0.13)
                .setAcquisition(55.00)
                .setGrossAnnualRate(7L)
                .setAnnualPremium(83000L)
                .setUnderinsurancePercentage(8L)
        );
        repository.save(new MyEntity3125()
                .setLocation("Saint Petersburg, Obvodny Canal Embankment")
                .setObject("St. Petersburg, Obvodny Canal Embankment, 16-18, lit. A")
                .setInsuranceAmount(60000.00)
                .setInsuranceValue(1200L)
                .setNetAnnualRate(0.13)
                .setAcquisition(75.00)
                .setGrossAnnualRate(8L)
                .setAnnualPremium(80000L)
                .setUnderinsurancePercentage(8L)
        );
        repository.save(new MyEntity3125()
                .setLocation("Moscow, Vernadsky Avenue")
                .setObject("SMoscow, Vernadsky Avenue, 19")
                .setInsuranceAmount(23000.66)
                .setInsuranceValue(1200L)
                .setNetAnnualRate(0.13)
                .setAcquisition(60.00)
                .setGrossAnnualRate(8L)
                .setAnnualPremium(5800L)
                .setUnderinsurancePercentage(5L)
        );
        repository3126.save(new MyEntity3126()
                .setLocation("Saint Petersburg, Obvodny Canal Embankment")
                .setObject("St. Petersburg, Obvodny Canal Embankment, 16-18, lit. A")
                .setInsuranceAmount(1200L)
                .setInsuranceValue(1200L)
                .setNetAnnualRate(3L)
        );
        repository3126.save(new MyEntity3126()
                .setLocation("Saint Petersburg, Obvodny Canal Embankment")
                .setObject("St. Petersburg, Obvodny Canal Embankment, 16-18, lit. A")
                .setInsuranceAmount(1400L)
                .setInsuranceValue(3200L)
                .setNetAnnualRate(3L)
        );
        repository3126.save(new MyEntity3126()
                .setLocation("Saint Petersburg, Obvodny Canal Embankment")
                .setObject("St. Petersburg, Obvodny Canal Embankment, 16-18, lit. B")
                .setInsuranceAmount(3200L)
                .setInsuranceValue(2200L)
                .setNetAnnualRate(6L)
        );
        repository3126.save(new MyEntity3126()
                .setLocation("Saint Petersburg, Obvodny Canal Embankment")
                .setObject("St. Petersburg, Obvodny Canal Embankment, 16-18, lit. B")
                .setInsuranceAmount(1700L)
                .setInsuranceValue(1600L)
                .setNetAnnualRate(6L)
        );
        repository3126.save(new MyEntity3126()
                .setLocation("Saint Petersburg, Obvodny Canal Embankment")
                .setObject("St. Petersburg, Obvodny Canal Embankment, 16-18, lit. A")
                .setInsuranceAmount(3200L)
                .setInsuranceValue(2200L)
                .setNetAnnualRate(1L)
        );
        repository3126.save(new MyEntity3126()
                .setLocation("Moscow, Vernadsky Avenue")
                .setObject("SMoscow, Vernadsky Avenue, 19")
                .setInsuranceAmount(1400L)
                .setInsuranceValue(1230L)
                .setNetAnnualRate(2L)
        );

    }

}