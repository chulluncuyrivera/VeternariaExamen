/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Personal;
import entidades.TipoDocumento;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public interface ITipoDocumento {
   
    public abstract boolean guardarTipoDocumento(TipoDocumento documento);
    
    public abstract ArrayList<TipoDocumento> listarTipoDocumento();

    public abstract boolean eliminarTipoDocumento(TipoDocumento documento);
    
     public abstract boolean ActualizarTipoDocumento(TipoDocumento documento);

}
