package org.demo.documentation.fileupload.validationannotation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity170 extends BaseEntity {

	@Column
	private String customField;

	@Column
	private String customFieldId;

}