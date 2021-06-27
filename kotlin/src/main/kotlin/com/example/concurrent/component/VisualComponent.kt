package com.example.concurrent.component

import java.awt.event.KeyListener
import java.awt.event.MouseListener
import java.util.concurrent.CopyOnWriteArrayList

class VisualComponent(
    private val keyListener: CopyOnWriteArrayList<KeyListener>,
    private val mouseListener: CopyOnWriteArrayList<MouseListener>,
) {
    fun addKeyListener(listener: KeyListener) {
        keyListener.add(listener)
    }

    fun addMouseListener(listener: MouseListener) {
        mouseListener.add(listener)
    }

    fun removeKeyListener(listener: KeyListener) {
        keyListener.remove(listener)
    }

    fun removeMouseListener(listener: MouseListener) {
        mouseListener.remove(listener)
    }
}