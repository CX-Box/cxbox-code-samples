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

package org.demo.conf.cxbox.extention.multivaluePrimary;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;

import java.io.IOException;

class CustomMultivalueFieldSingleValueDeserializer extends JsonDeserializer<MultivalueFieldSingleValue> {

	@Override
	public MultivalueFieldSingleValue deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		JsonNode node = jsonParser.readValueAsTree();
		MultivalueFieldSingleValue multivalueFieldSingleValue = new MultivalueFieldSingleValue(
				node.get("id").asText(),
				node.get("value").asText()
		);
		if (node.get("options") != null && node.get("options").isObject()) {
			node.get("options").fields().forEachRemaining(
					option -> multivalueFieldSingleValue.getOptions().put(option.getKey(), option.getValue().asText())
			);
		}
		return multivalueFieldSingleValue;
	}

}
