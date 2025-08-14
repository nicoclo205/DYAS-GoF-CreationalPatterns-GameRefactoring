package com.balitechy.spacewar.main.factories;

public class FactoryProducer {
    public static final String SPRITE_STYLE = "sprite";
    public static final String VECTORIAL_STYLE = "vectorial";
    public static final String COLORFUL_VECTORIAL_STYLE = "colorful-vectorial";
    
    private static String currentStyle = SPRITE_STYLE;
    
    public static GameElementsFactory getFactory() {
        switch(currentStyle) {
            case VECTORIAL_STYLE:
                return new VectorialElementsFactory();
            case COLORFUL_VECTORIAL_STYLE:
                return new ColorfulVectorialElementsFactory();
            case SPRITE_STYLE:
            default:
                return new SpriteElementsFactory();
        }
    }
    
    public static void setCurrentStyle(String style) {
        currentStyle = style;
    }
    
    public static String getCurrentStyle() {
        return currentStyle;
    }
}