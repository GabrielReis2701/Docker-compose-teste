package org.example.testejavaandangulalogin.service;

import org.example.testejavaandangulalogin.entity.Usuario;
import org.example.testejavaandangulalogin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public void inserirUsuario(Usuario usuario){

        repository.save(usuario);
    }

}
