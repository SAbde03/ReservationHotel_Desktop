package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDAO;
import entities.Categorie;
import entities.Client;

public class CategorieService implements IDAO<Categorie>{

	@Override
	public boolean create(Categorie o) {
		String req="insert into categorie(code,libelle) values(?,?)";
		try {
			PreparedStatement ps=Connexion.getcnx().prepareStatement(req);
			ps.setString(1,o.getCode());
			ps.setString(2,o.getLibelle());
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
	public boolean update(Categorie o) {
		String req="update categorie set code=?,libelle=? where id=?";
		try {
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req);
			ps.setString(1,o.getCode());
                        ps.setString(2,o.getLibelle());
			ps.setInt(3,o.getId());  
			
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
	public boolean delete(Categorie o) {
		String req2="Delete from categorie where id=?";
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
	public Categorie findById(int id) {
		String req3="select * from categorie where id=?";
		try {
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req3);
			ps.setInt(1,id);  
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Categorie categorie=new Categorie(1,"","");
				categorie.setId(rs.getInt("id"));
				categorie.setCode(rs.getString("code"));
				categorie.setLibelle(rs.getString("libelle"));
				return categorie;
			}
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL");
		}
		return null;
	}

	@Override
	public List<Categorie> findAll() {
		String req="select * from categorie";
		List<Categorie> categories=new ArrayList<>();
		
		try {
			
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req);
			ResultSet rs=ps.executeQuery();
			while(rs.next()==true) {
				Categorie categorie=new Categorie(1,"","");
				categorie.setId(rs.getInt("id"));
				categorie.setCode(rs.getString("code"));
				categorie.setLibelle(rs.getString("libelle"));
				
				categories.add(categorie);
				}
				return categories;
				
			
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL");
		}
		return null;
	}

}
