package com.proyecto.mycommunity.models.dao;

import com.proyecto.mycommunity.models.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura, Long>{

}