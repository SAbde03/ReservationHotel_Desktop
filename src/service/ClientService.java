package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDAO;
import entities.Client;

public class ClientService implements IDAO<Client>{

	@Override
	public boolean create(Client o) {
		String req="insert into client values(null,?,?,?,?)";
		try {
			PreparedStatement ps=Connexion.getcnx().prepareStatement(req);
			ps.setString(1,o.getNom());
			ps.setString(2,o.getPrenom());
			ps.setString(3,o.getTelephone());
			ps.setString(4,o.getEmail());
			if(ps.executeUpdate()==1) {
				return true;
			}
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL");
		}
		return false;
	}

	@Override
	public boolean update(Client o) {
		String req="update client set nom=?,prenom=?,telephone=?,email=? where id=?";
		try {
			PreparedStatement ps=Connexion.getcnx().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getTelephone());
			ps.setString(4, o.getEmail());
			ps.setInt(5, o.getId());
			if(ps.executeUpdate()==1) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Erreur de create SQL");
		}
		return false;
	}

	@Override
	public boolean delete(Client o) {
		String req2="Delete from client where id=?";
		try {
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req2);
			ps.setInt(1,o.getId());  
			if(ps.executeUpdate()==1) {
				return true;
			}
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL");
		}
		return false;
	}

	@Override
	public Client findById(int id) {
		String req3="select * from client where id=?";
		try {
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req3);
			ps.setInt(1,id);  
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Client client=new Client(1,"","","","");
				client.setId(rs.getInt("id"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setTelephone(rs.getString("telephone"));
				client.setEmail(rs.getString("email"));
				
				return client;
			}
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL");
		}
		return null;
	}

	@Override
	public List<Client> findAll() {
		String req4="select * from client";
		List<Client> clients=new ArrayList<>();
		
		try {
			
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req4);
			ResultSet rs=ps.executeQuery();
			while(rs.next()==true) {
				Client client=new Client(1,"","","","");
				client.setId(rs.getInt("id"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setTelephone(rs.getString("telephone"));
				client.setEmail(rs.getString("email"));
				clients.add(client);
				}
				return clients;
				
			
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL");
		}
		return null;
	}

}
