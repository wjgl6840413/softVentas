/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.Modelos;

//import Config.Conexion;
import com.emergentes.Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SYSTEMSJE
 */
public class VentaDAO {
      Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public String ObtenerNumeroDeFactura() {
        String numerodefactura ="";
        String consulta = "SELECT MAX(numerofactura) FROM ventas";
        con = cn.Conexion();

        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                numerodefactura = rs.getString(1);
                System.err.println("numfac"+numerodefactura);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return numerodefactura;

    }

        public void RegistrarVenta(Venta venta){
         String sentencia = "INSERT INTO ventas (idclienteventa,idempleadoventa,numerofactura,fechaventa,totalventa,estado) VALUES(?,?,?,?,?,?)";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sentencia);
            ps.setInt(1,venta.getIdCliente());
            ps.setInt(2, venta.getIdEmpleado());
            ps.setString(3, venta.getNumeroComprobante());
            ps.setString(4, venta.getFecha());
            ps.setDouble(5, venta.getMonto());
            ps.setString(6, venta.getEstado());
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void GuardarDetalleVenta(Venta venta){
          String sentencia = "INSERT INTO detalleventa (idventa,idproducto,cantidadproducto,precioventa) VALUES(?,?,?,?)";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sentencia);
            ps.setInt(1,venta.getIdVenta());
            ps.setInt(2, venta.getIdProducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
           
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public int ObtenerMaximoIdVentas(){
        int idVenta=0;
        String consulta = "SELECT MAX(idVenta) FROM ventas";
        con = cn.Conexion();
         try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
               idVenta=rs.getInt(1);
               System.out.println("max"+idVenta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idVenta;
    }


    
}
