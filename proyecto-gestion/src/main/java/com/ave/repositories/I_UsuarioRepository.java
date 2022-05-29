package com.ave.repositories;

import java.util.List;
import java.util.stream.Stream;

import com.ave.entities.Usuario;

public interface I_UsuarioRepository {

    List<Usuario> getAll();                        // select * from usuarios

    default Stream<Usuario> getStream() {
        return getAll().stream();
    }

    default Usuario getById(String id) {
        return getAll()
                .stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElse(new Usuario());
    }
}
