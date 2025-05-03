import { Component } from '@angular/core';
// importamos la librería para ngFor y otros
import { CommonModule } from '@angular/common';
import { Producto } from '../../models/producto';
import { ProductoService } from '../../service/producto.service';

@Component({
  selector: 'app-listar-producto',
  imports: [CommonModule],
  templateUrl: './listar-producto.component.html',
  styleUrl: './listar-producto.component.css'
})
export class ListarProductoComponent {
  // procesos y variables
  titulo: string = "Cargando...";
  productos: Producto[] = [];
  cargoLista: boolean = false;

  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    this.productoService.listarProductos().subscribe(
      data => {
        this.productos = data;
        this.titulo = 'Listado de productos';
        this.cargoLista = true;
    });

  }
}
/* ngOnInit() : void {
  this.cargarDatos().then(
    data => {
      this.titulo = data.titulo;
      this.productos = data.productos;
      this.cargoLista = true;
    }
  );
}

cargarDatos() : Promise<any> {
  return new Promise(
    resolve => {
      setTimeout(()=>{
        resolve({
          titulo : 'Listado de productos',
          productos : [
            { id_prod: "P0001", des_prod: 'Panadol Cj 10', stk_prod: 20, pre_prod: 1.85 },
            { id_prod: "P0002", des_prod: 'Curitas', stk_prod: 100, pre_prod: 1.00 },
            { id_prod: "P0003", des_prod: 'Panadol Cj 10', stk_prod: 20, pre_prod: 1.85 },
            { id_prod: "P0004", des_prod: 'Curitas', stk_prod: 100, pre_prod: 1.00 },
            { id_prod: "P0005", des_prod: 'Panadol Cj 10', stk_prod: 20, pre_prod: 1.85 },
            { id_prod: "P0006", des_prod: 'Curitas', stk_prod: 100, pre_prod: 1.00 },
            { id_prod: "P0007", des_prod: 'Panadol Cj 10', stk_prod: 20, pre_prod: 1.85 },
            { id_prod: "P0008", des_prod: 'Curitas', stk_prod: 100, pre_prod: 1.00 }
          ]
        });
      }, 1500);
    }
  );
} */




