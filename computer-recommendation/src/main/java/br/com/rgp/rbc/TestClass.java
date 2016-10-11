package br.com.rgp.rbc;

import java.io.File;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

import br.com.rgp.rbc.model.CPU;
import br.com.rgp.rbc.model.Configuracao;
import br.com.rgp.rbc.model.Fonte;
import br.com.rgp.rbc.model.Memoria;
import br.com.rgp.rbc.model.PlacaDeVideo;
import br.com.rgp.rbc.model.PlacaMae;
import br.com.rgp.rbc.model.Storage;

public class TestClass {

	public static void main(String[] args) {
		ObjectContainer db = Db4o.openFile(new File("teste").getAbsolutePath());
		Configuracao c = new Configuracao(new CPU(), new Fonte(), new Memoria(), new PlacaDeVideo(), new PlacaMae(), new Storage());
		System.out.println("Cliente armazenado: " + c);
		try {
		} finally {
			db.close();
		}

	}

}
