package org.demo.documentation.other.forceactive2.forproject;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity4903TestDataLoadService {

    @Autowired
    MyEntity4903Repository repository;

    @Autowired
    MyEntity4903FilePickRepository  myEntity4903FilePickRepository ;

    @Autowired
    MyEntity4903PickRepository repositoryPick;

    @Autowired
    MyEntity4903PickInstanceRepository myEntity4903PickInstanceRepository;

    @Autowired
    MyEntity4903PickOCPRepository repositoryOCP;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.deleteAll();
        repositoryOCP.deleteAll();
        repositoryPick.deleteAll();
        myEntity4903FilePickRepository.deleteAll();
        myEntity4903PickInstanceRepository.deleteAll();

        myEntity4903PickInstanceRepository.save(new MyEntity4903Instance().setCustomField("Instance1"));
        myEntity4903PickInstanceRepository.save(new MyEntity4903Instance().setCustomField("Instance2"));
        myEntity4903PickInstanceRepository.save(new MyEntity4903Instance().setCustomField("Instance3"));

        myEntity4903FilePickRepository.save(new MyEntity4903FileNamePick().setCustomField("File name1"));
        myEntity4903FilePickRepository.save(new MyEntity4903FileNamePick().setCustomField("File name2"));
        myEntity4903FilePickRepository.save(new MyEntity4903FileNamePick().setCustomField("File name3"));

        repositoryOCP.save(new MyEntity4903OCPPick().setCustomField("OCP1"));
        repositoryOCP.save(new MyEntity4903OCPPick().setCustomField("OCP2"));
        repositoryOCP.save(new MyEntity4903OCPPick().setCustomField("OCP3"));
        repositoryOCP.save(new MyEntity4903OCPPick().setCustomField("OCP4"));

        repositoryPick.save(new MyEntity4903Pick().setCustomField("FCPP1"));
        repositoryPick.save(new MyEntity4903Pick().setCustomField("FCPP2"));
        repositoryPick.save(new MyEntity4903Pick().setCustomField("FCPP3"));

        repository.save(new MyEntity4903().setCustomField("test data"));
    }

}