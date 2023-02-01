package org.jmdl.fp2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    static String DBName=null;

    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            DBName="FactoriaProyectos";
            addDB();
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

    public static void crearTablas() {

        try (Connection connection = Conexion.conectar()) {
            Statement statement = connection.createStatement();

            //Tabla Proyectos
            statement.execute("CREATE TABLE Proyectos (" +
                    "AUTO_ID int not null auto_increment primary key," +
                    "PROYECTO_ID int not null unique," +
                    "Titulo varchar(20)," +
                    "Descripcion varchar(120)," +
                    "Coordinador varchar(20)," +
                    "Estado varchar(20)," +
                    "Visibilidad varchar(20)," +
                    "Visitas int)");

            //Tabla Centros
            statement.execute("CREATE TABLE Centros(" +
                    "AUTO_ID int not null auto_increment primary key," +
                    "ID_CENTRO int not null unique," +
                    "Nombre varchar(20)," +
                    "Web varchar(20)," +
                    "Contacto varchar(20))");

            //Tabla Familia Profesional
            statement.execute("CREATE TABLE FamiliaProfesional(" +
                    "AUTO_ID int not null auto_increment primary key," +
                    "FAMILIA_PROFESIONAL_ID int not null unique," +
                    "Nombre_Familia varchar(60) not null unique)");


            //Tabla usuarios
            statement.execute("CREATE TABLE Usuario(" +
                    "AUTO_ID int not null auto_increment primary key ," +
                    "ID_Centro int not null ," +
                    "ID_USUARIO int not null unique ," +
                    "Nombre varchar(20) ," +
                    "Apellidos varchar(20)," +
                    "Contraseña varchar(30)," +
                    "Rol varchar(15)," +
                    "Puntuacion double ," +
                    "Familia_Profesional int not null," +
                    "Email varchar(20)," +
                    "Telefono int," +
                    "foreign key (Familia_Profesional) REFERENCES FamiliaProfesional(FAMILIA_PROFESIONAL_ID)," +
                    "foreign key (ID_Centro) REFERENCES Centros(ID_CENTRO) "+
                    ")");

            //Tabla Participantes
            statement.execute("CREATE TABLE Participantes (" +
                    "AUTO_ID int not null auto_increment primary key ," +
                    "Proyecto_id int not null," +
                    "id_Usuario int not null, " +
                    "Cordinador varchar(20)," +
                    "Fec_Ini date ," +
                    "Fec_Fin date, " +
                    "foreign key (Proyecto_id)REFERENCES Proyectos(PROYECTO_ID), " +
                    "foreign key (id_Usuario) REFERENCES Usuario(ID_USUARIO)" +

                    ")");

            //Tabla Comentarios
            statement.execute("CREATE TABLE Comentarios(" +
                    "AUTO_ID int not null auto_increment primary key ," +
                    "Escritor int not null ," +
                    "Proyecto_id int not null ," +
                    "Contenido varchar(20)," +
                    "foreign key (Escritor) REFERENCES Usuario(ID_USUARIO)," +
                    "foreign key (Proyecto_id)REFERENCES Proyectos(PROYECTO_ID) "+
                    ")");

            //Tabla Gustos
            statement.execute("CREATE TABLE Gustos(" +
                    "AUTO_ID int not null auto_increment primary key," +
                    "ID_USUARIO int not null," +
                    "Gusto varchar(20)," +
                    "foreign key (ID_USUARIO) REFERENCES Usuario(ID_USUARIO))");

            //Tabla Familia Profesional Implicada
            statement.execute("CREATE TABLE FamiliaProfesionalImplicada(" +
                    "AUTO_ID int not null auto_increment primary key," +
                    "Proyecto_ID int not null," +
                    "FAMILIA_PROFESIONAL_ID int not null," +
                    "foreign key (Proyecto_ID) REFERENCES Proyectos(PROYECTO_ID)," +
                    "foreign key (FAMILIA_PROFESIONAL_ID) REFERENCES FamiliaProfesional(FAMILIA_PROFESIONAL_ID))");

            //Tabla ProyectosFav
            statement.execute("CREATE TABLE ProyectosFav(" +
                    "AUTO_ID int not null auto_increment primary key ," +
                    "Proyecto_ID int not null," +
                    "ID_USUARIO int not null ," +
                    "foreign key (Proyecto_ID) REFERENCES Proyectos(PROYECTO_ID)," +
                    "foreign key (ID_USUARIO) REFERENCES Usuario(ID_USUARIO))");

            //Tabla CentrosDeProyectos
            statement.execute("CREATE TABLE CentrosDeProyecto(" +
                    "AUTO_ID int not null auto_increment primary key," +
                    "Proyecto_ID int not null," +
                    "ID_Centro int not null ," +
                    "foreign key (Proyecto_ID) REFERENCES Proyectos(PROYECTO_ID)," +
                    "foreign key (ID_Centro) REFERENCES Centros(ID_CENTRO))");

            //Tabla Tags
            statement.execute("CREATE TABLE Tags(" +
                    "AUTO_ID int not null auto_increment primary key," +
                    "Proyecto_ID int not null ," +
                    "Tag varchar(20)," +
                    "foreign key (Proyecto_ID) REFERENCES Proyectos(PROYECTO_ID))");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void borrarTablas() {
        try (Connection connection = Conexion.conectar()) {

            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS Tags");
            statement.execute("DROP TABLE IF EXISTS ProyectosFav");
            statement.execute("DROP TABLE IF EXISTS CentrosDeProyecto");
            statement.execute("DROP TABLE IF EXISTS FamiliaProfesionalImplicada");
            statement.execute("DROP TABLE IF EXISTS Gustos");
            statement.execute("DROP TABLE IF EXISTS Comentarios");
            statement.execute("DROP TABLE IF EXISTS Participantes");
            statement.execute("DROP TABLE IF EXISTS Usuario");
            statement.execute("DROP TABLE IF EXISTS FamiliaProfesional");
            statement.execute("DROP TABLE IF EXISTS Proyectos");
            statement.execute("DROP TABLE IF EXISTS Centros");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void crearBD() {
        try (Connection connection = Conexion.conectar()) {
            Statement statement = connection.createStatement();
            DBName="FactoriaProyectos";
            statement.execute("CREATE DATABASE "+DBName+"");
            if (!Conexion.getURL().contains(DBName)){
                Conexion.setURL("/"+DBName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addDB(){
        if (!Conexion.getURL().contains(DBName)){
            Conexion.setURL("/"+DBName);
        }
    }

}