package br.com.trino.ExpPedidos.produto;

import br.com.trino.ExpPedidos.diasProducao.DiasSemana;
import jakarta.persistence.*;
import jakarta.validation.ValidationException;

import java.util.Arrays;
import java.util.List;

@Table(name = "produto")
@Entity(name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int min_producao;
    private int qtd_embalado;
    private boolean ativo;

    public Produto(DiasSemana dia_producao, int qtd_embalado, String nome, int min_producao) {
        this.qtd_embalado = qtd_embalado;
        this.nome = nome;
        this.min_producao = min_producao;
        this.ativo = true;
    }

    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.min_producao = dados.min_producao();
        this.qtd_embalado = dados.qtd_embalado();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizarProduto dados){

        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.min_producao() != 0){
            this.min_producao = dados.min_producao();
        }
        if (dados.qtd_embalado() != 0){
            this.qtd_embalado = dados.qtd_embalado();
        }
    }


    public Produto() {}

    public long getId() {return id;}

    public String getNome() {return nome;}

    public int getMin_producao() {return min_producao;}

    public int getQtd_embalado() {return qtd_embalado;}

    public boolean getAtivo() {return this.ativo;}

    public void desabilitar() {
        this.ativo = false;
    }
    public void habilitar() {
        this.ativo = true;
    }
    public void validadorAtivo(boolean dadosAtivo){
        if(dadosAtivo == false){
            throw new ValidationException("Produto está desabilitado!");
        }
    }
}
