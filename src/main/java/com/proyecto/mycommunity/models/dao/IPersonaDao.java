package com.proyecto.mycommunity.models.dao;

import com.proyecto.mycommunity.models.entity.Persona;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IPersonaDao extends PagingAndSortingRepository<Persona, Integer>{


}
