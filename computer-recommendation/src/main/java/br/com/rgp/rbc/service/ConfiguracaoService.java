package br.com.rgp.rbc.service;

import java.io.File;
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
	private static final String DB_FILE_PATH = new File("").getAbsolutePath() + File.separator + DB_FILE_NAME;
	
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

	@SuppressWarnings("deprecation")
	@Override
	public List<Configuracao> listAllConfigurations() {
		//saveObject();
		List<Configuracao> configuracoes = new ArrayList<>();
		
		ObjectContainer db = Db4o.openFile(DB_FILE_PATH);
		ObjectSet<Configuracao> dbList = db.get(Configuracao.class);
		
		while (dbList.hasNext()) {
			configuracoes.add(dbList.next());
			System.out.println(dbList.next().toString());
		}
		
		System.out.println(configuracoes.size() + " configurações.");
		
		db.close();
		return configuracoes;
	}
	
}
