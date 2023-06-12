package web.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "disciplina")
public class Disciplinas implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String codDisciplina;
    private String nome;
    private String horario;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professores professor;

    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private Estudantes estudante;

}