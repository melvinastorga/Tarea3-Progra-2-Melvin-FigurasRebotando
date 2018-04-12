package anotherTechnique;
//Melvin Astorga Guevara  B70785
//Crea el simulacro de que las figuras se mueven
//Pero en realidad solo se esta pintando en diferentes posiciones.
import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.String;

public class Simulator {

    int x = 1;
    int y = 3;
    int x1 = 5;
    int y1 = 721;
    boolean retrocesoX = false;
    boolean cambioY = false;
    boolean retrocesoX1 = false;
    boolean cambioY1 = false;

    private DisplayFrame myDisplayer;  //JFrame
    private Circle myCircle;
    private Rectangle myRectangle;

    //constructor
    public Simulator(DisplayFrame myDisplayer_) {

        this.setMyDisplayer(myDisplayer_);
        this.setMyCircle(new Circle());
        this.setMyRectangle(new Rectangle());

        //valores de las figuras
        myCircle.setHeight(60);
        myCircle.setWidth(70);
        myRectangle.setHeight(75);
        myRectangle.setWidth(100);
    }

    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException {

        //ciclo infinito
        while (true) {
            this.moveShapes();
            this.createImages();

            //pone en espera el flujo del programa
            //Thread.sleep(waitingTime);
            Thread.sleep(2);
        }
    }//end method

    //cambio los valores de las variables de las figuras que tengo
    public void moveShapes() {
        
    //Movimiento del circulo
        //Movimiento en los laterales
        if (x >= 0 && !retrocesoX) {
            x++;
        } else if (x <= 340 && retrocesoX) {
            x--;
        }
        if (x == 340) {
            retrocesoX = true;
        } else if (x == 0) {
            retrocesoX = false;
        }
        //Movimiento de abajo hacia arriba
        if (y >= 3 && !cambioY) {
            y++;
        } else if (y <= 740 && cambioY) {
            y--;
        }
        if (y == 740) {
            cambioY = true;
        } else if (y == 3) {
            cambioY = false;
        }

        getMyCircle().setRow(y);
        getMyCircle().setColumn(x);

        //Figura 2  Rectangulo
        //Movimiento de los laterales
        if (x1 >= 5 && !retrocesoX1) {
            x1++;
        } else if (x1 <= 310 && retrocesoX1) {
            x1--;
        }
        if (x1 == 310) {
            retrocesoX1 = true;
        } else if (x1 == 5) {
            retrocesoX1 = false;
        }
        //Movimiento de arriba y abajo.
        if (y1 >= 4 && !cambioY1) {
            y1++;
        } else if (y1 <= 722 && cambioY1) {
            y1--;
        }
        if (y1 == 722) {
            cambioY1 = true;
        } else if (y1 == 4) {
            cambioY1 = false;
        }

        getMyRectangle().setRow(y1);
        getMyRectangle().setColumn(x1);

    }

    //coloca nuevos valores aleatorios en las figuras
    public void createImages() {
        myDisplayer.initImage();
        Graphics graphic = myDisplayer.getGraphicsImage();

        graphic.setColor(Color.BLUE);
        graphic.fillOval(getMyCircle().getColumn(),
                getMyCircle().getRow(),
                getMyCircle().getWidth(),
                getMyCircle().getHeight());

        graphic.setColor(Color.PINK);
        graphic.fillRect(getMyRectangle().getColumn(),
                getMyRectangle().getRow(),
                getMyRectangle().getWidth(),
                getMyRectangle().getHeight());

        myDisplayer.paintAgain();
    }

    //**************************************************************************
    /*     metodos accesores      */
    public Circle getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public DisplayFrame getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(DisplayFrame myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    public anotherTechnique.Rectangle getMyRectangle() {
        return myRectangle;
    }

    public void setMyRectangle(anotherTechnique.Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }

}
