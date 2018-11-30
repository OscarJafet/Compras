/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_Conexion;
import C_Frames.C_ADD_ProductosProveedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emilio
 */
public class Conexion {
    public static String conexionURL;
    public static Connection con=null;
    public Statement stn=null;
    public ResultSet rs=null;
    JTable tablaTemp;
    public String Sql;
    public boolean conex;
    private String usuarioname;
    public static Connection getConnection(String User, String Password){
        if(con == null){
            conexionURL = "jdbc:oracle:thin:@localhost:1521:XE";
            try{
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                con = (DriverManager.getConnection(conexionURL,User,Password));
                //JOptionPane.showMessageDialog(null,"Acceso a la base de datos", "Conection SQL ",JOptionPane.INFORMATION_MESSAGE);
                return con;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage(), "Error SQL ",JOptionPane.ERROR_MESSAGE);
                return con;
            }
        }
        return con;
    }
    public void OpenCon(String User, String Password){
        getConnection(User, Password);
    }
     public void SQL(String Sql){
          try {
              
              stn=(Statement) con.createStatement();
              stn.executeUpdate(Sql);
              con.commit();
              stn.close();
              JOptionPane.showMessageDialog(null," Acción realizada","Informacion", JOptionPane.INFORMATION_MESSAGE);
              //return true;
              // erp.V = null;
          } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
              //return false;
              //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          }
     }
     
          public void SQLLupita(String Sql) {
        try {

            stn = (Statement) con.createStatement();
            stn.executeUpdate(Sql);
            con.commit();
            stn.close();
            JOptionPane.showMessageDialog(null, " Acción realizada", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            if (JOptionPane.showConfirmDialog(null, "Desea agregar un producto al proveedor", "Informacion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                C_ADD_ProductosProveedor pro = new C_ADD_ProductosProveedor();
                pro.setLocationRelativeTo(pro);
                pro.setVisible(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Correo no valido", "Error", JOptionPane.INFORMATION_MESSAGE);
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SQLlupita2(String Sql) {
        try {

            stn = (Statement) con.createStatement();
            stn.executeUpdate(Sql);
            con.commit();
            stn.close();
            JOptionPane.showMessageDialog(null, " Acción realizada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Correo no valido", "Error", JOptionPane.INFORMATION_MESSAGE);
            
           // Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public boolean Log_in(String Usr, String Psw){
       Sql = "select estatus from ERP.Usuarios where nombre ='"+Usr+"' and CONTRASEÑA = '"+Psw+"'";
           
        try {
          
          String status = null;
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
      
       
            while(rs.next()){
                     status=rs.getString("ESTATUS");   
            }
            if(status!=null){
                if(status.toString().equals("A")){
                    setUsuario(String.valueOf(Usr));
                    return true;  
                }else 
                     return false;
            }         
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
            JOptionPane.showMessageDialog(null, "Usuario incorrecto o contraseña incorrecta");
            return false;
     }
             
     public void Update_Ped_Det_Total(int idPed){
         float Total = 0;
        Sql = "select subtotal from pedidodetalle where idpedido ="+idPed;
        try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String sub=rs.getString("SUBTOTAL");
                Total += Float.parseFloat(sub);
            }
            SQL("Update Pedidos set totalPagar = "+Total+" where idpedido = "+idPed);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error Categorias" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }
     public void Categorias_Search(String Nombre, JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if(Nombre.isEmpty())
            Sql = "select * from Categorias where estatus ='A'";
        else if(!Nombre.isEmpty())
            Sql = "select * from Categorias where nombre like '"+Nombre+"%'";
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String IDCat=rs.getString("idCategoria");
                String Nom=rs.getString("nombre");
                String Stat=rs.getString("estatus");
                Object datosRenglon[]={ IDCat, Nom, Stat};
                tablaTemp.addRow(datosRenglon);
            }
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error Categorias" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }
     public void SelectP_Search(JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        Sql = " select P.idPedido,p.fecharegistro,p.fecharecepcion,p.totalpagar,\n" +
" p.cantidadpagada,p.estatus, c.idproveedor,c.nombre\n" +
" from Pedidos P inner join Proveedores c on p.idproveedor = c.idproveedor \n" +
" where p.estatus = 'A'";
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        int idPe = 0;
            while(rs.next()){
                String idPed=rs.getString("IDPEDIDO");
                String feReg=rs.getString("FECHAREGISTRO");
                String feRecp=rs.getString("FECHARECEPCION");
                String Tp = rs.getString("TOTALPAGAR");
                String CantPag = rs.getString("CANTIDADPAGADA");
                String Est = rs.getString("ESTATUS");
                String idProv = rs.getString("IDPROVEEDOR");
                String NomPro = rs.getString("NOMBRE");
                Object datosRenglon[]={ idPed, feReg, feRecp,Tp,CantPag,Est,idProv,NomPro};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"No hay pedidos?" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }
     
     public void SelectP_Detalles_Search(JTable tabla, int id){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        Sql = "select idPedidoDetalle, cantPedida,precioCompra,subtotal,\n" +
" cantRecibida,cantRechazada,cantAceptada from PedidoDetalle where idPedido = "+id;
         System.out.println(id+"ahhh");
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
            while(rs.next()){
                String idP_D=rs.getString("IDPEDIDODETALLE");
                String feReg=rs.getString("CANTPEDIDA");
                String feRecp=rs.getString("PRECIOCOMPRA");
                String Tp = rs.getString("SUBTOTAL");
                String CantPag = rs.getString("CANTRECIBIDA");
                String Est = rs.getString("CANTRECHAZADA");
                String idProv = rs.getString("CANTACEPTADA");
                Object datosRenglon[]={ idP_D, feReg, feRecp,Tp,CantPag,Est,idProv};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"No hay detalles?" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void Lab_Search(String Nombre, JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if(Nombre.isEmpty())
            Sql = "select * from Laboratorios where estatus='A'";
        else if(!Nombre.isEmpty())
            Sql = "select * from Laboratorios where nombre like '"+Nombre+"%'";
        try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String idLab=rs.getString("idLaboratorio");
                String Nom=rs.getString("nombre");
                String Ori=rs.getString("origen");
                String Stat = rs.getString("estatus");
                Object datosRenglon[]={ idLab, Nom, Ori,Stat};
                tablaTemp.addRow(datosRenglon);
            }
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Emp_Search(String Nombre,JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if(Nombre.isEmpty())
            Sql = "select em.idEmpaque, em.nombre, em.capacidad,"
                    + "em.estatus, em.idunidad, um.nombre as nom from Empaques em inner join UnidadMedida um "
                    + "on em.idunidad=um.idunidad where em.estatus='A'";
        else if(!Nombre.isEmpty())
            Sql = "select em.idEmpaque, em.nombre, em.capacidad,"
                    + "em.estatus, em.idunidad, um.nombre as nom from Empaques em inner join UnidadMedida um "
                    + "on em.idunidad=um.idunidad where em.nombre like '"+Nombre+"%'";
        
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String idLab=rs.getString("idEmpaque");
                String Nom=rs.getString("nombre");
                String Ori=rs.getString("capacidad");
                String Stat = rs.getString("estatus");
                String IDPK = rs.getString("idUnidad");
                String unidad= rs.getString("nom");
                Object datosRenglon[]={ idLab, Nom, Ori,Stat,IDPK, unidad};
                tablaTemp.addRow(datosRenglon);
            }
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        public void Unidad_Search(String Nombre,JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if(Nombre.isEmpty())
            Sql = "select * from UnidadMedida where estatus='A'";
        else if(!Nombre.isEmpty())
            Sql = "select * from UnidadMedida where nombre like '"+Nombre+"%'";
        
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String idLab=rs.getString("idUnidad");
                String Nom=rs.getString("nombre");
                String Ori=rs.getString("siglas");
                String Stat = rs.getString("estatus");
                Object datosRenglon[]={ idLab, Nom, Ori,Stat};
                tablaTemp.addRow(datosRenglon);
            }
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public String PedDetPreComp_Search(int id){
            Sql = "select precioCompra from ERP.PresentacionesProducto where idPresentacion = "+id+"";
        String idLab ="";
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
               return idLab=rs.getString("precioCompra");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
          return idLab;      
    }
    
         public void Producto_Search(String Nombre,JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
         if(Nombre.isEmpty())
            Sql = "select pro.idproducto, pro.nombre,\n" +
            "pro.descripcion,pro.ingredienteactivo,pro.bandatoxicologica,pro.aplicacion,pro.uso,pro.estatus,la.nombre\n" +
                "as nom ,ca.nombre as nomb from Productos pro\n" +
                "inner join laboratorios la on pro.idlaboratorio=la.idlaboratorio\n" +
                "inner join categorias ca on\n" +
                "pro.idcategoria=ca.idcategoria where pro.estatus='A'";
        else if(!Nombre.isEmpty())
            Sql = "select pro.idproducto, pro.nombre,\n" +
            "pro.descripcion,pro.ingredienteactivo,pro.bandatoxicologica,pro.aplicacion,pro.uso,pro.estatus,la.nombre\n" +
                "as nom ,ca.nombre as nomb from Productos pro\n" +
                "inner join laboratorios la on pro.idlaboratorio=la.idlaboratorio\n" +
                "inner join categorias ca on\n" +
                "pro.idcategoria=ca.idcategoria where pro.nombre like '"+Nombre+"%'";
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String idPro=rs.getString("idproducto");
                String Nom=rs.getString("nombre");
                String descripcion=rs.getString("descripcion");
                String ingrediente = rs.getString("ingredienteactivo");
                String banda = rs.getString("bandatoxicologica");
                String apli = rs.getString("aplicacion");
                String uso = rs.getString("uso");
                String estatus = rs.getString("estatus");
                String lab = rs.getString("nom");
                String cat = rs.getString("nomb");
                Object datosRenglon[]={ idPro, Nom, descripcion,ingrediente,banda,apli,uso,estatus,lab,cat};
                tablaTemp.addRow(datosRenglon);
            }     
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
         public void Sucursales_Search(String Nombre,JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if(Nombre.isEmpty())
            Sql = "select s.idsucursal, s.nombre, s.telefono,"
                    + "s.direccion,s.colonia,"
                    + "s.codigopostal, s.presupuesto, s.estatus, s.idciudad, cd.nombre as nom from Sucursal s inner join Ciudad cd "
                    + "on s.idciudad=cd.idciudad where s.estatus='A'";
            
            
        else if(!Nombre.isEmpty())
            Sql = "select s.idsucursal, s.nombre, s.telefono,"
                    + "s.direccion,s.colonia,"
                    + "s.codigopostal, s.presupuesto, s.estatus, s.idciudad, cd.nombre as nom from Sucursal s inner join Ciudad cd "
                    + "on s.idciudad=cd.idciudad where s.nombre like '"+Nombre+"%'";
                    
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String idsuc=rs.getString("idsucursal");
                String Nom=rs.getString("nombre");
                String tel=rs.getString("telefono");
                String dir=rs.getString("direccion");
                String col=rs.getString("colonia");
                String cp=rs.getString("codigopostal");
                String pre=rs.getString("presupuesto");
                String Stat = rs.getString("estatus");
                String ciu=rs.getString("idciudad");
                String nombre=rs.getString("nom");
                Object datosRenglon[]={idsuc,Nom,tel,dir,col,cp,pre,Stat,ciu, nombre};
                tablaTemp.addRow(datosRenglon);
            }
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public void ExistenciaSucursal_search(JTable tabla,String Sql){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        
           
           
      
              
        
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                
                String idLab1=rs.getString("IDPRESENTACION");
                String idLab2=rs.getString("IDSUCURSAL");
                String idLab=rs.getString("NOMBRE");
                String Nom=rs.getString("PRECIOVENTA");
                String Ori=rs.getString("PUNTOREORDEN");
                String nombre=rs.getString("nomb");
                String Stat2 = rs.getString("CANTIDAD");
                String Stat = rs.getString("NOM");
                 String Stat3 = rs.getString("NO");
                 String Stat4 = rs.getString("estatus");
                Object datosRenglon[]={idLab1,nombre,idLab2, idLab, Nom, Ori,Stat2,Stat,Stat3,Stat4};
                tablaTemp.addRow(datosRenglon);
            }
            
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


public void ExistenciaSucursal_search_nombre(JTable tabla, String Sql){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
               String idLab1=rs.getString("IDPRESENTACION");
                String idLab2=rs.getString("IDSUCURSAL");
                String idLab=rs.getString("NOMBRE");
                String Nom=rs.getString("PRECIOVENTA");
                String Ori=rs.getString("PUNTOREORDEN");
                String nombre=rs.getString("nomb");
                String Stat2 = rs.getString("CANTIDAD");
                String Stat = rs.getString("NOM");
                 String Stat3 = rs.getString("NO");
                 String Stat4 = rs.getString("estatus");
                Object datosRenglon[]={idLab1,nombre,idLab2, idLab, Nom, Ori,Stat2,Stat,Stat3,Stat4};
                tablaTemp.addRow(datosRenglon);
            }
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public void ExistenciaSucursal_search_claves(JTable tabla, String Sql){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String idLab1=rs.getString("IDSUCURSAL");
                String idLab2=rs.getString("IDPRESENTACION");
                String idLab=rs.getString("NOMBRE");
                String Nom=rs.getString("PRECIOVENTA");
                String Ori=rs.getString("PUNTOREORDEN");
                
                String Stat2 = rs.getString("CANTIDAD");
                String Stat = rs.getString("NOM");
                 String Stat3 = rs.getString("NO");
                Object datosRenglon[]={idLab1,idLab2,idLab, Nom, Ori,Stat2,Stat,Stat3};
                tablaTemp.addRow(datosRenglon);
            }
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 public void consultaregistroE(JTable tabla){
       
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        String cadenaSQL="select IDSUCURSAL,NOMBRE from sucursal where ESTATUS='A'";
           
        try {
            stn=(java.sql.Statement) con.createStatement();
            rs=stn.executeQuery(cadenaSQL);
        
            while(rs.next()){
                
                 String X=rs.getString("IDSUCURSAL");
                   String Y=rs.getString("NOMBRE");
                    
                       
                Object datosRenglon[]={X,Y};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     }
     
      public void consultaregistroPR(JTable tabla){
       
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        String cadenaSQL="select pp.IDPresentacion, pt.NOMBRE, EM.NOMBRE AS EMPAQUE from \n" +
"              presentacionESproducto pp inner join productos pt \n" +
"                on pp.idproducto=pt.idproducto inner join EMPAQUES EM ON em.idempaque=pp.idempaque where pt.ESTATUS = 'A'";
           
        try {
            stn=(java.sql.Statement) con.createStatement();
            rs=stn.executeQuery(cadenaSQL);
        
            while(rs.next()){
                
                 String X=rs.getString("IDPRESENTACION");
                   String Y=rs.getString("NOMBRE");
                   String Y2=rs.getString("EMPAQUE"); 
                       
                Object datosRenglon[]={X,Y,Y2};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     }
      public String consultaEdo(int Edo){
       
        String cadenaSQL="Select idEstado from Ciudad where idCiudad = "+Edo;
           String X = "";
        try {
            stn=(java.sql.Statement) con.createStatement();
            rs=stn.executeQuery(cadenaSQL);
        
            while(rs.next()){
                
                  X=rs.getString("IDESTADO");
                     
            }
            return  X; 
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return X;
        }
     
     }
      public String consultaLab(String nombre){
       
        String cadenaSQL="Select idlaboratorio from laboratorios where nombre = '"+nombre+"'";
           String X = "";
        try {
            stn=(java.sql.Statement) con.createStatement();
            rs=stn.executeQuery(cadenaSQL);
        
            while(rs.next()){
                
                  X=rs.getString("idlaboratorio");
                     
            }
            return  X; 
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return X;
        }
     
     
     }
      public String consultaCat(String nombre){
       
        String cadenaSQL="Select idcategoria from categorias where nombre = '"+nombre+"'";
           String X = "";
        try {
            stn=(java.sql.Statement) con.createStatement();
            rs=stn.executeQuery(cadenaSQL);
        
            while(rs.next()){
                
                  X=rs.getString("idcategoria");
                     
            }
            return  X; 
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return X;
        }
     
     
     }
      public String consultaPro(String nombre){
       
        String cadenaSQL="Select idproveedor from Proveedores where nombre = '"+nombre+"'";
           String X = "";
        try {
            stn=(java.sql.Statement) con.createStatement();
            rs=stn.executeQuery(cadenaSQL);
        
            while(rs.next()){
                
                  X=rs.getString("idproveedor");
                     
            }
            return  X; 
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return X;
        }
     
     
     }
      public void Presentacion_seacrh(String Nombre, JTable tabla, char Stat) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if (Nombre.isEmpty() && Stat == 'E') {
            Sql = "select PresentacionesProducto.idPresentacion, PresentacionesProducto.precioCompra,\n"
                    + "PresentacionesProducto.precioVenta,PresentacionesProducto.puntoReorden,\n"
                    + "PresentacionesProducto.idProducto,PresentacionesProducto.idEmpaque,PresentacionesProducto.estatus,PresentacionesProducto.nombre\n"
                    + "from presentacionesproducto\n"
                    + "inner join ERP.Productos\n"
                    + "on PresentacionesProducto.idProducto = Productos.idProducto and Productos.estatus = 'A'";
        } else if (!Nombre.isEmpty() && Stat == 'E') {
            Sql = "select PresentacionesProducto.idPresentacion, PresentacionesProducto.precioCompra,\n"
                    + "PresentacionesProducto.precioVenta,PresentacionesProducto.puntoReorden,\n"
                    + "PresentacionesProducto.idProducto,PresentacionesProducto.idEmpaque,PresentacionesProducto.estatus,PresentacionesProducto.nombre\n"
                    + "from presentacionesproducto\n"
                    + "inner join ERP.Productos\n"
                    + "on PresentacionesProducto.idProducto = Productos.idProducto and Productos.estatus = 'A' and Productos.nombre = '" + Nombre + "'";
        } else if (Stat == 'A' || Stat == 'B') {
            Sql = "select PresentacionesProducto.idPresentacion, PresentacionesProducto.precioCompra,\n"
                    + "PresentacionesProducto.precioVenta,PresentacionesProducto.puntoReorden,\n"
                    + "PresentacionesProducto.idProducto,PresentacionesProducto.idEmpaque,PresentacionesProducto.estatus,PresentacionesProducto.nombre\n"
                    + "from presentacionesproducto\n"
                    + "inner join ERP.Productos\n"
                    + "on PresentacionesProducto.idProducto = Productos.idProducto and PresentacionesProducto.estatus = '" + Stat + "'";
        }
        //System.out.println(Sql);
               try {
            stn= con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String idPress=rs.getString("idPresentacion");
                String preCom=rs.getString("precioCompra");
                String preVent=rs.getString("precioVenta");
                String pReorden = rs.getString("puntoReorden");
                String idPro = rs.getString("idProducto");
                String idEmp = rs.getString("idEmpaque");
                String stat = rs.getString("estatus");
                String nom = rs.getString("nombre");
                Object datosRenglon[]={idPress, preCom, preVent,pReorden,idPro,idEmp,stat,nom};
                tablaTemp.addRow(datosRenglon);
            }
            Sql = "select Productos.nombre from Productos\n"
                    + "inner join ERP.PresentacionesProducto\n"
                    + "on PresentacionesProducto.idProducto = Productos.idProducto";
            stn= con.createStatement();
            rs=stn.executeQuery(Sql);
        
            for (int i = 0; rs.next(); i++) {
                 String nombre=rs.getString("nombre");
                 tablaTemp.setValueAt(tablaTemp.getValueAt(i, 4)+" "+nombre, i, 4);
            }
            
            Sql = "select Empaques.nombre from Empaques\n"
                    + "inner join ERP.PresentacionesProducto\n"
                    + "on PresentacionesProducto.idEmpaque = Empaques.idEmpaque";
            stn= con.createStatement();
            rs=stn.executeQuery(Sql);
        
            for (int i = 0; rs.next(); i++) {
                 String nombre=rs.getString("nombre");
                 tablaTemp.setValueAt(tablaTemp.getValueAt(i, 5)+" "+nombre, i, 5);
            }
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void Detalles_seacrh(String Nombre, JTable tabla, char Stat) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if (Nombre.isEmpty() && Stat == 'E') {
            Sql = "SELECT * FROM ERP.PEDIDODETALLE d INNER JOIN PEDIDOS  p ON p.idpedido = d.idpedido where p.estatus = 'E'";
        } else if (!Nombre.isEmpty() && Stat == 'E') {
            Sql = "SELECT * FROM PEDIDODETALLE d INNER JOIN PEDIDOS p ON p.idpedido = d.idpedido INNER JOIN PRESENTACIONESPRODUCTO R ON R.NOMBRE like '"+Nombre+"%' where p.estatus = 'A'";
        } else if (Stat == 'A' || Stat == 'C' || Stat == 'E') {
            Sql = "SELECT P.idPedidoDetalle, p.cantPedida,p.precioCompra,p.subTotal,p.cantRecibida,p.CantRechazada,p.cantAceptada,p.idPedido,p.idPresentacion\n" +
"FROM PEDIDODETALLE p INNER JOIN PEDIDOS d ON  p.idpedido = d.idpedido where d.estatus = '"+Stat+"'";
        }
      try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
          //System.out.println(Sql);
          
            while(rs.next()){
                
                String idDt=rs.getString("idPedidoDetalle");
                String cPd=rs.getString("cantPedida");
                String pC=rs.getString("precioCompra");
                String sb = rs.getString("subtotal");
                String cAp = rs.getString("cantAceptada");
                String cRe = rs.getString("cantRecibida");
                String cRh = rs.getString("cantRechazada");
                String idPed = rs.getString("idPedido");
                String idPress = rs.getString("idPresentacion");
                Object datosRenglon[]={idDt, cPd, pC,sb,cRe,cRh,cAp,idPed,idPress};
                tablaTemp.addRow(datosRenglon);
            }
            Sql = "SELECT SUCURSALES.NOMBRE FROM PEDIDOS\n" +
"INNER JOIN ERP.SUCURSALES\n" +
"ON PEDIDOS.IDSUCURSAL = SUCURSALES.IDSUCURSAL WHERE PEDIDOS.ESTATUS = 'A' or PEDIDOS.ESTATUS = 'E'";
            stn= con.createStatement();
            rs=stn.executeQuery(Sql);
        
            for (int i = 0; rs.next(); i++) {
                 String nombre=rs.getString("nombre");
                 //System.out.println(nombre+"ped");
                 tablaTemp.setValueAt(tablaTemp.getValueAt(i, 7)+" "+nombre, i, 7);
            }
            //comentario
            Sql = "SELECT P.NOMBRE FROM PRESENTACIONESPRODUCTO P inner join PEDIDODETALLE D on P.idPresentacion = D.idpresentacion where P.estatus ='A' or P.estatus = 'E' or P.estatus = 'C'";
            stn= con.createStatement();
            rs=stn.executeQuery(Sql);
          for (int i = 0; rs.next(); i++) {
                 String nombre=rs.getString("NOMBRE");
                 //System.out.println(nombre+"pres");
                 tablaTemp.setValueAt(tablaTemp.getValueAt(i, 8)+" "+nombre, i, 8);
            }
         
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void Proveedores_Search(String Nombre,JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        
         if(Nombre.isEmpty())
            Sql = "select p.idproveedor, p.nombre, p.telefono,"
                    + "p.email,p.direccion,p.colonia,"
                    + "p.codigopostal,p.estatus,p.idciudad, cd.nombre as nom from Proveedores p inner join Ciudad cd "
                    + "on p.idciudad=cd.idciudad where p.estatus='A'";
            
        else if(!Nombre.isEmpty())
            Sql = "select p.idproveedor, p.nombre, p.telefono,"
                    + "p.email,p.direccion,p.colonia,"
                    + "p.codigopostal,p.estatus p.idciudad, "
                    + "cd.nombre as nom from Proveedores p inner join Ciudad cd "
                    + "on p.idciudad=cd.idciudad"
                    + " where p.nombre like '"+Nombre+"%'";
        
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String idsuc=rs.getString("idProveedor");
                String Nom=rs.getString("nombre");
                String tel=rs.getString("telefono");
                String email=rs.getString("email");
                String dir=rs.getString("direccion");
                String col=rs.getString("colonia");
                String cp=rs.getString("codigopostal");
                String Stat = rs.getString("estatus");
                String idcuidad=rs.getString("idciudad");
                String ciudad = rs.getString("nom");
                Object datosRenglon[]={idsuc,Nom,email,tel,dir,col,cp,Stat,idcuidad,ciudad};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

         public void ProductoProveedor_Search(String Nombre,JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
         if(Nombre.isEmpty())
            Sql = "select pro.diasretardo, pro.precioestandar,\n" +
                    "pro.precioultimacompra,pro.cantminpedir,pro.cantmaxpedir,pro.estatus,pre.nombre\n" +
                    "as nom ,prove.nombre as nomb,producto.nombre as nombre from ProductosProveedor pro\n" +
                    "inner join PresentacionesProducto pre on pro.idpresentacion=pre.idpresentacion\n" +
                    "inner join Productos producto on pre.idproducto=producto.idproducto\n" +
                    "inner join Proveedores prove on \n" +
                     "pro.idproveedor=prove.idproveedor where pro.estatus='A'";
            
        else if(!Nombre.isEmpty())
            Sql = "select pro.diasretardo, pro.precioestandar,\n" +
                    "pro.precioultimacompra,pro.cantminpedir,pro.cantmaxpedir,pro.estatus,pre.nombre\n" +
                    "as nom ,prove.nombre as nomb,producto.nombre as nombre from ProductosProveedor pro\n" +
                    "inner join PresentacionesProducto pre on pro.idpresentacion=pre.idpresentacion\n" +
                    "inner join Productos producto on pre.idproducto=producto.idproducto\n" +
                    "inner join Proveedores prove on \n" +
                    "pro.idproveedor=prove.idproveedor where prove.nombre like '"+Nombre+"%'";
        
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String pro= rs.getString("nomb");
                String producto= rs.getString("nombre");
                String pre= rs.getString("nom");
                String dias=rs.getString("diasretardo");
                String precioes = rs.getString("precioestandar");
                String precioul = rs.getString("precioultimacompra");
                String cantmin = rs.getString("cantminpedir");
                String cantmax = rs.getString("cantmaxpedir");
                String estatus = rs.getString("estatus");
                Object datosRenglon[]={pro,producto,pre,dias,precioes,precioul,cantmin,cantmax,estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         public void CuentasProveedor_Search(String Nombre,JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
         if(Nombre.isEmpty())
            Sql = "select cu.idcuentaproveedor, cu.nocuenta,cu.estatus,\n" +
                    "cu.banco,pro.nombre as nom  from CuentasProveedor cu\n" +
                    "inner join Proveedores pro on pro.idproveedor=cu.idproveedor\n" +
                    "where cu.estatus='A'";
            
        else if(!Nombre.isEmpty())
            Sql = "select cu.idcuentaproveedor, cu.nocuenta,cu.estatus,\n" +
                    "cu.banco,pro.nombre as nom  from CuentasProveedor cu\n" +
                    "inner join Proveedores pro on pro.idproveedor=cu.idproveedor where pro.nombre like '"+Nombre+"%'";
        
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String id= rs.getString("idcuentaproveedor");
                String nombre= rs.getString("nom");
                String nocuenta= rs.getString("nocuenta");
                String banco=rs.getString("banco");
                String estatus = rs.getString("estatus");
                Object datosRenglon[]={id,nombre,nocuenta,banco,estatus};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setLocationRelativeTo(Conexion erp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
            public String Name(Object username){
       
       
        Sql="select distinct em.nombre, em.apaterno from usuarios us "
                + "inner join empleados em on em.idempleado=us.idempleado "
                + "where us.nombre='"+username+"' " ;
           
        try {
          
          String status = null;
              String apellido= null;
            stn= con.createStatement();
            rs=stn.executeQuery(Sql);
      
       
            while(rs.next()){
                     status=rs.getString("NOMBRE");  
                      apellido=rs.getString("APATERNO");  
            }
            
                    return status +" " +apellido;  
                      
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
            JOptionPane.showConfirmDialog(null, "User incorrecto");
            return "";
     
     }
        
        
        
        public void setUsuario(String Usuario){
            usuarioname=Usuario;
        }
        
        public String getUsuario(){
            return usuarioname;
        }
    /**
     * @return the con
     */
        
           public void pedidos_search_claves(JTable tabla, String Sql){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String pro= rs.getString("IDPEDIDO");
                String pre= rs.getString("fecharesgistro");
                String dias=rs.getString("FECHARECEPCION");
                String precioes = rs.getString("TOTALPAGAR");
                String precioul = rs.getString("CANTIDADPAGADA");
                String cantmin = rs.getString("ESTATUS");
                String cantmax = rs.getString("NOMBRE");
                String estatus = rs.getString("NOM");
                String estatus1 = rs.getString("NOM1");
                Object datosRenglon[]={pro,pre,dias,precioes,precioul,cantmin,cantmax,estatus,estatus1};
                tablaTemp.addRow(datosRenglon);
            }
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ContactosProveedores_Search(String Nombre,JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        
         if(Nombre.isEmpty())
            Sql = "select cpro.idcontacto, cpro.nombre, cpro.telefono, cpro.email,"
                    + "cpro.estatus, cpro.idproveedor, pro.nombre " 
                     +"as nom from contactosproveedor cpro " 
                     +"inner join proveedores pro " 
                     +"on cpro.idproveedor=pro.idproveedor where cpro.estatus='A'";
        else if(!Nombre.isEmpty())
            Sql = "select cpro.idcontacto, cpro.nombre, cpro.telefono,"
                    + "cpro.email, cpro.estatus, cpro.idproveedor, pro.nombre " 
                     +"as nom from contactosproveedor cpro " 
                     +"inner join proveedores pro " 
                     +"on cpro.idproveedor=pro.idproveedor where cpro.nombre like '"+Nombre+"%'";
        
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String idcon=rs.getString("idcontacto");
                String nomBRE=rs.getString("nombre");
                String tele=rs.getString("telefono");
                String emaill=rs.getString("email");
                String estatus=rs.getString("estatus");
                String idprovee=rs.getString("idproveedor");
                String proveedor = rs.getString("nom");
                Object datosRenglon[]={idcon,nomBRE,tele,emaill,estatus,idprovee,proveedor};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
  
}

