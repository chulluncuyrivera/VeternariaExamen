/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;


import Dao.TipoAtencionDao;
import Dao.TipoDocDao;

import entidades.Atencion;
import entidades.Tipoatencion;
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
public class TipoAtencionBeans {
    
   
    private Tipoatencion tipoatencion;
    private boolean banderaSelect = false;

    //constructor
    public TipoAtencionBeans() {
        this.tipoatencion = new Tipoatencion();
    }

    public String guardarTipoAtencion() {
        TipoAtencionDao dao = new TipoAtencionDao();
        boolean respuesta = dao.guardarTipoAtencion(tipoatencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/RegistroTipoAtencion";

    }

    public String ActualizarTipoAtencion() {
        try {
            TipoAtencionDao dao = new TipoAtencionDao();
            boolean resp = dao.ActualizarTipoAtencion(tipoatencion);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }

        } catch (HibernateException e) {
            System.out.println("Error::" + e);
        }
        return "/RegistroTipoAtencion";
    }


    public ArrayList<Tipoatencion> listarTipoAtencion() {
        ArrayList<Tipoatencion> milista = new ArrayList<>();
        TipoAtencionDao dao = new TipoAtencionDao();
        milista = dao.listarTipoAtencion();
        return milista;

    }

    public String limpiar() {
        banderaSelect = false;
        return "/RegistroTipoAtencion.xhtml";
    }

    public String eliminar(Tipoatencion tipoatencion) {
        TipoAtencionDao TipoAtencionDao = new TipoAtencionDao();
        boolean respuesta = TipoAtencionDao.eliminarTipoAtencion(tipoatencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }
        return "/RegistroTipoAtencion.xhtml";
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

    public Tipoatencion getTipoatencion() {
        return tipoatencion;
    }

    public void setTipoatencion(Tipoatencion tipoatencion) {
        this.tipoatencion = tipoatencion;
    }
}