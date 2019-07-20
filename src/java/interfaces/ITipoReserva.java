/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Tiporeserva;
import java.util.ArrayList;
/**
 *
 * @author USUARIO
 */
public interface ITipoReserva {
    
public abstract boolean guardarTipoReserva(Tiporeserva tiporeserva);

    public abstract ArrayList<Tiporeserva> listarTipoReseva();

    public abstract boolean ActualizarTipoReserva(Tiporeserva tiporeserva);

    public abstract boolean eliminarTipoReserva(Tiporeserva tiporeserva);
}

