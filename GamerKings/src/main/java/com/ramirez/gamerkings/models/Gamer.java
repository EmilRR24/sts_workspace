package com.ramirez.gamerkings.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="gamers")
public class Gamer {
	// MEMBER VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //firstName
    @NotEmpty(message="Stream is required!")
    private String stream;
    
    //RELATIONSHIP
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    
    
    //CONSTRUCTORS
    public Gamer() {}
	public Gamer(@NotEmpty(message = "Stream is required!") String stream) {
		super();
		this.stream = stream;
	}
    //GETTERS /SETTERS / OTHER METHODS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
