/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;

/**
 *
 * @author Huy Hoàng
 */
public class Author implements Serializable {
        private static final long serialVersionUID = 1L;

	private String name;
	private String workplace;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((workplace == null) ? 0 : workplace.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
            
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (workplace == null) {
			if (other.workplace != null)
				return false;
		} else if (!workplace.equals(other.workplace))
			return false;
		return true;
	}

	public String toString() {
		return "Author [name=" + name + ", workplace=" + workplace + "]";
	}
        

}
