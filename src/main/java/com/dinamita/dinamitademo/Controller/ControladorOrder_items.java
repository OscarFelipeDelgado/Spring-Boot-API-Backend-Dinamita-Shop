package com.dinamita.dinamitademo.Controller;


import com.dinamita.dinamitademo.Entity.order_items;
import com.dinamita.dinamitademo.Service.claseServicioOrder_items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Order_items")

public class ControladorOrder_items {
    @Autowired
    private claseServicioOrder_items csu;

    /*La anotación GetMapping nos ayuda mapear una solicitud GET*/
    @GetMapping
    /*Inicializamos la ruta para realizar el mapeo de la petición GET
     *
     * http:localhost:8082/Order_items/ConsultarOrder_items*/
    @RequestMapping(value = "ConsultarOrder_items", method = RequestMethod.GET)
    /*Este método maneja la solicitud GET para consultar todas las personas que están guardadas y si los datos correcto, me mostrará una repsuesta de código HTTP 200*/
    public ResponseEntity<?> ConsultarOrder_items(){
        List<order_items> Order_itemsList=this.csu.ConsultarOrder_items();
        return ResponseEntity.ok(Order_itemsList);
    }
    @PutMapping
    /*Usamos este mapeo http:localhost:8082/Order_items/CrearOrder_items para insertar datos*/
    @RequestMapping(value = "CrearOrder_items", method = RequestMethod.POST)
    public ResponseEntity<?> CrearOrder_items(@RequestBody order_items order_items){
        order_items orderitemsCrear =this.csu.CrearOrder_items(order_items);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderitemsCrear);
    }

    /*Usamos este mapeo http:localhost:8082/Order_items/ModificarOrder_items para actualizar datos*/
    @PutMapping
    @RequestMapping(value = "ModificarOrder_items", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarOrder_items(@RequestBody order_items order_items){
        order_items Order_itemsSModificar=this.csu.ModificarOrder_items(order_items);
        return ResponseEntity.status(HttpStatus.CREATED).body(Order_itemsSModificar);
    }

    /*Usamos este mapeo http:localhost:8082/Order_items/BuscarOrder_items/{id} para actualizar datos*/
    @GetMapping
    @RequestMapping(value = "BuscarOrder_items/{id}", method = RequestMethod.GET)
    /*La anotación @PatVariable nos ayuda a insertar una ruta*/
    public ResponseEntity<?> BuscarOrder_items(@PathVariable int id) {
        order_items orderitemsBuscar =this.csu.BuscarOrder_items(id);
        return  ResponseEntity.ok(orderitemsBuscar);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarOrder_items/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarOrder_items(@PathVariable int id){
        this.csu.EliminarOrder_items(id);
        return ResponseEntity.ok().build();
    }
}