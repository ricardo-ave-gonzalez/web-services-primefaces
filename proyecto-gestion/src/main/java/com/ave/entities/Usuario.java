package com.ave.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(
    		name="Usuario.findByUserNameAndPassword", 
    		query="SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password")
}) 
public class Usuario implements Serializable {
	
	@Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;

	public Usuario() {
    }

    public Usuario(String id) {
        this.id = id;
    }

    public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
	}

    public Usuario(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + "]";
	}}
