package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Ra1004ek on 24.08.2015.
 */
public class ImageReaderFactory
{


    public static ImageReader getReader(ImageTypes imageTypes)
    {

        ImageReader result;


        if (imageTypes == null) throw new IllegalArgumentException("Неизвестный тип картинки");
        else
        switch (imageTypes)
        {
            case BMP:
                result = new BmpReader();
            break;
            case JPG:
                result = new JpgReader();
            break;
            case PNG:
                result = new PngReader();
            break;
            default:
                throw new IllegalArgumentException("Неизвестный тип картинки");
        } return result;
    }
}
