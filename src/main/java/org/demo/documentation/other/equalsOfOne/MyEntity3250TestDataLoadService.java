package org.demo.documentation.other.equalsOfOne;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.model.core.dao.JpaDao;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOne;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOneManyToMany;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOneOneToMany;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOneOneToOne;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyEntity3250TestDataLoadService {

	private final JpaDao dao;

	private final InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		oneToOneInit();
		oneToManyInit();

		manyToManyInit();
	}

	private void manyToManyInit() {
		List<MyExample3250OneToOne> myExample3250OneToOnes = List.of(
				MyExample3250OneToOne.builder()
						.build(),
				MyExample3250OneToOne.builder()
						.build(),
				MyExample3250OneToOne.builder()
						.build()
		);
		dao.saveAll(myExample3250OneToOnes);
		List<MyExample3250> myExample3250s = List.of(
				MyExample3250.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(0))
						.build(),
				MyExample3250.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(1))
						.build(),
				MyExample3250.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(2))
						.build()
		);
		dao.saveAll(myExample3250s);
		List<MyExample3250OneToOneManyToMany> myExample3250OneToOneManyToManies = List.of(
				MyExample3250OneToOneManyToMany.builder()
						.dictionary(MyExample3250Dictionary.FIFTH_DICT)
						.build(),
				MyExample3250OneToOneManyToMany.builder()
						.dictionary(MyExample3250Dictionary.FIRST_DICT)
						.build(),
				MyExample3250OneToOneManyToMany.builder()
						.dictionary(MyExample3250Dictionary.SECOND_DICT)
						.build(),
				MyExample3250OneToOneManyToMany.builder()
						.dictionary(MyExample3250Dictionary.THIRD_DICT)
						.build()
		);
		dao.saveAll(myExample3250OneToOneManyToManies);
		List<MyExample3250LinkManyToMany> myExample3250LinkManyToManies = List.of(
				MyExample3250LinkManyToMany.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(0))
						.myExample3250OneToOneManyToMany(myExample3250OneToOneManyToManies.get(0))
						.build(),
				MyExample3250LinkManyToMany.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(0))
						.myExample3250OneToOneManyToMany(myExample3250OneToOneManyToManies.get(1))
						.build(),
				MyExample3250LinkManyToMany.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(1))
						.myExample3250OneToOneManyToMany(myExample3250OneToOneManyToManies.get(0))
						.build(),
				MyExample3250LinkManyToMany.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(2))
						.myExample3250OneToOneManyToMany(myExample3250OneToOneManyToManies.get(2))
						.build()
		);
		dao.saveAll(myExample3250LinkManyToManies);
		List<MyExample3250Multivalue> myExample3250Multivalues = List.of(
				MyExample3250Multivalue.builder()
						.name("many-to-many 1")
						.build(),
				MyExample3250Multivalue.builder()
						.name("many-to-many 2")
						.build(),
				MyExample3250Multivalue.builder()
						.name("many-to-many 2")
						.build()
		);
		dao.saveAll(myExample3250Multivalues);
		List<MyExample3250LinkMultivalue> myExample3250LinkMultivalues = List.of(
				MyExample3250LinkMultivalue.builder()
						.myExample3250OneToOneManyToMany(myExample3250OneToOneManyToManies.get(0))
						.myExample3250Multivalue(myExample3250Multivalues.get(0))
						.build(),
				MyExample3250LinkMultivalue.builder()
						.myExample3250OneToOneManyToMany(myExample3250OneToOneManyToManies.get(0))
						.myExample3250Multivalue(myExample3250Multivalues.get(1))
						.build(),
				MyExample3250LinkMultivalue.builder()
						.myExample3250OneToOneManyToMany(myExample3250OneToOneManyToManies.get(1))
						.myExample3250Multivalue(myExample3250Multivalues.get(2))
						.build(),
				MyExample3250LinkMultivalue.builder()
						.myExample3250OneToOneManyToMany(myExample3250OneToOneManyToManies.get(2))
						.myExample3250Multivalue(myExample3250Multivalues.get(1))
						.build()
		);
		dao.saveAll(myExample3250LinkMultivalues);

		List<MyExample3250ElementCollectionDataEntity> myExample3250ElementCollectionDataEntities = List.of(
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneManyToMany(myExample3250OneToOneManyToManies.get(0))
						.value(MyExample3250ElementCollectionData.FIRST)
						.build(),
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneManyToMany(myExample3250OneToOneManyToManies.get(0))
						.value(MyExample3250ElementCollectionData.SECOND)
						.build(),
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneManyToMany(myExample3250OneToOneManyToManies.get(1))
						.value(MyExample3250ElementCollectionData.THIRD)
						.build(),
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneManyToMany(myExample3250OneToOneManyToManies.get(1))
						.value(MyExample3250ElementCollectionData.FIRST)
						.build()
		);
		dao.saveAll(myExample3250ElementCollectionDataEntities);
	}

	private void oneToManyInit() {

		List<MyExample3250OneToOne> myExample3250OneToOnes = List.of(
				MyExample3250OneToOne.builder()
						.build(),
				MyExample3250OneToOne.builder()
						.build(),
				MyExample3250OneToOne.builder()
						.build()
		);
		dao.saveAll(myExample3250OneToOnes);

		List<MyExample3250OneToOneOneToMany> myExample3250OneToOneOneToManies = List.of(
				MyExample3250OneToOneOneToMany.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(0))
						.dictionary(MyExample3250Dictionary.FIRST_DICT)
						.build(),
				MyExample3250OneToOneOneToMany.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(1))
						.dictionary(MyExample3250Dictionary.FIRST_DICT)
						.build(),
				MyExample3250OneToOneOneToMany.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(1))
						.dictionary(MyExample3250Dictionary.SECOND_DICT)
						.build(),

				MyExample3250OneToOneOneToMany.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(2))
						.dictionary(MyExample3250Dictionary.THIRD_DICT)
						.build()
		);
		dao.saveAll(myExample3250OneToOneOneToManies);

		List<MyExample3250> myExample3250s = List.of(
				MyExample3250.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(0))
						.build(),
				MyExample3250.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(1))
						.build(),
				MyExample3250.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(2))
						.build()
		);
		dao.saveAll(myExample3250s);

		List<MyExample3250Multivalue> myExample3250Multivalues = List.of(
				MyExample3250Multivalue.builder()
						.name("one-to-many 1")
						.build(),
				MyExample3250Multivalue.builder()
						.name("one-to-many 2")
						.build(),
				MyExample3250Multivalue.builder()
						.name("one-to-many 3")
						.build()
		);
		dao.saveAll(myExample3250Multivalues);

		List<MyExample3250LinkMultivalue> myExample3250LinkMultivalues = List.of(
				MyExample3250LinkMultivalue.builder()
						.myExample3250Multivalue(myExample3250Multivalues.get(0))
						.myExample3250OneToOneOneToMany(myExample3250OneToOneOneToManies.get(0))
						.build(),
				MyExample3250LinkMultivalue.builder()
						.myExample3250Multivalue(myExample3250Multivalues.get(1))
						.myExample3250OneToOneOneToMany(myExample3250OneToOneOneToManies.get(0))
						.build(),
				MyExample3250LinkMultivalue.builder()
						.myExample3250Multivalue(myExample3250Multivalues.get(2))
						.myExample3250OneToOneOneToMany(myExample3250OneToOneOneToManies.get(0))
						.build(),
				MyExample3250LinkMultivalue.builder()
						.myExample3250Multivalue(myExample3250Multivalues.get(0))
						.myExample3250OneToOneOneToMany(myExample3250OneToOneOneToManies.get(1))
						.build()
		);
		dao.saveAll(myExample3250LinkMultivalues);
		List<MyExample3250ElementCollectionDataEntity> myExample3250ElementCollectionDataEntities = List.of(
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneOneToMany(myExample3250OneToOneOneToManies.get(0))
						.value(MyExample3250ElementCollectionData.FIRST)
						.build(),
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneOneToMany(myExample3250OneToOneOneToManies.get(0))
						.value(MyExample3250ElementCollectionData.SECOND)
						.build(),
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneOneToMany(myExample3250OneToOneOneToManies.get(0))
						.value(MyExample3250ElementCollectionData.THIRD)
						.build(),
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneOneToMany(myExample3250OneToOneOneToManies.get(1))
						.value(MyExample3250ElementCollectionData.THIRD)
						.build(),
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneOneToMany(myExample3250OneToOneOneToManies.get(2))
						.value(MyExample3250ElementCollectionData.FOURTH)
						.build(),
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneOneToMany(myExample3250OneToOneOneToManies.get(3))
						.value(MyExample3250ElementCollectionData.FOURTH)
						.build()
		);
		dao.saveAll(myExample3250ElementCollectionDataEntities);
	}

	private void oneToOneInit() {
		List<MyExample3250OneToOneOneToOne> myExample3250OneToOneOneToOnes = List.of(
				MyExample3250OneToOneOneToOne.builder()
						.dictionary(MyExample3250Dictionary.FIRST_DICT)
						.build(),
				MyExample3250OneToOneOneToOne.builder()
						.dictionary(MyExample3250Dictionary.SECOND_DICT)
						.build(),
				MyExample3250OneToOneOneToOne.builder()
						.dictionary(MyExample3250Dictionary.THIRD_DICT)
						.build()
		);
		dao.saveAll(myExample3250OneToOneOneToOnes);

		List<MyExample3250OneToOne> myExample3250OneToOnes = List.of(
				MyExample3250OneToOne.builder()
						.myExample3250OneToOneOneToOne(myExample3250OneToOneOneToOnes.get(0))
						.build(),
				MyExample3250OneToOne.builder()
						.myExample3250OneToOneOneToOne(myExample3250OneToOneOneToOnes.get(1))
						.build(),
				MyExample3250OneToOne.builder()
						.myExample3250OneToOneOneToOne(myExample3250OneToOneOneToOnes.get(2))
						.build()
		);
		dao.saveAll(myExample3250OneToOnes);
		List<MyExample3250> myExample3250s = List.of(
				MyExample3250.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(0))
						.build(),
				MyExample3250.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(1))
						.build(),
				MyExample3250.builder()
						.myExample3250OneToOne(myExample3250OneToOnes.get(2))
						.build()
		);
		dao.saveAll(myExample3250s);
		List<MyExample3250Multivalue> myExample3250Multivalues = List.of(
				MyExample3250Multivalue.builder()
						.name("one-to-one 1")
						.build(),
				MyExample3250Multivalue.builder()
						.name("one-to-one 2")
						.build(),
				MyExample3250Multivalue.builder()
						.name("one-to-one 2")
						.build()
		);
		dao.saveAll(myExample3250Multivalues);
		List<MyExample3250LinkMultivalue> myExample3250LinkMultivalues = List.of(
				MyExample3250LinkMultivalue.builder()
						.myExample3250Multivalue(myExample3250Multivalues.get(0))
						.myExample3250OneToOneOneToOne(myExample3250OneToOneOneToOnes.get(0))
						.build(),
				MyExample3250LinkMultivalue.builder()
						.myExample3250Multivalue(myExample3250Multivalues.get(1))
						.myExample3250OneToOneOneToOne(myExample3250OneToOneOneToOnes.get(0))
						.build(),
				MyExample3250LinkMultivalue.builder()
						.myExample3250Multivalue(myExample3250Multivalues.get(2))
						.myExample3250OneToOneOneToOne(myExample3250OneToOneOneToOnes.get(0))
						.build(),
				MyExample3250LinkMultivalue.builder()
						.myExample3250Multivalue(myExample3250Multivalues.get(0))
						.myExample3250OneToOneOneToOne(myExample3250OneToOneOneToOnes.get(1))
						.build()
		);
		dao.saveAll(myExample3250LinkMultivalues);

		List<MyExample3250ElementCollectionDataEntity> myExample3250ElementCollectionDataEntities = List.of(
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneOneToOne(myExample3250OneToOneOneToOnes.get(0))
						.value(MyExample3250ElementCollectionData.FIRST)
						.build(),
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneOneToOne(myExample3250OneToOneOneToOnes.get(0))
						.value(MyExample3250ElementCollectionData.SECOND)
						.build(),
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneOneToOne(myExample3250OneToOneOneToOnes.get(0))
						.value(MyExample3250ElementCollectionData.THIRD)
						.build(),
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneOneToOne(myExample3250OneToOneOneToOnes.get(1))
						.value(MyExample3250ElementCollectionData.THIRD)
						.build(),
				MyExample3250ElementCollectionDataEntity.builder()
						.myExample3250OneToOneOneToOne(myExample3250OneToOneOneToOnes.get(2))
						.value(MyExample3250ElementCollectionData.FOURTH)
						.build()
		);
		dao.saveAll(myExample3250ElementCollectionDataEntities);
	}

}