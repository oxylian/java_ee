/**  Copyright 2016 Sébastian Dejonghe
  *
  *  Licensed under the Apache License, Version 2.0 (the "License");
  *  you may not use this file except in compliance with the License.
  *  You may obtain a copy of the License at
  *
  *      http://www.apache.org/licenses/LICENSE-2.0
  *
  *   Unless required by applicable law or agreed to in writing, software
  *   distributed under the License is distributed on an "AS IS" BASIS,
  *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  *   See the License for the specific language governing permissions and
  *   limitations under the License.
  **/

package com.oxylian.java_ee.hibernate;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static <T> T fromString(String string, Class<T> clazz) {
		try {
			return objectMapper.readValue(string, clazz);
		} catch (IOException e) {
			throw new IllegalArgumentException("The given string value: " + string + " cannot be transformed to Json object");
		}
	}

	public static String toString(Object value) {
		try {
			return objectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException("The given Json object value: " + value + " cannot be transformed to a String");
		}
	}

	public static JsonNode toJsonNode(String value) {
		try {
			return objectMapper.readTree(value);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T clone(T value) {
		return fromString(toString(value), (Class<T>) value.getClass());
	}
}