/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Consulta;
import util.JpaUtil;

/**
 *
 * @author temporario
 */
public class DaoHistorico implements Serializable {

    public List<Consulta> buscarHistorico(Integer codigo) {
        EntityManager manager = JpaUtil.getEntityManager();
        String sql = "SELECT c FROM Consulta c WHERE c.animal.codigo = :codigo";
        TypedQuery<Consulta> query = manager.createQuery(sql, Consulta.class);
        query.setParameter("codigo", codigo);
        List<Consulta> lista = query.getResultList();
        manager.close();
        return lista;
    }
}
