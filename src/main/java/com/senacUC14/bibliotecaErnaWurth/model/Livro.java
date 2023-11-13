
package com.senacUC14.bibliotecaErnaWurth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    public int id;
    @NotBlank(message = "Campo Nome do livro é obrigatório")
    public String nomeLivro;
    @NotBlank(message = "Campo Categroria do Livro é obrigatório")
    public String categoriaLivro;
    public String statusLivro;
    public int numeroPaginas;
    @NotBlank(message = "Campo data de aquisição é obrigatório")
    public Date dataAquisicao;
    @NotBlank(message = "Campo número de registro é obrigatório")
    public String numeroRegistro;
    public String numeroRegistroVirtual;
    @NotBlank(message = "Campo Nome do autor é obrigatório")
    public String autorLivro;
    public String editoraLivro;
}
