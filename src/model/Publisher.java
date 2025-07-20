/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author Huy Hoàng
 */
public class Publisher implements Serializable {
        private static final long serialVersionUID = 1L;
        
        private String publisherId;
	private String name;
	private String address;
        
        public Publisher(String publisherId, String name, String address) {
        if (publisherId == null || publisherId.isEmpty()) {
            throw new IllegalArgumentException("Publisher ID cannot be empty!");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Publisher name cannot be empty!");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Publisher address cannot be empty!");
        }

        this.publisherId = publisherId;
        this.name = name;
        this.address = address;
    }
        
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString() {
		return "Publisher [name=" + name + ", address=" + address + "]";
	}

}
