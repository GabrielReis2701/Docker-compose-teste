package org.example.testejavaandangulalogin.repository;

import org.example.testejavaandangulalogin.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
