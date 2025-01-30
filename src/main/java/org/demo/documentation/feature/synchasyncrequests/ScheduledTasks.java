package org.demo.documentation.feature.synchasyncrequests;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.feature.synchasyncrequests.enums.StatusEnum;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

import static org.cxbox.api.service.session.InternalAuthorizationService.SystemUsers.VANILLA;

@Component
public class ScheduledTasks {

    private final MyEntity3231Repository repository;
    private final InternalAuthorizationService authzService;

    public ScheduledTasks(MyEntity3231Repository repository, InternalAuthorizationService authzService) {
        this.repository = repository;
        this.authzService = authzService;
    }

    @Scheduled(fixedRate = 15000)
    public void changeStatus() {
        authzService.loginAs(authzService.createAuthentication(VANILLA));
        List<MyEntity3231> dataListInProgress = repository.findAllByStatusResponse(StatusEnum.IN_PROGRESS);
        dataListInProgress.forEach(data -> {
                    data.setUpdatedDate(LocalDateTime.now());
                    data.setStatusResponse(StatusEnum.DONE);
                    repository.save(data);
                }
        );
    }
}