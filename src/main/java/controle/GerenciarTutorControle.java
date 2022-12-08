package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Tutor;
import util.JsfUtil;

@Named
@ViewScoped
public class GerenciarTutorControle implements Serializable {
    
    private Tutor tutor;
    private Dao<Tutor> dao;
    private List<Tutor> lista;
    private Boolean mostraPopupAlteracao;

    @PostConstruct
    public void iniciar() {
        tutor = new Tutor();
        dao = new Dao(Tutor.class);
        setLista(dao.listarTodos());
        mostraPopupAlteracao = false; 
    }

    public void alterar(Tutor selecionado) {
        this.tutor = selecionado; 
        mostraPopupAlteracao = true;
    }

    
    public void excluir(Tutor excluido) {
        dao.excluir(excluido.getCodigo());
        lista = dao.listarTodos();
    }
    
    public void fecharPopupAlteracao(){
        mostraPopupAlteracao = false; 
    }
    
    public String salvar() {
        dao.inserir(tutor);
        tutor = new Tutor(); // limpa os campos 
        JsfUtil.mostrarSucesso("Usuário cadastrado");
        lista = dao.listarTodos(); // atualiza tabela 
        return null;
    }

    public String salvarAlteracao(){
        dao.alterar(tutor);
        tutor = new Tutor(); // limpa os campos 
        JsfUtil.mostrarSucesso("Usuário alterado");
        lista = dao.listarTodos(); // atualiza tabela 
        return null; 
    }
    
    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public List<Tutor> getLista() {
        return lista;
    }

    public void setLista(List<Tutor> lista) {
        this.lista = lista;
    }

    public Boolean getMostraPopupAlteracao() {
        return mostraPopupAlteracao;
    }

    public void setMostraPopupAlteracao(Boolean mostraPopupAlteracao) {
        this.mostraPopupAlteracao = mostraPopupAlteracao;
    }

}