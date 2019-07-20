/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;


import Dao.ClienteDao;
import Dao.PersonalDao;
import Dao.UsuarioDao;
import entidades.Cliente;
import entidades.Personal;

import entidades.Usuario;

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
public class UsuarioBeans {
    
   
    private Usuario usuario;
    private boolean banderaSelect = false;
    
   private Cliente cliente;
   private Personal personal;
   private ArrayList listaclientes;
   private ArrayList listapersonal;
   
   private int idPersonal;
   private int idCliente;
   //constructor
   public UsuarioBeans(){
       usuario = new Usuario();
       listapersonal = new ArrayList();
       listaclientes = new ArrayList();
       personal = new Personal();
       cliente = new Cliente();
       listarCombox();
       
       
   }
   public void listarCombox(){
       PersonalDao personadao = new PersonalDao();
       ClienteDao clientedao = new ClienteDao();
       listaclientes = clientedao.listarCliente();
       listapersonal = personadao.listarPersonal();
   }  
  

    public String guardarUsuario() {
        UsuarioDao dao = new UsuarioDao();
        personal.setIdPersonal(idPersonal);
        cliente.setIdCliente(idCliente);
        
        usuario.setPersonal(personal);
        usuario.setCliente(cliente);
        boolean respuesta = dao.guardarUsuario(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/Usuario";

    }

    public String ActualizarUsuario() {
        try {
            UsuarioDao dao = new UsuarioDao();
            boolean resp = dao.ActualizarUsuario(usuario);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }

        } catch (HibernateException e) {
            System.out.println("Error::" + e);
        }
        return "/RegistroUsuario";
    }


    public ArrayList<Usuario> listarUsuario() {
        ArrayList<Usuario> milista = new ArrayList<>();
        UsuarioDao dao = new UsuarioDao();
        milista = dao.listarUsuario();
        return milista;

    }

    public String limpiar() {
        banderaSelect = false;
        return "/RegistroUsuario.xhtml";
    }

    public String eliminar(Usuario usuario) {
        UsuarioDao UsuarioDao = new UsuarioDao();
        boolean respuesta = UsuarioDao.eliminarUsuario(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }
        return "/RegistroUsuario.xhtml";
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public ArrayList getListaclientes() {
        return listaclientes;
    }

    public void setListaclientes(ArrayList listaclientes) {
        this.listaclientes = listaclientes;
    }

    public ArrayList getListapersonal() {
        return listapersonal;
    }

    public void setListapersonal(ArrayList listapersonal) {
        this.listapersonal = listapersonal;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    }
    
    


    

   
    
