import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageConversionExample {

    public static void main(String[] args) {
        String inputFile = "fine.jpg";
        String outputFile = "fine_grayscale.jpg";

        convertToGrayscale(inputFile, outputFile);
    }

    public static void convertToGrayscale(String inputFilePath, String outputFilePath) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(inputFilePath));

            int width = originalImage.getWidth();
            int height = originalImage.getHeight();

            BufferedImage grayscaleImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = originalImage.getRGB(x, y);
                    Color color = new Color(rgb);
                    int r = color.getRed();
                    int g = color.getGreen();
                    int b = color.getBlue();
                    // https://en.wikipedia.org/wiki/Relative_luminance
                    int luminance = (int) (0.2126 * r + 0.7152 * g + 0.0722 * b);

                    grayscaleImage.setRGB(x, y, new Color(luminance, luminance, luminance).getRGB());
                }
            }

            ImageIO.write(grayscaleImage, "JPEG", new File(outputFilePath));
            System.out.println("Output image: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
