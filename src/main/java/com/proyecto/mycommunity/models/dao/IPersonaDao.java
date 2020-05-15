package com.proyecto.mycommunity.models.dao;

import com.proyecto.mycommunity.models.entity.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IPersonaDao extends PagingAndSortingRepository<Persona, Integer> {


    @Query("select p from Persona p left join fetch p.facturas f where p.rut=?1")
    public Persona fetchByIdWithFacturas(int rut);

}