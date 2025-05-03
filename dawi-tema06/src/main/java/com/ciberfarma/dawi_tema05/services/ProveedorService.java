package com.ciberfarma.dawi_tema05.services;

import com.ciberfarma.dawi_tema05.models.Proveedor;
import com.ciberfarma.dawi_tema05.repositories.IProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private IProveedorRepository repoProv;

    public List<Proveedor> listaTodos() {
        return repoProv.findAll();
    }
}
