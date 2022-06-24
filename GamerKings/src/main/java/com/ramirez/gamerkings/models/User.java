package com.ramirez.gamerkings.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	// MEMBER VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //firstName
    @NotEmpty(message="First Name is required!")
    @Size(min=3, max=30, message="First name must be between 3 and 30 characters")
    private String firstName;
    //lastName
    @NotEmpty(message="Last Name is required!")
    @Size(min=3, max=30, message="Last Name must be between 3 and 30 characters")
    private String lastName;
    //email
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    //userName
    @NotEmpty(message="User Name is required!")
    @Size(min=3, max=30, message="Name must be between 3 and 30 characters")
    private String userName;
    //password
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    //total
    @NotEmpty(message="Amount Required!")
    private Integer total;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
    
    //RELATIONSHIPS
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Gamer gamer;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "bets", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "game_id")
    )     
    private List<Game> games;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // EMPTY CONSTRUCTOR
    public User() {}
    //Full CONSTRUCTOR
    public User(
    		@NotEmpty(message = "First Name is required!") @Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters") String firstName,
    		@NotEmpty(message = "Last Name is required!") @Size(min = 3, max = 30, message = "Last Name must be between 3 and 30 characters") String lastName,
    		@NotEmpty(message = "Email is required!") @Email(message = "Please enter a valid email!") String email,
    		@NotEmpty(message = "User Name is required!") @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters") String userName,
    		@NotEmpty(message = "Password is required!") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters") String password,
    		@NotEmpty(message = "Amount Required!") Integer total) {
    	super();
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.userName = userName;
    	this.password = password;
    	this.total = total;
    }

    
    
	// GETTERS / SETTERS / OTHER METHODS

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	//FOR CREATED_AT and UPDATED_AT
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Gamer getGamer() {
		return gamer;
	}

	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
	
   
}