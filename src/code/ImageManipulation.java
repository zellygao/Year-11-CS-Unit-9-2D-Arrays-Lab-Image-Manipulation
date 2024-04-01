package code;

import image.APImage;
import image.Pixel;

public class ImageManipulation {

    /** CHALLENGE 0: Display Image
     *  Write a statement that will display the image in a window
     */
    private static APImage image;

    public static void main(String[] args) {
        image = new APImage("cyberpunk2077.jpg");
        image.draw();

        grayScale("cyberpunk2077.jpg");
        image.draw();

        image = new APImage("cyberpunk2077.jpg"); // reset the image (thank you chat gpt)
        blackAndWhite("cyberpunk2077.jpg");
        image.draw();

        image = new APImage("cyberpunk2077.jpg");
        edgeDetection("cyberpunk2077.jpg", 20);
        image.draw();

    }

    /** CHALLENGE ONE: Grayscale
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a grayscale copy of the image
     *
     * To convert a colour image to grayscale, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * Set the red, green, and blue components to this average value. */
    public static void grayScale(String pathOfFile) {
        int rgbav = 0;
        image = new APImage(pathOfFile);
        int width = image.getWidth();
        int height = image.getHeight();
        for(int i = 0;i<width;i++){
            for(int j = 0;j<height;j++){
                rgbav=getAverageColour(image.getPixel(i,j));
                Pixel grey = new Pixel (rgbav, rgbav, rgbav);
                image.setPixel(i,j,grey);
            }
        }
    }

    /** A helper method that can be used to assist you in each challenge.
     * This method simply calculates the average of the RGB values of a single pixel.
     * @param pixel
     * @return the average RGB value
     */
    private static int getAverageColour(Pixel pixel) {
        int sum = pixel.getBlue()+ pixel.getGreen()+pixel.getRed();
        return sum/3;
    }

    /** CHALLENGE TWO: Black and White
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a black and white copy of the image
     *
     * To convert a colour image to black and white, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * If the average is less than 128, set the pixel to black
     * If the average is equal to or greater than 128, set the pixel to white */
    public static void blackAndWhite(String pathOfFile) {
        image = new APImage(pathOfFile);
        int rgbav = 0;

        int width = image.getWidth();
        int height = image.getHeight();
        for(int i = 0;i<width;i++){
            for(int j = 0;j<height;j++){
                rgbav=getAverageColour(image.getPixel(i,j));
                if(rgbav<128){
                    image.setPixel(i,j,new Pixel(0,0,0));
                }
                else image.setPixel(i, j, new Pixel(255, 255, 255));
            }
        }
    }

    /** CHALLENGE Three: Edge Detection
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: an outline of the image. The amount of information will correspond to the threshold.
     *
     * Edge detection is an image processing technique for finding the boundaries of objects within images.
     * It works by detecting discontinuities in brightness. Edge detection is used for image segmentation
     * and data extraction in areas such as image processing, computer vision, and machine vision.
     *
     * There are many different edge detection algorithms. We will use a basic edge detection technique
     * For each pixel, we will calculate ...
     * 1. The average colour value of the current pixel
     * 2. The average colour value of the pixel to the left of the current pixel
     * 3. The average colour value of the pixel below the current pixel
     * If the difference between 1. and 2. OR if the difference between 1. and 3. is greater than some threshold value,
     * we will set the current pixel to black. This is because an absolute difference that is greater than our threshold
     * value should indicate an edge and thus, we colour the pixel black.
     * Otherwise, we will set the current pixel to white
     * NOTE: We want to be able to apply edge detection using various thresholds
     * For example, we could apply edge detection to an image using a threshold of 20 OR we could apply
     * edge detection to an image using a threshold of 35
     *  */
    public static void edgeDetection(String pathToFile, int threshold) {
        image = new APImage(pathToFile);

        int av = 0;
        int avleft = 0;
        int avdown = 0;

        int width = image.getWidth();
        int height = image.getHeight();

        boolean[][] check = new boolean[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                av = getAverageColour(image.getPixel(i, j));
                if (i > 0) {
                    avleft = getAverageColour(image.getPixel(i - 1, j));
                    if (Math.abs(av - avleft) > threshold) {
                        check[i][j] = true;
                    }
                } else if (j < height - 1) {
                    avdown = getAverageColour(image.getPixel(i, j + 1));
                    if (Math.abs(av - avdown) > threshold) {
                        check[i][j] = true;
                        continue;
                    }
                } else {
                    check[i][j] = false;
                }
                if(check[i][j]){
                    image.setPixel(i, j, new Pixel(0,0,0));
                }
                else{
                    image.setPixel(i, j, new Pixel(255,255,255));
                }
            }
        }
    }
}


    /*/** CHALLENGE Four: Reflect Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image reflected about the y-axis
     *
     */
    /*public static void reflectImage(String pathToFile) {

    }

    /** CHALLENGE Five: Rotate Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image rotated 90 degrees CLOCKWISE
     *
     *  */
   /* public static void rotateImage(String pathToFile) {

    }*/
