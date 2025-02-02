package br.com.trino.ExpPedidos.controller;

import br.com.trino.ExpPedidos.usuario.DadosAtualizarUsuario;
import br.com.trino.ExpPedidos.usuario.DadosCadastroUsuario;
import br.com.trino.ExpPedidos.usuario.Usuario;
import br.com.trino.ExpPedidos.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados){
        var usuario = new Usuario(dados);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Cadastrado!");
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarUsuario dados){
        var usuario = usuarioRepository.getReferenceById(dados.id());
        usuario.validadorAtivo(usuario.getAtivo());
        usuario.atualizarInformacoes(dados);
        return ResponseEntity.ok("Atualizado!");
    }
    @GetMapping
    public ResponseEntity listar(){
        var usuario = usuarioRepository.findAll();
        return ResponseEntity.ok(usuario);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desabilitar(@PathVariable Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.desabilitar();
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity habilitar(@PathVariable Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.habilitar();
        return ResponseEntity.noContent().build();
    }
}
