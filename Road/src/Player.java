public class Player {

    private String carPath;
    private int upKey, downKey, rightKey, leftKey;
    private double angle;
    private double positionX;
    private double positionY;

    Player(String carPath, int upKey, int downKey, int rightKey, int leftKey){
        this.carPath = carPath;
        this.upKey = upKey;
        this.downKey = downKey;
        this.rightKey = rightKey;
        this.leftKey = leftKey;
    }

    public String getCarPath(){
        return this.carPath;
    }

    // ici on doit encore implementer les mouvements de la voiture de l'utilisateur.
}
