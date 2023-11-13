
package com.senacUC14.bibliotecaErnaWurth.controller;


import com.senacUC14.bibliotecaErnaWurth.model.Aluno;
import com.senacUC14.bibliotecaErnaWurth.model.Devolucao;
import com.senacUC14.bibliotecaErnaWurth.model.Emprestimo;
import com.senacUC14.bibliotecaErnaWurth.model.Livro;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BibliotecaController {
    
    private List<Aluno> listaAlunos = new ArrayList<>();
    private List<Livro> listaLivros = new ArrayList<>();
    private List<Emprestimo> listaEmprestimo = new ArrayList<>();
    private List<Devolucao> listaDevolucoes = new ArrayList<>();
   
    
    
    @GetMapping("/")//eh definido a URL que sera chamada
    public String inicio(){
        return "index";//sera apontado o arquivo HTML que sera chamado
    }
    
    @GetMapping("/cadastrarAluno")//eh definido a URL que sera chamada
    public String cadastrarAluno(Model model){
        model.addAttribute("aluno", new Aluno());
        return "cadastroAluno";//sera apontado o arquivo HTML que sera chamado
    }
    
    @GetMapping("/cadastrarLivro")//eh definido a URL que sera chamada
    public String cadastrarLivro(Model model){
        model.addAttribute("livro", new Livro());
        return "cadastroLivro";//sera apontado o arquivo HTML que sera chamado
    }
    
    @GetMapping("/devolucaoLivro")//eh definido a URL que sera chamada
    public String devolucaoLivro(Model model){
        model.addAttribute("devolucao", new Devolucao());
        return "devolucaoLivro";//sera apontado o arquivo HTML que sera chamado
    }
    
    @GetMapping("/emprestimoLivro")//eh definido a URL que sera chamada
    public String emprestimoLivro(Model model){
        model.addAttribute("emprestimo", new Emprestimo());
        model.addAttribute("listaLivros", listaLivros); 
        model.addAttribute("listaAlunos", listaAlunos);
        return "emprestimoLivro";//sera apontado o arquivo HTML que sera chamado
    }
    
    @GetMapping("/listaLivro")//eh definido a URL que sera chamada
    public String listaLivro(Model model){
        model.addAttribute("listaLivro", listaLivros);
        return "listaLivro";//sera apontado o arquivo HTML que sera chamado
    }
    
    @GetMapping("/listaAlunos")//eh definido a URL que sera chamada
    public String listaAluno(Model model){
        model.addAttribute("listaAlunos", listaAlunos);
        return "listaAlunos";//sera apontado o arquivo HTML que sera chamado
    }
    
    @GetMapping("/listaEmprestimo")
    public String listaEmprestimo(Model model) {
        model.addAttribute("listaEmprestimo", listaEmprestimo);
        return "listaEmprestimo";
    }
    
    @GetMapping("/listaDevolucao")//eh definido a URL que sera chamada
    public String listaDevolucoes(Model model) {
        model.addAttribute("listaDevolucoes", listaDevolucoes);
        return "listaDevolucao";//sera apontado o arquivo HTML que sera chamado
    }
    
    @PostMapping("/gravarAluno")
    public String processarFormularioAluno(@Valid @ModelAttribute("aluno") Aluno aluno, BindingResult result) {
        if (result.hasErrors()) {
        // Se houver erros de validação, você pode redirecionar para a página de formulário com uma mensagem de erro.
        return "cadastroAluno";
    }
        aluno.setId(listaAlunos.size() + 1);
        listaAlunos.add(aluno);
        return "redirect:/listaAlunos";
    }
    
    @PostMapping("/gravarLivro")
    public String processarFormularioLivro(@ModelAttribute Livro livro, Model model){
        livro.setId(listaLivros.size() + 1);
        livro.setStatusLivro("Na Biblioteca");
        listaLivros.add(livro);
        return "redirect:/listaLivro";
    }
    
    @PostMapping("/gravarEmprestimo")
    public String processarFormularioEmprestimo(@ModelAttribute Emprestimo emprestimo, Model model) {
        emprestimo.setId(listaEmprestimo.size() + 1);

        Livro livroAssociado = emprestimo.getLivro();
        livroAssociado.setStatusLivro("Emprestado");
        listaEmprestimo.add(emprestimo);

        return "redirect:/listaEmprestimo";
    }
    
    @GetMapping("/locarLivro")
    public String emprestimoLivros(Model model, @RequestParam String id){
        Integer idLivro = Integer.parseInt(id);
        
        Livro registroEncontrado = new Livro();
        for(Livro l: listaLivros){
           if(l.getId()==idLivro) {
               registroEncontrado = l;
               break;
           }
        }
        model.addAttribute("livro", registroEncontrado);
        return "emprestimoLivro";
        
    }
    
     @GetMapping("/registrarDevolucao")
    public String registrarDevolucao(Model model) {
        model.addAttribute("devolucao", new Devolucao());
        model.addAttribute("listaEmprestimos", listaEmprestimo);
        model.addAttribute("listaLivros", listaLivros);
        model.addAttribute("listaAlunos", listaAlunos);
        return "registrarDevolucao";
    }

    @PostMapping("/gravarDevolucao")
    public String gravarDevolucao(@ModelAttribute Devolucao devolucao) {
        // Lógica para processar o formulário de devolução
        // Certifique-se de validar e manipular os dados conforme necessário

        // Exemplo: definir ID e adicionar à lista de devoluções
        devolucao.setId(listaDevolucoes.size() + 1);
        listaDevolucoes.add(devolucao);

        // Você pode querer atualizar o estado do livro (por exemplo, marcá-lo como "Devolvido")
        Livro livroDevolvido = devolucao.getLivro();
        livroDevolvido.setStatusLivro("Devolvido");

        return "redirect:/listaDevolucoes";
    }
}
