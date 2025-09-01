package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public String getNome(){
        return nome;
    }
    public Double getMultaDiaria(){
        return multaDiaria;
    }
    public Integer getQtdLivros(){
        return qtdLivros;
    }
    public Boolean getAtiva(){
        return ativa;
    }
    public void setNome(String nome){
        this.nome = nome;
    }



    public Biblioteca(String nome, Double multaDiaria){
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        qtdLivros = 0;
        ativa = true;
    }

    public void registrarLivro(Integer quantidade){

        if(quantidade != null && quantidade > 0 && ativa){
            qtdLivros += quantidade;
        }
    }

    public Integer emprestar(Integer quantidade){
        if(ativa && quantidade != null && quantidade > 0 && quantidade <= qtdLivros ){
            qtdLivros -= quantidade;
            return quantidade;
        }else {
            return null;
        }
    }
    public Integer devolver(Integer quantidade){
        if(ativa && quantidade != null && quantidade > 0 ){
            qtdLivros += quantidade;
        }
        return quantidade;
    }
    public Integer desativar(){
        if(ativa == false){
            return null;
        }else{
            ativa = false;
            Integer qtdAnterior = qtdLivros;
            qtdLivros *= 0;
            return qtdAnterior;
        }
    }
    public void transferir(Biblioteca destino, Integer quantidade){
        if(ativa && destino.ativa && quantidade != null && quantidade > 0 && quantidade <= qtdLivros){
            qtdLivros -= quantidade;
            destino.qtdLivros += quantidade;
        }
    }
    public Boolean reajustarMulta(Double percentual){
        if(percentual != null && percentual > 0){
            multaDiaria *= (1.0 + (percentual));
            return true;
        }else{
            return false;
        }
    }
}
