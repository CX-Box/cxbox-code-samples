package org.demo.documentation.fields.datetime.color;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "DateTimeColorCalc")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeColorCalc extends BaseEntity {

	private LocalDateTime customField;

}