package misc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageAsciiConverter {

        private BufferedImage img;
        private double pixelValue;
        private PrintWriter prntwrt;
        private FileWriter filewrt;

    public ImageAsciiConverter() throws IOException
        {
            prntwrt = new PrintWriter(filewrt = new FileWriter("asciiart.txt", true));
        }

        /**
         *
         * @param fileName
         *        Takes image name while excuting via terminal
         * @exception IOException
         *            if file is not found or readable
         */
        public static void main(final String... fileName)
        {
            try
            {
                ImageAsciiConverter imageConv = new ImageAsciiConverter();
                imageConv.convertImageToAscii(fileName[0]);

                FileReader fr = new FileReader("asciiart.txt");
                int i;
                while ((i = fr.read()) != -1)
                {
                    System.out.print((char) i);
                }
                PrintWriter writer = new PrintWriter("asciiart.txt");
                writer.print("");
                writer.close();
                fr.close();
            }
            catch(final ArrayIndexOutOfBoundsException nullValue)
            {
                System.out.println("\nPlease enter imagename after -> [ java ImageAsciiConverter [ImageName] ]");
                System.out.println("\t--------- OR ---------");
                System.out.println("Try Run -> \' java ImageAsciiConverter java.png \'");
                System.out.println();
            }
            catch(final IOException notFound)
            {
                System.err.print("Error !! , check the IMAGE NAME you Entered  ");
                System.out.print("[ OR ]  Make Sure you kept images in source folder");
            }
        }
        /**
         * Method to Take an image and Convert them into Ascii format
         *
         * @param imageName     Takes Image to convert into asciiart
         * @throws IOException
         */
        public void convertImageToAscii(final String imageName) throws IOException
        {
            img = ImageIO.read(new File(imageName));

            for (int i = 0; i < img.getHeight(); i++)
            {
                for (int j = 0; j < img.getWidth(); j++)
                {
                    Color pixelcolor = new Color(img.getRGB(j, i));
                    pixelValue = (((pixelcolor.getRed() * 0.30) + (pixelcolor.getBlue() * 0.59) + (pixelcolor.getGreen() * 0.11)));
                    print(colorToChar(pixelValue));  // pass pixel value to print
                }
                prntwrt.println("");
                prntwrt.flush();
                filewrt.flush();
            }
        }
        /**
         * This Method return the ASCII art to print method
         *
         * @param pixval
         * @return a character to print
         */
        public char colorToChar(final double pixval)
        {
            if (pixval >= 240)
                return ' ';
            else if (pixval >= 210)
                return '.';
            else if (pixval >= 190)
                return '*';
            else if (pixval >= 170)
                return '+';
            else if (pixval >= 120)
                return '^';
            else if (pixval >= 110)
                return '$';
            else if (pixval >= 80)
                return '4';
            else if (pixval >= 60)
                return '#';
            else
                return ' ';
        }
        /**
         * Prints the ascii characters
         *
         * @param asciiArt
         * @throws IOException
         */
        public void print(char asciiArt) throws IOException
        {
            prntwrt.print(asciiArt);
            prntwrt.flush();
            filewrt.flush();
        }

}
