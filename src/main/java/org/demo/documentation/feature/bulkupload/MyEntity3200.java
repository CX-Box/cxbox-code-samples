package org.demo.documentation.feature.bulkupload;

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
public class MyEntity3200 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldFile;
	@Column
	private String customFieldFileId;
}