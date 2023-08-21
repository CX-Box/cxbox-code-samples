package org.demo.documentation.fileupload.filtration;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity99 extends BaseEntity {

	@Column
	private String customField;

	@Column
	private String customFieldId;

}