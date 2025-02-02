package br.com.trino.ExpPedidos.usuario;

import jakarta.persistence.*;
import jakarta.validation.ValidationException;

import java.util.Arrays;
import java.util.List;

@Table(name = "usuario")
@Entity(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String senha;
    @Enumerated(EnumType.STRING)
    private NvlAcesso nivel_acesso;
    private boolean ativo;

    public Usuario(String nome, String senha, NvlAcesso nivel_acesso) {
        this.nome = nome;
        this.senha = senha;
        this.nivel_acesso = nivel_acesso;
        this.ativo = true;
    }

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.senha = dados.senha();
        this.nivel_acesso = dados.nivel_acesso();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizarUsuario dados){

        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.senha() != null){
            this.senha = dados.senha();
        }
        List<NvlAcesso> list = Arrays.asList(NvlAcesso.values());
        for (int i = 0; i < list.size(); i++) {
            if (dados.nivel_acesso() == list.get(i)) {
                this.nivel_acesso = dados.nivel_acesso();
                break;
            }
        }
    }
    public void habilitar(){
        this.ativo = true;
    }
    public void validadorAtivo(boolean dadosAtivo){
        if(dadosAtivo == false){
            throw new ValidationException("Usuario está desabilitado!");
        }
    }

    public void desabilitar(){
        this.ativo = false;
    }

    public Usuario() {}

    public long getId() {return id;}

    public String getNome() {return nome;}

    public String getSenha() {return senha;}

    public NvlAcesso getNivel_acesso() {return nivel_acesso;}

    public boolean getAtivo() {return ativo;}
}
