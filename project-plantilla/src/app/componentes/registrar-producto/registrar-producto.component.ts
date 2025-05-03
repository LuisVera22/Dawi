import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Categoria } from '../../models/categoria';
import { Proveedor } from '../../models/proveedor';
import { CategoriaService } from '../../service/categoria.service';
import { ProveedorService } from '../../service/proveedor.service';

@Component({
  selector: 'app-registrar-producto',
  imports: [CommonModule],
  templateUrl: './registrar-producto.component.html',
  styleUrl: './registrar-producto.component.css'
})
export class RegistrarProductoComponent {

  categorias: Categoria[] = [];
  islistadoCategorias: boolean = false;

  proveedores: Proveedor[] = [];
  islistadoProveedores: boolean = false;

  constructor(
    private categoriaService: CategoriaService,
    private proveedorService: ProveedorService
  ) { }

  ngOnInit(): void {
    this.categoriaService.listarCategorias().subscribe(
      data => {
        this.categorias = data;
        this.islistadoCategorias = true;
      }
    );

    this.proveedorService.listarProveedores().subscribe(
      data => {
        this.proveedores = data;
        this.islistadoProveedores = true;
      }
    );
  }
}
