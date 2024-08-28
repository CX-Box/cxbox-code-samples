package org.demo.documentation.other.savewithparent;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.other.savewithparent.child.MyEntity3057;
import org.demo.documentation.other.savewithparent.child.MyEntity3057Repository;
import org.demo.documentation.other.savewithparent.parent.MyEntity3058;
import org.demo.documentation.other.savewithparent.parent.MyEntity3058Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3057TestDataLoadService {

    @Autowired
    MyEntity3057Repository repository;

    @Autowired
    MyEntity3058Repository repositoryParent;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repositoryParent.deleteAll();
        repositoryParent.save(new MyEntity3058().setCustomField("test data"));
        repository.deleteAll();
        repository.save(new MyEntity3057().setCustomField("test data"));
    }

}