package com.dinamita.dinamitademo.Controller;

import com.dinamita.dinamitademo.Entity.users;
import com.dinamita.dinamitademo.Service.classServiceUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class ControllerUsers {

    @Autowired
    private classServiceUsers csu;

    @GetMapping
    @RequestMapping(value = "/ConsultarUsuarios", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarUsuarios(){
        List<users> usersList=this.csu.ConsultarUsuarios();
        return ResponseEntity.ok(usersList);
    }

    @PutMapping
    @RequestMapping(value = "/CrearUsuarios", method = RequestMethod.POST)
    public ResponseEntity<?> CrearUsuarios(@RequestBody users users){
        users usersCreate=this.csu.CrearUsuarios(users);
        return  ResponseEntity.status(HttpStatus.CREATED).body(usersCreate);
    }

    @PutMapping
    @RequestMapping(value = "/ModificarUsuarios", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarUsuarios(@RequestBody users users){
        users usersModify=this.csu.ModificarUsuarios(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(usersModify);
    }

    @PutMapping
    @RequestMapping(value = "/BuscarUsuarios/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarUsuarios(@PathVariable int id){
        users usersFind=this.csu.BuscarUsuarios(id);
        return ResponseEntity.ok(usersFind);
    }

    @DeleteMapping
    @RequestMapping(value="/EliminarUsuarios/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?>EliminarUsuarios(@PathVariable int id){
        this.csu.EliminarUsuarios(id);
        return ResponseEntity.ok().build();
    }
}


