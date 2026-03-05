package org.demo.documentation.feature.microservice.microservicestoringdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3137;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.enums.CountryEnum;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.enums.RegionEnum;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3137DTO implements Serializable {

	private RegionEnum region;
	private CountryEnum country;
	private String product;
	private String descriptionProduct;
	private Long money;
	private String street;
	private String id;
	private String customField;
	private String customFieldNew;
	private LocalDateTime customFieldDateTime;
	private Double customFieldDouble;
	private String parentId;
	private String fileName;
	private String fileNameId;
	private MultivalueField files;

	public MyExample3137DTO(MyEntity3137 entity) {
		this.id = entity.getId().toString();
		this.parentId = entity.getParentId();
		this.customField = entity.getCustomField();
		this.customFieldNew = entity.getCustomFieldNew();
		this.customFieldDateTime = entity.getCustomFieldDateTime();
		this.customFieldDouble = entity.getCustomFieldDouble();
		this.region = entity.getRegion();
		this.country = entity.getCountry();
		this.product = entity.getProduct();
		this.descriptionProduct = entity.getDescriptionProduct();
		this.money = entity.getMoney();
		this.street = entity.getStreet();
		this.fileName = entity.getFileName();
		this.fileNameId = entity.getFileNameId();
		this.files = entity.getFiles();
	}
}
