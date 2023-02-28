# Year-11-CS-Unit-8-2D-Arrays-Lab-Image-Manipulation

This lab includes a jar file called images. The jar file has already been added to the project for you. This jar file contains several different classes (APImage, ImageIterator, ImageFileFilter, ImagePanel, and Pixel). The only two classes that you will directly use in the images jar file are <b>APImage</b> and <b>Pixel</b>. The <b>APImage</b> class represents an image as a two-dimensional grid of <b>Pixel</b> objects. You will use the constructors and methods in the <b>APImage</b> class and <b>Pixel</b> class in order to complete this lab. The methods for the <b>APImage</b> and <b>Pixel</b> class are listed below.

# APImage class

| <b>APImage CONSTRUCTORS</b> | <b>WHAT IT DOES</b> |
| -------------------- | ------------ |
| APImage()            | Creates an image from a file dialog selection, or creates a blank, 200 by 200, black image if the user cancels the dialog. |
| APImage (String filename) | Creates an image from the given file; throws an exception if the file does not exist or the file is not in JPEG format. |
| APImage (int width, int height) | Creates a blank image of the given width and height, with a color of black. |

| <b>APImage METHODS</b> | <b>WHAT IT DOES</b> |
| ---------------------- | ------------------- |
| int getWidth() | Returns the images width in pixels |
| int getHeight() | Returns the images height in pixels |
| Pixel getPixel(int x, int y) | Returns the pixel at the given position, where x is the column and y is the row |
| void setPixel(int x, int y, Pixel p) | Resets the pixel at the given position, where x is the column and y is the row |
| void draw() | Makes the image’s window visible and draws the image in it |
| APImage clone() | Returns a new instance of APImage that is a copy of this image |
| String toString() | Returns the string representation of the image containing the information (filename, width, and height) |

# Pixel class

| Pixel CONSTRUCTOR | WHAT IT DOES |
| ----------------- | ------------ |
| Pixel(int red, int green, int blue) | Creates a pixel with the given RGB values |

| Pixel METHOD | WHAT IT DOES |
| ------------ | ------------ |
| int getRed() | Returns the pixel’s red value |
| int getGreen() | Returns the pixel’s green value |
| int getBlue() | Returns the pixel’s blue value |
| void setRed(int red) | Resets the pixel’s red value to red |
| void setGreen(int green) | Resets the pixel’s green value to green |
| void setBlue(int blue) | Resets the pixel’s blue value to blue |
| Pixel clone() | Returns a copy of this pixel |
| String toString() | Returns the string representation of the pixel (red, green, and blue values) |





