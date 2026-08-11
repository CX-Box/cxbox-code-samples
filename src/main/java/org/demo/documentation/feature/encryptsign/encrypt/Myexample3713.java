package org.demo.documentation.feature.encryptsign.encrypt;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.encryptsign.encrypt.enums.StatusEncryptEnum;


@Entity
@Table(name = "MYEXAMPLE3713")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class Myexample3713 extends BaseEntity {

	@Column(name = "file_name")
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

	@Enumerated(value = EnumType.STRING)
	@Column
	private StatusEncryptEnum status = StatusEncryptEnum.NO_ENCRYPT;
}