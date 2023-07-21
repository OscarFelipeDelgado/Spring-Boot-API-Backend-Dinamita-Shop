package com.dinamita.dinamitademo.Controller;

import com.dinamita.dinamitademo.Entity.products;
import com.dinamita.dinamitademo.Service.classServiceProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Products")

public class ControllerProducts {

    @Autowired
    private classServiceProducts csp;

    /*La anotación GetMapping nos ayuda mapear una solicitud GET*/
    @GetMapping
    /*Inicializamos la ruta para realizar el mapeo de la petición GET
     *
     * http:localhost:8083/Products/Consultarproducts*/
    @RequestMapping(value = "Consultarproducts", method = RequestMethod.GET)
    /*Este método maneja la solicitud GET para consultar todas las personas que están guardadas y si los datos correcto, me mostrará una repsuesta de código HTTP 200*/
    public ResponseEntity<?> Consultarproducts(){
        List<products> productsList=this.csp.Consultarproducts();
        return ResponseEntity.ok(productsList);
    }
    @PutMapping
    /*Usamos este mapeo http://localhost:8083/Products/Crearproducts para insertar datos*/
    @RequestMapping(value = "Crearproducts", method = RequestMethod.POST)
    public ResponseEntity<?> Crearproducts(@RequestBody products products){
        products productsCrear =this.csp.Crearproducts(products);
        return ResponseEntity.status(HttpStatus.CREATED).body(productsCrear);
    }

    /*Usamos este mapeo http:localhost:8083/Products/Modificarproducts para actualizar datos*/
    @PutMapping
    @RequestMapping(value = "Modificarproducts", method = RequestMethod.PUT)
    public ResponseEntity<?> Modificarproducts(@RequestBody products products){
        products productsModificar=this.csp.Modificarproducts(products);
        return ResponseEntity.status(HttpStatus.CREATED).body(productsModificar);
    }

    /*Usamos este mapeo http:localhost:8083/Products/Buscarproducts/{id} para actualizar datos*/
    @GetMapping
    @RequestMapping(value = "Buscarproducts/{id}", method = RequestMethod.GET)
    /*La anotación @PatVariable nos ayuda a insertar una ruta*/
    public ResponseEntity<?> Buscarproducts(@PathVariable int id) {
        products productsBuscar =this.csp.Buscarproducts(id);
        return  ResponseEntity.ok(productsBuscar);
    }

    @DeleteMapping
    @RequestMapping(value = "Eliminarproducts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> Eliminarproducts(@PathVariable int id){
        this.csp.Eliminarproducts(id);
        return ResponseEntity.ok().build();
    }
}
