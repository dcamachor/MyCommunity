package com.proyecto.mycommunity.models.service;

import java.util.List;

import com.proyecto.mycommunity.models.dao.IPersonaDao;
import com.proyecto.mycommunity.models.entity.Factura;
import com.proyecto.mycommunity.models.entity.Persona;
import com.proyecto.mycommunity.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.mycommunity.models.dao.IFacturaDao;
import com.proyecto.mycommunity.models.dao.IProductoDao;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaDao personaDao;

    @Autowired
    private IProductoDao productoDao;

    @Autowired
    private IFacturaDao facturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Persona persona) {
        personaDao.save(persona);

    }

    @Override
    @Transactional(readOnly = true)
    public Persona findOne(int rut) {
        return personaDao.findById(rut).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona fetchByIdWithFacturas(int rut) {
        return personaDao.fetchByIdWithFacturas(rut);
    }

    @Override
    @Transactional
    public void delete(int rut) {
        personaDao.deleteById(rut);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Persona> findAll(Pageable pageable) {
        return personaDao.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByNombre(String term) {
        return productoDao.findByNombreLikeIgnoreCase("%" + term + "%");
    }

    @Override
    @Transactional
    public void saveFactura(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findProductoById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findFacturaById(Long id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteFactura(Long id) {
        facturaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura fetchFacturaByIdWithPersonaWhithItemFacturaWithProducto(Long id) {
        return facturaDao.fetchByIdWithPersonaWhithItemFacturaWithProducto(id);
    }


}
