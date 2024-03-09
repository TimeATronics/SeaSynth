package com.searemind.synth;

import javax.swing.*;
import java.awt.*;
import java.util.function.Function;

import com.searemind.synth.utils.Utils;

public class WaveViewer extends JPanel {
    private Oscillator[] oscillators;
    public WaveViewer(Oscillator[] oscillators) {
        this.oscillators = oscillators;
        setBorder(Utils.WindowDesign.LINE_BORDER);
    }
    @Override
    public void paintComponent(Graphics graphics) {
        final int PAD = 25;
        super.paintComponent(graphics);
        int numSamples = getWidth() - PAD * 2;
        double[] mixedSamples = new double[numSamples];
        Graphics2D graphics2d = (Graphics2D)graphics;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Oscillator oscillator : oscillators) {
            double[] samples = oscillator.getSampleWaveform(numSamples);
            for (int i = 0; i < samples.length; ++i) {
                mixedSamples[i] += samples[i] / oscillators.length;
            }
        }
        int midY = getHeight() / 2;
        Function<Double, Integer> sampleToYCoord = sample -> (int)(midY + sample * (midY - PAD));
        graphics2d.drawLine(PAD, midY, getWidth() - PAD, midY);
        graphics2d.drawLine(PAD, PAD, PAD, getHeight() - PAD);
        for (int i = 0; i < numSamples; ++i) {
            int nextY = i == numSamples - 1 ? sampleToYCoord.apply(mixedSamples[i]) : sampleToYCoord.apply(mixedSamples[i+1]);
            graphics2d.drawLine(PAD + i, sampleToYCoord.apply(mixedSamples[i]), PAD + i + 1, nextY);
        }
    }
}
