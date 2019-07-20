/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.PersonalDao;
import Dao.TipoDocDao;
import entidades.Personal;
import entidades.TipoDocumento;
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
public class TipoDocumentoBeans {

    private TipoDocumento documento;
    private boolean banderaSelect = false;

    //constructor
    public TipoDocumentoBeans() {
        this.documento = new TipoDocumento();
    }

    public String guardarTipoDocumento() {
        TipoDocDao dao = new TipoDocDao();
        boolean respuesta = dao.guardarTipoDocumento(documento);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/RegistroTipoDocumento";

    }

    public String actualizarDocumento() {
        try {
            TipoDocDao TipoDocDao = new TipoDocDao();
            boolean resp = TipoDocDao.ActualizarTipoDocumento(documento);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }
            // personaldao.ActualizarPersonal(personal);
        } catch (HibernateException e) {
            System.out.println("Error::" + e);
        }
        return "/RegistroTipoDocumento";
    }


    public ArrayList<TipoDocumento> listarDocumento() {
        ArrayList<TipoDocumento> milista = new ArrayList<>();
        TipoDocDao dao = new TipoDocDao();
        milista = dao.listarTipoDocumento();
        return milista;

    }

    public String limpiar() {
        banderaSelect = false;
        return "/RegistroTipoDocumento.xhtml";
    }

    public String eliminar(TipoDocumento document) {
        TipoDocDao tipoDocDao = new TipoDocDao();
        boolean respuesta = tipoDocDao.eliminarTipoDocumento(document);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }
        return "/RegistroTipoDocumento.xhtml";
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

    public TipoDocumento getDocumento() {
        return documento;
    }

    public void setDocumento(TipoDocumento documento) {
        this.documento = documento;
    }

}
