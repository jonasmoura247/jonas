package adsisaep;


import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class ErvaTerere {
	@Id
	private String id;
	private String marca;
	private String sabor;

	public ErvaTerere() {
		id = UUID.randomUUID().toString();
	}

	public ErvaTerere(String marca, String sabor) {
		this ();
		this.marca = marca;
		this.sabor = sabor;
	}

	public String getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}
	
	public String getSabor() {
		return sabor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((sabor == null) ? 0 : sabor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErvaTerere other = (ErvaTerere) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (sabor == null) {
			if (other.sabor != null)
				return false;
		} else if (!sabor.equals(other.sabor))
			return false;
		return true;
	}


	
	
	
	
	
	
	
	
	
}
