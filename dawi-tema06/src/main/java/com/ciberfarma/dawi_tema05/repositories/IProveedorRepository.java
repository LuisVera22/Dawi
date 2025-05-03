package com.ciberfarma.dawi_tema05.repositories;

import com.ciberfarma.dawi_tema05.models.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {
}
