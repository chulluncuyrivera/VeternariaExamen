/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;


import Dao.TipoAtencionDao;
import Dao.TipoDocDao;
import Dao.TipoReservaDao;

import entidades.Atencion;
import entidades.Tiporeserva;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author USUARIOWIN10
 */
@ManagedBean
@ViewScoped
public class TipoReservaBeans {
    
   
    private Tiporeserva tiporeserva;
    private boolean banderaSelect = false;

    //constructor
    public TipoReservaBeans() {
        this.tiporeserva = new Tiporeserva();
    }

    public String guardarTipoReserva() {
        TipoReservaDao dao = new TipoReservaDao();
        boolean respuesta = dao.guardarTipoReserva(tiporeserva);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/RegistroTipoReserva";

    }

    public String ActualizarTipoReserva() {
        try {
            TipoReservaDao dao = new TipoReservaDao();
            boolean resp = dao.ActualizarTipoReserva(tiporeserva);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }

        } catch (HibernateException e) {
            System.out.println("Error::" + e);
        }
        return "/RegistroTipoReserva";
    }


    public ArrayList<Tiporeserva> listarTipoReserva() {
        ArrayList<Tiporeserva> milista = new ArrayList<>();
        TipoReservaDao dao = new TipoReservaDao();
        milista = dao.listarTipoReseva();
        return milista;

    }

    public String limpiar() {
        banderaSelect = false;
        return "/RegistroTipoReserva.xhtml";
    }

    public String eliminar(Tiporeserva tiporeserva) {
        TipoReservaDao TipoReservaDao = new TipoReservaDao();
        boolean respuesta = TipoReservaDao.eliminarTipoReserva(tiporeserva);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }
        return "/RegistroTipoReserva.xhtml";
    }

    public void selectBandera() {
        banderaSelect = true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;


 
}

    public Tiporeserva getTiporeserva() {
        return tiporeserva;
    }

    public void setTiporeserva(Tiporeserva tiporeserva) {
        this.tiporeserva = tiporeserva;
    }

   
    }
