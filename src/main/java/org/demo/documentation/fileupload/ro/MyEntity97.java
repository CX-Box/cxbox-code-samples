package org.demo.documentation.fileupload.ro;

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
public class MyEntity97 extends BaseEntity {

	@Column
	private String customField;

	@Column
	private String customFieldId;

}