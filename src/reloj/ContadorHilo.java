package reloj;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


public class ContadorHilo extends Thread implements Runnable{
 
    private String horas, minutos, segundos;
    private boolean estado;
    private JLabel hora;
    Thread hilo;

public ContadorHilo(JLabel hora) {
       this.hora = hora;
    }

    
public void run(){
    while (estado == true){
            
        
    Calendar fecha = new GregorianCalendar();
        
    int h = fecha.get(Calendar.HOUR_OF_DAY);
    int m = fecha.get(Calendar.MINUTE);
    int s = fecha.get(Calendar.SECOND);
        
horas = Integer.toString(h);
minutos = Integer.toString(m);
segundos = Integer.toString(s);
        
hora.setText(horas+" : "+minutos+" : "+segundos);
      try{
          Thread.sleep(1000);
      } catch (InterruptedException ex) {
            Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
    
    public void iniciar(){
        hilo = new Thread(this);
        estado = true;
        hilo.start();
    }
    
    public void detener(){
        estado = false;
    }
}

