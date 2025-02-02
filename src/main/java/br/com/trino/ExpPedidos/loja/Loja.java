package br.com.trino.ExpPedidos.loja;

import jakarta.persistence.*;
import jakarta.validation.ValidationException;

@Table(name = "loja")
@Entity(name = "Loja")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private long cnpj;
    private boolean ativo;

    public Loja(String nome, int cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.ativo = true;
    }

    public Loja() {}

    public Loja(DadosCadastroLoja dados) {
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizarLoja dados) {

        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.cnpj() != 0) {
            this.cnpj = dados.cnpj();
        }
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public long getCnpj() {
        return cnpj;
    }

    public boolean getAtivo() {
        return this.ativo;
    }
    public void desabilitar() {
        this.ativo = false;
    }
    public void habilitar(){
        this.ativo = true;
    }
    public void validadorAtivo(boolean dadosAtivo){
        if (dadosAtivo == false){
            throw new ValidationException("Loja está desabilitada!");
        }
    }
}
