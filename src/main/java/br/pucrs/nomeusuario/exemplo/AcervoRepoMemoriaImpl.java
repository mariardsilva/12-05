package br.pucrs.nomeusuario.exemplo;

import java.util.*;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;

@Repository
public class AcervoRepoMemoriaImpl implements IAcervoRepository {
    private List<Livro> livros;

    public AcervoRepoMemoriaImpl(){
        livros = new ArrayList<>();

        livros.add(new Livro(110, "Aprendendo Java", "Maria da Silva", 2015));
        livros.add(new Livro(120, "Spring-Boot", "Jose de Souza", 2020));
        livros.add(new Livro(130, "Principios SOLID", "Pedro da Silva", 2023));
        livros.add(new Livro(140, "Padroes de Projeto", "JoanaMoura", 2023));
        livros.add(new Livro(150, "Teste Unitario", "Pedro da Silva", 2024));  
    }

    @Override
    public List<Livro>getLivros(){
        return livros;
    }

    @Override
    public boolean removeLivro(int id) {
        List<Livro> tmp = livros.stream()
            .filter(livro->livro.getId() == id)
            .toList();
        return livros.removeAll(tmp);
    }

    @Override
    public List<String> getTitulos() {
        return livros.stream().map(Livro::getTitulo).collect(Collectors.toList());
    }

    @Override
    public List<String> getAutores() {
        return livros.stream().map(Livro::getAutor).distinct().collect(Collectors.toList());
    }

    @Override
    public List<Livro> getLivrosDoAutor(String autor) {
        return livros.stream().filter(livro -> livro.getAutor().equals(autor)).collect(Collectors.toList());
    }

    @Override
    public List<Livro> getLivrosDoAutor(String autor, int ano) {
        return livros.stream().filter(livro -> livro.getAutor().equals(autor) && livro.getAno() == ano).collect(Collectors.toList());
    }

    @Override
    public Livro getLivroTitulo(String titulo) {
        return livros.stream().filter(livro -> livro.getTitulo().equals(titulo)).findFirst().orElse(null);
    }

    @Override
    public boolean cadastraLivroNovo(Livro livro) {
        return livros.add(livro);
    }
}
