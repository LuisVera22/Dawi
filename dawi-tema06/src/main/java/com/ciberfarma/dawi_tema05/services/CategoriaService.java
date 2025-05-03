package com.ciberfarma.dawi_tema05.services;

import com.ciberfarma.dawi_tema05.models.Categoria;
import com.ciberfarma.dawi_tema05.repositories.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private ICategoriaRepository repoCat;

    public List<Categoria> listarTodas() {
        return repoCat.findAll();
    }
}
