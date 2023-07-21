package com.dinamita.dinamitademo.Service;

import com.dinamita.dinamitademo.Entity.users;

import java.util.List;

public interface usersService {
    public List<users> ConsultarUsuarios();

    public users CrearUsuarios (users users);

    public Object ModificarUsuarios (users users);

    public users BuscarUsuarios (int id);

    public void EliminarUsuarios (int id);

}
