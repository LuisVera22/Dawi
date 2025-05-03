import { Categoria } from "./categoria";
import { Proveedor } from "./proveedor";

export interface Producto {
    id_prod: string;
    des_prod: string;
    stk_prod: number;
    pre_prod: number;
    idcategoria: number;
    est_prod: number;
    idproveedor: number;
    objCategoria : Categoria;
    objProveedor : Proveedor;
}
