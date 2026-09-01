package org.demo.documentation.widgets.tree.data.inner;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.tree.base.inner.MyEntity3263Repository;
import org.demo.documentation.widgets.tree.base.inner.Myexample3263;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3261TestDataLoadService {

	@Autowired
	MyEntity3261Repository repository3261;

	@Autowired
	MyEntity3263Repository repository3263;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository3261.deleteAll();
		repository3263.deleteAll();

		Myexample3261 e1103500 = new Myexample3261()
				.setDepartment("Полномочия Росгвардии")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103500")
				.setMnemonic("GRP_1103500");
		repository3261.save(e1103500);

		repository3261.save(new Myexample3261()
				.setParentId(e1103500.getId())
				.setDepartment("Подача заявлений на получение и переоформление разрешения на хранение и ношение служебного оружия и патронов к нему")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает право доверенному лицу на подачу заявлений на получение, переоформление и продления разрешения на хранение и ношение служебного оружия и патронов к нему")
				.setCode("RSGV01_RSGV_740")
				.setMnemonic("RSGV_740"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103500.getId())
				.setDepartment("Подача заявлений на выдачу организации лицензий на приобретение гражданского, служебного оружия и патронов")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает право доверенному лицу на подачу заявлений на выдачу или переоформление лицензии на приобретение гражданского, служебного оружия и патронов")
				.setCode("RSGV01_RSGV_517")
				.setMnemonic("RSGV_517"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103500.getId())
				.setDepartment("Подача заявлений на получение и переоформление разрешений на хранение оружия и патронов для организации")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает право доверенному лицу на подачу заявлений на получение и переоформление разрешений на хранение оружия и патронов для организации")
				.setCode("RSGV01_RSGV_520")
				.setMnemonic("RSGV_520"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103500.getId())
				.setDepartment("Подача заявлений на получение разрешения на хранение и использование оружия и патронов к нему")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает право доверенному лицу на получение или переоформление разрешения на хранение и использование оружия и патронов к нему")
				.setCode("RSGV01_RSGV_355")
				.setMnemonic("RSGV_355"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103500.getId())
				.setDepartment("Подача заявлений на получение и переоформление разрешений на хранение и использование оружия на стрелковом объекте")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает право доверенному лицу на подачу заявлений на получение и переоформление разрешений на хранение и использование оружия на стрелковом объекте")
				.setCode("RSGV01_RSGV_531")
				.setMnemonic("RSGV_531"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103500.getId())
				.setDepartment("Подача заявлений для уведомления Росгвардии об оказании охранных услуг или изменении состава учредителей")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает право доверенному лицу на отправку заявлений для уведомления Росгвардии о начале/окончании оказания охранных услуг, об изменении состава учредителей или руководителя")
				.setCode("RSGV01_RSGV_440")
				.setMnemonic("RSGV_440"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103500.getId())
				.setDepartment("Подача заявлений для уведомления Росгвардии о продаже оружия и патронов")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает право доверенному лицу на подачу заявлений на уведомление Росгвардии о планируемой продаже оружия и патронов")
				.setCode("RSGV01_RSGV_533")
				.setMnemonic("RSGV_533"));

// Корень 2: Полномочия ФТС
		Myexample3261 e1103508 = new Myexample3261()
				.setDepartment("Полномочия ФТС")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103508")
				.setMnemonic("GRP_1103508");
		repository3261.save(e1103508);


		Myexample3261 e1103509 = new Myexample3261()
				.setParentId(e1103508.getId())
				.setDepartment("Таможенное декларирование и таможенные операции")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103509")
				.setMnemonic("GRP_1103509");
		repository3261.save(e1103509);

		repository3261.save(new Myexample3261()
				.setParentId(e1103509.getId())
				.setDepartment("Подписание таможенных документов, предоставляемых в ФТС России заинтересованными лицами в рамках таможенного декларирования и таможенных операций, связанных с подачей, регистрацией, отзывом и изменением сведений, заявленных в таможенной декларации")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FTS_10001")
				.setMnemonic(""));

		repository3261.save(new Myexample3261()
				.setParentId(e1103509.getId())
				.setDepartment("Подписание иных электронных документов, предоставляемых заинтересованными лицами в таможенные органы, несвязанных с таможенным декларированием товаров, транспортных средств и выпуском товаров")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FTS_10002")
				.setMnemonic(""));

		repository3261.save(new Myexample3261()
				.setParentId(e1103509.getId())
				.setDepartment("Подписание таможенных документов от имени таможенных органов в рамках таможенного декларирования и таможенных операций, связанных с подачей, приемом, регистрацией, отзывом таможенной декларации, изменением заявленных в ней сведений и выпуском товаров")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FTS_00001")
				.setMnemonic(""));

		repository3261.save(new Myexample3261()
				.setParentId(e1103509.getId())
				.setDepartment("Подписание иных электронных документов от имени таможенных органов, несвязанных с таможенным декларированием товаров, транспортных средств и выпуском товаров")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FTS_00002")
				.setMnemonic(""));

		Myexample3261 e1103514 = new Myexample3261()
				.setParentId(e1103508.getId())
				.setDepartment("Дела об административных правонарушениях")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103514")
				.setMnemonic("GRP_1103514");
		repository3261.save(e1103514);


		repository3261.save(new Myexample3261()
				.setParentId(e1103514.getId())
				.setDepartment("Получение извещений, уведомлений и процессуальных документов по делам об административных правонарушениях")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FTS_10003")
				.setMnemonic(""));

		repository3261.save(new Myexample3261()
				.setParentId(e1103514.getId())
				.setDepartment("Получение информации по делам об административных правонарушениях")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FTS_10004")
				.setMnemonic(""));

		repository3261.save(new Myexample3261()
				.setParentId(e1103514.getId())
				.setDepartment("Представление заявлений, объяснений, ходатайств, жалоб и иных документов по делам об административных правонарушениях")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FTS_10005")
				.setMnemonic(""));

		Myexample3261 e1103518 = new Myexample3261()
				.setDepartment("Полномочия Минфина")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103518")
				.setMnemonic("GRP_1103518");
		repository3261.save(e1103518);

		repository3261.save(new Myexample3261()
				.setParentId(e1103518.getId())
				.setDepartment("Подписание электронных документов в ГИС ЕСУБП")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MFOOPOLN_MF00052")
				.setMnemonic("MF00052"));


		Myexample3261 e1103520 = new Myexample3261()
				.setDepartment("Полномочия субъектов РФ")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103520")
				.setMnemonic("GRP_1103520");
		repository3261.save(e1103520);


		Myexample3261 e1103521 = new Myexample3261()
				.setParentId(e1103520.getId())
				.setDepartment("ГИСЗ НСО (закупки Новосибирской области)")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103521")
				.setMnemonic("GRP_1103521");
		repository3261.save(e1103521);


		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы в соответствии с пунктом 4 статьи 19 Федерального закона от 05.04.2013 № 44-ФЗ")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO13")
				.setMnemonic("GISZNSO13"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Осуществлять внутренний государственный финансовый контроль (в рамках осуществления полномочий контрольного органа УК НСО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO14")
				.setMnemonic("GISZNSO14"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Рассматривать документы в соответствии с частью 2 статьи 93 Федерального закона от 05.04.2013 № 44-ФЗ (в рамках осуществления полномочий контрольного органа УК НСО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO15")
				.setMnemonic("GISZNSO15"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать и просматривать документы от лица администратора в ГИСЗ НСО (в рамках осуществления полномочий по консультационному сопровождению пользователей)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_223_GISZNSO16")
				.setMnemonic("GISZNSO16"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы в рамках Федерального закона от 18.07.2011 № 223-ФЗ")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_223_GISZNSO17")
				.setMnemonic("GISZNSO17"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Разрабатывать и согласовывать проекты извещений об осуществлении закупки и документацию о конкурентной закупке в рамках Федерального закона от 18.07.2011 № 223-ФЗ")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_223_GISZNSO18")
				.setMnemonic("GISZNSO18"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать и просматривать документы от лица администратора ГИСЗ НСО (в рамках осуществления полномочий по консультационному сопровождению пользователей)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_OTHER_GISZNSO19")
				.setMnemonic("GISZNSO19"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы при осуществлении закупок товаров, работ, услуг для обеспечения государственных нужд в целях реализации своих функций и полномочий")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_OTHER_GISZNSO20")
				.setMnemonic("GISZNSO20"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы в соответствии с постановлением Правительства НСО от 01.11.2016 № 352-п (в рамках осуществления полномочий уполномоченного учреждения ГКУ НСО «УКСис»)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO7")
				.setMnemonic("GISZNSO7"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы в соответствии с частью 1 статьи 26 Федерального закона от 05.04.2013 № 44-ФЗ (в рамках осуществления полномочий уполномоченного органа или уполномоченного учреждения муниципального уровня)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO8")
				.setMnemonic("GISZNSO8"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать и просматривать документы от лица администратора ГИСЗ НСО (в рамках осуществления полномочий по консультационному сопровождению пользователей)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO1")
				.setMnemonic("GISZNSO1"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы в рамках Федерального закона от 05.04.2013 № 44-ФЗ и в соответствии с постановлением Правительства НСО от 30.12.2013 № 596-п")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO2")
				.setMnemonic("GISZNSO2"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы в рамках Федерального закона от 05.04.2013 № 44-ФЗ и в соответствии с постановлением Правительства НСО от 30.12.2013 № 597-п")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO3")
				.setMnemonic("GISZNSO3"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы в соответствии с постановлением Правительства НСО от 30.12.2013 № 598-п")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO4")
				.setMnemonic("GISZNSO4"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы в соответствии с постановлением Правительства НСО от 01.11.2016 № 352-п (в рамках осуществления полномочий координатора совместных закупок)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO11")
				.setMnemonic("GISZNSO11"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Просматривать документы подведомственных учреждений (для областных исполнительных органов государственной власти Новосибирской области, администраций муниципальных районов и городских округов)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO12")
				.setMnemonic("GISZNSO12"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы в соответствии с частью 3 статьи 26 Федерального закона от 05.04.2013 № 44-ФЗ, постановлением Правительства НСО от 30.12.2013 № 598-п (в рамках полномочий уполномоченного учреждения ГКУ НСО «УКСис»)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO5")
				.setMnemonic("GISZNSO5"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы в соответствии с частями 1, 4, 7, 8 статьи 26 Федерального закона от 05.04.2013 № 44-ФЗ, постановлениями Правительства НСО от 19.01.2015 № 11-п, № 12-п (в рамках полномочий уполномоченного органа Минстрой НСО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO6")
				.setMnemonic("GISZNSO6"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы в соответствии с частью 3 статьи 26 Федерального закона от 05.04.2013 № 44-ФЗ (в рамках осуществления полномочий уполномоченного органа или уполномоченного учреждения муниципального уровня)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO9")
				.setMnemonic("GISZNSO9"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы в соответствии с частями 1, 4, 7, 8 статьи 26 Федерального закона от 05.04.2013 № 44-ФЗ, постановлениями Правительства НСО от 19.01.2015 № 11-п, № 12-п (в рамках осуществления полномочий уполномоченного органа Минстрой НСО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_44_GISZNSO10")
				.setMnemonic("GISZNSO10"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103521.getId())
				.setDepartment("Подписывать документы в личном кабинете ГИСЗ НСО в соответствии с предоставленными правами, предусмотренные регламентом осуществления закупок с использованием ГИСЗ НСО")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GKUNSOUKSIS_SIGN_GISZNSO")
				.setMnemonic("GISZNSO"));

// ПК «Региональная контрактная система» (Севастополь)
		Myexample3261 e1103543 = new Myexample3261()
				.setParentId(e1103520.getId())
				.setDepartment("ПК «Региональная контрактная система» (Севастополь)")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103543")
				.setMnemonic("GRP_1103543");
		repository3261.save(e1103543);

		repository3261.save(new Myexample3261()
				.setParentId(e1103543.getId())
				.setDepartment("Подписывать документы в личном кабинете программного комплекса «Региональная контрактная система» в соответствии с предоставленными правами, предусмотренными Регламентом программного комплекса «Региональная контрактная система»")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("GZSEVASTOPOL_NSIRKS_ALLSIGN")
				.setMnemonic("ALLSIGN"));

		Myexample3261 e1103545 = new Myexample3261()
				.setParentId(e1103520.getId())
				.setDepartment("АИС «АРМ Контроль» (Москоллектор)")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103545")
				.setMnemonic("GRP_1103545");
		repository3261.save(e1103545);


		repository3261.save(new Myexample3261()
				.setParentId(e1103545.getId())
				.setDepartment("Регистрация в АИС «АРМ Контроль»")
				.setIsLeaf(true)
				.setDescription("Подача заявок на регистрацию в АИС «АРМ Контроль»")
				.setCode("MOSCOLLECTOR_DOPUSK_REG")
				.setMnemonic("REG"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103545.getId())
				.setDepartment("Создание и подписание заявок на сотрудников")
				.setIsLeaf(true)
				.setDescription("Подача списков работников на допуск в коммуникационные коллекторы и диспетчерские пункты")
				.setCode("MOSCOLLECTOR_DOPUSK_EMP_REQUEST")
				.setMnemonic("EMP_REQUEST"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103545.getId())
				.setDepartment("Согласование заявок на сотрудников от подрядных организаций")
				.setIsLeaf(true)
				.setDescription("Согласование списков работников на допуск в коммуникационные коллекторы и диспетчерские пункты от подрядных организаций")
				.setCode("MOSCOLLECTOR_DOPUSK_EMP_APPROVE")
				.setMnemonic("EMP_APPROVE"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103545.getId())
				.setDepartment("Создание и подписание заявок на допуск")
				.setIsLeaf(true)
				.setDescription("Подача заявок на допуск сотрудников в коммуникационные коллекторы и диспетчерские пункты")
				.setCode("MOSCOLLECTOR_DOPUSK_ACCESS_REQUEST")
				.setMnemonic("ACCESS_REQUEST"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103545.getId())
				.setDepartment("Согласование заявок на допуск от подрядных организаций")
				.setIsLeaf(true)
				.setDescription("Согласование заявок на допуск сотрудников в коммуникационные коллекторы и диспетчерские пункты от подрядных организаций")
				.setCode("MOSCOLLECTOR_DOPUSK_ACCESS_APPROVE")
				.setMnemonic("ACCESS_APPROVE"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103545.getId())
				.setDepartment("Создание и подписание заявок на допуск в административные здания")
				.setIsLeaf(true)
				.setDescription("Подача заявок на допуск в административные здания и на территории баз управления автотранспорта и механизации")
				.setCode("MOSCOLLECTOR_DOPUSK_OFFICE_REQUEST")
				.setMnemonic("OFFICE_REQUEST"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103545.getId())
				.setDepartment("Изменение данных сотрудников и организации")
				.setIsLeaf(true)
				.setDescription("Внесение изменений в регистрационные данные организации, изменения данных работников организации в АИС «АРМ Контроль»")
				.setCode("MOSCOLLECTOR_DOPUSK_DATA_EDIT")
				.setMnemonic("DATA_EDIT"));

		Myexample3261 e1103553 = new Myexample3261()
				.setParentId(e1103520.getId())
				.setDepartment("ГИИС ДМДК")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103553")
				.setMnemonic("GRP_1103553");
		repository3261.save(e1103553);

		repository3261.save(new Myexample3261()
				.setParentId(e1103553.getId())
				.setDepartment("Отправка данных в ГИИС ДМДК через сервис интеграции")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_MFDMDK_DMDK_02")
				.setMnemonic("DMDK_02"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103553.getId())
				.setDepartment("Доступ в личный кабинет ГИИС ДМДК")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_MFDMDK_DMDK_01")
				.setMnemonic("DMDK_01"));

		Myexample3261 e1103556 = new Myexample3261()
				.setParentId(e1103520.getId())
				.setDepartment("Государственный долг Московской области")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103556")
				.setMnemonic("GRP_1103556");
		repository3261.save(e1103556);

		repository3261.save(new Myexample3261()
				.setParentId(e1103556.getId())
				.setDepartment("Подписание документов в соответствии с Порядком организации электронного документооборота между Министерством экономики и финансов Московской области и кредитными организациями, размещающими средства бюджета Московской области на банковских депозитах")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GOSDOLG_GD1")
				.setMnemonic("GD1"));

		Myexample3261 e1103558 = new Myexample3261()
				.setParentId(e1103520.getId())
				.setDepartment("ГИС РЭБ Московской области")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103558")
				.setMnemonic("GRP_1103558");
		repository3261.save(e1103558);


		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Сведений об операциях с целевыми средствами, документов, подтверждающих возникновение денежных обязательств (руководитель (уполномоченное лицо) участника казначейского сопровождения)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB5")
				.setMnemonic("REB5"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов, содержащих Сведения об объемах средств, указанных в НПА, предусматривающих возможность заключения гос. (мун.) контракта на срок, превышающий срок действия доведенных ЛБО (рук. (уполн. лицо) субъекта контроля)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB33")
				.setMnemonic("REB33"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов, содержащих Заявки на доведение предельных объемов финансирования на лицевой счет по переданным полномочиям получателя средств федерального бюджета (рук. (уполномоченное лицо) главного распорядителя средств бюджета МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB17")
				.setMnemonic("REB17"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Заявки на перечисление межбюджетных трансфертов (руководитель (уполномоченное лицо) органа местного самоуправления)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB40")
				.setMnemonic("REB40"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов по предельным объемам финансирования, подлежащих доведению до главных распорядителей (распорядителей) и получателей средств бюджета Московской области (изменению, отзыву) (уполномоченное лицо ГКУ «ФАЦ»)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB14")
				.setMnemonic("REB14"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание распоряжений о совершении казначейских платежей и иных документов при совершении операций по лицевому счету получателя бюджетных средств с правом второй подписи (гл. бух. (уполномоченное лицо) получателя средств бюджета МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB43")
				.setMnemonic("REB43"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Справки о межрасчетных выплатах и заработной плате (гл. бух. (уполномоч. лицо) государственного бюджетного (автоном.) уч. МО (иное лицо, уполномоч. на ведение бух. учета, или иное лицо, уполномоч. на подписание док. по фин.-эконом. вопр.))")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB48")
				.setMnemonic("REB48"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание распоряжений о совершении казнач. платежей и иных документов при совершении операций по лицевым счетам для учета операций со средствами участников казнач. сопровожд. с правом второй подписи (глав. бух. (уполномоч. лицо) участника казнач. сопр.)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB9")
				.setMnemonic("REB9"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание распоряжений о совершении казначейских платежей и иных документов при совершении операций по лицевым счетам, открытым государственным бюджетным (автоном.) учреж. МО, с правом второй подписи (гл.бух. (уполн.лицо) гос. бюджет. (автоном.) уч. МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB50")
				.setMnemonic("REB50"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Справки о межрасчетных выплатах и заработной плате (руководитель (уполномоченное лицо) государственного бюджетного (автономного) учреждения Московской области)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB47")
				.setMnemonic("REB47"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Информации о контракте (договоре), Информации о денежном обязательстве неучастника бюджетного процесса (руководитель (уполномоченное лицо) участника казначейского сопровождения)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB7")
				.setMnemonic("REB7"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Справки о межрасчетных выплатах и заработной плате (руководитель (уполномоченное лицо) получателя средств бюджета Московской области)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB38")
				.setMnemonic("REB38"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание распоряжений о совершении казначейских платежей и иных документов при совершении операций по лицевым счетам для учета операций со средствами участников казнач. Сопровожд. с правом первой подписи (рук. (уполн. лицо) участника казнач. сопровож.)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB8")
				.setMnemonic("REB8"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание распоряжений о совершении казначейских платежей и иных документов при совершении операций по лицевым счетам, открытым государственным унитарным предприятиям МО, с правом первой подписи (рук. (уполн. лицо) гос. унитар.предприятия МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB51")
				.setMnemonic("REB51"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Уведомления о запрете (об отказе) осуществления операций на лиц. счете для учета операций со средствами уч. казн. сопр., Уведомления об отмене запрета (отказа), Уведомления о приостановлении операции (уполномоченное лицо ГКУ «ФАЦ»)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB63")
				.setMnemonic("REB63"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Информации (уточняющей инф. в ранее представленную Инф.) об источнике образования задолженности и кодах бюджет. классифик. РФ, по кот. должны быть произведены расходы по исп. исполнительного док. (реш. налог. орг.) (рук. (уполн. лицо) должника)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB30")
				.setMnemonic("REB30"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов, содержащих информацию о лимитах БО, предельных объемах финансирования на лицевом счете по переданным полномочиям получателя средств федерального бюджета (рук. (уполн. лицо) глав. распорядителя средств бюджета МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB19")
				.setMnemonic("REB19"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Сведений о проекте контракта, направляемого участнику закупки без использования ЕИС при осуществлении закупок у единственного поставщика (подрядчика, исполнителя) (руководитель (уполномоченное лицо) субъекта контроля)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB32")
				.setMnemonic("REB32"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Утверждение (отклонение) Заявки на перечисление межбюджетных трансфертов (руководитель (уполномоченное лицо) главного распорядителя средств бюджета Московской области)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB41")
				.setMnemonic("REB41"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание распоряжений о совершении казначейских платежей и иных документов при совершении операций по лицевым счетам, открытым получателям средств из бюджета МО, с правом первой подписи (руковод. (уполномоч. лицо) получателя средств из бюджета МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB57")
				.setMnemonic("REB57"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание распоряжений о совершении казначейских платежей и иных документов при совершении операций по лицевым счетам, открытым гос. бюджетным (автоном.) учрежден. МО, с правом первой подписи (рук. (уполн. лицо) гос. бюджетного (автоном.) уч. МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB49")
				.setMnemonic("REB49"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов, содержащих принятые к исполнению распоряжения о совершении казначейских платежей, для направления в Министерство экономики и финансов Московской области (уполномоченное лицо ГКУ МО «ФАЦ»)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB59")
				.setMnemonic("REB59"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание распоряжений о совершении казначейских платежей и иных документов при совершении операций по лицевому счету получателя бюджетных средств с правом первой подписи (рук. (уполномоченное лицо) получателя средств бюджета МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB42")
				.setMnemonic("REB42"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Принятие прогнозов (изменений в прогнозы), представленных в целях формирования Кассового плана исполнения бюджета Московской области, пояснительных записок к прогнозу на год (уполномоченное лицо ГКУ МО «ФАЦ»)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB24")
				.setMnemonic("REB24"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов по лимитам бюджетных обязательств, подлежащих доведению при выполнении условий (руководитель (уполномоченное лицо) главного распорядителя средств бюджета Московской области)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB11")
				.setMnemonic("REB11"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов по лимитам бюджетных обязательств, подлежащих доведению до главных распорядителей средств бюджета Московской области (отзыву) (уполномоченное лицо ГКУ МО «ФАЦ»)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB12")
				.setMnemonic("REB12"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Справки о межрасчетных выплатах и заработной плате (гл. бух. (уполномоченное лицо) получателя средств бюджета МО (иное лицо, уполномоченное на ведение бух. учета, или иное лицо, уполномоч. на подписание док. по фин.-эконом. вопр.))")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB39")
				.setMnemonic("REB39"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Прогноза (изменений в прогноз) поступлений по доходам бюдж. МО на год, Прогноза поступлений по доходам бюджета МО на месяц, Пояснительной записки к прогнозу поступлений по доходам бюдж. МО на год (рук. (уполн.лицо) гл. админ. доходов бюдж. МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB21")
				.setMnemonic("REB21"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание проекта кассового плана (уточненного кассового плана) исполнения бюджета Московской области на год, проекта кассового плана исполнения бюджета Московской области на месяц для направления в МЭФ МО (уполномоченное лицо ГКУ МО «ФАЦ»)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB25")
				.setMnemonic("REB25"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Сведений о бюджетных обязательствах (руководитель (уполномоченное лицо) получателя средств бюджета Московской области)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB36")
				.setMnemonic("REB36"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Информации о контракте (договоре), Информации о денежном обязательстве неучастника бюджетного процесса (руководитель (уполномоченное лицо) государственного бюджетного (автономного) учреждения Московской области)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB46")
				.setMnemonic("REB46"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов, содержащих аналитический код для учета операций с целевыми субсидиями (руководитель (уполномоченное лицо) главного распорядителя средств бюджета Московской области)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB2")
				.setMnemonic("REB2"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Принятие (отклонение) электронных документов, содержащих информацию о лимитах бюджетных обязательств, предельных объемах финансирования на лицевом счете по переданным полномочиям получателя средств федерального бюджета (уполномоченное лицо ГКУ «ФАЦ»)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB20")
				.setMnemonic("REB20"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание эл. документов по лимитам бюджетных обязательств, подлежащих доведению до распорядителей и получателей средств бюджета Московской области (отзыву) (руководитель (уполномоч. лицо) главного распорядителя (распорядителя) средств бюджета МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB15")
				.setMnemonic("REB15"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов, содержащих Сведения о показателях выплат по расходам на закупку товаров, работ, услуг, включенных в ПФХД ГБ(А)У МО (рук. (уполномоч.ю лицо) гл. распорядителя средств бюджета МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB35")
				.setMnemonic("REB35"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов по предельным объемам финансирования, подлежащих доведению до главных распорядителей средств бюджета Московской области (изменению, отзыву) (руководитель (уполномоченное лицо) главного распорядителя средств бюджета МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB13")
				.setMnemonic("REB13"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Прогноза (изменений в прогноз) поступлений и перечислений по источникам финансирования дефицита бюджета МО на год (на месяц), Пояснительной записки к прогнозу на год (рук. (уполн. лицо) гл. админи. источников финан. дефицита бюджета МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB23")
				.setMnemonic("REB23"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание распоряжений о совершении казнач. платежей и иных док. при совершении опера. по лицевым счетам, открытым админ. источ. внутрен. финан. дефицита бюджета МО, с правом 1 подписи (рук. (уполн. лицо) админ. источ. внутрен. фин. дефицита бюд. МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB53")
				.setMnemonic("REB53"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Уведомлений о поступлении исполнительного документа (реш. Налог. Орг.), Информации о поступлении от налог. органа Уведомления об уточнении суммы задолженности по решению налог. орг. для направления в МЭФ МО, должнику (уполн.лицо ГКУ МО «ФАЦ»)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB29")
				.setMnemonic("REB29"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Информации о контракте (договоре), Информации о денежном обязательстве неучастника бюджетного процесса (руководитель (уполномоченное лицо) получателя средств из бюджета Московской области)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB56")
				.setMnemonic("REB56"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Сведений об операциях с целевыми субсидиями (руководитель (уполномоченное лицо) главного распорядителя средств бюджета Московской области)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB1")
				.setMnemonic("REB1"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание распоряжений о совершении казн. плат. и иных док. в при совершении операций по лиц. счетам для учета операций со средствами уч. казнач. сопр. с одной 1 подписью (при отсутствии в штате должности гл. бух. (другого лица, выпол. его функции))")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB61")
				.setMnemonic("REB61"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов, содержащих Информацию о поступившем исполнительном документе и скан-копии поступивших документов, для направления на правовую экспертизу в МЭФ МО (уполномоченное лицо ГКУ МО «ФАЦ»)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB28")
				.setMnemonic("REB28"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Сведений о направлениях расходования целевых средств (руководитель (уполномоченное лицо) получателя средств бюджета Московской области, заказчика по договору)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB55")
				.setMnemonic("REB55"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Предупреждения (информирования) о наличии признаков финансовых нарушений при осуществлении операций на лицевом счете для учета операций с целевыми средствами участника казначейского сопровождения (уполномоченное лицо ГКУ «ФАЦ»)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB64")
				.setMnemonic("REB64"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Принятие (отклонение) электронных документов, содержащих Заявки на доведение предельных объемов финансирования на лицевой счет по переданным полномочиям получателя средств федерального бюджета (уполномоченное лицо ГКУ «ФАЦ»)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB18")
				.setMnemonic("REB18"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание эл. документов по предельным объемам финансирования, подлежащих доведению до распорядителей и получателей средств бюджета МО (изменению, отзыву) (руководитель (уполномоченное лицо) главного распорядителя (распорядителя) средств бюджета МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB16")
				.setMnemonic("REB16"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание распоряж. о совершении казнач. платежей и иных док. при совершении опер. по лиц. счету для учета операций со средствами, поступ. во времен. распоряж. получателя бюджет. средств, с прав. первой подписи (рук. (уполн. лицо) получ. средств бюд. МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB44")
				.setMnemonic("REB44"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Утверждение Сведений об операциях с целевыми средствами (руководитель (уполномоченное лицо) государственного заказчика Московской области (получателя средств бюджета Московской области, заказчика по контракту (договору))")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB6")
				.setMnemonic("REB6"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание распоряжений о совершении казначейских платежей и иных документов при совершении операций по лицевым счетам, открытым получателям средств из бюджета МО, с правом второй подписи (гл. бух. (уполномоченное лицо) получателя средств из бюджета МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB58")
				.setMnemonic("REB58"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Прогноза (изменений в прогноз) перечислений по расход. бюджета МО на год, Прогноза перечислений по расход. Бюд. МО на мес., Пояснительной зап. к прогнозу перечислений по расход. Бюд. МО на год (рук. (уполн.лицо) гл. распоряд. средств бюдж. МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB22")
				.setMnemonic("REB22"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание Сведений о денежных обязательствах (руководитель (уполномоченное лицо) получателя средств бюджета Московской области)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB37")
				.setMnemonic("REB37"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание распоряжений о совершении казнач. платежей и иных док. при совершении опер. по лиц. счету для учета опер. со средствами, поступ. во времен. распоряж. получателя бюджет. средств, с правом второй подписи (гл. бух. (уполномоч. лицо) ПБС МО)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB45")
				.setMnemonic("REB45"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов, содержащих Сведения о показателях выплат по расходам на закупку товаров, работ, услуг, включенных в ПФХД ГБ(А)У МО (руководитель (уполномоченное лицо) субъекта контроля)")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB34")
				.setMnemonic("REB34"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов в аналитической подсистеме ГИС РЭБ в соответствии с должностными обязанностями/курируемыми вопросами")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB1.7")
				.setMnemonic("REB1.7"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов в подсистеме бюджетного планирования Московской области, бюджетов муниципальных образований Московской области ГИС РЭБ в соответствии с должностными обязанностями/курируемыми вопросами")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB1.1")
				.setMnemonic("REB1.1"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов в подсистеме исполнения бюджета Московской области, бюджетов муниципальных образований Московской области ГИС РЭБ в соответствии с должностными обязанностями/курируемыми вопросами")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB1.2")
				.setMnemonic("REB1.2"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов в подсистеме управления доходами ГИС РЭБ в соответствии с должностными обязанностями/курируемыми вопросами")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB1.3")
				.setMnemonic("REB1.3"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов в подсистеме сбора и формирования отчетности ГИС РЭБ в соответствии с должностными обязанностями/курируемыми вопросами")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB1.4")
				.setMnemonic("REB1.4"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов в подсистеме бюджетного и бухгалтерского учета ГИС РЭБ в соответствии с должностными обязанностями/курируемыми вопросами")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB1.5")
				.setMnemonic("REB1.5"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов на портале «Открытый бюджет Московской области» ГИС РЭБ в соответствии с должностными обязанностями/курируемыми вопросами")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB1.6")
				.setMnemonic("REB1.6"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов в подсистеме нормативной справочной информации ГИС РЭБ в соответствии с должностными обязанностями/курируемыми вопросами")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB1.8")
				.setMnemonic("REB1.8"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов в подсистеме обеспечения юридически значимого электронного документооборота ГИС РЭБ в соответствии с должностными обязанностями/курируемыми вопросами")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB1.9")
				.setMnemonic("REB1.9"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103558.getId())
				.setDepartment("Подписание электронных документов в подсистеме обеспечения интеграционного взаимодействия с внешними системами ГИС РЭБ в соответствии с должностными обязанностями/курируемыми вопросами")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MEFMO_GISREB_REB1.10")
				.setMnemonic("REB1.10"));


		Myexample3261 e1103623 = new Myexample3261()
				.setDepartment("Полномочия Федеральной нотариальной палаты")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103623")
				.setMnemonic("GRP_1103623");
		repository3261.save(e1103623);

		Myexample3261 e1103624 = new Myexample3261()
				.setParentId(e1103623.getId())
				.setDepartment("Реестры и уведомления (залог движимого имущества, отмена доверенностей)")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103624")
				.setMnemonic("GRP_1103624");
		repository3261.save(e1103624);

		repository3261.save(new Myexample3261()
				.setParentId(e1103624.getId())
				.setDepartment("Направлять уведомление о возникновении залога движимого имущества для регистрации в реестре уведомлений о залоге движимого имущества, в том числе подписывать уведомление электронной подписью и получать свидетельство о регистрации")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP001")
				.setMnemonic("FNP001"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103624.getId())
				.setDepartment("Направлять уведомление об изменении залога движимого имущества для регистрации в реестре уведомлений о залоге движимого имущества, в том числе подписывать уведомление электронной подписью и получать свидетельство о регистрации")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP002")
				.setMnemonic("FNP002"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103624.getId())
				.setDepartment("Направлять уведомление об исключении сведений о залоге движимого имущества для регистрации в реестре уведомлений о залоге движимого имущества, в том числе подписывать уведомление электронной подписью и получать свидетельство о регистрации")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP003")
				.setMnemonic("FNP003"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103624.getId())
				.setDepartment("Обращаться к нотариусу за совершением нотариального действия по выдаче выписки из реестра уведомлений о залоге движимого имущества удаленно, подписывать заявления и документы электронной подписью, получать результаты совершения нотариального действия")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP005")
				.setMnemonic("FNP005"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103624.getId())
				.setDepartment("Обращаться к нотариусу за совершением нотариального действия по выдаче выписки из реестра распоряжений об отмене доверенностей, подписывать заявления и документы электронной подписью, получать результаты совершения нотариального действия")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP014")
				.setMnemonic("FNP014"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103624.getId())
				.setDepartment("Подписывать распоряжения об отмене доверенности и получать уведомления о регистрации распоряжения об отмене доверенности в реестре распоряжений об отмене доверенностей, за исключением нотариально удостоверенных доверенностей")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP016")
				.setMnemonic("FNP016"));


		Myexample3261 e1103631 = new Myexample3261()
				.setParentId(e1103623.getId())
				.setDepartment("Нотариальные действия удаленно")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103631")
				.setMnemonic("GRP_1103631");
		repository3261.save(e1103631);

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Обращаться к нотариусу за совершением удаленно исполнительной надписи о взыскании денежных сумм или истребовании имущества от должника, подписывать заявление и документы электронной подписью, получать результаты совершения нотариального действия")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP004")
				.setMnemonic("FNP004"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Обращаться к нотариусу за совершением нотариального действия по обеспечению доказательств удаленно, подписывать заявления и документы электронной подписью, получать результаты совершения нотариального действия")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP006")
				.setMnemonic("FNP006"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Обращаться к нотариусу за совершением удаленно нотариального действия по принятию в депозит нотариуса безналичных денежных средств, подписывать заявления и документы электронной подписью, получать результаты совершения нотариального действия")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP007")
				.setMnemonic("FNP007"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Обращаться к нотариусу за совершением нотариального действия по передаче удаленно электронных документов физическим и юридическим лицам, подписывать заявления и документы электронной подписью, получать результаты совершения нотариального действия")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP008")
				.setMnemonic("FNP008"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Обращаться к нотариусу за совершением нотариального действия по конвертации электронного документа с сохранением его юридической силы, подписывать заявления и документы электронной подписью, получать результаты совершения нотариального действия")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP009")
				.setMnemonic("FNP009"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Обращаться к нотариусу за совершением нотариального действия по свидетельствованию верности перевода нотариусом, совершенного удаленно, подписывать заявления и документы электронной подписью, получать результаты совершения нотариального действия")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP010")
				.setMnemonic("FNP010"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Обращаться к нотариусу за совершением нотариального действия по принятию на хранение электронного документа удаленно, подписывать заявления и документы электронной подписью, получать результаты совершения нотариального действия")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP011")
				.setMnemonic("FNP011"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Обращаться к нотариусу за выдачей принятого на хранение электронного документа (пакета электронных документов) удаленно, подписывать заявления и документы электронной подписью, получать результаты совершения нотариального действия")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP012")
				.setMnemonic("FNP012"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Обращаться к нотариусу за совершением нотариального действия по принятию на депонирование безналичных денежных средств удаленно, подписывать заявления и документы электронной подписью, получать результаты совершения нотариального действия")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP013")
				.setMnemonic("FNP013"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Обращаться к нотариусу за удостоверением удаленно факта наличия сведений в Едином государственном реестре недвижимости, подписывать заявления и документы электронной подписью, получать результаты совершения нотариального действия")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP015")
				.setMnemonic("FNP015"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Регистрировать запись в Реестре нотариальных действий на основании сведений о совершенном должностным лицом органа местного самоуправления нотариальном действии")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP023")
				.setMnemonic("FNP023"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Регистрировать запись в Реестре нотариальных действий на основании сведений о совершенном консульским должностным лицом нотариальном действии")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP024")
				.setMnemonic("FNP024"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Обращаться к нотариусу за совершением удаленно исполнительной надписи о взыскании денежных сумм или истребовании имущества от должника и получать результаты совершения исполнительной надписи или отказа в совершении исполнительной надписи")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP026")
				.setMnemonic("FNP026"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Направлять дополнительные сведения, заявления и документы в случае отложения нотариального действия")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP027")
				.setMnemonic("FNP027"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Подавать заявление нотариусу об отправке исполнительной надписи, совершенной удаленно, в структурное подразделение территориального органа ФССП России")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP028")
				.setMnemonic("FNP028"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Подписывать любые заявления и прилагаемые к нему документы усиленной квалифицированной электронной подписью при обращении к нотариусу за совершением нотариального действия удаленно")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP029")
				.setMnemonic("FNP029"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103631.getId())
				.setDepartment("Подписывать и направлять сведения о совершенном нотариальном действии, включая направление сообщения об изменении ранее направленных сведений, в нотариальную палату субъекта РФ")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP030")
				.setMnemonic("FNP030"));

// Нотариальный архив и ЕИС
		Myexample3261 e1103649 = new Myexample3261()
				.setParentId(e1103623.getId())
				.setDepartment("Нотариальный архив и ЕИС")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103649")
				.setMnemonic("GRP_1103649");
		repository3261.save(e1103649);


		repository3261.save(new Myexample3261()
				.setParentId(e1103649.getId())
				.setDepartment("Подписывать акты приема-передачи номенклатурных дел в нотариальный архив")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP017")
				.setMnemonic("FNP017"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103649.getId())
				.setDepartment("Подписывать акты приема-передачи номенклатурных дел, связанные с временным хранением дел в нотариальной палате")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP018")
				.setMnemonic("FNP018"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103649.getId())
				.setDepartment("Подписывать записи о регистрации наследственного дела, об изменении сведений о наследственном деле, о передаче наследственных дел")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP019")
				.setMnemonic("FNP019"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103649.getId())
				.setDepartment("Подписывать электронные образы нотариальных документов для передачи на хранение в архив")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP020")
				.setMnemonic("FNP020"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103649.getId())
				.setDepartment("Подписывать архивные справки, архивные копии, иные документы, связанные с деятельностью нотариального архива")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP021")
				.setMnemonic("FNP021"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103649.getId())
				.setDepartment("Подписывать в ЕИС сведения о документах, связанных с передачей дел в нотариальный архив")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP022")
				.setMnemonic("FNP022"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103649.getId())
				.setDepartment("Подписывать запросы, направляемые в ЕИС, уполномоченным работником Федеральной нотариальной палаты")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("FNP0000_FNP025")
				.setMnemonic("FNP025"));


		Myexample3261 e1103657 = new Myexample3261()
				.setDepartment("Полномочия Минстроя России")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103657")
				.setMnemonic("GRP_1103657");
		repository3261.save(e1103657);

// Экспертиза, строительство и планировка
		Myexample3261 e1103658 = new Myexample3261()
				.setParentId(e1103657.getId())
				.setDepartment("Экспертиза, строительство и планировка (Минстрой РФ)")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103658")
				.setMnemonic("GRP_1103658");
		repository3261.save(e1103658);


		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заключение государственной экспертизы")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заключения государственной экспертизы")
				.setCode("MINSTROYRF_MA0009")
				.setMnemonic("MA0009"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать проектно-сметную документацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования проектно-сметной документации")
				.setCode("MINSTROYRF_MA0031")
				.setMnemonic("MA0031"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать решение об отказе в выдаче разрешения на строительство")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования решения об отказе в выдаче разрешения на строительство")
				.setCode("MINSTROYRF_MA0015")
				.setMnemonic("MA0015"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать акты приемки выполненных работ по форме № КС-2")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования актов приемки выполненных работ по форме № КС-2")
				.setCode("MINSTROYRF_MA0032")
				.setMnemonic("MA0032"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать документы для осуществления государственного строительного надзора")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования документов для осуществления государственного строительного надзора по отношению к объектам капитального строительства")
				.setCode("MINSTROYRF_MA0010")
				.setMnemonic("MA0010"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать разрешение на строительство")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования разрешение на строительство")
				.setCode("MINSTROYRF_MA0011")
				.setMnemonic("MA0011"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление о выдаче разрешения на строительство")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о выдаче разрешения на строительство")
				.setCode("MINSTROYRF_MA0012")
				.setMnemonic("MA0012"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление о внесении изменений в разрешение на строительство")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о внесении изменений в разрешение на строительство")
				.setCode("MINSTROYRF_MA0013")
				.setMnemonic("MA0013"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать акт обследования объекта инженерно-коммунального назначения")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования акта обследования объекта инженерно-коммунального назначения")
				.setCode("MINSTROYRF_MA0016")
				.setMnemonic("MA0016"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать акт осмотра")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования акта осмотра")
				.setCode("MINSTROYRF_MA0017")
				.setMnemonic("MA0017"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать акт приема-передачи объектов во временную эксплуатацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования акта приема-передачи объектов во временную эксплуатацию")
				.setCode("MINSTROYRF_MA0018")
				.setMnemonic("MA0018"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать решение об отказе в приеме документов на выдачу разрешения на строительство")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования решения об отказе в приеме документов на выдачу разрешения на строительство")
				.setCode("MINSTROYRF_MA0014")
				.setMnemonic("MA0014"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать задание на проектирование объекта капитального строительства")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования задания на проектирование объекта капитального строительства")
				.setCode("MINSTROYRF_MA0002")
				.setMnemonic("MA0002"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать сводный календарный план")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования сводный календарный план")
				.setCode("MINSTROYRF_MA0003")
				.setMnemonic("MA0003"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать объектный календарный план")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования объектно календарного плана")
				.setCode("MINSTROYRF_MA0004")
				.setMnemonic("MA0004"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать рабочий календарный график")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования рабочий календарный график")
				.setCode("MINSTROYRF_MA0005")
				.setMnemonic("MA0005"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать пояснительную записку")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования пояснительной записки")
				.setCode("MINSTROYRF_MA0006")
				.setMnemonic("MA0006"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать акты сдачи-приемки выполненных работ")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования актов сдачи-приемки выполненных работ")
				.setCode("MINSTROYRF_MA0007")
				.setMnemonic("MA0007"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать договор о проведении государственный экспертизы документации")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования договора о проведении государственный экспертизы документации")
				.setCode("MINSTROYRF_MA0008")
				.setMnemonic("MA0008"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать акт приемки внутренних систем хозяйственного и горячего водоснабжения")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования акта приемки внутренних систем хозяйственного и горячего водоснабжения")
				.setCode("MINSTROYRF_MA0019")
				.setMnemonic("MA0019"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать акт приемки системы и выпусков внутренней канализации")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования акта приемки системы и выпусков внутренней канализации")
				.setCode("MINSTROYRF_MA0020")
				.setMnemonic("MA0020"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать акт технической приемки объекта инженерного и коммунального назначения")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования акта технической приемки объекта инженерного и коммунального назначения")
				.setCode("MINSTROYRF_MA0021")
				.setMnemonic("MA0021"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать документы")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования документов (в том числе накладной)")
				.setCode("MINSTROYRF_MA0022")
				.setMnemonic("MA0022"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать документы, созданные в рамках осуществления строительного контроля в соответствии со ст. 54 ГрК РФ")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования документов, созданных в рамках осуществления строительного контроля в соответствии со ст. 54 Градостроительного кодекса Российской Федерации")
				.setCode("MINSTROYRF_MA0023")
				.setMnemonic("MA0023"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать результаты инженерных изысканий")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования инженерных изысканий")
				.setCode("MINSTROYRF_MA0024")
				.setMnemonic("MA0024"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать проектную документацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования проектной документации")
				.setCode("MINSTROYRF_MA0025")
				.setMnemonic("MA0025"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать рабочую документацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования рабочей документации")
				.setCode("MINSTROYRF_MA0026")
				.setMnemonic("MA0026"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Выпускать в производство работ рабочую документацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право выпуска в производство работ рабочей документации")
				.setCode("MINSTROYRF_MA0027")
				.setMnemonic("MA0027"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Получать и подписывать исходно-разрешительную документацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право получения и подписи исходно-разрешительной документации")
				.setCode("MINSTROYRF_MA0028")
				.setMnemonic("MA0028"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать исполнительную документацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования исполнительной документации")
				.setCode("MINSTROYRF_MA0029")
				.setMnemonic("MA0029"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать графики календарно-сетевого планирования")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования графиков календарно-сетевого планирования")
				.setCode("MINSTROYRF_MA0030")
				.setMnemonic("MA0030"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать справки о стоимости выполненных работ и затрат по форме № КС-3")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования справок о стоимости выполненных работ и затрат по форме № КС-3")
				.setCode("MINSTROYRF_MA0033")
				.setMnemonic("MA0033"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать исполнительные схемы")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования исполнительных схем")
				.setCode("MINSTROYRF_MA0034")
				.setMnemonic("MA0034"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление о внесении изменений в разрешение на строительство в связи с продлением срока действия такого разрешения")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о внесении изменений в разрешение на строительство в связи с продлением срока действия такого разрешения")
				.setCode("MINSTROYRF_MA0035")
				.setMnemonic("MA0035"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление об исправлении допущенных опечаток и ошибок в сведениях, указанных в разрешении на строительство")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления об исправлении допущенных опечаток и ошибок в сведениях, указанных в разрешении на строительство")
				.setCode("MINSTROYRF_MA0036")
				.setMnemonic("MA0036"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление о выдаче дубликата разрешения на строительство")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о выдаче дубликата разрешения на строительство")
				.setCode("MINSTROYRF_MA0037")
				.setMnemonic("MA0037"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление о выдаче разрешения на ввод объекта капитального строительства в эксплуатацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о выдаче разрешения на ввод объекта капитального строительства в эксплуатацию")
				.setCode("MINSTROYRF_MA0038")
				.setMnemonic("MA0038"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление о выдаче дубликата разрешения на ввод объекта капитального строительства в эксплуатацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о выдаче дубликата разрешения на ввод объекта капитального строительства в эксплуатацию")
				.setCode("MINSTROYRF_MA0039")
				.setMnemonic("MA0039"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление об исправлении допущенных опечаток и ошибок в разрешении на ввод объекта капитального строительства в эксплуатацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления об исправлении допущенных опечаток и ошибок в разрешении на ввод объекта капитального строительства в эксплуатацию")
				.setCode("MINSTROYRF_MA0040")
				.setMnemonic("MA0040"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление о внесении изменений в разрешение на ввод объекта капитального строительства в эксплуатацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о внесении изменений в разрешение на ввод объекта капитального строительства в эксплуатацию")
				.setCode("MINSTROYRF_MA0041")
				.setMnemonic("MA0041"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление о выдаче разрешения на проведение работ по созданию искусственного земельного участка")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о выдаче разрешения на проведение работ по созданию искусственного земельного участка")
				.setCode("MINSTROYRF_MA0042")
				.setMnemonic("MA0042"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление о выдаче дубликата разрешения на проведение работ по созданию искусственного земельного участка")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о выдаче дубликата разрешения на проведение работ по созданию искусственного земельного участка")
				.setCode("MINSTROYRF_MA0043")
				.setMnemonic("MA0043"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление об исправлении допущенных опечаток и ошибок в разрешении на проведение работ по созданию искусственного земельного участка")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления об исправлении допущенных опечаток и ошибок в разрешении на проведение работ по созданию искусственного земельного участка")
				.setCode("MINSTROYRF_MA0044")
				.setMnemonic("MA0044"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление о выдаче разрешения на ввод искусственно созданного земельного участка в эксплуатацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о выдаче разрешения на ввод искусственно созданного земельного участка в эксплуатацию")
				.setCode("MINSTROYRF_MA0045")
				.setMnemonic("MA0045"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление о выдаче дубликата разрешения на ввод искусственно созданного земельного участка в эксплуатацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о выдаче дубликата разрешения на ввод искусственно созданного земельного участка в эксплуатацию")
				.setCode("MINSTROYRF_MA0046")
				.setMnemonic("MA0046"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление об исправлении допущенных опечаток и ошибок в разрешении на ввод искусственно созданного земельного участка в эксплуатацию")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления об исправлении допущенных опечаток и ошибок в разрешении на ввод искусственно созданного земельного участка в эксплуатацию")
				.setCode("MINSTROYRF_MA0047")
				.setMnemonic("MA0047"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на прохождение аттестации на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления на прохождение аттестации на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setCode("MINSTROYRF_MA0048")
				.setMnemonic("MA0048"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать документы, необходимые для получения государственной услуги по аттестации на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования документов, необходимых для получения государственной услуги по аттестации на право подготовки заключений экспертизы проектной документации и (или) результатов инженерных изысканий")
				.setCode("MINSTROYRF_MA0049")
				.setMnemonic("MA0049"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на прохождение переаттестации на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления на прохождение переаттестации на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setCode("MINSTROYRF_MA0050")
				.setMnemonic("MA0050"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на продление срока действия квалификационного аттестата на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления на продление срока действия квалификационного аттестата на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setCode("MINSTROYRF_MA0051")
				.setMnemonic("MA0051"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление о принятии решения о подготовке документации по планировке территории")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о принятии решения о подготовке документации по планировке территории")
				.setCode("MINSTROYRF_MA0059")
				.setMnemonic("MA0059"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать документы, необходимые для получения подуслуги по продлению срока действия квалификационного аттестата на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования документов, необходимых для получения государственной услуги по аттестации на право подготовки заключений экспертизы проектной документации и (или) результатов инженерных изысканий")
				.setCode("MINSTROYRF_MA0052")
				.setMnemonic("MA0052"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на перенос даты аттестации на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления на перенос даты аттестации на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setCode("MINSTROYRF_MA0053")
				.setMnemonic("MA0053"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на перенос даты переаттестации на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления на перенос даты переаттестации на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setCode("MINSTROYRF_MA0054")
				.setMnemonic("MA0054"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на получение дубликата квалификационного аттестата на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления на получение дубликата квалификационного аттестата на право подготовки заключений экспертизы проектной документации и (или) экспертизы результатов инженерных изысканий")
				.setCode("MINSTROYRF_MA0055")
				.setMnemonic("MA0055"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на исправление опечатки и (или) ошибки в сведениях, указанных в квалификационном аттестате на право подготовки заключений экспертизы проектной документации и (или) результатов инженерных изысканий")
				.setIsLeaf(true)
				.setDescription("Полномочие дает право подписи и согласования заявления на исправление опечатки и(или) ошибки в сведениях, указанных в квалификационном аттестате на право подготовки заключений экспертизы проектной документации и(или) результатов инженерных изысканий")
				.setCode("MINSTROYRF_MA0056")
				.setMnemonic("MA0056"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на согласование специальных технических условий для разработки проектной документации на объект капитального строительства")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления на согласование специальных технических условий для разработки проектной документации на объект капитального строительства")
				.setCode("MINSTROYRF_MA0057")
				.setMnemonic("MA0057"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать документы, необходимые для получения государственной услуги по согласованию специальных технических условий для разработки проектной документации на объект капитального строительства")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования документов, необходимых для получения государственной услуги по согласованию специальных технических условий для разработки проектной документации на объект капитального строительства")
				.setCode("MINSTROYRF_MA0058")
				.setMnemonic("MA0058"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать документы, необходимые для получения государственной услуги по принятию решения о подготовке документации по планировке территории")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования документов, необходимых для получения государственной услуги по принятию решения о подготовке документации по планировке территории")
				.setCode("MINSTROYRF_MA0060")
				.setMnemonic("MA0060"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на получение дубликата приказа о принятии решения о подготовке документации по планировке территории")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления на получение дубликата приказа о принятии решения о подготовке документации по планировке территории")
				.setCode("MINSTROYRF_MA0061")
				.setMnemonic("MA0061"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на исправление опечатки и (или) ошибки в сведениях, указанных в приказе о принятии решения о подготовке документации по планировке территории")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления на исправление опечатки и (или) ошибки в сведениях, указанных в приказе о принятии решения о подготовке документации по планировке территории")
				.setCode("MINSTROYRF_MA0062")
				.setMnemonic("MA0062"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление об утверждении документации по планировке территории")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления об утверждении документации по планировке территории")
				.setCode("MINSTROYRF_MA0063")
				.setMnemonic("MA0063"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать документы, необходимые для получения государственной услуги по утверждению документации по планировке территории")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования документов, необходимых для получения государственной услуги по утверждению документации по планировке территории")
				.setCode("MINSTROYRF_MA0064")
				.setMnemonic("MA0064"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на получение дубликата приказа об утверждении документации по планировке территории")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления на получение дубликата приказа об утверждении документации по планировке территории")
				.setCode("MINSTROYRF_MA0065")
				.setMnemonic("MA0065"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на исправление опечатки и (или) ошибки в сведениях, указанных в приказе об утверждении документации по планировке территории")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления на исправление опечатки и (или) ошибки в сведениях, указанных в приказе об утверждении документации по планировке территории")
				.setCode("MINSTROYRF_MA0066")
				.setMnemonic("MA0066"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление о внесении изменений в документацию по планировке территории")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о внесении изменений в документацию по планировке территории")
				.setCode("MINSTROYRF_MA0067")
				.setMnemonic("MA0067"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать документы, необходимые для получения государственной услуги по внесению изменений в документацию по планировке территории")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования документов, необходимых для получения государственной услуги по внесению изменений в документацию по планировке территории")
				.setCode("MINSTROYRF_MA0068")
				.setMnemonic("MA0068"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на получение дубликата приказа о внесении изменений в документацию по планировке территории")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления о внесении изменений в документацию по планировке территории")
				.setCode("MINSTROYRF_MA0069")
				.setMnemonic("MA0069"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103658.getId())
				.setDepartment("Подписывать и согласовывать заявление на исправление опечатки и (или) ошибки в сведениях, указанных в приказе о внесении изменений в документацию по планировке территории")
				.setIsLeaf(true)
				.setDescription("Данное полномочие дает доверенному лицу право подписи и согласования заявления на исправление опечатки и (или) ошибки в сведениях, указанных в приказе о внесении изменений в документацию по планировке территории")
				.setCode("MINSTROYRF_MA0070")
				.setMnemonic("MA0070"));


		Myexample3261 e1103728 = new Myexample3261()
				.setParentId(e1103657.getId())
				.setDepartment("Градостроительство и перепланировка (регионы)")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103728")
				.setMnemonic("GRP_1103728");
		repository3261.save(e1103728);

		repository3261.save(new Myexample3261()
				.setParentId(e1103728.getId())
				.setDepartment("Признание садового дома жилым и жилого садовым")
				.setIsLeaf(true)
				.setDescription("Полномочия направлять заявление о признании садового дома жилым и жилого садовым")
				.setCode("MNSTR01_VLGHOUSE")
				.setMnemonic("VLGHOUSE"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103728.getId())
				.setDepartment("Проведение переустройства и (или) перепланировки помещения")
				.setIsLeaf(true)
				.setDescription("Полномочия проводить согласование проведения переустройства и (или) перепланировки помещения в многоквартирном доме")
				.setCode("OTHER_FTRDVLP")
				.setMnemonic("FTRDVLP"));

		repository3261.save(new Myexample3261()
				.setParentId(e1103728.getId())
				.setDepartment("Выдача градостроительного плана земельного участка")
				.setIsLeaf(true)
				.setDescription("Полномочия направлять заявление на выдачу градостроительного плана земельного участка, исправление технической ошибки и получение дубликата")
				.setCode("MNSTR01_URBPLOTR")
				.setMnemonic("URBPLOTR"));

		Myexample3261 e1103732 = new Myexample3261()
				.setDepartment("Полномочия Минтруда")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103732")
				.setMnemonic("GRP_1103732");
		repository3261.save(e1103732);

		repository3261.save(new Myexample3261()
				.setParentId(e1103732.getId())
				.setDepartment("Подписание кадровых документов от лица работодателя")
				.setIsLeaf(true)
				.setDescription("")
				.setCode("MINTRUD_MIN01")
				.setMnemonic("MIN01"));


		Myexample3261 e1103734 = new Myexample3261()
				.setDepartment("Полномочия Минпромторга")
				.setIsLeaf(false)
				.setDescription("")
				.setCode("GRP_1103734")
				.setMnemonic("GRP_1103734");
		repository3261.save(e1103734);

		repository3261.save(new Myexample3261()
				.setParentId(e1103734.getId())
				.setDepartment("Выполнять юридически значимые действия в Государственная информационная система промышленности (ГИСП)")
				.setIsLeaf(true)
				.setDescription("Выполнять юридически значимые действия в ГИСП, в т.ч. регистрация как пользователя ГИСП, подписание электронных документов в ГИСП")
				.setCode("RFTR_GISPer Brown")
				.setIsLeaf(true));

		Myexample3261 myexample5 = new Myexample3261()
				.setParentId(e1103734.getId())
				.setDepartment("QA team")
				.setIsLeaf(false);

		repository3261.save(myexample5);
		Myexample3261 myexample6 =
				new Myexample3261()
						.setParentId(myexample5.getId())
						.setDepartment("Anna White")
						.setIsLeaf(true);
		repository3261.save(myexample6);

		Myexample3261 myexample7 = new Myexample3261()
				.setParentId(myexample6.getId())
				.setDepartment("Support team")
				.setIsLeaf(false);
		repository3261.save(myexample7);

		repository3261.save(new Myexample3261()
				.setParentId(myexample7.getId())
				.setDepartment("Kim Foster")
				.setIsLeaf(true));

		Myexample3261 myexample9 = new Myexample3261()
				.setDepartment("Finance Department")
				.setIsLeaf(false);
		repository3261.save(myexample9);
		Myexample3261 myexample10 = new Myexample3261()
				.setParentId(myexample9.getId())
				.setDepartment("Accounting team")
				.setIsLeaf(false);
		repository3261.save(myexample10);
		repository3261.save(new Myexample3261()
				.setParentId(myexample10.getId())
				.setDepartment("Robert Clark")
				.setIsLeaf(true));

		repository3261.save(new Myexample3261()
				.setParentId(myexample10.getId())
				.setDepartment("Maria Lopez")
				.setIsLeaf(true));


		Myexample3261 parent1 = new Myexample3261()
				.setDepartment("IT Department")
				.setIsLeaf(false);

		repository3261.save(parent1);

		repository3263.save(new Myexample3263());
	}

}