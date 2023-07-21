package com.dinamita.dinamitademo.Service;

import com.dinamita.dinamitademo.Entity.users;
import com.dinamita.dinamitademo.Repository.usersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class classServiceUsers implements usersService{
    @Autowired
    private usersRepo repo;

    @Override
    public List<users> ConsultarUsuarios(){
        return (List<users>) this.repo.findAll();//findAll, asi traigo todos los datos del repo
    }

    @Override
    public users CrearUsuarios(users users) {
        users.setName(users.getName());
        return this.repo.save(users);
    }
    // com.dina..... es para solucionar un error
    @Override
    public users ModificarUsuarios(users users) {
        return this.repo.save(users);
    }

    public users BuscarUsuarios(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void EliminarUsuarios(int id) {
        this.repo.deleteById(id);
    }

}
