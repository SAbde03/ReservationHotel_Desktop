package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDAO;
import entities.Utilisateur;

public class Userservice implements IDAO<Utilisateur>{

	@Override
	public boolean create(Utilisateur o) {
		String req="insert into utilisateur(nom,prenom,email,password) values(?,?,?,?)";
		try {
			PreparedStatement ps=Connexion.getcnx().prepareStatement(req);
			ps.setString(1,o.getNom());
			ps.setString(2,o.getPrenom());
			ps.setString(4,o.getPassword());
			ps.setString(3,o.getEmail());
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
	public boolean update(Utilisateur o) {
		String req="update utilisateur set nom=?,prenom=?,email=?,password=? where Id=?";
		try {
			PreparedStatement ps=Connexion.getcnx().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(4, o.getPassword());
			ps.setString(3, o.getEmail());
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
	public boolean delete(Utilisateur o) {
		String req2="Delete from utilisateur where Id=?";
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
	public Utilisateur findById(int id) {
		String req3="select * from utilisateur where Id=?";
		try {
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req3);
			ps.setInt(1,id);  
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Utilisateur user=new Utilisateur(1,"","","","");
				user.setId(rs.getInt("id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				
				return user;
			}
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL");
		}
		return null;
	}

	@Override
	public List<Utilisateur> findAll() {
		String req4="select * from utilisateur";
		List<Utilisateur> clients=new ArrayList<>();
		
		try {
			
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req4);
			ResultSet rs=ps.executeQuery();
			while(rs.next()==true) {
				Utilisateur user=new Utilisateur(1,"","","","");
				user.setId(rs.getInt("id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				clients.add(user);
				}
				return clients;
				
			
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL");
		}
		return null;
	}

}

