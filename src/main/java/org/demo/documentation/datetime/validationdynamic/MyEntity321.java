package org.demo.documentation.datetime.validationdynamic;

import java.time.LocalDateTime;
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
public class MyEntity321 extends BaseEntity {

	@Column
	private LocalDateTime customField;

	@Column
	private LocalDateTime customFieldAdditional;

}