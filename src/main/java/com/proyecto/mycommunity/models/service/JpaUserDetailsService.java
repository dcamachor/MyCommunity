package com.proyecto.mycommunity.models.service;

import com.proyecto.mycommunity.models.dao.IUsuarioDAO;
import com.proyecto.mycommunity.models.entity.Usuario;
import com.proyecto.mycommunity.models.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String rut) throws UsernameNotFoundException {

        Usuario usuario = usuarioDAO.findByRut(Integer.parseInt(rut));

        if (usuario == null) {
            logger.error("Error login: no existe el usuario '" + rut + "'");
            throw new UsernameNotFoundException("Usuario" + rut + "no existe en el sistema");
        }

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

        for (Role role : usuario.getRoles()) {
            logger.info("Role: ".concat(role.getRole()));
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }

        if (roles.isEmpty()) {
            logger.error("Error login: '" + rut + "' no tiene roles asignados!");
            throw new UsernameNotFoundException("Error login: '" + rut + "' no tiene roles asignados!");
        }

        return new User(Integer.toString(usuario.getRut()), usuario.getPassword(), usuario.isEstado(), true, true, true, roles);
    }

}
