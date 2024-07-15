package org.demo.documentation.fields.datetime.ro;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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