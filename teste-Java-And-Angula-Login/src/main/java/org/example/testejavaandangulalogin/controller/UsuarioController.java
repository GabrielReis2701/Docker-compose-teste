package org.example.testejavaandangulalogin.controller;

import org.example.testejavaandangulalogin.entity.Usuario;
import org.example.testejavaandangulalogin.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    final
    UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?>inserirUsuario(@RequestBody Usuario usuario){

        usuarioService.inserirUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
}
