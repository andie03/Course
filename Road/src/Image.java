public class Image {

    private String pattern;

    Image(String path){
        this.pattern = path;
    }

    public String getPath(){
        return this.pattern;
    }
}
