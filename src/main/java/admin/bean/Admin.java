package admin.bean;

public class Admin {
	private int id;
	private String nom;
	private String email;
	private String telephone;
	private String password;
	
	public Admin(int id, String nom, String email, String telephone, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
	}

	public Admin(String nom, String email, String telephone, String password) {
		super();
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
