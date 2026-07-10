package org.demo.documentation.widgets.pie1d.data;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class MyEntityRingTestDataLoadService {

	@Autowired
	MyEntityRingRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
  
		repository.save(new MyEntityRingData()
				.setCustomField("Trade Prof Media LLC")
				.setCustomFieldNum(295L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(2).plusHours(10))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Web Project Communication”")
				.setCustomFieldNum(544L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(3).plusHours(11))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(756L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(4).plusHours(12))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Synthesis Technology”")
				.setCustomFieldNum(1318L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(5).plusHours(13))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Info Trust”")
				.setCustomFieldNum(791L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(6).plusHours(14))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("GlobalTrade Partners")
				.setCustomFieldNum(599L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(7).plusHours(15))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("AcademWeb Holding")
				.setCustomFieldNum(418L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(8).plusHours(16))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("AllianceConsult JSC")
				.setCustomFieldNum(598L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(9).plusHours(17))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("Trade Prof Media LLC")
				.setCustomFieldNum(546L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(10).plusHours(18))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("Trade Prof Media LLC")
				.setCustomFieldNum(1548L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(11).plusHours(19))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Web Project Communication”")
				.setCustomFieldNum(1682L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(12).plusHours(20))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(1462L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(13).plusHours(21))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(490L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(14).plusHours(22))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “TelecomTrade”")
				.setCustomFieldNum(710L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(15).plusHours(23))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “TelecomTrade”")
				.setCustomFieldNum(438L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(16).plusHours(10))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Synthesis Technology”")
				.setCustomFieldNum(684L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(17).plusHours(11))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Synthesis Technology”")
				.setCustomFieldNum(488L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(3).plusDays(18).plusHours(12))
		);

		// ---- Month -2 (May) ----
		repository.save(new MyEntityRingData()
				.setCustomField("Trade Prof Media LLC")
				.setCustomFieldNum(423L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(2).plusHours(10))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Web Project Communication”")
				.setCustomFieldNum(778L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(3).plusHours(11))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(692L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(4).plusHours(12))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Synthesis Technology”")
				.setCustomFieldNum(1247L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(5).plusHours(13))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Info Trust”")
				.setCustomFieldNum(586L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(6).plusHours(14))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("GlobalTrade Partners")
				.setCustomFieldNum(856L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(7).plusHours(15))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("AcademWeb Holding")
				.setCustomFieldNum(568L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(8).plusHours(16))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("AllianceConsult JSC")
				.setCustomFieldNum(342L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(9).plusHours(17))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("Trade Prof Media LLC")
				.setCustomFieldNum(418L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(10).plusHours(18))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("Trade Prof Media LLC")
				.setCustomFieldNum(1356L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(11).plusHours(19))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Web Project Communication”")
				.setCustomFieldNum(1538L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(12).plusHours(20))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(1540L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(13).plusHours(21))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(780L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(14).plusHours(22))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “TelecomTrade”")
				.setCustomFieldNum(322L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(15).plusHours(23))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “TelecomTrade”")
				.setCustomFieldNum(304L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(16).plusHours(10))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Synthesis Technology”")
				.setCustomFieldNum(404L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(17).plusHours(11))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Synthesis Technology”")
				.setCustomFieldNum(682L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(2).plusDays(18).plusHours(12))
		);

		// ---- Month -1 (June) ----
		repository.save(new MyEntityRingData()
				.setCustomField("Trade Prof Media LLC")
				.setCustomFieldNum(438L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(2).plusHours(10))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Web Project Communication”")
				.setCustomFieldNum(360L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(3).plusHours(11))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(714L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(4).plusHours(12))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Synthesis Technology”")
				.setCustomFieldNum(1309L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(5).plusHours(13))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(3214L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(6).plusHours(14))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Web Project Communication”")
				.setCustomFieldNum(2889L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(7).plusHours(15))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("AcademWeb Holding")
				.setCustomFieldNum(589L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(8).plusHours(16))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("AllianceConsult JSC")
				.setCustomFieldNum(522L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(9).plusHours(17))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("Trade Prof Media LLC")
				.setCustomFieldNum(569L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(10).plusHours(18))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("Trade Prof Media LLC")
				.setCustomFieldNum(1690L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(11).plusHours(19))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Web Project Communication”")
				.setCustomFieldNum(1392L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(12).plusHours(20))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(1650L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(13).plusHours(21))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(708L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(14).plusHours(22))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “TelecomTrade”")
				.setCustomFieldNum(548L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(15).plusHours(23))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “TelecomTrade”")
				.setCustomFieldNum(626L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(16).plusHours(10))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Synthesis Technology”")
				.setCustomFieldNum(548L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().minusMonths(1).plusDays(17).plusHours(11))
		);

		// ---- Month 0 (July) ----
		repository.save(new MyEntityRingData()
				.setCustomField("Trade Prof Media LLC")
				.setCustomFieldNum(717L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(2).plusHours(10))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Web Project Communication”")
				.setCustomFieldNum(521L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(3).plusHours(11))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(436L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(4).plusHours(12))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Synthesis Technology”")
				.setCustomFieldNum(1588L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().plusDays(5).plusHours(13))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(2440L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(6).plusHours(14))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Web Project Communication”")
				.setCustomFieldNum(2874L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(7).plusHours(15))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("AcademWeb Holding")
				.setCustomFieldNum(428L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.CLOSED)
				.setCustomFieldDate(getStartOfMonth().plusDays(8).plusHours(16))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("AllianceConsult JSC")
				.setCustomFieldNum(464L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(9).plusHours(17))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("Trade Prof Media LLC")
				.setCustomFieldNum(1617L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(10).plusHours(18))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("Trade Prof Media LLC")
				.setCustomFieldNum(1590L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(11).plusHours(19))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Web Project Communication”")
				.setCustomFieldNum(1584L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(12).plusHours(20))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(1732L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(13).plusHours(21))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC TelemedOperations")
				.setCustomFieldNum(680L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(14).plusHours(22))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “TelecomTrade”")
				.setCustomFieldNum(402L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(15).plusHours(23))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “TelecomTrade”")
				.setCustomFieldNum(780L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(16).plusHours(10))
		);
		repository.save(new MyEntityRingData()
				.setCustomField("LLC “Synthesis Technology”")
				.setCustomFieldNum(542L)
				.setCustomFieldDictionary(CustomFieldStatusEnum.OPEN)
				.setCustomFieldDate(getStartOfMonth().plusDays(17).plusHours(11))
		);
	}

	private LocalDateTime getStartOfMonth() {
		return LocalDate.now().withDayOfMonth(1).atStartOfDay();
	}
}
