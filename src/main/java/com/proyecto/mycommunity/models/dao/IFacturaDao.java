package com.proyecto.mycommunity.models.dao;

import com.proyecto.mycommunity.models.entity.Factura;
import com.proyecto.mycommunity.models.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFacturaDao extends CrudRepository<Factura, Long>{

    @Query("select p from Producto p where p.nombre like %?1%")
    public List<Producto> findByNombre(String term);

    public List<Producto> findByNombreLikeIgnoreCase(String term);

}