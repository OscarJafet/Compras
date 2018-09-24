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
    private static Connection con=null;
    private Statement stn=null;
    private ResultSet rs=null;
    JTable tablaTemp;
    String Sql;
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

    /**
     * @return the con
     */
  
}

