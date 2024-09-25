package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name ="produto")
public class Produto {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String descricao;

public Produto() {}

public Produto(String descricao) {
	this.descricao = descricao;
}

public int getId() {
	return id;
}
public void setCodigo(int id) {
	this.id = id;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String desc) {
	this.descricao = desc;
}

@Override
public String toString() {
	return "Produto: id=" + id + ", descricao=" + descricao ;
}

}