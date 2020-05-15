package com.proyecto.mycommunity.models.service;

import java.util.List;

import com.proyecto.mycommunity.models.entity.Factura;
import com.proyecto.mycommunity.models.entity.Persona;
import com.proyecto.mycommunity.models.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPersonaService {

    public List<Persona> findAll();

    public Page<Persona> findAll(Pageable pageable);

    public void save(Persona persona);

    public Persona findOne(int rut);

    public Persona fetchByIdWithFacturas(int rut);

    public void delete(int rut);

    //modificar para agregar direccion

    public List<Producto> findByNombre(String term);

    public void saveFactura(Factura factura);

    public Producto findProductoById(Long id);

    public Factura findFacturaById(Long id);

    public void deleteFactura(Long id);

    public Factura fetchFacturaByIdWithPersonaWhithItemFacturaWithProducto(Long id);

}
