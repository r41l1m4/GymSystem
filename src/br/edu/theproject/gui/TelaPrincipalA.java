package br.edu.theproject.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaPrincipalA extends Application {

	@Override
	public void start(Stage palco) throws Exception {
		BorderPane fundoPrincipal = new BorderPane();
		
		GridPane malha = new GridPane();
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(15, 15, 15, 15));
		malha.setAlignment(Pos.CENTER);
		
		Scene cena = new Scene(fundoPrincipal, 700, 500);
		
		Image logo = new Image("/br/edu/theproject/img/gymsystemrem.png");
		ImageView iv = new ImageView(logo);
		
		MenuBar menuzin = new MenuBar(); //cria barra de menu
		
		//Cadastrar - Menu
		Menu cadastrar = new Menu("Cadastrar"); // cria menu
		MenuItem cdCli = new MenuItem("Cadastrar cliente");
		MenuItem inc = new MenuItem("Inicio");
		
		// Consultar - Menu
		Menu consulta = new Menu("Consultar");
		MenuItem cnsCliente = new MenuItem("Consultar cliente");
		MenuItem cnsBens = new MenuItem("Consultar bens");
		MenuItem cnsAtiv = new MenuItem("Consultar atividade");
		
		// Sobre - Menu
		Menu sobre = new Menu("Sobre");
		MenuItem sobreNois = new MenuItem("Sobre tudo");
		MenuItem sair = new MenuItem("Sair");
		
		
		//Acoes dos botoes
		sair.setOnAction(new EventHandler<ActionEvent>() { //trata o evento de apertar no botão
			@Override
			public void handle(ActionEvent aperto) {
				//System.exit(0); // define o que fazer quando apertar em sair
				
				
				Login lgin = new Login();  // volta a tela de login ..É um log-off
				try {
					lgin.start(palco);
				} catch (Exception e) {
					e.printStackTrace();				
				}
				
			}
		});
		
		cdCli.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				/*
				cadastrarBasic cc = new cadastrarBasic();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();
					cc.cds(malha);
				} catch (Exception e) {
					e.printStackTrace();				
				}
				*/
			}
		});
		
		// consultar cliente
		cnsCliente.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				consultarCliente cc = new consultarCliente();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					cc.cds(malha);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} );
		
		inc.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				malha.getChildren().clear();
				fundoPrincipal.setCenter(iv);
			}
		});
		
		sobreNois.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				@SuppressWarnings("unused")
				Sobre sobre = new Sobre(palco);
			}
		});
		
		
		//Add as coisas a seus devidos lugares
		cadastrar.getItems().addAll(cdCli, inc); // add sub items ao menu
		consulta.getItems().addAll(cnsCliente, cnsBens, cnsAtiv); // add sub items ao menu
		sobre.getItems().addAll(sobreNois, sair); // add sub items ao menu
		
		menuzin.getMenus().addAll(cadastrar, consulta, sobre); // add menua a barra
		
		fundoPrincipal.setTop(menuzin); // seta a barra de menu na borda de cima do BorderPane
		fundoPrincipal.setCenter(iv);
		
		palco.setScene(cena);
		palco.setTitle("GymSystem");
		palco.show();
		
	}

	public static void main(String[] args) {
		launch();
	}

}
