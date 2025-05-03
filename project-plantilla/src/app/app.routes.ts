import { Routes } from '@angular/router';
import { PrincipalComponent } from './componentes/principal/principal.component';
import { ListarProductoComponent } from './componentes/listar-producto/listar-producto.component';
import { RegistrarProductoComponent } from './componentes/registrar-producto/registrar-producto.component';

export const routes: Routes = [
    { path: '', component: PrincipalComponent },
    { path: 'listado', component: ListarProductoComponent },
    { path: 'nuevo', component: RegistrarProductoComponent },
    // otras rutas
    {path: '**', redirectTo: '', pathMatch: 'full'}
];
