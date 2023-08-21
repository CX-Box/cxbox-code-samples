package org.demo.documentation.datetime.placeholder;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimePlaceholder
@Entity
@Table(name = "DateTimePlaceholderEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimePlaceholderEntity extends BaseEntity {


	@Column
	private LocalDateTime customField;

}