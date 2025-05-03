import { Component } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';
import { ListarProductoComponent } from "./componentes/listar-producto/listar-producto.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'project-plantilla';
}
