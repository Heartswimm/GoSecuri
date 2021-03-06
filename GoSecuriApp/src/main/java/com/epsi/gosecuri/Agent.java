/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epsi.gosecuri;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author loicb
 */
public class Agent {
    
    private String nom;
    private String prenom;
    private String photoPath;
    private String password;
    private String mission;
    private ArrayList<String> stuffList;
    
    private final String htmlDirPath = "src\\main\\java\\com\\epsi\\gosecuri\\htmlFiles\\";


    public Agent(String nom, String prenom, String password, String mission, ArrayList<String> stuffList) {
        this.nom = nom;
        this.prenom = prenom;
        this.photoPath = "..\\ressourceFiles\\"+prenom.toCharArray()[0]+nom+".jpg";
        this.photoPath = this.photoPath.toLowerCase();
        this.password = password;
        this.mission = mission;
        this.stuffList = stuffList;
    }
    
    public String generateAgentFile(){
        String res = "";
          try{
                //Récupération du template html
                File htmlAgentFileBody = new File(this.htmlDirPath+"agentFileBody.html");
                String htmlString = FileUtils.readFileToString(htmlAgentFileBody);

                //Initialisation des variables avec le contenu à ajouter
                String identity = this.getIdentity();
                String photo = this.photoPath;

                //Ajoute le contenu dans la page Html
                htmlString = htmlString.replace("$mission",this.mission);
                htmlString = htmlString.replace("$identity", identity);
                htmlString = htmlString.replace("$photo", photo);
                
                res = htmlString;
            }
            catch(IOException e){
                e.printStackTrace();
            }
        return res;
    }

    public ArrayList<String> getStuffList() {
        return stuffList;
    }
    
       
    public String getIdentity(){
        return this.nom+" "+this.prenom;
    }
    
    public String getFileName(){
        return (this.prenom.toCharArray()[0]+this.nom).toLowerCase();
    }
    
    public String toString(){
        String res;
        res = "Nom: "+this.nom+" Prenom: "+this.prenom;
        res += "\n mdp: "+this.password;
        res += "\n mission: "+this.mission;
        res += "\n Liste de matériel: "+this.stuffList.toString();
        res += "\n Chemin de la photo: "+this.photoPath;
        return res;
    }
    
}
