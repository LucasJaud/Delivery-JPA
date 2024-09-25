package modelo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name ="entrega")
public class Entrega {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String data;
private String endereco;
@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.LAZY)
@JoinColumn(name ="entregador")
private Entregador entregador = new Entregador();

@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.LAZY)
@JoinTable(name="entrega_has_produtos", joinColumns=
{@JoinColumn(name="entrega_id")}, inverseJoinColumns=
  {@JoinColumn(name="produto_id")})
List <Produto> produtos =new ArrayList<>();

public Entrega() {}

public Entrega(String data,String endereco){
	this.data = data;
	this.endereco = endereco;
}


@Override
public String toString() {
	String texto = "Entrega: id=" + id + ", data=" + data + ", endereco=" + endereco + ", entregador=" + entregador.getNome();
	for(Produto produto: produtos){
		texto += "\n produtos:" +produto.getDescricao();
	}
	
	return texto;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public Entregador getEntregador() {
	return entregador;
}
public void setEntregador(Entregador entregador) {
	this.entregador = entregador;
}

public List<Produto> getProdutos() {
	return produtos;
}
public void setProdutos(ArrayList<Produto> produtos) {
	this.produtos = produtos;
}

public void adicionar(Produto p){
	this.produtos.add(p);
}
public void remover(Produto p){
	this.produtos.remove(p);
}

	
}
