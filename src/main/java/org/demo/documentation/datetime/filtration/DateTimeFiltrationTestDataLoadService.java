package org.demo.documentation.datetime.filtration;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateTimeFiltrationTestDataLoadService {

	@Autowired
	DateTimeFiltrationRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new DateTimeFiltration().setCustomField(LocalDateTime.now()));
		repository.save(new DateTimeFiltration().setCustomField(LocalDateTime.now().minusMinutes(3)));
		repository.save(new DateTimeFiltration().setCustomField(LocalDateTime.now().minusMinutes(30)));
		repository.save(new DateTimeFiltration().setCustomField(LocalDateTime.now().minusHours(2)));
		repository.save(new DateTimeFiltration().setCustomField(LocalDateTime.now().minusDays(1).minusHours(2)
				.minusMinutes(3)));
		repository.save(new DateTimeFiltration().setCustomField(LocalDateTime.now().minusDays(2).minusMinutes(15)));
		repository.save(new DateTimeFiltration().setCustomField(LocalDateTime.now().minusYears(1).minusHours(4)
				.minusMinutes(15)));
		repository.save(new DateTimeFiltration().setCustomField(LocalDateTime.now().minusYears(2)));
		repository.save(new DateTimeFiltration().setCustomField(LocalDateTime.now().plusMonths(1).minusHours(3)
				.minusMinutes(15)));
		repository.save(new DateTimeFiltration().setCustomField(LocalDateTime.now().plusMonths(2)));

	}

}