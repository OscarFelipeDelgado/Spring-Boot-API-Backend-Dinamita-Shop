package com.dinamita.dinamitademo.Controller;

import com.dinamita.dinamitademo.Entity.orders;
import com.dinamita.dinamitademo.Service.classServiceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class ControllerOrders {

    @Autowired
    private classServiceOrders csu;

    @GetMapping
    @RequestMapping(value = "/ConsultarOrden", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarOrden(){
        List<orders> ordersList = this.csu.ConsultarOrden();
        return ResponseEntity.ok(ordersList);
    }

    @PutMapping
    @RequestMapping(value = "/CrearOrden", method = RequestMethod.POST)
    public ResponseEntity<?> CrearOrden(@RequestBody orders orders){
        com.dinamita.dinamitademo.Entity.orders ordersCreate=this.csu.CrearOrden(orders);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordersCreate);
    }

    @PutMapping
    @RequestMapping(value = "/ModificarOrden", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarOrden(@RequestBody orders orders){
        com.dinamita.dinamitademo.Entity.orders ordersModify = this.csu.ModificarOrden(orders);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordersModify);
    }

    @PutMapping
    @RequestMapping(value="/BuscarOrden/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarOrden(@PathVariable int id){
        orders ordersFind=this.csu.BuscarOrden(id);
        return ResponseEntity.ok(ordersFind);
    }

    @DeleteMapping
    @RequestMapping(value="/EliminarOrden/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?>EliminarOrden(@PathVariable int id){
        this.csu.EliminarOrden(id);
        return ResponseEntity.ok().build();
    }

}
