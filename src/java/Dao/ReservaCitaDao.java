/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Reservacita;
import entidades.Tiporeserva;
import interfaces.IReservaCita;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import utilitarios.HibernateUtil;

/**
 *
 * @author USUARIOWIN10
 */
public class ReservaCitaDao implements IReservaCita {

    @Override
     public boolean guardarReservaCita(Reservacita reservacita) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //Rgistrar en la base de datos la tipotiporeserva

        try {
            sesion.save(reservacita);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("ERROR DE GUARFDAR::" + e);
            respuesta = false;
        }

        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Reservacita> listarResevaCita(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Reservacita> milista = new ArrayList<>();
        //Create la consulta hacia la base de datos
        Query query = sesion.createQuery("FROM Reservacita");
        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<Reservacita>) query.list();
          sesion.close();
        return milista;
    
       
    }

    @Override
      public boolean ActualizarReservaCita(Reservacita reservacita) {
        //System.out.println("error"+ tiporeserva.getNombreCliente());
        boolean resp= true;
        Session sesion= null;
        try {
            sesion=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=sesion.beginTransaction();
            sesion.update(reservacita);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error en actualizar::"+e);
        }finally{
            if(sesion != null){
                sesion.close();
            }
            
        }
       return resp;
    }

   
    @Override
    public boolean eliminarReservaCita(Reservacita reservacita) {
        Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(reservacita);
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

}