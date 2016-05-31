package br.aeso.projeto.vendedor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaVendedorVaziaException;
import br.aeso.projeto.util.VendedorNaoEncontradoException;

public class RepositorioVendedorArquivo implements IRepositorioVendedor{
	
	private ArrayList<Vendedor> listaVendedor;
	private String endereco = ("C:/Users/adson_000/Desktop/temp/listaVendedor.txt");
	
	public RepositorioVendedorArquivo() {
		listaVendedor = new ArrayList<>();
	}
	
	@Override
	public void cadastrar(Vendedor vendedor) throws VendedorNaoEncontradoException {
		if(vendedor.getCodigoVendedor()!=null){
			listaVendedor.add(vendedor);
			try {
				FileOutputStream fos;
				fos = new FileOutputStream(endereco);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(listaVendedor);
				oos.flush();
				oos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			throw new VendedorNaoEncontradoException();
		}
	}

	@Override
	public void atualizar(Vendedor vendedor) throws CodigoInexistenteException {
		if(vendedor.getCodigoVendedor()!=null){
			
			try {
				FileInputStream fis;
				fis = new FileInputStream(endereco);
				ObjectInputStream ois = new ObjectInputStream(fis);
				listaVendedor = (ArrayList<Vendedor>) ois.readObject();
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
			
			for(int i=0;i<listaVendedor.size();i++){
				if(listaVendedor.get(i).getCodigoVendedor().equals(vendedor.getCodigoVendedor())){
					listaVendedor.get(i).setCodigoVendedor(vendedor.getCodigoVendedor());
					listaVendedor.get(i).setNome(vendedor.getNome());
					listaVendedor.get(i).setEndereco(vendedor.getEndereco());
					listaVendedor.get(i).setTelefone(vendedor.getTelefone());
				}
			}
			
			try {
				FileOutputStream fos;
				fos = new FileOutputStream(endereco);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(listaVendedor);
				oos.flush();
				oos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			throw new CodigoInexistenteException();
		}

		
	}

	@Override
	public boolean remover(Vendedor vendedor) throws VendedorNaoEncontradoException {
		if(vendedor.getCodigoVendedor() != null){
			
			try {
				FileInputStream fis;
				fis = new FileInputStream(endereco);
				ObjectInputStream ois = new ObjectInputStream(fis);
				listaVendedor = (ArrayList<Vendedor>) ois.readObject();
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
			
			
			if(listaVendedor.contains(vendedor)){
				listaVendedor.remove(vendedor);
				
				try {
					FileOutputStream fos;
					fos = new FileOutputStream(endereco);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(listaVendedor);
					oos.flush();
					oos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}else{
				return false;
			}
		}else{
			throw new VendedorNaoEncontradoException();
		}
	}

	@Override
	public Vendedor procurar(String codigo) throws CodigoInexistenteException {
		if(codigo != null){
			try {
				FileInputStream fis;
				fis = new FileInputStream(endereco);
				ObjectInputStream ois = new ObjectInputStream(fis);
				listaVendedor = (ArrayList<Vendedor>) ois.readObject();
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
			
			for(int i=0; i<listaVendedor.size(); i++){
				if(listaVendedor.get(i).getCodigoVendedor().equals(codigo)){
					return listaVendedor.get(i);
				}
			}
			return null;
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public boolean existe(String codigo) throws CodigoInexistenteException {
		if(codigo != null){
			try {
				FileInputStream fis;
				fis = new FileInputStream(endereco);
				ObjectInputStream ois = new ObjectInputStream(fis);
				listaVendedor = (ArrayList<Vendedor>) ois.readObject();
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
			
			for(int i=0; i<listaVendedor.size(); i++){
				if(listaVendedor.get(i).getCodigoVendedor().equals(codigo)){
					return true;
				}
			}
			return false;
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public ArrayList<Vendedor> listar()throws ListaVendedorVaziaException{
		try {
			FileInputStream fis;
			fis = new FileInputStream(endereco);
			ObjectInputStream ois = new ObjectInputStream(fis);
			listaVendedor = (ArrayList<Vendedor>) ois.readObject();
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
		
		if(!listaVendedor.isEmpty()){
			return listaVendedor;
		}else{
			throw new ListaVendedorVaziaException();
		}
	}
	
	
}
