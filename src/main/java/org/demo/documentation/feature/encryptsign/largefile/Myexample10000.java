package org.demo.documentation.feature.encryptsign.largefile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Table(name = "MYEXAMPLE10000")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class Myexample10000 extends BaseEntity {

	@Column
	private String description;

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
	private String lastOperation;

}
