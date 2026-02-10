package org.demo.documentation.other.fileConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "MYEXAMPLE_6151")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class Myexample6151 extends BaseEntity {


	@Column
	private String fileName;

	@Column
	private String fileNameId;

	@Column
	private String fileNameNAF;

	@Column
	private String fileNameNAFId;
}