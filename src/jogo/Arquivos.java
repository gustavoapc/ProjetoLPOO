package jogo;
import java.io.File;
import java.io.*;

public class Arquivos implements Serializable{
	
	
	public static Object salvarJogo(Object obj, String caminho) {
		File arquivo=new File(caminho);
		if (!arquivo.exists()) {
			try{
			arquivo.createNewFile();
		}catch(Exception erro){
			erro.printStackTrace();
			System.out.println("O arquivo não conseguiu ser criado");
		}
			}
		try {
			FileOutputStream fileOutput= new FileOutputStream(arquivo);
			ObjectOutputStream objOutput= new ObjectOutputStream(fileOutput);
			objOutput.writeObject(objOutput);
			objOutput.flush();
			fileOutput.flush();
			objOutput.close();
			fileOutput.close();
			System.out.println("O arquivo foi salvo");
			
		
		}catch(Exception erro){
			erro.printStackTrace();
			System.out.println("Falha ao salvar o arquivo");
	
		}
		
		return null;
}
	public static Object recuperarJogo(String caminho) {
		File arquivo = new File(caminho); 
		try {
			FileInputStream fileInput= new FileInputStream(arquivo);
			ObjectInputStream objInput= new ObjectInputStream(fileInput);
			Object retorno = objInput.readObject();
			
			objInput.close();
			fileInput.close();
		}catch(Exception erro) {
				erro.printStackTrace();
				return null;
			}
	return null;
	}


}