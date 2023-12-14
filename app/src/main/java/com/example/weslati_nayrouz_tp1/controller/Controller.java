package com.example.weslati_nayrouz_tp1.controller;

import com.example.weslati_nayrouz_tp1.model.Patient;

public class Controller {
private static Patient patient;
private static Controller instance = null;
public static Controller getInstance(){
    if (Controller.instance == null)
        Controller.instance = new Controller();
    return instance;
}
private Controller(){
    super();
}
//user action view --> controller
public void createPt(int age, float vm ,boolean jn){
    patient = new Patient(age,vm,jn);

}
//notify Controller --> view
public String getResponse(){
    return patient.getResultat();
}
}
