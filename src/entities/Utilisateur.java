/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author golde
 */
public class Utilisateur {
        private int id;
	private String nom;
	private String prenom;
	private String password;
	private String email;
	private static int count=0;
        
        public Utilisateur(String nom, String prenom, String password, String email) {
		this.id=count++;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
	}

	public Utilisateur(int id,String nom, String prenom, String password, String email) {
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String telephone) {
		this.password = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		/*return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", email="
				+ email + "]";*/
                  return nom+" "+prenom;
        
        }
}
