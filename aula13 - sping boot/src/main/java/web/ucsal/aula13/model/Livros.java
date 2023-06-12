package web.ucsal.aula13.model;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Livros implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titulo;
    private String autor;
    private String editora;
    private String anoPublicacao;
    private String isbn;

}
