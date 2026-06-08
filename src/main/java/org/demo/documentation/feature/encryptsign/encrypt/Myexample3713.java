package org.demo.documentation.feature.encryptsign.encrypt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "MYEXAMPLE3713")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class Myexample3713 extends BaseEntity {


	@Column
	private String file;

	@Column
	private String fileId;

	@Column
	private String fileEncryptAndSign;

	@Column
	private String fileEncryptAndSignId;

	@Column
	private String fileEncrypt;

	@Column
	private String fileEncryptId;

	@Column
	private String fileSign;

	@Column
	private String fileSignId;
}