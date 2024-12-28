import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Random;

public class Panel extends JPanel {

    private Player player = new Player(".\\assetsJeu\\car\\Car_1_01.png", 3, 3, 3, 6);

    private Image tournantGaucheHaut = new Image(".\\assetsJeu\\road\\Tile2.png");
    private Image tournantGaucheBas = new Image(".\\assetsJeu\\road\\Tile1.png");
    private Image tournantDroiteHaut = new Image(".\\assetsJeu\\road\\Tile10.png");
    private Image tournantDroiteBas = new Image(".\\assetsJeu\\road\\Tile9.png");


    private Image rue1H = new Image(".\\assetsJeu\\road\\Tile7.png");
    private Image rue3H = new Image(".\\assetsJeu\\road\\Tile4.png");
    private Image rue4H = new Image(".\\assetsJeu\\road\\Tile3.png");

    private Image rue1V = new Image(".\\assetsJeu\\road\\Tile11.png");
    private Image rue2V = new Image(".\\assetsJeu\\road\\Tile12.png");
    private Image rue3V = new Image(".\\assetsJeu\\road\\Tile13.png");

    private Image bush = new Image(".\\assetsJeu\\decor\\Bush.png");
    private Image building = new Image(".\\assetsJeu\\decor\\Decor_Building.png");
    private Image pavillon = new Image(".\\assetsJeu\\decor\\Pavilion.png");
    private Image tree = new Image(".\\assetsJeu\\decor\\Tree.png");


    private ArrayList <Image> rueVerticale = new ArrayList <>();
    private ArrayList <Image> rueHorizontale = new ArrayList<>();
    private ArrayList <Image> decor = new ArrayList<>();
    private ArrayList <Image> green = new ArrayList<>();

    private Image courbe = new Image(".\\assetsJeu\\road\\Tile6.png");

    private Image background = new Image(".\\assetsJeu\\bg\\Grass_Tile.png");

    private final int TILE =50;
    private final int POSXG = 100;
    private final int POSYH = 70;
    private final int POSYB = (Frame.FHEIGTH - (TILE + POSYH))-17;
    private final int ARRET = Frame.FWIDTH - (TILE + POSXG);
    private final int ARRET2 = Frame.FHEIGTH - (TILE + POSYH);
    private final int POSXD = (Frame.FWIDTH - (TILE + POSXG))-9;


    @Override
    public void paintComponent (Graphics g){

        super.paintComponent(g);
        rueHorizontale.add(rue1H);
        rueHorizontale.add(rue3H);
        rueHorizontale.add(rue4H);

        rueVerticale.add(rue1V);
        rueVerticale.add(rue2V);
        rueVerticale.add(rue3V);

        decor.add(bush);
        decor.add(building);
        decor.add(tree);
        decor.add(pavillon);

        green.add(tree);
        green.add(bush);

        Random random = new Random();


        //-------------------------dessin du background----------------------
        for (int i = 0; i<Frame.FWIDTH; i+=150){
            for (int j = 0; j<Frame.FHEIGTH; j+=150){
                try{
                    BufferedImage rue = ImageIO.read(new File(background.getPath()));
                    g.drawImage(rue, i,j,150,150,this);
                }
                catch(IOException e){
                    e.printStackTrace();
                }

            }
        }
        //--------------------dessin du background--------------------

        int x  = POSXG + 45;
        int y = POSYH;

        //dessin des rue horizontales
        for (int i = x; i< ARRET; i ++){

            for (Image image : rueHorizontale) {
                if (i < ARRET- 47){
                    try {
                        BufferedImage rue = ImageIO.read(new File(image.getPath()));
                        g.drawImage(rue, i, y, TILE, TILE, this);
                        g.drawImage(rue, i, POSYB, TILE, TILE,this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                i = i + 50;
            }
            i = i - 1;
        }
        //dessin des rue horizontales

        // dessin des rues verticales

        for (int i = y+47; i< ARRET2; i++){

            for (Image image : rueVerticale){
                if (i < ARRET2 - 47){

                    try {
                        BufferedImage rue = ImageIO.read(new File(image.getPath()));
                        g.drawImage(rue, POSXG, i, TILE, TILE, this);
                        g.drawImage(rue, POSXD, i, TILE, TILE, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                i += 50;
            }
            i -= 1;
        }




            // dessin du virage haut gauche
        try{
            BufferedImage rue = ImageIO.read(new File(tournantGaucheHaut.getPath()));
            g.drawImage(rue, POSXG, POSYH,TILE,TILE,this);
        }
        catch(IOException e){
            e.printStackTrace();
        }
           // dessin du virage bas gauche
        try{
            BufferedImage rue = ImageIO.read(new File(tournantGaucheBas.getPath()));
            g.drawImage(rue, POSXG, POSYB,TILE,TILE,this);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        // dessin de la courbe haut droite

        try{
            BufferedImage rue = ImageIO.read(new File(tournantDroiteHaut.getPath()));
            g.drawImage(rue, POSXD, POSYH,TILE,TILE,this);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        //dessin de la courbe bas droite
        try{
            BufferedImage rue = ImageIO.read(new File(tournantDroiteBas.getPath()));
            g.drawImage(rue, POSXD, POSYB,TILE,TILE,this);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        //dessin des decors
        for (int i = 1; i< 5; i++){

            for (Image decoration : green){

                try{
                    BufferedImage rue = ImageIO.read(new File(decoration.getPath()));
                    int xtemp = random.nextInt(0, Frame.FWIDTH);
                    int ytemp = random.nextInt(0, POSYH - 50);
                    int xtemp1 = random.nextInt(POSYH + 50, POSYB - 50);
                    int ytemp2 = random.nextInt(POSXG + 50, POSXD);
                    g.drawImage(rue, ytemp2, xtemp1, TILE, TILE, this);
                    g.drawImage(rue, xtemp, ytemp,TILE,TILE,this);
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }


        }
        for(Image decora : decor){
            try{
                int xtemp = random.nextInt(0, Frame.FWIDTH);
                int ytemp = random.nextInt(0, POSYB - 50);
                BufferedImage decoration = ImageIO.read(new File(decora.getPath()));
                g.drawImage(decoration, xtemp, ytemp,TILE,TILE,this);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

        //dessin de la voiture de l'utilisateur
        try{
            BufferedImage voiture = ImageIO.read(new File(player.getCarPath()));
            g.drawImage(voiture, POSXD, POSYB,25,50,this);
        }
        catch(IOException e){
            e.printStackTrace();
        }


    }



}
