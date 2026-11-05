package org.demo.documentation.feature.drilldown.drilldownfilter;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.model.core.dao.JpaDao;
import org.demo.documentation.feature.drilldown.drilldownfilter.dictionary.CustomField4300Dictionary;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300DictionaryEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300MultipleSelectEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300RadioEnum;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MyEntity4300TestDataLoadService {

	private final MyEntityWithDrilldown4300Repository repository;

	private final InternalAuthorizationService authzService;

	private final JpaDao dao;

	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();

		List<MyEntity4300PickList> pls = List.of(
				MyEntity4300PickList.builder().value("PL1 R&D + QA").build(),
				MyEntity4300PickList.builder().value("PL2").build(),
				MyEntity4300PickList.builder().value("PL3").build(),
				MyEntity4300PickList.builder().value("PL4").build(),
				MyEntity4300PickList.builder().value("PL5").build(),
				MyEntity4300PickList.builder().value("PL6").build(),
				MyEntity4300PickList.builder().value("PL7").build(),
				MyEntity4300PickList.builder().value("PL8").build(),
				MyEntity4300PickList.builder().value("PL9").build(),
				MyEntity4300PickList.builder().value("PL10").build()
		);
		dao.saveAll(pls);
		List<MyEntity4300InlinePickList> ipls = List.of(
				MyEntity4300InlinePickList.builder().value("IPL1 R&D + QA").build(),
				MyEntity4300InlinePickList.builder().value("IPL2").build(),
				MyEntity4300InlinePickList.builder().value("IPL3").build(),
				MyEntity4300InlinePickList.builder().value("IPL4").build(),
				MyEntity4300InlinePickList.builder().value("IPL5").build(),
				MyEntity4300InlinePickList.builder().value("IPL6").build(),
				MyEntity4300InlinePickList.builder().value("IPL7").build(),
				MyEntity4300InlinePickList.builder().value("IPL8").build(),
				MyEntity4300InlinePickList.builder().value("IPL9").build(),
				MyEntity4300InlinePickList.builder().value("IPL10").build()
		);
		dao.saveAll(ipls);

		List<MyEntity4300Multivalue> mvs = List.of(
				MyEntity4300Multivalue.builder().value("MV1 R&D + QA").build(),
				MyEntity4300Multivalue.builder().value("MV2").build(),
				MyEntity4300Multivalue.builder().value("MV3").build(),
				MyEntity4300Multivalue.builder().value("MV4").build(),
				MyEntity4300Multivalue.builder().value("MV5").build(),
				MyEntity4300Multivalue.builder().value("MV6").build(),
				MyEntity4300Multivalue.builder().value("MV7").build(),
				MyEntity4300Multivalue.builder().value("MV8").build(),
				MyEntity4300Multivalue.builder().value("MV9").build(),
				MyEntity4300Multivalue.builder().value("MV10").build()
		);
		dao.saveAll(mvs);
		List<MyEntity4300MultivalueHover> mvh = List.of(
				MyEntity4300MultivalueHover.builder().value("MVH1 R&D + QA").build(),
				MyEntity4300MultivalueHover.builder().value("MVH2").build(),
				MyEntity4300MultivalueHover.builder().value("MVH3").build(),
				MyEntity4300MultivalueHover.builder().value("MVH4").build(),
				MyEntity4300MultivalueHover.builder().value("MVH5").build(),
				MyEntity4300MultivalueHover.builder().value("MVH6").build(),
				MyEntity4300MultivalueHover.builder().value("MVH7").build(),
				MyEntity4300MultivalueHover.builder().value("MVH8").build(),
				MyEntity4300MultivalueHover.builder().value("MVH9").build(),
				MyEntity4300MultivalueHover.builder().value("MVH10").build()
		);
		dao.saveAll(mvh);

		for (int i = 1; i <= 5; i++) {
			buildEntity(i, pls, ipls, mvs, mvh);
			MyEntity4300SecondEntity myEntity4300SecondEntity = buildEntityWithDrillDown(i, pls, ipls, mvs, mvh);
			MyEntity4300FirstEntity myEntity4300FirstEntity = MyEntity4300FirstEntity.builder().secondEntity(myEntity4300SecondEntity).build();
			dao.save(myEntity4300FirstEntity);
			MyEntity4300WithDriildownKey myEntity4300WithDriildownKey = MyEntity4300WithDriildownKey.builder().firstEntity(myEntity4300FirstEntity).build();
			dao.save(myEntity4300WithDriildownKey);
		}
		for (int i = 6; i <= 10; i++) {
			buildEntity(i, pls, ipls, mvs, mvh);
		}
		buildEntity();
	}

	private MyEntityWithDrilldown4300 buildEntity(int idx, List<MyEntity4300PickList> pls, List<MyEntity4300InlinePickList> ipls,
												  List<MyEntity4300Multivalue> mvs, List<MyEntity4300MultivalueHover> mvh) {

		int choice = (idx - 1) % 5;
		int related = idx <= 5 ? 5 - idx : idx % 5 + 5;
		var selections = new HashSet<>(Collections.singletonList(CustomField4300MultipleSelectEnum.values()[choice]));
		if (idx > 5) {
			selections.add(CustomField4300MultipleSelectEnum.values()[(choice + 1) % 5]);
		}
		MyEntityWithDrilldown4300 build = MyEntityWithDrilldown4300.builder()
				.customField(idx == 1 ? "Field_1 R&D + QA" : idx == 2 ? "Field_2 \"Quoted\" = 100%" : "Field_" + idx)
				.customField4300Dictionary(CustomField4300Dictionary.getAllStaticValues().get(choice))
				.customFieldHint(idx == 1 ? "Hint: R&D + QA 100% = \"ok\" \\ путь" : "Hint_" + idx)
				.customFieldText(idx == 1 ? "Text: R&D + QA 100% = \"ok\" \\ путь" : "Text content " + idx)
				.customFieldHidden(ipls.get(idx - 1).getValue())

				.customFieldMoney(idx == 4 ? null : idx == 5 ? 0.0 : 100.00 * idx + (idx > 5 ? 0.25 : 0))        // 100, 200, 300…
				.customFieldPercent(idx == 4 ? null : idx == 5 ? 0L : idx > 5 ? 35L + idx * 5L : idx * 20L) // 20, 40, 60…
				.customFieldNumber(idx == 4 ? null : idx == 5 ? 0L : idx * 150L) // 150, 300, 450…

				.customFieldDate(LocalDateTime.of(2025, 7, 1 + idx, 9, 25, 55))
				.customFieldDateTime(LocalDateTime.of(2025, 7, 10 + idx, 16, 0))
				.customFieldDateTimeWithSeconds(LocalDateTime.of(2025, 7, 15 + idx, 9, 25, 55))

					.customFieldCheckbox(idx == 4 ? null : idx != 5 && idx % 2 == 1)
				.customFieldFileUpload(idx == 1 ? "report R&D + QA 100%.pdf" : "file_" + idx + ".pdf")
				.customFieldFileUploadId(String.valueOf(1000 + idx))

				.customFieldRadio(CustomField4300RadioEnum.values()[choice])
				.customFieldDictionary(CustomField4300DictionaryEnum.values()[choice])
				.customFieldMultipleSelect(selections)

				.multivalueList(Arrays.asList(mvs.get(idx - 1), mvs.get(related)))
				.multivalueHoverList(Arrays.asList(mvh.get(idx - 1), mvh.get(related)))
				.myEntity4300PickList(pls.get(idx - 1))
				.myEntity4300InlinePickList(ipls.get(idx - 1))
				.build();
		dao.save(build);
		return build;
	}

	private MyEntity4300SecondEntity buildEntityWithDrillDown(int idx, List<MyEntity4300PickList> pls, List<MyEntity4300InlinePickList> ipls,
															  List<MyEntity4300Multivalue> mvs, List<MyEntity4300MultivalueHover> mvh) {

		MyEntity4300SecondEntity build = MyEntity4300SecondEntity.builder()
				.customField("Field_" + idx)
				.customFieldHint("Hint_" + idx)
				.customFieldText("Text content " + idx)
				.customFieldHidden("Hidden_" + idx)

				.customFieldMoney(100.00 * idx)        // 100, 200, 300…
				.customFieldPercent((idx * 20L)) // 20, 40, 60…
				.customFieldNumber((idx * 150L)) // 150, 300, 450…

				.customFieldDate(LocalDateTime.of(2025, 7, 1 + idx, 9, 25, 55))
				.customFieldDateTime(LocalDateTime.of(2025, 7, 10 + idx, 16, 0))
				.customFieldDateTimeWithSeconds(LocalDateTime.of(2025, 7, 15 + idx, 9, 25, 55))

				.customFieldCheckbox(idx % 2 == 1)     // TRUE для нечётных
				.customFieldFileUpload("file_" + idx + ".pdf")
				.customFieldFileUploadId(String.valueOf(1000 + idx))

				.customFieldRadio(CustomField4300RadioEnum.values()[idx - 1])
				.customFieldDictionary(CustomField4300DictionaryEnum.values()[idx - 1])
				.customFieldMultipleSelect(new HashSet<>(Collections.singletonList(CustomField4300MultipleSelectEnum.values()[idx - 1])))
				.customField4300Dictionary(CustomField4300Dictionary.getAllStaticValues().get(idx - 1))
				.multivalueList(Arrays.asList(mvs.get(idx - 1), mvs.get(5 - idx)))
				.multivalueHoverList(Arrays.asList(mvh.get(idx - 1), mvh.get(5 - idx)))
				.myEntity4300PickList(pls.get(idx - 1))
				.myEntity4300InlinePickList(ipls.get(idx - 1))
				.build();
		dao.save(build);
		return build;
	}

	private MyEntity4300PostActionWithCustomBuilder buildEntity() {
		MyEntity4300PostActionWithCustomBuilder build = MyEntity4300PostActionWithCustomBuilder.builder()
				.build();
		dao.save(build);
		return build;
	}

}
