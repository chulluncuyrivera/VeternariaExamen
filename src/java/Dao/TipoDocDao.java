/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import entidades.TipoDocumento;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;

import utilitarios.HibernateUtil;
import interfaces.ITipoDocumento;

/**
 *
 * @author USUARIOWIN10
 */
public class TipoDocDao implements ITipoDocumento {

   
    @Override
    public boolean guardarTipoDocumento(TipoDocumento documento) {
     
    boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //Rgistrar en la base de datos la personal

        try {
            sesion.save(documento);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("ERROR DE GUARDAR::" + e);
            respuesta = false;
        }

        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<TipoDocumento> listarTipoDocumento() {
          Session sesion = HibernateUtil.getSessionFactory().openSession();
        ArrayList<TipoDocumento> milista = new ArrayList<>();
        //Create la consulta hacia la base de datos
        Query query = sesion.createQuery("from TipoDocumento");
        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<TipoDocumento>) query.list();
        sesion.close();
        return milista;
    }

    @Override
    public boolean eliminarTipoDocumento(TipoDocumento documento) {
         
    Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(documento);
            sesion.getTransaction().commit();

        } catch (Exception e) {
            resp = false;
            System.out.println("ERROR EN ELIMINAR::" + e);
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();

            }

        }
        return resp;
    }

    @Override
    public boolean ActualizarTipoDocumento(TipoDocumento documento) {
        
   //     System.out.println("error" + ITipoDocumento.getNombre());
        boolean resp = true;
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
            sesion.update(documento);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error en actualizar::" + e);
        } finally {
            if (sesion != null) {
                sesion.close();
            }

        }
        return resp;
    }
}
