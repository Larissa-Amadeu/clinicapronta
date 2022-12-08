package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Animal;
import modelo.Consulta;
import util.JsfUtil;


@Named
@ViewScoped
public class GerenciarConsultaControle implements Serializable {
    private Consulta consulta; 
    private Dao<Consulta> daoConsulta;
    private Dao<Animal> daoAnimal;

    
    private Animal animal;
    private List<Consulta> listaConsulta;
    private List<Animal> listaAnimal;
    private Boolean mostraPopupAlteracao;

    
    @PostConstruct
    public void iniciar() {
     //   daoTutor = new Dao(Tutor.class);
        daoAnimal = new Dao(Animal.class);
        consulta = new Consulta();
        daoConsulta= new Dao(Consulta.class);
        listaConsulta = daoConsulta.listarTodos();
        listaAnimal = daoAnimal.listarTodos();
        animal = new Animal();
        
    }
    

    public void alterar(Consulta selecionado) {
        this.consulta = selecionado; 
        mostraPopupAlteracao = true;
    }

    
    public void excluir(Consulta excluido) {
        daoConsulta.excluir(excluido.getCodigo());
        listaConsulta = daoConsulta.listarTodos();
    }
    
    public void fecharPopupAlteracao(){
        mostraPopupAlteracao = false; 
    }
    
    public String salvar() {
        daoConsulta.inserir(consulta);
        consulta = new Consulta(); // limpa os campos 
        JsfUtil.mostrarSucesso("Consulta cadastrada");
        listaConsulta = daoConsulta.listarTodos(); // atualiza tabela 
        return null;
    }

    public String salvarAlteracao(){
        daoConsulta.alterar(consulta);
        animal = new Animal(); // limpa os campos 
        JsfUtil.mostrarSucesso("Consulta alterada");
        listaAnimal = daoAnimal.listarTodos(); // atualiza tabela 
        return null; 
    }
    
    
    
    public List<Animal> getListaAnimais() {
        return listaAnimal;
    }

    public void setListaAnimais(List<Animal> listaAnimal) {
        this.listaAnimal = listaAnimal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal tutor) {
        this.animal = tutor;
    }
    public Boolean getMostraEstadoPagamento() {
        return mostraEstadoPagamento;
    }

    public void setMostraEstadoPagamento(Boolean mostraEstadoPagamento) {
        this.mostraEstadoPagamento = mostraEstadoPagamento;
    }
    
    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

     public List<Consulta> getListaConsulta() {
        return listaConsulta;
    }

    public void setListaConsulta(List<Consulta> listaConsulta) {
        this.listaConsulta = listaConsulta;
    }

    public Boolean getMostraPopupAlteracao() {
        return mostraPopupAlteracao;
    }

    public void setMostraPopupAlteracao(Boolean mostraPopupAlteracao) {
        this.mostraPopupAlteracao = mostraPopupAlteracao;
    }
    private Boolean mostraEstadoPagamento;
     
//    public Boolean getMostraEstadoPagamento() {
//        return mostraEstadoPagamento;
//    }
//
//    public void setMostraEstadoPagamento(Boolean mostraEstadoPagamento) {
//        this.mostraEstadoPagamento = mostraEstadoPagamento;
//    }
 public List<Animal> getListaAnimal() {
        return listaAnimal;
    }

}
