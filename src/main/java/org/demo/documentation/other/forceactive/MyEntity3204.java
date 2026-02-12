package org.demo.documentation.other.forceactive;

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
public class MyEntity3204 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldFA;
	@Column
	private String customFieldDrillDown;
}