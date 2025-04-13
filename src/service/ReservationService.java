package service;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import connexion.Connexion;
import entities.Categorie;
import entities.Chambre;
import entities.Client;
import entities.Reservation;
import dao.IDAO;

public class ReservationService implements IDAO<Reservation>{

	@Override
	public boolean create(Reservation o) {
		String req="insert into reservation(dateDebut,dateFin,idClient,idChambre) values(?,?,?,?)";
		try {
			PreparedStatement ps=Connexion.getcnx().prepareStatement(req);
			ps.setDate(1,new Date(o.getDateDebut().getTime()));
			ps.setDate(2,new Date(o.getDateFin().getTime()));
			ps.setInt(3,o.getClt().getId());
			ps.setInt(4,o.getCh().getId());
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
	public boolean update(Reservation o) {
		String req="update reservation set dateDebut=?, dateFin=? where id=?";
		try {
			PreparedStatement ps=Connexion.getcnx().prepareStatement(req);
			ps.setDate(1,new Date(o.getDateDebut().getTime()));
                        ps.setDate(2, new Date(o.getDateFin().getTime()));
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
	public boolean delete(Reservation o) {
		String req="delete from reservation where id=?";
		try {
			PreparedStatement ps=Connexion.getcnx().prepareStatement(req);
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
	public Reservation findById(int id) {
		String req="select * from reservation where id=?";
		try {
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			ClientService client=new ClientService();
			ChambreService chambre=new ChambreService();
			
			if(rs.next()) {
				
		Chambre Chambre = chambre.findById(rs.getInt("idChambre"));
                Client Client = client.findById(rs.getInt("idClient"));
                Reservation reservation = new Reservation(1,rs.getDate("dateDebut"),
                        rs.getDate("dateFin"),
                        Client,
                        Chambre
                        );
                reservation.setId(rs.getInt("id"));
                reservation.setDateDebut(rs.getDate("dateDebut"));
                reservation.setDateFin(rs.getDate("dateFin"));
                reservation.setClt(Client);
                reservation.setCh(Chambre);
                
                System.out.println("Reservation found.");
                return reservation;
			}
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL");
		}
		return null;
	}

	

	@Override
	public List<Reservation> findAll() {
		String req="select * from reservation;";
		try {
			
			PreparedStatement ps= Connexion.getcnx().prepareStatement(req);
			ResultSet rs=ps.executeQuery();
			List<Reservation> reservationList = new ArrayList<>();
            ClientService clientService = new ClientService();
            ChambreService chambreService = new ChambreService();
			while(rs.next()==true) {
				Chambre chambre = chambreService.findById(rs.getInt("idChambre"));
                Client client = clientService.findById(rs.getInt("idClient"));
                Reservation reservation = new Reservation(
                        1,
                	rs.getDate("dateDebut"),
                        rs.getDate("dateFin"),
                        client,
                        chambre
                        );
                reservation.setId(rs.getInt("id"));
                reservation.setDateDebut(rs.getDate("dateDebut"));
                reservation.setDateFin(rs.getDate("dateFin"));
                reservation.setClt(client);
                reservation.setCh(chambre);
                reservationList.add(reservation);
			
			}
			return reservationList;
			
		}
		
		catch(SQLException e) {
			System.out.println("Erreur SQL");
		}
		return null;
	}

	
}
