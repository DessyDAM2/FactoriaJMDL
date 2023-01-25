package org.jmdl.fp2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1 -> crearTablas();
                case 2 -> borrarTablas();
                case 3 -> crearBD();
                case 0 -> System.out.println("Salir");
            }
        } while (opcion != 0);


    }

    public static int menu() {
        System.out.println("Crear tablas");
        System.out.println("Borrar tablas");
        System.out.println("Modificar Datos");
        System.out.println("Salir");
        return sc.nextInt();
    }

    public static void crearTablas(){
        try(Connection connection = Conexion.conectar()){
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE Participantes (" +
                    "AUTO_ID int not null auto_increment primary key ," +
                    " Proyecto_ID int not null," +
                    "ID_Usuario int not null, Cordinador varchar(20)," +
                    "Fec_Ini date ," +
                    "Fec_Fin date/*, " +
                    "foreign key (Proyecto_ID)REFERENCES Proyectos(Proyecto_ID), foreign key (ID_Usuario) REFERENCES Usuario(ID_Usuario)*/)");
        statement.execute("CREATE TABLE Proyectos (" +
                "AUTO_ID int not null auto_increment primary key" +
                ")");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void borrarTablas(){

    }

    public static void crearBD(){

    }
}