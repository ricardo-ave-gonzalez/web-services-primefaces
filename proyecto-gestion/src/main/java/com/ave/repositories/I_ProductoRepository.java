package com.ave.repositories;

import java.util.List;
import java.util.stream.Stream;

import com.ave.entities.Producto;

public interface I_ProductoRepository {
	
	void save(Producto producto);
	void remove(Producto producto);
	
	List<Producto> getAll(); 
    
    default Stream<Producto> getStream() {
        return getAll().stream();
    }

    default Producto getById(String id) {
        return getAll()
                .stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElse(new Producto());
    }
}
