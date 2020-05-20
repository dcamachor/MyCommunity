package com.proyecto.mycommunity.models.dao;

import com.proyecto.mycommunity.models.entity.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura, Long>{

    @Query("select f from Factura f join fetch f.persona p join fetch f.items l join fetch l.producto where f.id=?1")
    public Factura fetchByIdWithPersonaWhithItemFacturaWithProducto(Long id);

}