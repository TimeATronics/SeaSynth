package com.searemind.synth;

import java.awt.Component;
import java.awt.Point;

import javax.swing.JPanel;

public class SynthControlContainer extends JPanel {
    protected boolean on;
    
    private Point mouseClickLocation;
    private SeaSynth synth;
    public SynthControlContainer(SeaSynth synth) {
        this.synth = synth;
    }

    public Point getMouseClickLocation() {
        return mouseClickLocation;
    }

    public void setMouseLocation(Point mouseClickLocation) {
        this.mouseClickLocation = mouseClickLocation;
    }
    public boolean isOn() {
        return on;
    }
    public void setOn(boolean on) {
        this.on = on;
    }

    @Override
    public Component add(Component component) {
        component.addKeyListener(synth.getKeyAdapter());
        return super.add(component);
    }

    @Override
    public void add(Component component, Object constraints) {
        component.addKeyListener(synth.getKeyAdapter());
        super.add(component, constraints);
    }

    @Override
    public Component add(Component component, int index) {
        component.addKeyListener(synth.getKeyAdapter());
        return super.add(component, index);
    }

    @Override
    public Component add(String name, Component component) {
        component.addKeyListener(synth.getKeyAdapter());
        return super.add(name, component);
    }

    @Override
    public void add(Component component, Object constraints, int index) {
        component.addKeyListener(synth.getKeyAdapter());
        super.add(component, constraints, index);
    }
}
