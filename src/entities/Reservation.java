package entities;

import java.util.Date;

public class Reservation {
    private int id;
  private static int count=0;
  private Date dateDebut;
  private Date dateFin;
  private Client clt;
  private Chambre ch;
public Reservation(Date dateDebut, Date dateFin, Client clt, Chambre ch) {
	this.id=count++;
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
	this.clt = clt;
	this.ch = ch;
}
public Reservation(int id,Date dateDebut, Date dateFin, Client clt, Chambre ch) {
	this.id=id;
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
	this.clt = clt;
	this.ch = ch;
}
public int getId() {
	 return id;
	}

public void setId(int id) {
		this.id = id;
}
public Date getDateDebut() {
	return dateDebut;
}
public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}
public Date getDateFin() {
	return dateFin;
}
public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}
public Client getClt() {
	return clt;
}
public void setClt(Client clt) {
	this.clt = clt;
}
public Chambre getCh() {
	return ch;
}
public void setCh(Chambre ch) {
	this.ch = ch;
}
@Override
public String toString() {
	return "Reservation [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", clt=" + clt + ", ch=" + ch + "]\n";
}
  
  
}
