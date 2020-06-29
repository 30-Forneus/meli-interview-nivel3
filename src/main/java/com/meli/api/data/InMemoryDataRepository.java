package com.meli.api.data;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.tinkerpop.gremlin.structure.T;

public class InMemoryDataRepository {
	
	private static final Map<String, T> DATA_STORE = new ConcurrentHashMap<String, T> ();

	public T create(final T entity) {
		String id = UUID.randomUUID().toString();
		return DATA_STORE.put(id, entity);
	}

	public T retrieve(final Object id) {
		return DATA_STORE.get(id);
	}

	public T update(final T newValues, final String outdatedId) {
		return DATA_STORE.put(outdatedId, newValues);
	}

	public void delete(final Object id) {
		DATA_STORE.remove(id);
		
	}
}
