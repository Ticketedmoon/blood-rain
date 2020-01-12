package com.bloodrain.display.entities;

import java.awt.Graphics;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RainDropTest {

    @InjectMocks
    private RainDrop testRainDrop;

    @Mock
    private Graphics graphicsMock;

    @Test
    public void testRainDropClassAttributeY() {
        Assert.assertNotNull(testRainDrop);
        Assert.assertTrue(testRainDrop.getY() < 0.0);
        Assert.assertEquals(testRainDrop.getY() % 1, -0.0, 0.0);
    }

    @Test
    public void testGetNewVelocityValueRange() {
        Assert.assertTrue(testRainDrop.getNewVelocity() >= 1);
        Assert.assertTrue(testRainDrop.getNewVelocity() <= 8);
    }

    @Test
    public void testDrawToScreen_setsColor() {
        testRainDrop.drawToScreen(graphicsMock);
        Mockito.verify(graphicsMock, Mockito.times(1)).setColor(Mockito.any());
    }

    @Test
    public void testDrawToScreen_fillsRect() {
        testRainDrop.drawToScreen(graphicsMock);
        Mockito.verify(graphicsMock, Mockito.times(1)).fillRect(Mockito.anyInt(),
                Mockito.anyInt(),
                Mockito.anyInt(),
                Mockito.anyInt()
        );
    }

    @Test
    public void testDrawToScreen_updatesXYPosition() {
        float rainDropYPositionBeforeDraw = testRainDrop.getY();
        testRainDrop.drawToScreen(graphicsMock);
        float rainDropYPositionAfterDraw = testRainDrop.getY();
        Assert.assertTrue(rainDropYPositionAfterDraw > rainDropYPositionBeforeDraw);
    }

}
