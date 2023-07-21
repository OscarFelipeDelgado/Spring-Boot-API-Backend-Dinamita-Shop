package com.dinamita.dinamitademo.Service;

import com.dinamita.dinamitademo.Entity.order_items;

import java.util.List;

public interface ServiceOrder_items {

    //La colecction List nos ayuda a crear una lista (PETICIÓN GET)
    public List<order_items> ConsultarOrder_items();

    //Vamos a realizar el método para realizar la PETICIÓN POST
    public order_items CrearOrder_items(order_items order_items);

    //Vamos a realizar el método para realizar la PETICIÓN PUT
    public order_items ModificarOrder_items(order_items order_items);

    //Vamos a realizar el método para buscar las personas
    public order_items BuscarOrder_items(int id);

    //Vamos a realizar el método para realizar la PETICIÓN DELETE
    //Le colocamos el método void para que no nos devuelva un valor
    public void EliminarOrder_items(int id);
}
