package org.demo.documentation.datetime.ro;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeEdit
@Entity
@Table(name = "DateTimeEdit")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeEdit extends BaseEntity {

	private LocalDateTime customField;

}