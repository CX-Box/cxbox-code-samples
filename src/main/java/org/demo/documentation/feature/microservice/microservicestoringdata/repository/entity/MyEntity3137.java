package org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.enums.CountryEnum;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.enums.RegionEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MyEntity3137 extends BaseEntity {

	private String customField;
	private String customFieldNew;
	private LocalDateTime customFieldDateTime;
	private Double customFieldDouble;
	private String parentId;
	@Enumerated(value = EnumType.STRING)
	private RegionEnum region;
	@Enumerated(value = EnumType.STRING)
	private CountryEnum country;
	private String product;
	private String descriptionProduct;
	private Long money;
	private String street;
	private String fileName;
	private String fileNameId;
	private MultivalueField files;
	@JoinTable(name = "MyEntity3137_MyEntity3137Files",
			joinColumns = @JoinColumn(name = "MyEntity3137_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3137Files_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3137Files> filesMV = new ArrayList<>();

}