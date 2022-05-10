package application;




import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.SocketSecurityException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;
import com.sun.media.jfxmedia.events.NewFrameEvent;

import DAO.Classement_DAO;
import DAO.Convert_date;
import DAO.Demande_DAO;
import DAO.Equipe_DAO;
import DAO.Joueur_DAO;
import DAO.Match_DAO;
import DAO.My_Connection;
import DAO.Resultat_DAO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import oo.Equipe;
import oo.Joueur;
import oo.Match;
import oo.Resultat;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	TextField txtIdETD , txtNom ,txtPrenom;
	Button BTAjouter, BTAnnuler;
	ComboBox FiliereList ,niveauList ,groupeList;
	DatePicker checkInDatePicker;
	static TextArea textArea;
	static TextField textField;
	static BufferedReader in;
	static PrintWriter out;
	static Thread recevoir;
	static Thread envoi;

	@Override
	public void start(Stage primaryStage) {
		try {
			My_Connection conn = new My_Connection();
			
			checkInDatePicker = new DatePicker(LocalDate.of(1998, 10, 8));

			// Setting a particular date value by using the setValue method
			checkInDatePicker.setValue(LocalDate.of(1998, 10, 8));

			// Setting the minimum date available in the calendar
			checkInDatePicker.setValue(LocalDate.MIN);

			// Setting the maximum date available in the calendar
			checkInDatePicker.setValue(LocalDate.MAX);

			// Setting the current date
			checkInDatePicker.setValue(LocalDate.now());
			GridPane panAjoutETD = new GridPane();
			// Ajout des boutons Ajouter et Annuler
			panAjoutETD.add(checkInDatePicker, 0, 2);
			BTAjouter = new Button("Ajouter");
			panAjoutETD.add(BTAjouter, 0, 6);

			BTAjouter.setOnAction(new MyHandle());
			BTAnnuler = new Button("Annuler");
			panAjoutETD.add(BTAnnuler, 1, 6);
			BTAnnuler.setOnAction(new MyHandle());
			 textArea = new TextArea();
			panAjoutETD.add(textArea, 1,8);
			 textField = new TextField();
			panAjoutETD.add(textField, 1,9);
			//Parent root = FXMLLoader.load(getClass().getResource("../ihm/dashboard.fxml"));
			Scene scene = new Scene(panAjoutETD ,800,500);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private class MyHandle implements  EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			Object source = event.getSource();
			if(source == BTAjouter ) {
				
				//envoi.start();
				//recevoir.start();
								// ADD New Joueur
				// MAMCHETCH
				/*String date_str = checkInDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				java.util.Date date = Convert_date.string_to_utilDate(date_str);
				
				Equipe equipe1 = new Equipe(3, "hafouz", "touns", date);
				//Equipe_DAO.insert(equipe);
				//Equipe_DAO.insert(equipe1);
				//Match match = new Match(0, 20, 21, "rades", date);
				//Match_DAO.insert(match);
				//Resultat resultat = new Resultat(6, 10, 3, "chkun marka louel");
				//Resultat_DAO.insert(resultat);
				//Resultat_DAO.delete(resultat);
				
				Joueur joueur = new Joueur(2, "kamel", "mansurrrr", "gardien", date, 2, true);
				Demande_DAO.nonValider(joueur);*/
			
				String date_str = checkInDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				java.util.Date date = Convert_date.string_to_utilDate(date_str);
				Equipe equipe = new Equipe(3, "9orbes", "touns", date);
				Equipe_DAO.insert(equipe);
				
				
				
				
				
				
				


			}
		}

	}
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		BufferedReader in;
		PrintWriter out;
		// ServerSocket ss;
		// Socket s;
		try {

			ServerSocket ss = new ServerSocket(5000);
			Socket s = ss.accept();
			out = new PrintWriter(s.getOutputStream());
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			 envoi = new Thread(new Runnable() {
				String msg;

				@Override
				public void run() {
					while (true) {
					//	msg = sc.nextLine();
						msg = textField.getText();
						out.println(msg);
						out.flush();
					}
				}
			});

			  recevoir = new Thread(new Runnable() {
				String msg;

				@Override
				public void run() {
					try {
						msg = in.readLine();
						
						while (msg != null) {
							//System.out.println("client:" + msg);
							textArea.appendText("server:" + msg);
							msg = in.readLine();
						}
						out.close();
						ss.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			});
			//envoi.start();
			//recevoir.start();

		} catch (Exception e) {
			// TODO: handle exception
		}
		launch(args);
	}
}

