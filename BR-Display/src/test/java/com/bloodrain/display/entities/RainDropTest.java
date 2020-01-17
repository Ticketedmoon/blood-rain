package com.bloodrain.display.entities;

import java.awt.Graphics;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
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
    public void testDrawToScreenSetsColor() {
        testRainDrop.drawToScreen(graphicsMock);
        Mockito.verify(graphicsMock, Mockito.times(1)).setColor(Matchers.any());
    }

    @Test
    public void testDrawToScreenFillsRect() {
        testRainDrop.drawToScreen(graphicsMock);
        Mockito.verify(graphicsMock, Mockito.times(1)).fillRect(Matchers.anyInt(),
                Matchers.anyInt(),
                Matchers.anyInt(),
                Matchers.anyInt()
        );
    }

    @Test
    public void testDrawToScreenUpdatesXYPosition() {
        float rainDropYPositionBeforeDraw = testRainDrop.getY();
        testRainDrop.drawToScreen(graphicsMock);
        float rainDropYPositionAfterDraw = testRainDrop.getY();
        Assert.assertTrue(rainDropYPositionAfterDraw > rainDropYPositionBeforeDraw);
    }

}
