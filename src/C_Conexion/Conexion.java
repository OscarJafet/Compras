/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_Conexion;
import C_Frames.C_ADD_ProductosProveedor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
     PreparedStatement st=null;
    public String Sql;
    public boolean conex;
    private String usuarioname;
  
    public static Connection getConnection(String User, String Password){
        if(con == null){
            conexionURL = "jdbc:oracle:thin:@192.168.0.1:1521:XE";
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
    
    
      public void SQLAI(String Sql,String array[],File blob,FileInputStream in,String ruta){
          try {
              
     
        
                        
                        st = con.prepareStatement(Sql);
                        
                        
                                st.setString(1, array[0]);
                        
                            blob = new File(ruta);
                        
                          in = new FileInputStream(blob);
                        
                            st.setBinaryStream(2, in, (int)blob.length());
                        
                                 st.setString(3 ,"A");
                        
                        
                        
                          st.setInt(4, Integer.parseInt(array[1]));
                        
                                st.setInt(5, Integer.parseInt(array[2]));
                        
                              
                              rs = st.executeQuery();
                                
              con.commit();
              stn.close();
              JOptionPane.showMessageDialog(null," Acción realizada","Informacion", JOptionPane.INFORMATION_MESSAGE);
              //return true;
              // erp.V = null;
          } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
              //return false;
              //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     
      public void SQLima(String Sql,String array[],File blob,FileInputStream in,String ruta){
          try {
              
     
      st = con.prepareStatement(Sql);
           
   
         st.setString(1, array[0]);
          blob = new File(ruta);
  
          in = new FileInputStream(blob);
          
  st.setBinaryStream(2,in, (int)blob.length());
         
    
      st.setString(3,"A");
      st.setInt(4, Integer.parseInt(array[1]));
     rs= st.executeQuery();
             
              con.commit();
              stn.close();
              JOptionPane.showMessageDialog(null," Acción realizada","Informacion", JOptionPane.INFORMATION_MESSAGE);
              //return true;
              // erp.V = null;
          } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
              //return false;
              //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      public void SQLpp(String Sql){
          try {
              
              stn=(Statement) con.createStatement();
              stn.executeUpdate(Sql);
              con.commit();
              stn.close();
            
          } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
              //return false;
              //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
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
               public void imagen(JTable tabla, String Sql){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);

    
    
        
            while(rs.next()){
                String pro= rs.getString("IDIMAGEN");
                String pre= rs.getString("NOBREIMAGEN");
                String dias=rs.getString("PRINCIPAL");
                String precioes = rs.getString("NOMBRE");
             
                
                Object datosRenglon[]={pro,pre,dias,precioes};
                tablaTemp.addRow(datosRenglon);
            }
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     public float Presupuesto_Sucursal(int id){
         float Re = 0;
         Sql = "select sc.presupuesto from  sucursal sc inner join Pedidos pe on pe.idsucursal = sc.idsucursal where idpedido = "+id;
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                String pre=rs.getString("presupuesto");
                Re = Float.parseFloat(pre);
            }
            return Re;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error Categorias" ,JOptionPane.INFORMATION_MESSAGE);
        }
               return Re;
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
     public void Pagos_Search_Bien_Vergas(String Nombre, JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if(Nombre.isEmpty())
            Sql = "select pg.idpago,pg.fecha,sc.nombre,sc.direccion,sc.telefono,pr.nombre,pg.idcuentaproveedor,cp.nocuenta,pr.direccion,pr.telefono,fp.nombre,pe.cantidadpagada,pg.importe,pg.idpedido,pg.estatus from pagos pg\n" +
"inner join pedidos pe on pg.idpedido = pe.idpedido inner join sucursal sc on pe.idsucursal = sc.idsucursal \n" +
"inner join cuentasproveedor cp on pg.idcuentaproveedor = cp.idcuentaproveedor inner join proveedores pr on cp.idproveedor = pr.idproveedor\n" +
"inner join Formaspago fp on pg.idformapago = fp.idformapago";
        else if(!Nombre.isEmpty())
            Sql = "select pg.idpago,pg.fecha,sc.nombre, sc.direccion,sc.telefono,pr.nombre,pg.idcuentaproveedor,cp.nocuenta,pr.direccion,pr.telefono,fp.nombre,pe.cantidadpagada,pg.importe,pg.idpedido,pg.estatus from pagos pg\n" +
"inner join pedidos pe on pg.idpedido = pe.idpedido inner join sucursal sc on pe.idsucursal = sc.idsucursal \n" +
"inner join cuentasproveedor cp on pg.idcuentaproveedor = cp.idcuentaproveedor inner join proveedores pr on cp.idproveedor = pr.idproveedor\n" +
"inner join Formaspago fp on pg.idformapago = fp.idformapago where pr.nombre like '"+Nombre+"%'";
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        
            while(rs.next()){
                //System.out.println("entra");
                String IDP=rs.getString(1);
                String F=rs.getString(2);
                String NomSC = rs.getString(3);
                String DIRS=rs.getString(4);
                String TELS=rs.getString(5);
                String NP=rs.getString(6);
                String IDC=rs.getString(7);
                String NC=rs.getString(8);
                String DIRP=rs.getString(9);
                String TELP=rs.getString(10);
                String NFP=rs.getString(11);
                String CP = rs.getString(12);
                String IMP=rs.getString(13);
                String IDPED=rs.getString(14);
                String Est = rs.getString(15);
                Object datosRenglon[]={IDP,F,NomSC,DIRS,TELS,NP,IDC,NC,DIRP,TELP,NFP,CP,"Ver Detalles","Ver Detalles",IMP,IMP,IMP,IDPED,Est};
                tablaTemp.addRow(datosRenglon);
            }
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error Categorias" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }
     public void SelectP_Search(JTable tabla){
         DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        Sql = "select P.idPedido,p.fecharesgistro,p.fecharecepcion,p.totalpagar,\n" +
"p.cantidadpagada,p.estatus, c.idproveedor,c.nombre,p.idsucursal\n" +
"from ERP.Pedidos P inner join ERP.Proveedores c on p.idproveedor = c.idproveedor \n" +
"where p.estatus = 'E'";
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
        int idPe = 0;
            while(rs.next()){
                String idPed=rs.getString("IDPEDIDO");
                String feReg=rs.getString("FECHARESGISTRO");
                String feRecp=rs.getString("FECHARECEPCION");
                String Tp = rs.getString("TOTALPAGAR");
                String CantPag = rs.getString("CANTIDADPAGADA");
                String Est = rs.getString("ESTATUS");
                String idProv = rs.getString("IDPROVEEDOR");
                String NomPro = rs.getString("NOMBRE");
                String idSc = rs.getString("idSucursal");
                Object datosRenglon[]={ idPed, feReg, feRecp,Tp,CantPag,Est,idProv,NomPro,idSc};
                tablaTemp.addRow(datosRenglon);
            }
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"No hay pedidos?" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }
     public String Det_Pagos_Ya_Me_Enfade(int id){
         String Det = "";
        Sql = "select cantPedida,subtotal,\n" +
" cantRecibida,cantRechazada,cantAceptada from PedidoDetalle where idPedido = "+id;
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
            while(rs.next()){
                String feReg=rs.getString("CANTPEDIDA");
                //String feRecp=rs.getString("PRECIOCOMPRA");
                String Tp = rs.getString("SUBTOTAL");
                String CantPag = rs.getString("CANTRECIBIDA");
                String Est = rs.getString("CANTRECHAZADA");
                String idProv = rs.getString("CANTACEPTADA");
                Det += "Cant P: "+feReg+", Cant R: "+CantPag+"\nCant Re: "+Est+", Cant A: "+idProv+"\n SubTotal:"+Tp+"\n";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"No hay detalles?" ,JOptionPane.INFORMATION_MESSAGE);
        }
               return Det;
    }
     public String Det_Pagos_Neta_Ya(int id){
         String Det = "";
        Sql = "select precioCompra\n" +
"  from PedidoDetalle where idPedido = "+id;
               try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
            while(rs.next()){
                String feRecp=rs.getString("PRECIOCOMPRA");
                Det += "P.Unitario: "+feRecp+"\n\n\n";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"No hay detalles?" ,JOptionPane.INFORMATION_MESSAGE);
        }
               return Det;
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
      public void Presentacion_seacrh(String Nombre, JTable tabla) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if (Nombre.isEmpty()) {
            Sql = "select PresentacionesProducto.idPresentacion, PresentacionesProducto.precioCompra,\n" +
                    "PresentacionesProducto.precioVenta,PresentacionesProducto.puntoReorden,\n" +
                    "PresentacionesProducto.idProducto,PresentacionesProducto.idEmpaque,PresentacionesProducto.estatus,PresentacionesProducto.nombre,\n" +
                    "Productos.nombre as nom, Empaques.nombre as nomb\n" +
                    "from presentacionesproducto\n" +
                    "inner join ERP.Empaques\n" +
                    "on PresentacionesProducto.idEmpaque = Empaques.idEmpaque\n" +
                    "inner join ERP.Productos\n" +
                     "on PresentacionesProducto.idProducto = Productos.idProducto where PresentacionesProducto.estatus = 'A'";
        } else if (!Nombre.isEmpty()) {
            Sql = "select PresentacionesProducto.idPresentacion, PresentacionesProducto.precioCompra,\n" +
                    "PresentacionesProducto.precioVenta,PresentacionesProducto.puntoReorden,\n" +
                    "PresentacionesProducto.idProducto,PresentacionesProducto.idEmpaque,PresentacionesProducto.estatus,PresentacionesProducto.nombre,\n" +
                    "Productos.nombre as nom, Empaques.nombre as nomb\n" +
                    "from presentacionesproducto\n" +
                    "inner join ERP.Empaques\n" +
                    "on PresentacionesProducto.idEmpaque = Empaques.idEmpaque\n" +
                    "inner join ERP.Productos\n" +
                    "on PresentacionesProducto.idProducto = Productos.idProducto where Productos.nombre like '" + Nombre + "%'";
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
                String nom1 = rs.getString("nom");
                String idEmp = rs.getString("idEmpaque");
                String nomb = rs.getString("nomb");
                String stat = rs.getString("estatus");
                String nom = rs.getString("nombre");
                Object datosRenglon[]={idPress, preCom, preVent,pReorden,idPro+" "+nom1,idEmp+" "+nomb,stat,nom};
                tablaTemp.addRow(datosRenglon);
            }
            
            tabla.setModel(tablaTemp);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
      public void Detalles_seacrh(String Nombre, JTable tabla, char Stat) {
        DefaultTableModel tablaTemp = (DefaultTableModel) tabla.getModel();
        if (Nombre.isEmpty() && Stat == 'E') {
            Sql = "SELECT d.idpedidodetalle,d.cantPedida,d.preciocompra,d.subtotal,d.cantrecibida,d.cantrechazada,d.cantAceptada,"
                    + "d.idpedido,sc.nombre,r.idpresentacion, r.nombre from Pedidodetalle d inner join Pedidos p on d.idPedido = p.idpedido"
                    + " inner join Presentacionesproducto r on r.idpresentacion = d.idpresentacion inner join sucursal sc "
                    + "on p.idsucursal = sc.idsucursal where d.estatus = 'E'";
        } else if (!Nombre.isEmpty() && Stat == 'E') {
            Sql = "SELECT d.idpedidodetalle,d.cantPedida,d.preciocompra,d.subtotal,d.cantrecibida,d.cantrechazada,d.cantAceptada,"
                    + "d.idpedido,sc.nombre,r.idpresentacion, r.nombre from Pedidodetalle d inner join Pedidos p on d.idPedido = p.idpedido"
                    + " inner join Presentacionesproducto r on r.idpresentacion = d.idpresentacion inner join sucursal sc "
                    + "on p.idsucursal = sc.idsucursal where r.nombre like '"+Nombre+"%' and d.estatus = 'E'";
        } else if (Stat == 'A' || Stat == 'C' || Stat == 'E') {
            Sql = "SELECT d.idpedidodetalle,d.cantPedida,d.preciocompra,d.subtotal,d.cantrecibida,d.cantrechazada,d.cantAceptada,"
                    + "d.idpedido,sc.nombre,r.idpresentacion, r.nombre from Pedidodetalle d inner join Pedidos p on d.idPedido = p.idpedido"
                    + " inner join Presentacionesproducto r on r.idpresentacion = d.idpresentacion inner join sucursal sc "
                    + "on p.idsucursal = sc.idsucursal where p.estatus = '"+Stat+"'";
        }
      try {
            stn=(Statement) con.createStatement();
            rs=stn.executeQuery(Sql);
          //System.out.println(Sql);
          
            while(rs.next()){
                
                String idDt=rs.getString(1);
                String cPd=rs.getString(2);
                String pC=rs.getString(3);
                String sb = rs.getString(4);
                String cAp = rs.getString(5);
                String cRe = rs.getString(6);
                String cRh = rs.getString(7);
                String idPed = rs.getString(8);
                String SCnom = rs.getString(9);
                String idPress = rs.getString(10);
                String NomPres = rs.getString(11);
                
                Object datosRenglon[]={idDt, cPd, pC,sb,cRe,cRh,cAp,idPed,SCnom,idPress,NomPres};
                tablaTemp.addRow(datosRenglon);
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

