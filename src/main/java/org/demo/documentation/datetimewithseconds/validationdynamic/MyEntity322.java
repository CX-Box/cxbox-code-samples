package org.demo.documentation.datetimewithseconds.validationdynamic;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
// 322
// 322
//  DataTimeWithSeconds validation field level dynamic",

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity322 extends BaseEntity {

	@Column
	private LocalDateTime customField;

	@Column
	private LocalDateTime customFieldAdditional;

}