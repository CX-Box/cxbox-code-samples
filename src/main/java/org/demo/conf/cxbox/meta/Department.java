/*
 * © OOO "SI IKS LAB", 2022-2023
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.demo.conf.cxbox.meta;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.io.Serializable;


/*@Audited* is not audited by default in 4.0.0 cxbox major. Please audit on project level*/
@Entity
@Getter
@Setter
@Table(name = "DEPT")
public class Department extends BaseEntity implements Serializable {

	private String shortName;

	private String fullName;

	private String code;

}
