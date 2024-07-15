package org.demo.documentation.fields.hidden.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "HiddenBasic")
@Getter
@Setter
@NoArgsConstructor
public class HiddenBasic extends BaseEntity {

	private String customField;

}