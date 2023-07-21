package com.dinamita.dinamitademo.Service;

import com.dinamita.dinamitademo.Entity.order_items;
import com.dinamita.dinamitademo.Repository.order_itemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class claseServicioOrder_items implements ServiceOrder_items {

    @Autowired
    private order_itemsRepo repo;

    @Override
    public List<order_items> ConsultarOrder_items(){
        return (List<order_items>)
                this.repo.findAll();
    }

    @Override
    public order_items CrearOrder_items(order_items order_items) {
        order_items.setOrder_id(order_items.getOrder_id());
        return this.repo.save(order_items);
    }
    /*Este código nos ayuda a actualizar los datos que queremos editar en la BD*/
    @Override
    public order_items ModificarOrder_items(order_items order_items) {
        return this.repo.save(order_items);
    }

    /*Este código nos ayuda a buscar los datos del usuario mediante el ID de la BD*/
    @Override
    public order_items BuscarOrder_items(int id)
    {
        return this.repo.findById(id).get();
    }

    /*Este código nos ayuda a eliminar los datos del usuario mediante su ID de la BD
     *
     * Insertamos el método como void, ya que cómo estamos eliminando datos, no nos va a devolver una información*/

    @Override
    public void EliminarOrder_items(int id){
        this.repo.deleteById(id);
    }
}