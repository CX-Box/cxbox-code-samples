package org.demo.documentation.feature.postaction;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.feature.postaction.drilldownandwaituntil.allbutton.MyEntity3232;
import org.demo.documentation.feature.postaction.drilldownandwaituntil.allbutton.MyEntity3232Repository;
import org.demo.documentation.feature.postaction.drilldownandwaituntil.basic.MyEntity3234;
import org.demo.documentation.feature.postaction.drilldownandwaituntil.basic.MyEntity3234Repository;
import org.demo.documentation.feature.postaction.enums.StatusEnum;
import org.demo.documentation.feature.postaction.waituntil.allbutton.MyEntity3231;
import org.demo.documentation.feature.postaction.waituntil.allbutton.MyEntity3231Repository;
import org.demo.documentation.feature.postaction.waituntil.basic.MyEntity3233;
import org.demo.documentation.feature.postaction.waituntil.basic.MyEntity3233Repository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

import static org.cxbox.api.service.session.InternalAuthorizationService.SystemUsers.VANILLA;

@Component
public class ScheduledTasks {
    private final MyEntity3234Repository repository3234;
    private final MyEntity3233Repository repository3233;
    private final MyEntity3232Repository repository3232;
    private final MyEntity3231Repository repository3231;
    private final InternalAuthorizationService authzService;

    public ScheduledTasks(MyEntity3234Repository repository3234, MyEntity3233Repository repository3233, MyEntity3232Repository repository3232, MyEntity3231Repository repository3231, InternalAuthorizationService authzService) {
        this.repository3234 = repository3234;
        this.repository3233 = repository3233;
        this.repository3232 = repository3232;
        this.repository3231 = repository3231;

        this.authzService = authzService;
    }

    @Scheduled(fixedRate = 7000)
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
        List<MyEntity3233> dataListInProgress3233 = repository3233.findAllByStatusResponse(StatusEnum.IN_PROGRESS);
        dataListInProgress3233.forEach(data -> {
                    data.setUpdatedDate(LocalDateTime.now());
                    data.setStatusResponse(StatusEnum.DONE);
                    repository3233.save(data);
                }
        );
        List<MyEntity3234> dataListInProgress3234 = repository3234.findAllByStatusResponse(StatusEnum.IN_PROGRESS);
        dataListInProgress3234.forEach(data -> {
                    data.setUpdatedDate(LocalDateTime.now());
                    data.setStatusResponse(StatusEnum.DONE);
                    repository3234.save(data);
                }
        );
    }
}