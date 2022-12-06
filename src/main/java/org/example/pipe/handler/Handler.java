package org.example.pipe.handler;

@FunctionalInterface
public interface Handler<I, O> {
    O process(I input);
}
