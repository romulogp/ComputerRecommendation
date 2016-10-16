package br.com.rgp.rbc.service;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import br.com.rgp.rbc.model.Configuracao;

@Service
public class ConfiguracaoService implements IConfiguracaoService {

	private static final String DB_FILE_NAME = "database";
	private static final String DB_FILE_PATH = Paths.get("").toAbsolutePath().toString() + File.separator + DB_FILE_NAME;
	
	@SuppressWarnings({ "unused", "deprecation" })
	private static final void saveObject() {
		ObjectContainer db = Db4o.openFile(DB_FILE_PATH);
		System.out.println("Local do arquivo da base de dados: " + DB_FILE_PATH);
		try {
			Configuracao c = new Configuracao();
			db.set(c);
			System.out.println("Configuração salva com sucesso: " + c);
		} finally {
			db.close();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Configuracao> listAllConfigurations() {
//		saveObject();
		List<Configuracao> configuracoes = new ArrayList<>();
		
		System.out.println("Lendo dados do arquivo: " + DB_FILE_PATH);
		ObjectContainer db = Db4o.openFile(DB_FILE_PATH);
		ObjectSet<Configuracao> dbList = db.get(Configuracao.class);
		
		while (dbList.hasNext()) {
			configuracoes.add(dbList.next());
		}
		
		System.out.println(configuracoes.size() + " configurações.");
		
		db.close();
		return configuracoes;
	}

}
