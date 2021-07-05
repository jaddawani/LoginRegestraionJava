package com.axsos.logandreg.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 10, max = 10, message = "Number Must be 10 Numbers")
    private String phone;
	@Size(min = 2, max = 20, message = "First Name must be greater than 2 characters")
	private String firstName;
	@Size(min = 2, max = 20, message = "First Name must be greater than 2 characters")
	private String lastName;
	@NotNull
	@Email(message = "Email must be valid")
	private String email;
	@Size(min = 5, message = "Password must be greater than 5 characters")
	private String password;
	@Transient
	private String passwordConfirmation;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	 @OneToMany(mappedBy = "adopter", fetch = FetchType.LAZY)
	    private List<Pet> pets;
	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	        name = "users_roles", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id")
	    )
	    private List<Role> roles;

	public User() {
	}

	


	public User(@Size(min = 10, max = 10, message = "Number Must be 10 Numbers") String phone,
			@Size(min = 2, max = 20, message = "First Name must be greater than 2 characters") String firstName,
			@Size(min = 2, max = 20, message = "First Name must be greater than 2 characters") String lastName,
			@NotNull @Email(message = "Email must be valid") String email,
			@Size(min = 5, message = "Password must be greater than 5 characters") String password,
			String passwordConfirmation, List<Pet> pets, List<Role> roles) {
		super();
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.pets = pets;
		this.roles = roles;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Pet> getPets() {
		return pets;
	}




	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}




	public List<Role> getRoles() {
		return roles;
	}




	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}




	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}