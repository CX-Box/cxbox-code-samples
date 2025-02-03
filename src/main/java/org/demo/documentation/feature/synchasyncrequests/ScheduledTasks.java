package org.demo.documentation.feature.synchasyncrequests;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.feature.synchasyncrequests.enums.StatusEnum;
import org.demo.documentation.feature.synchasyncrequests.drilldownandwaituntil.MyEntity3232;
import org.demo.documentation.feature.synchasyncrequests.drilldownandwaituntil.MyEntity3232Repository;
import org.demo.documentation.feature.synchasyncrequests.waituntil.MyEntity3231;
import org.demo.documentation.feature.synchasyncrequests.waituntil.MyEntity3231Repository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

import static org.cxbox.api.service.session.InternalAuthorizationService.SystemUsers.VANILLA;

@Component
public class ScheduledTasks {

    private final MyEntity3232Repository repository3232;
    private final MyEntity3231Repository repository3231;
    private final InternalAuthorizationService authzService;

    public ScheduledTasks(MyEntity3232Repository repository3232, MyEntity3231Repository repository3231, InternalAuthorizationService authzService) {
        this.repository3232 = repository3232;
        this.repository3231 = repository3231;

        this.authzService = authzService;
    }

    @Scheduled(fixedRate = 5000)
    public void changeStatus() {
        authzService.loginAs(authzService.createAuthentication(VANILLA));
        List<MyEntity3231> dataListInProgress = repository3231.findAllByStatusResponse(StatusEnum.IN_PROGRESS);
        dataListInProgress.forEach(data -> {
                    data.setUpdatedDate(LocalDateTime.now());
                    data.setStatusResponse(StatusEnum.DONE);
            repository3231.save(data);
                }
        );
        List<MyEntity3232> dataListInProgress3232 = repository3232.findAllByStatusResponse(StatusEnum.IN_PROGRESS);
        dataListInProgress3232.forEach(data -> {
                    data.setUpdatedDate(LocalDateTime.now());
                    data.setStatusResponse(StatusEnum.DONE);
            repository3232.save(data);
                }
        );
    }
}