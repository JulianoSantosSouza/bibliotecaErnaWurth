
package com.senacUC14.bibliotecaErnaWurth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Devolucao")
public class Devolucao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int id;

    private Date dataRetorno;

    @ManyToOne
    private Emprestimo emprestimo;

    @ManyToOne
    private Livro livro;

    @ManyToOne
    private Aluno aluno;
    
}
