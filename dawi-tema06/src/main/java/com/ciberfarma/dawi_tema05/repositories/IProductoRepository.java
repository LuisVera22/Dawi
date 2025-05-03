package com.ciberfarma.dawi_tema05.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciberfarma.dawi_tema05.models.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, String>{

}
