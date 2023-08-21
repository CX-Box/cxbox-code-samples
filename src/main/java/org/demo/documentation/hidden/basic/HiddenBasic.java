package org.demo.documentation.hidden.basic;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//hiddenBasic
@Entity
@Table(name = "HiddenBasic")
@Getter
@Setter
@NoArgsConstructor
public class HiddenBasic extends BaseEntity {

	private String customField;

}