package org.demo.documentation.additional.signunsavedrecord;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyEntity1348 extends BaseEntity {

	@Column(name = "file_name")
	private String file;

	@Column
	private String fileId;

	@Column
	private String fileSign;

	@Column
	private String fileSignId;

	@Column
	private String fileEncrypt;

	@Column
	private String fileEncryptId;

	@Column
	private String notes;

	@Column
	private Boolean signed;

}
