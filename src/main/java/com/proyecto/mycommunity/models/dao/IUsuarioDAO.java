package com.proyecto.mycommunity.models.dao;

import com.proyecto.mycommunity.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDAO extends CrudRepository<Usuario, Integer> {

    public Usuario findByRut(Integer rut);

}
