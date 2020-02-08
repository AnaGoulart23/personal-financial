package com.financeiro.personalfinancials.model;

import java.util.HashMap;
import java.util.Map;

public class GenericJson {

	private Map<String, String> data = new HashMap<String, String>();

	public GenericJson(final String message) {
		this.addNewJsonField("message", message);
	}

	public GenericJson(final String[] keysValues) {
		this.addNewJsonFields(keysValues);
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(final Map<String, String> data) {
		this.data = data;
	}

	/**
	 * Adds a value into json.
	 *
	 * @param key   - The key of the value.
	 * @param value - The value of the key.
	 * @return False if the key or the value is null or an white space (The key
	 *         value won't be add) and true if the key and value has a value (the
	 *         key value will be add).
	 */
	public boolean addNewJsonField(final String key, final String value) {
		if (!key.isEmpty() && key != null && !value.isEmpty() && value != null) {
			this.getData().put(key, value);
			return true;
		}

		return false;
	}

	/**
	 * Adds key values into json based on an vector. The vector needs to be pair,
	 * that is, each key has one value.
	 *
	 * @param keysValues - String vector with pair values.
	 * @return False if the vector is odd (the values won't be add) and True if the
	 *         vector is pair (the values will be add).
	 */
	public boolean addNewJsonFields(final String[] keysValues) {
		if (keysValues.length > 0 && keysValues.length % 2 == 0) {

			for (int i = 0; i < keysValues.length; i += 2) {
				addNewJsonField(keysValues[i], keysValues[i + 1]);
			}

			return true;
		}

		return false;
	}

}
