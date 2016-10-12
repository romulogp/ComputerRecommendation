package br.com.rgp.rbc;

import java.io.File;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import br.com.rgp.rbc.model.Configuracao;

public class TestClass {

	private static final String DB_FILE_NAME = "database";
	private static final String DB_FILE_PATH = new File("").getAbsolutePath() + File.separator + DB_FILE_NAME;
	
	public static void main(String[] args) {
		System.out.println(DB_FILE_PATH);

//		saveObject();
		loadConfigurations();
		
	}

	@SuppressWarnings("deprecation")
	private static final void loadConfigurations() {
		ObjectContainer db = Db4o.openFile(DB_FILE_PATH);
		
		// recuperar todos as configurações
		ObjectSet<Configuracao> configuracoes = db.get(Configuracao.class);
		while (configuracoes.hasNext()) {
			System.out.println(configuracoes.next());
		}
		
		db.close();
	}
	
	@SuppressWarnings({ "unused", "deprecation" })
	private static final void saveObject() {
		ObjectContainer db = Db4o.openFile(DB_FILE_PATH);
		
		try {
			Configuracao c = new Configuracao();
			db.set(c);
			System.out.println("Cliente armazenado: " + c);
		} finally {
			db.close();
		}
	}
	
}
