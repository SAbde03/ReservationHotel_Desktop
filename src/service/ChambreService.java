package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDAO;
import entities.Categorie;
import entities.Chambre;


public class ChambreService implements IDAO<Chambre>{

	@Override
	public boolean create(Chambre o) {
		String req="insert into chambre(telephone, categId) values(?,?)";
		try {
			PreparedStatement ps=Connexion.getcnx().prepareStatement(req);
			ps.setString(1,o.getTelephone());
                        ps.setInt(2,o.getCateg().getId());
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
	public boolean update(Chambre o) {
		String req="update chambre set telephone=? where id=?";
		try {
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req);
			ps.setString(1,o.getTelephone());
			ps.setInt(2,1);  
			
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
	public boolean delete(Chambre o) {
		String req="Delete from chambre where id=?";
		try {
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req);
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
	public Chambre findById(int id) {
		String req="select * from chambre where id=?";
		try {
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req);
			ps.setInt(1,id);  
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				CategorieService cat =new CategorieService();
				Chambre chambre=new Chambre(1,"",cat.findById(1));
				chambre.setId(rs.getInt("id"));
				chambre.setTelephone(rs.getString("telephone"));
				CategorieService CategServ=new CategorieService();
				chambre.setCateg(CategServ.findById(rs.getInt("categId")));
				return chambre;
			}
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL");
		}
		return null;
	}

	@Override
	public List<Chambre> findAll() {
		String req="select * from chambre";
		List<Chambre> chambres=new ArrayList<>();
		
		try {
			
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req);
			ResultSet rs=ps.executeQuery();
			while(rs.next()==true) {
				CategorieService cat =new CategorieService();
				Chambre chambre=new Chambre(1,"",cat.findById(1));
				chambre.setId(rs.getInt("id"));
				chambre.setTelephone(rs.getString("telephone"));
				CategorieService CategServ=new CategorieService();
				chambre.setCateg(CategServ.findById(rs.getInt("categId")));
				
				chambres.add(chambre);
				}
				return chambres;
				
			
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL");
		}
		return null;
	}
	
}
