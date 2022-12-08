/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.Dao;
import dao.DaoHistorico;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Animal;

@Named
@ViewScoped

public class GerenciarHistoricoControle implements Serializable {

    private List<Animal> listaAnimal;
    private Dao<Animal> daoAnimal;
    private Animal animal;
    private DaoHistorico historico;
    

    @PostConstruct
    public void iniciar() {
        daoAnimal = new Dao(Animal.class);
        listaAnimal = daoAnimal.listarTodos();
        animal = new Animal();
        historico = new DaoHistorico();
    }
    
    public void atualizarTabela(){
        animal.setConsultas(historico.buscarHistorico(animal.getCodigo()));
    }

    public List<Animal> getListaAnimal() {
        return listaAnimal;
    }

    public void setListaAnimal(List<Animal> listaAnimal) {
        this.listaAnimal = listaAnimal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
