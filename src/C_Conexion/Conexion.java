/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     public boolean Log_in(String Usr, String Psw){
       Sql = "select * from ERP.Usuarios where nombre ='"+Usr+"' and contraseña = '"+Psw+"'";
         try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
            String NOM = "";
            String PSW = "";
            while(rs.next()){
                NOM=rs.getString("NOMBRE");
                PSW=rs.getString("CONTRASEÑA");
            }
            if(NOM.equals(Usr) && PSW.equals(Psw))
                return true;
            else
                return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
            return false;
        }   
     }
             
     
     public void Categorias_Search(String Nombre, JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if(Nombre.isEmpty())
            Sql = "select * from Categorias";
        else if(!Nombre.isEmpty())
            Sql = "select * from Categorias where nombre = '"+Nombre+"'";
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
    public void Lab_Search(String Nombre, JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if(Nombre.isEmpty())
            Sql = "select * from Laboratorios";
        else if(!Nombre.isEmpty())
            Sql = "select * from Laboratorios where nombre = '"+Nombre+"'";
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
            Sql = "select * from Empaques";
        else if(!Nombre.isEmpty())
            Sql = "select * from Empaques where nombre = '"+Nombre+"'";
        
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String idLab=rs.getString("idEmpaque");
                String Nom=rs.getString("nombre");
                String Ori=rs.getString("capacidad");
                String Stat = rs.getString("estatus");
                String IDPK = rs.getString("idUnidad");
                Object datosRenglon[]={ idLab, Nom, Ori,Stat,IDPK};
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
            Sql = "select * from UnidadMedida";
        else if(!Nombre.isEmpty())
            Sql = "select * from UnidadMedida where nombre = '"+Nombre+"'";
        
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
    
         public void Producto_Search(String Nombre,JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if(Nombre.isEmpty())
            Sql = "select * from Productos where estatus='A'";
        else if(!Nombre.isEmpty())
            Sql = "select * from Productos where nombre = '"+Nombre+"'";
        
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String idPro=rs.getString("idproducto");
                String Nom=rs.getString("nombre");
                String descripcion=rs.getString("descripcion");
                String punto = rs.getString("puntoreorden");
                String ingrediente = rs.getString("ingredienteactivo");
                String banda = rs.getString("bandatoxicologica");
                String apli = rs.getString("aplicacion");
                String uso = rs.getString("uso");
                String estatus = rs.getString("estatus");
                String lab = rs.getString("idlaboratorio");
                String cat = rs.getString("idcategoria");
                Object datosRenglon[]={ idPro, Nom, descripcion,punto,ingrediente,banda,apli,uso,estatus,lab,cat};
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
            Sql = "select * from sucursal where estatus='A'";
        else if(!Nombre.isEmpty())
            Sql = "select * from sucursal where nombre = '"+Nombre+"'";
        
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
                Object datosRenglon[]={idsuc,Nom,tel,dir,col,cp,pre,Stat,ciu};
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
                
                String Stat2 = rs.getString("CANTIDAD");
                String Stat = rs.getString("NOM");
                 String Stat3 = rs.getString("NO");
                Object datosRenglon[]={idLab1,idLab2, idLab, Nom, Ori,Stat2,Stat,Stat3};
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
                
                String Stat2 = rs.getString("CANTIDAD");
                String Stat = rs.getString("NOM");
                 String Stat3 = rs.getString("NO");
                Object datosRenglon[]={idLab1,idLab2, idLab, Nom, Ori,Stat2,Stat,Stat3};
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
      public void Presentacion_seacrh(String Nombre, JTable tabla,char Stat){
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if(Nombre.isEmpty()&&Stat =='E')
            Sql = "select PresentacionesProducto.idPresentacion, PresentacionesProducto.precioCompra,\n" +
"PresentacionesProducto.precioVenta,PresentacionesProducto.puntoReorden,\n" +
"PresentacionesProducto.idProducto,PresentacionesProducto.idEmpaque,PresentacionesProducto.estatus\n" +
"from presentacionesproducto\n" +
"inner join ERP.Productos\n" +
"on PresentacionesProducto.idProducto = Productos.idProducto and Productos.estatus = 'A'";
        else if(!Nombre.isEmpty()&&Stat =='E'){
            Sql = "select PresentacionesProducto.idPresentacion, PresentacionesProducto.precioCompra,\n" +
"PresentacionesProducto.precioVenta,PresentacionesProducto.puntoReorden,\n" +
"PresentacionesProducto.idProducto,PresentacionesProducto.idEmpaque,PresentacionesProducto.estatus\n" +
"from presentacionesproducto\n" +
"inner join ERP.Productos\n" +
"on PresentacionesProducto.idProducto = Productos.idProducto and Productos.estatus = 'A' and Productos.nombre = '"+Nombre+"'";
        }else if (Stat == 'A' || Stat == 'B'){
            Sql = "select PresentacionesProducto.idPresentacion, PresentacionesProducto.precioCompra,\n" +
"PresentacionesProducto.precioVenta,PresentacionesProducto.puntoReorden,\n" +
"PresentacionesProducto.idProducto,PresentacionesProducto.idEmpaque,PresentacionesProducto.estatus\n" +
"from presentacionesproducto\n" +
"inner join ERP.Productos\n" +
"on PresentacionesProducto.idProducto = Productos.idProducto and PresentacionesProducto.estatus = '"+Stat+"'";
        }
        System.out.println(Sql);
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
                Object datosRenglon[]={idPress, preCom, preVent,pReorden,idPro,idEmp,stat};
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

    /**
     * @return the con
     */
  
}

