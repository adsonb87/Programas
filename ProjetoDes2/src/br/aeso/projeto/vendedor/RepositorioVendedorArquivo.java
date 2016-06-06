package br.aeso.projeto.vendedor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RepositorioVendedorArquivo implements IRepositorioVendedor{
	
	private ArrayList<Vendedor> listaVendedor;
	private String endereco = ("C:/Users/adson_000/Desktop/temp/listaVendedor.txt");
	
	public RepositorioVendedorArquivo() {
		listaVendedor = new ArrayList<>();
	}
	
	@Override
	public void cadastrar(Vendedor vendedor){
		if(!this.existe(vendedor.getCodigoVendedor())) {
			listaVendedor.add(vendedor);
			gravarArquivoNaMemoria();
		}
	}

	@Override
	public void atualizar(Vendedor vendedor){
		if(this.existe(vendedor.getCodigoVendedor())){
			for(int i=0;i<listaVendedor.size();i++){
				if(listaVendedor.get(i).getCodigoVendedor().equals(vendedor.getCodigoVendedor())){
					listaVendedor.set(i, vendedor);
//					listaVendedor.get(i).setCodigoVendedor(vendedor.getCodigoVendedor());
//					listaVendedor.get(i).setNome(vendedor.getNome());
//					listaVendedor.get(i).setEndereco(vendedor.getEndereco());
//					listaVendedor.get(i).setTelefone(vendedor.getTelefone());
				}
			}
			gravarArquivoNaMemoria();
		}
	}

	@Override
	public boolean remover(Vendedor vendedor){
//		if(this.existe(vendedor.getCodigoVendedor())){
//			listaVendedor.remove(vendedor);
//			gravarArquivoNaMemoria();
//			return true;
//		}else{
//			return false;
//		}
		if(vendedor.equals(null)){
			return false;
		}else{
			listaVendedor.remove(vendedor);
			gravarArquivoNaMemoria();
			return true;
		}
		
	}

	@Override
	public Vendedor procurar(String codigo){
		if(this.existe(codigo)){
			for(int i=0; i<listaVendedor.size(); i++){
				if(listaVendedor.get(i).getCodigoVendedor().equals(codigo)){
					return listaVendedor.get(i);
				}
			}
			return null;
		}else{
			return null;	
		}
	}

	@Override
	public boolean existe(String codigo) {
		if(codigo != null){
			listaVendedor = lerArquivoDaMemoria();
				for(int i=0; i<listaVendedor.size(); i++){
					if(listaVendedor.get(i).getCodigoVendedor().equals(codigo)){
						return true;
					}
				}
				return false;
		}else{
			return false;
		}
	}

	@Override
	public ArrayList<Vendedor> listar() {
		ArrayList<Vendedor> lista = lerArquivoDaMemoria();
		return lista;
	}
	
	
	public void gravarArquivoNaMemoria(){
		try {
			FileOutputStream fos;
			fos = new FileOutputStream("C:/Users/adson_000/Desktop/temp/listaVendedor.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.listaVendedor);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Vendedor> lerArquivoDaMemoria(){
		ArrayList<Vendedor> listaMemoria = new ArrayList<>();
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/Users/adson_000/Desktop/temp/listaVendedor.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			listaMemoria = (ArrayList<Vendedor>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaMemoria;
	}
	
	
}
