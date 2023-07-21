package com.dinamita.dinamitademo.Service;

import com.dinamita.dinamitademo.Entity.products;


import java.util.List;

public interface productsService {

    public List<products> Consultarproducts();

    //Vamos a realizar el método para realizar la PETICIÓN POST
    public products Crearproducts(products products);

    //Vamos a realizar el método para realizar la PETICIÓN PUT
    public products Modificarproducts(products products);

    //Vamos a realizar el método para buscar las personas
    public products Buscarproducts(int id);

    //Vamos a realizar el método para realizar la PETICIÓN DELETE
    //Le colocamos el método void para que no nos devuelva un valor
    public void Eliminarproducts(int id);


}
