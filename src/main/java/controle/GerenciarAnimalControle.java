package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Animal;
import modelo.Tutor;
import util.JsfUtil;


@Named
@ViewScoped
public class GerenciarAnimalControle implements Serializable {
    private Dao<Tutor> daoTutor;
    private List<Tutor> listaTutores;
    private List<Animal> listaAnimal;
    private Boolean mostraPopupAlteracao;

    public List<Animal> getListaAnimal() {
        return listaAnimal;
    }

    public void setListaAnimal(List<Animal> listaAnimal) {
        this.listaAnimal = listaAnimal;
    }

    public Boolean getMostraPopupAlteracao() {
        return mostraPopupAlteracao;
    }

    public void setMostraPopupAlteracao(Boolean mostraPopupAlteracao) {
        this.mostraPopupAlteracao = mostraPopupAlteracao;
    }
    private Animal animal; 
    private Dao<Animal> daoAnimal;
  
    
    @PostConstruct
    public void iniciar() {
        daoTutor = new Dao(Tutor.class);
        daoAnimal = new Dao(Animal.class);
        listaTutores = daoTutor.listarTodos();
        listaAnimal = daoAnimal.listarTodos();
        animal = new Animal();
        
    }
    

    public void alterar(Animal selecionado) {
        this.animal = selecionado; 
        mostraPopupAlteracao = true;
    }

    
    public void excluir(Animal excluido) {
        daoAnimal.excluir(excluido.getCodigo());
        listaAnimal = daoAnimal.listarTodos();
    }
    
    public void fecharPopupAlteracao(){
        mostraPopupAlteracao = false; 
    }
    
    public String salvar() {
        daoAnimal.inserir(animal);
        animal = new Animal(); // limpa os campos 
        JsfUtil.mostrarSucesso("Animal cadastrado");
        listaAnimal = daoAnimal.listarTodos(); // atualiza tabela 
        return null;
    }

    public String salvarAlteracao(){
        daoAnimal.alterar(animal);
        animal = new Animal(); // limpa os campos 
        JsfUtil.mostrarSucesso("Usuário alterado");
        listaAnimal = daoAnimal.listarTodos(); // atualiza tabela 
        return null; 
    }
    
    
    
    public List<Tutor> getListaTutores() {
        return listaTutores;
    }

    public void setListaTutores(List<Tutor> listaTutores) {
        this.listaTutores = listaTutores;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal tutor) {
        this.animal = tutor;
    }
       
}