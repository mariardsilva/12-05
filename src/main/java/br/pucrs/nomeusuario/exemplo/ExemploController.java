package br.pucrs.nomeusuario.exemplo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExemploController {
    private IAcervoRepository acervo;

    @Autowired
    public ExemploController(IAcervoRepository acervo) {
        this.acervo = acervo;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return acervo.getLivros();
    }

    @GetMapping("/livros/titulo/{titulo}")
    public Livro getLivroByTitulo(@PathVariable String titulo) {
        return acervo.getLivroTitulo(titulo);
    }

    @GetMapping("/livros/autor/{autor}")
    public List<Livro> getLivrosByAutor(@PathVariable String autor) {
        return acervo.getLivrosDoAutor(autor);
    }
}
