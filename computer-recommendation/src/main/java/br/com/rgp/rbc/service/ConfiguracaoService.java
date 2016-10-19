package br.com.rgp.rbc.service;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.google.gson.Gson;

import br.com.rgp.rbc.model.Configuracao;

@Service
public class ConfiguracaoService implements IConfiguracaoService {

	public static final String DB_FILE_NAME = "database";
	public static final String DB_FILE_PATH = Paths.get("").toAbsolutePath().toString() + File.separator + DB_FILE_NAME;
	
	@SuppressWarnings({ "deprecation" })
	@Override
	public final void save(Configuracao configuracao) {
		ObjectContainer db = Db4o.openFile(DB_FILE_PATH);
		
		try {
			db.set(configuracao);
			System.out.println("Dados salvos em: \"" + DB_FILE_PATH + "\"");
		} finally {
			db.close();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public final List<Configuracao> listAllConfigurations() {
		List<Configuracao> configuracoes = new ArrayList<>();
		
		System.out.println("Lendo dados do arquivo: \"" + DB_FILE_PATH + "\"");
		
		ObjectContainer db = Db4o.openFile(DB_FILE_PATH);
		ObjectSet<Configuracao> dbList = db.get(Configuracao.class);
		
		while (dbList.hasNext()) {
			configuracoes.add(dbList.next());
			Gson g = new Gson();
			System.out.println(g.toJson(configuracoes.get(configuracoes.size() - 1)));
		}
		
		System.out.println(configuracoes.size() + " configurações no total.");
		
		db.close();
		return configuracoes;
	}

}
