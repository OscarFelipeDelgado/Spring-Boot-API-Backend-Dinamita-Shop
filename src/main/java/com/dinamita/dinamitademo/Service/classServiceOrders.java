package com.dinamita.dinamitademo.Service;

import com.dinamita.dinamitademo.Entity.orders;
import com.dinamita.dinamitademo.Repository.ordersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class classServiceOrders implements ordersService{
    @Autowired
    private ordersRepo repo;

    @Override
    public List<orders> ConsultarOrden(){
        return (List<orders>) this.repo.findAll();
    }

    @Override
    public orders CrearOrden(orders orders){
        orders.setOrder_number(orders.getOrder_number());
        return (com.dinamita.dinamitademo.Entity.orders) this.repo.save(orders);
    }

    @Override
    public orders ModificarOrden(orders orders) {
        return (com.dinamita.dinamitademo.Entity.orders) this.repo.save(orders);
    }

    public orders BuscarOrden(int id){
        return (orders) this.repo.findById(id).get();
    }

    @Override
    public void EliminarOrden(int id){
        this.repo.deleteById(id);
    }
}
