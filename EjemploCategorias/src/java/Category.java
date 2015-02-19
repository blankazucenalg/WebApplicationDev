
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azu
 */
@Entity 
@Table (name="categoria")
public class Category implements Serializable{
	@Id @GeneratedValue (strategy=GeneratedType.IDENTITY)
	private int idCategory;
	private String description;

	public Category(){}

	public int getIdCategory(){ return idCategory;}
	
	public String getDescription(){ return description;}

	public void setIdCategory(int idCategory){
		this.idCategory = idCategory;
	}

	public void setDescription(String description){
		this.description = description;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("idCategory: ").append(idCategory).append("\n");
		sb.append("Descripcion: ").append(description).append("\n");
		return sb.toString();
	}
}
