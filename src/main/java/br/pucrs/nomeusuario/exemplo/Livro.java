package br.pucrs.nomeusuario.exemplo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Livro {

    @Id
    private int id;

    private String titulo;
    private String autor;
    private int ano;

    // construtor vazio
    public Livro() {
    }

    // construtor completo
    public Livro(int id, String titulo, String autor, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}