package com.ipartek.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.conexion.Conexion;
import com.ipartek.model.Producto;

public class ProductoDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	//guardar producto
	public boolean guardar(Producto producto) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="INSERT INTO producto(id, nombre, id_usuario) VALUES(?,?,?)";
			
			statement=connection.prepareStatement(sql);
			statement.setInt(1, 0);
			statement.setString(2, producto.getNombre());
			statement.setInt(3, producto.getIdUsuario()); 
			
			estadoOperacion= statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	//editar producto
	public boolean editar(Producto producto) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="UPDATE producto SET nombre=? WHERE id=?";
			
			statement=connection.prepareStatement(sql);
			statement.setString(1, producto.getNombre());
			statement.setInt(2, producto.getId());
			estadoOperacion=statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();

			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	//eliminar producto
	public boolean eliminar(int  idProducto) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="DELETE FROM producto WHERE id=?";
			
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idProducto);

			estadoOperacion=statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();

			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	//obtener lista de producto
	public List<Producto> obtenerProductos() throws SQLException {
		ResultSet resultSet=null;
		List<Producto>listaProductos=new ArrayList<Producto>();
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		try {
			sql="SELECT * FROM producto";
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
				Producto producto=new Producto();
				producto.setId(resultSet.getInt(1));
				producto.setNombre(resultSet.getString(2));
				producto.setIdUsuario(resultSet.getInt(3));
				listaProductos.add(producto);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaProductos;
	}
	
	//obtener producto
	public Producto obtenerProducto(int idProducto) throws SQLException {
		ResultSet resultSet=null;
		Producto producto=new Producto();
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		try {
			sql="SELECT * FROM producto WHERE id=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idProducto);
			resultSet=statement.executeQuery();
			
			if (resultSet.next()) {
				
				producto.setId(resultSet.getInt(1));
				producto.setNombre(resultSet.getString(2));
				producto.setIdUsuario(resultSet.getInt(3));
								
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
	}
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
}
