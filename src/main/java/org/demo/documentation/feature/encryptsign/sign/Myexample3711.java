package org.demo.documentation.feature.encryptsign.sign;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.encryptsign.sign.enums.StatusSignEnum;


@Entity
@Table(name = "MYEXAMPLE3711")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class Myexample3711 extends BaseEntity {


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

	@Enumerated(value = EnumType.STRING)
	@Column
	private StatusSignEnum status = StatusSignEnum.NO_SIGNED;
}