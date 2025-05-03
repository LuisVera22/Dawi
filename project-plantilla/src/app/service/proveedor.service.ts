import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proveedor } from '../models/proveedor';

@Injectable({
  providedIn: 'root'
})
export class ProveedorService {
  private urlBase = 'http://localhost:8080/api/proveedores';

  constructor(private http: HttpClient) { }

  listarProveedores(): Observable<Proveedor[]> {
    return this.http.get<Proveedor[]>(this.urlBase);
  }
}
