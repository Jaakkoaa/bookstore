package palvelinohjelmointi.bookstore.domain;

import javax.persistence.*;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private long id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "password", nullable = false, unique = false)
	private String passwordHash;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role", nullable = false, unique = false)
	private String role;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	public User() {
    }
	
	public User(String username, String passwordHash, String role, String email) {
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
