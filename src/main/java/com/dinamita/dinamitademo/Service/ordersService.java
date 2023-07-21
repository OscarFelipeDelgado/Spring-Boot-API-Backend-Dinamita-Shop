package com.dinamita.dinamitademo.Service;

import com.dinamita.dinamitademo.Entity.orders;

import java.util.List;

public interface ordersService {
    public List<orders> ConsultarOrden();

    public orders CrearOrden (orders orders);

    public Object ModificarOrden (orders orders);

    public orders BuscarOrden (int id);

    public void EliminarOrden (int id);
}
