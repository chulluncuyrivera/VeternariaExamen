/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Dao.ReservaCitaDao;
import entidades.Reservacita;

import java.util.ArrayList;
/**
 *
 * @author USUARIO
 */
public interface IReservaCita {
    
public abstract boolean guardarReservaCita(Reservacita reservacita);

    public abstract ArrayList<Reservacita> listarResevaCita();

    public abstract boolean ActualizarReservaCita(Reservacita reservacita);

    public abstract boolean eliminarReservaCita(Reservacita reservacita);
}

