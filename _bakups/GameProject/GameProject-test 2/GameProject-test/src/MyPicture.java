import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MyPicture {
    private boolean isClicked;


    String noImage= "/Users/goncalo/Documents/GitHub/my-exercises/GameProject-test/src/no_image.png";
    String image0 = "src/0.png";
    String image1 = "src/1.png";
    String image2 = "/Users/goncalo/Documents/GitHub/my-exercises/GameProject-test/src/2.png";
    String image3 = "/Users/goncalo/Documents/GitHub/my-exercises/GameProject-test/src/3.png";
    String image4 = "/Users/goncalo/Documents/GitHub/my-exercises/GameProject-test/src/4.png";
    String image5 = "/Users/goncalo/Documents/GitHub/my-exercises/GameProject-test/src/5.png";
    String image6 = "/Users/goncalo/Documents/GitHub/my-exercises/GameProject-test/src/6.png";
    String image7 = "/Users/goncalo/Documents/GitHub/my-exercises/GameProject-test/src/7.png";


    //Array with images paths
    public String[] imagesArray = {image0, image1, image2, image3, image4, image5, image6, image7,image0, image1, image2, image3, image4, image5, image6, image7};
    //turn array in a list to remove a random index from de list when a card is chosen
    public static ArrayList<String >imagesList;


    public MyPicture(int positionX, int positionY, boolean isClicked){
        this.isClicked = isClicked;
        if (imagesList == null || imagesList.isEmpty()) {
            prepareImagesList(); // Prepara a lista de imagens
        }

        choseImage(positionX,positionY,isClicked);

        }

    private void prepareImagesList() {
        imagesList = new ArrayList<>(Arrays.asList(imagesArray));
        Collections.shuffle(imagesList); // Embaralha a lista de imagens para garantir aleatoriedade
        System.out.println("A lista está a ser baralhada e criada com o tamanho: "+ imagesList.size());
    }

        public Picture choseImage(int positionX,int positionY,boolean isClicked){
        if (isClicked){
            Picture randomPicture = new Picture(120, 120,getAnImagePath());
            randomPicture.translate(0,0);
            randomPicture.translate(positionX-120, positionY-120);
            randomPicture.draw();
            System.out.println("escolhi a primeira imagem");
            return randomPicture;
            }

        else{
            Picture noImage = new Picture(120, 120, this.noImage);
            noImage.translate(0,0);
            noImage.translate(positionX-120, positionY-120);
            noImage.draw();
            System.out.println("escolhi a segunda");
            return noImage;
        }
    }

        private String getAnImagePath(){
            String createdImagePath = imagesList.removeFirst();

            System.out.println("imagem removida: " + createdImagePath);
            System.out.println("tamanho da lista: " + imagesList.size());
            return createdImagePath;

    }
        public String getIconImage(){
            return noImage;
        }
       // public String getImagePath(){
        //    return
       // }

}
