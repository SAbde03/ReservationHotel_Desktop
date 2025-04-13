package entities;

public class Chambre {
  private int id;
  private int count=0;
  private String telephone;
  private Categorie categ;
  
public Chambre(String telephone, Categorie categ) {
	this.id=count++;
	this.telephone = telephone;
	this.categ=categ;
}

public Chambre(int id,String telephone, Categorie categ) {
	this.id=id;
	this.telephone=telephone;
	this.categ=categ;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}

public Categorie getCateg() {
	return categ;
}

public void setCateg(Categorie categ) {
	this.categ = categ;
}

@Override
public String toString() {
    
	//return "Chambre [id=" + id + ", telephone=" + telephone + ", categ=" + categ + "]";
        return telephone;
}


  
  
}
